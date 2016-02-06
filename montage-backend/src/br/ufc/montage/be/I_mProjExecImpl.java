package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mProjExec")
public class I_mProjExecImpl implements I_mProjExec{

	private static int index = 1;
	
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
	public synchronized void go() {
		this.tblPortProvides = "mprojexec"+index+".tbl";
		index++;
		String cmd = "mProjExec -p " + UnixUtil.home_dir+this.dirPortUsesIn + " " + UnixUtil.home_dir+this.tblPortUses + " " + UnixUtil.home_dir+this.hdrPortUses + " " + UnixUtil.home_dir+this.dirPortUsesOut + " " + UnixUtil.home_dir+this.tblPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
