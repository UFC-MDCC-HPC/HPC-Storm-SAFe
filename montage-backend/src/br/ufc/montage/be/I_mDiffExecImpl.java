package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mDiffExec")
public class I_mDiffExecImpl implements I_mDiffExec{

	private String tblPortUses;
	private String dirPortUsesIn;
	private String dirPortUsesOut;
	private String hdrPortUses;
	
	@Override
	public void setTblPortUses(String value) {
		this.tblPortUses = value;
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
	public void setHdrPortUses(String value) {
		this.hdrPortUses = value;
	}

	@Override
	public void go() {
		String cmd = "mDiffExec -p " + this.dirPortUsesIn + " " + this.tblPortUses + " "
				+ this.hdrPortUses + " " + this.dirPortUsesOut;
		System.out.println(cmd);
	}

}
