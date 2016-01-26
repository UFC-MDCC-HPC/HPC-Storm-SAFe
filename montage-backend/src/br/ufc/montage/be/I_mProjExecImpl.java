package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mProjExec")
public class I_mProjExecImpl implements I_mProjExec{

	private String tblPortProvides;
	
	private String tblPortUses;
	private String dirPortUsesIn;
	private String dirPortUsesOut;
	private String hdrPortUses;
	
	@Override
	public String getTblPortProvides() {
		return this.tblPortProvides;
	}

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
		this.tblPortProvides = " mprojexec.tbl";
		String cmd = "mProjExec -p " + this.dirPortUsesIn + " " + this.tblPortUses + " " + this.hdrPortUses + " " + this.dirPortUsesOut + " " + this.tblPortProvides;
		System.out.println(cmd);
	}

}
