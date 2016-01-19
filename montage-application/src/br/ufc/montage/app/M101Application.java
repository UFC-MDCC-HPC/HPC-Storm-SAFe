package br.ufc.montage.app;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.env.HdrPortProvides;

public class M101Application extends HShelfApplication{

	
	public M101Application(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		
		try {
			this.services.registerUsesPort("port_SAFeSWL",IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort("port_Go",IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort("jpg-uses", IHShelfPortTypes.NO_TYPE);
			HdrPortProvides hdrPortProvides = new HdrPortProvides();
			hdrPortProvides.setValue("template-hdr");
			hdrPortProvides.setName("tmpl-hdr-prov");
			this.services.setProvidesPort(hdrPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void run() throws HShelfException{
		if(this.services!=null){
			
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort("port_SAFeSWL")).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/m101-arch.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/m101-flow.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort("port_Go")).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
		HShelfProvidesPort provides = ((HShelfUsesPort)this.services.getPort("jpg-uses")).getProvidesPort();
		if(provides!=null){
			MontageShelfProvidesPort mp = (MontageShelfProvidesPort)provides;
			System.out.println(mp.getValue());
		}
	}
	
	public static void main(String[] args) {
		M101Application m101Application = new M101Application("app-101");
		try {
			m101Application.run();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
