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
		String cmd = "mDiffExec -p " + UnixUtil.home_dir+this.dirPortUsesIn + " " + UnixUtil.home_dir+this.tblPortUses + " "
				+ UnixUtil.home_dir+this.hdrPortUses + " " + UnixUtil.home_dir+this.dirPortUsesOut;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
