package br.ufc.montage.proxies;

import br.montage.stubs.mBgExec.IMBgExecImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MBgExecProxie extends MontageShelfComputationComponent {

	private HShelfUsesPort tblPortUsesA;
	private HShelfUsesPort tblPortUsesB;

	private HShelfUsesPort dirPortUsesIn;
	private HShelfUsesPort dirPortUsesOut;

	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mbgexec-go");
		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mbgexec-go-tbl-port-uses-a",
					MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mbgexec-go-dir-port-uses-in",
					MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mbgexec-go-dir-port-uses-out",
					MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mbgexec-go-tbl-port-uses-b",
					MontageTypes.TBL_TYPE);

			// comunicar com o web service uses aqui, passando o parâmetro a
			// ele, conseguido da local
			// WS_USES.SET_VALUE...
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void go() {
		String tblValueA = null;
		String dirInValue = null;
		String dirOutValue = null;
		String tblValueB = null;
		IMBgExecImplService service = new IMBgExecImplService();

		try {
			this.tblPortUsesA = (HShelfUsesPort) this.services
					.getPort("mbgexec-go-tbl-port-uses-a");
			this.dirPortUsesIn = (HShelfUsesPort) this.services
					.getPort("mbgexec-go-dir-port-uses-in");
			this.dirPortUsesOut = (HShelfUsesPort) this.services
					.getPort("mbgexec-go-dir-port-uses-out");
			this.tblPortUsesB = (HShelfUsesPort) this.services
					.getPort("mbgexec-go-tbl-port-uses-b");

			dirInValue = ((MontageShelfProvidesPort) this.dirPortUsesIn
					.getProvidesPort()).getValue();
			dirOutValue = ((MontageShelfProvidesPort) this.dirPortUsesOut
					.getProvidesPort()).getValue();
			tblValueA = ((MontageShelfProvidesPort) this.tblPortUsesA
					.getProvidesPort()).getValue();
			tblValueB = ((MontageShelfProvidesPort) this.tblPortUsesB
					.getProvidesPort()).getValue();

			// comunicar com o web service uses aqui, passando os 4 parâmetros a
			// ele, conseguido da local
			// 4 x WS_USES.SET_VALUE..
			service.getIMBgExecImplPort().setDirPortUsesIn(dirInValue);
			service.getIMBgExecImplPort().setDirPortUsesOut(dirOutValue);
			service.getIMBgExecImplPort().setTblPortUsesA(tblValueA);
			service.getIMBgExecImplPort().setTblPortUsesB(tblValueB);

		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		// mBgExec -p projdir images.tbl corrections.tbl corrdir
		//String cmd = "mBgExec -p " + dirInValue + " " + tblValueA + " "
		//		+ tblValueB + " " + dirOutValue;
		//System.out.println(cmd);
		service.getIMBgExecImplPort().go();
		// end some computation!
		// FIM DA SIMULAÇÃO

	}

}
