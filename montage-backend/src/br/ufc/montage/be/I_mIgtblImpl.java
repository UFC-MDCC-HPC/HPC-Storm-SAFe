package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mIgtbl")
public class I_mIgtblImpl implements I_mIgtbl{

	
	public String dirPortUses;
	public String tblPortProvides;
	
	@Override
	public void setDirPortUses(String value) {
		this.dirPortUses = value;		
	}

	 

	@Override
	public String getTblPortProvides() {
		return this.tblPortProvides;
	}

	@Override
	public void go() {
		this.tblPortProvides = "imgbtl.tbl";
		String cmd = "mImgtbl "+this.dirPortUses+" "+this.tblPortProvides;
		System.out.println(cmd);
	}

}
