package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mFitExec")
public class I_mFitExecImpl implements I_mFitExec{

	private String tblPortProvides;

	private String tblPortUses;
	private String dirPortUses;
	
	@Override
	public String getTblPortProvides() {
		return this.tblPortProvides;
	}

	@Override
	public void setTblPortUses(String value) {
		this.tblPortUses = value;		
	}

	@Override
	public void setDirPortUses(String value) {
		this.dirPortUses = value;
	}

	@Override
	public void go() {
		this.tblPortProvides = "fits.tbl";
		String cmd = "mFitExec " + this.tblPortUses + " " + this.tblPortProvides + " " + this.dirPortUses;
		System.out.println(cmd);
	}

}
