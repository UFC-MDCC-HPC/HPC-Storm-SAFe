package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mOverlaps")
public class I_mOverlapsImpl implements I_mOverlaps{

	private String tblPortProvides;
	private String tblPortUses;
	
	@Override
	public String getTblPortProvides() {
		return this.tblPortProvides;
	}

	@Override
	public void setTblPortUses(String value) {
		this.tblPortUses = value;
	}

	@Override
	public void go() {
		this.tblPortProvides = "diffs.tbl";
		String cmd = "mOverlaps " + UnixUtil.home_dir+this.tblPortUses + " " + UnixUtil.home_dir+this.tblPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
