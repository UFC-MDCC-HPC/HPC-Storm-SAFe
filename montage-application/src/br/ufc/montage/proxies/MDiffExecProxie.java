package br.ufc.montage.proxies;

import br.montage.stubs.mDiffExec.IMDiffExecImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MDiffExecProxie extends MontageShelfComputationComponent {

	private HShelfUsesPort tblPortUses;
	private HShelfUsesPort dirPortUsesIn;
	private HShelfUsesPort dirPortUsesOut;
	private HShelfUsesPort hdrPortUses;
	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.goPortTask = new GoPortTask(this);
		
		try {
			this.goPortTask.setName("mdiffexec-go");
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mdiffexec-tbl-port-uses",
					MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mdiffexec-dir-port-uses-in",
					MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mdiffexec-dir-port-uses-out",
					MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mdiffexec-hdr-port-uses",
					MontageTypes.HDR_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void go() {
		
		String tblValue = null;
		String dirInValue = null;
		String dirOutValue = null;
		String hdrValue = null;
		IMDiffExecImplService service = new IMDiffExecImplService();
		
		try {
			this.tblPortUses = (HShelfUsesPort) this.services
					.getPort("mdiffexec-tbl-port-uses");
			this.dirPortUsesIn = (HShelfUsesPort) this.services
					.getPort("mdiffexec-dir-port-uses-in");
			this.dirPortUsesOut = (HShelfUsesPort) this.services
					.getPort("mdiffexec-dir-port-uses-out");
			this.hdrPortUses = (HShelfUsesPort) this.services
					.getPort("mdiffexec-hdr-port-uses");

			dirInValue = ((MontageShelfProvidesPort) this.dirPortUsesIn
					.getProvidesPort()).getValue();
			dirOutValue = ((MontageShelfProvidesPort) this.dirPortUsesOut
					.getProvidesPort()).getValue();
			tblValue = ((MontageShelfProvidesPort) this.tblPortUses
					.getProvidesPort()).getValue();
			hdrValue = ((MontageShelfProvidesPort) this.hdrPortUses
					.getProvidesPort()).getValue();

			// comunicar com o web service uses aqui, passando os 4 parâmetros a
			// ele, conseguido da local
			// 4 x WS_USES.SET_VALUE..
			service.getIMDiffExecImplPort().setDirPortUsesIn(dirInValue);
			service.getIMDiffExecImplPort().setDirPortUsesOut(dirOutValue);
			service.getIMDiffExecImplPort().setTblPortUses(tblValue);
			service.getIMDiffExecImplPort().setHdrPortUses(hdrValue);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		// mDiffExec -p projdir diffs.tbl template.hdr diffdir
		/*String cmd = "mDiffExec -p " + dirInValue + " " + tblValue + " "
				+ hdrValue + " " + dirOutValue;
		System.out.println(cmd);*/
		service.getIMDiffExecImplPort().go();
		// end some computation!
		// FIM DA SIMULAÇÃO

	}
}
