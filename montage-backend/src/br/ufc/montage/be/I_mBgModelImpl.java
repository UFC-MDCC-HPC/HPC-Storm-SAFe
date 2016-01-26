package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mBgModel")
public class I_mBgModelImpl implements I_mBgModel{
	
	private String tblPortProvides;

	private String tblPortUsesA;
	private String tblPortUsesB;

	@Override
	public String getTblPortProvides() {
		return this.tblPortProvides;
	}

	@Override
	public void setTblPortUsesA(String value) {
		this.tblPortUsesA = value;
	}

	@Override
	public void settblPortUsesB(String value) {
		this.tblPortUsesB = value;
	}

	@Override
	public void go() {
		this.tblPortProvides = "corrections.tbl";
		String cmd = "mBgModel " + UnixUtil.home_dir+this.tblPortUsesA + " " + UnixUtil.home_dir+this.tblPortUsesB + " "
				+ UnixUtil.home_dir+this.tblPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
