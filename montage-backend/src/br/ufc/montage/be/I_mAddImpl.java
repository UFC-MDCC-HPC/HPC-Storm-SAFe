package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mAdd")
public class I_mAddImpl implements I_mAdd{

	private int index = 0;
	
	private String fitsPortProvides;

	private String tblPortUses;
	private String dirPortUses;
	private String hdrPortUses;
	
	@Override
	public String getfitsPortProvides() {
		return this.fitsPortProvides;
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
	public void setHdrPortUses(String value) {
		this.hdrPortUses = value;
	}

	@Override
	public void go() {
		this.fitsPortProvides = "mosaic"+index+".fits";
		index++;
		String cmd = "mAdd -p " + UnixUtil.home_dir+this.dirPortUses + " " + UnixUtil.home_dir+this.tblPortUses + " "
				+ UnixUtil.home_dir+this.hdrPortUses + " " + UnixUtil.home_dir+this.fitsPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
		
	}

}
