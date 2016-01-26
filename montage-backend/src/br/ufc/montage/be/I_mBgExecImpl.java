package br.ufc.montage.be;

import javax.jws.WebService;


@WebService(endpointInterface="br.ufc.montage.be.I_mBgExec")
public class I_mBgExecImpl implements I_mBgExec{

	private String tblPortUsesA;
	private String tblPortUsesB;

	private String dirPortUsesIn;
	private String dirPortUsesOut;

	
	@Override
	public void setTblPortUsesA(String value) {
		this.tblPortUsesA = value;
		
	}

	@Override
	public void setTblPortUsesB(String value) {
		this.tblPortUsesB = value;
	}

	@Override
	public void setDirPortUsesIn(String value) {
		this.dirPortUsesIn = value;
	}

	@Override
	public void setDirPortUsesOut(String value) {
		this.dirPortUsesOut = value;	
	}

	@Override
	public void go() {
		String cmd = "mBgExec -p " + this.dirPortUsesIn + " " + this.tblPortUsesA + " "
				+ this.tblPortUsesB + " " + this.dirPortUsesOut;
		System.out.println(cmd);
	}

}
