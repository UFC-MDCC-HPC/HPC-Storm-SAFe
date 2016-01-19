package br.ufc.montage.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MBgModelProxie extends MontageShelfComputationComponent {

	private TblPortProvides tblPortProvides;

	private HShelfUsesPort tblPortUsesA;
	private HShelfUsesPort tblPortUsesB;

	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mbgmodel-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mbgmodel-tbl-port-uses-a",
					MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mbgmodel-tbl-port-uses-b",
					MontageTypes.TBL_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mbgmodel-tbl-port-provides");
		try {
			this.services.setProvidesPort(tblPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void go() {

		String tblAValue = null;
		String tblBValue = null;

		try {
			this.tblPortUsesA = (HShelfUsesPort) this.services
					.getPort("mbgmodel-tbl-port-uses-a");
			tblAValue = ((MontageShelfProvidesPort) tblPortUsesA
					.getProvidesPort()).getValue();

			this.tblPortUsesB = (HShelfUsesPort) this.services
					.getPort("mbgmodel-tbl-port-uses-b");
			tblBValue = ((MontageShelfProvidesPort) tblPortUsesB
					.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		// mBgModel images.tbl fits.tbl corrections.tbl
		String tblValueOut = "corrections.tbl";
		String cmd = "mBgModel " + tblAValue + " " + tblBValue + " "
				+ tblValueOut;
		System.out.println(cmd);
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValueOut);

	}

}
