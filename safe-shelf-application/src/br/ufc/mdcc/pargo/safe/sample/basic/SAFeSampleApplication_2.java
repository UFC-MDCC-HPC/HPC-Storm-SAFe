package br.ufc.mdcc.pargo.safe.sample.basic;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class SAFeSampleApplication_2 extends HShelfApplication{

	public SAFeSampleApplication_2(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		try {

			System.out.println("PASSO 1");
			HShelfPort portSWL = services.getProvidesPort("safeswl-port");

			((HShelfSAFeSWLPort) portSWL)
					.setSAFeSWLArchFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/mImgtbl-simple-run-arch.xml");
			((HShelfSAFeSWLPort) portSWL)
					.setSAFeSWLFlowFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/mImgtbl-simple-run-flow.xml");

			System.out.println("PASSO 2");
			HShelfPort portGo = services.getProvidesPort("go-workflow");
			((HShelfGoPort) portGo).go();

		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
