package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mIgtbl")
public class I_mIgtblImpl implements I_mIgtbl{

	private static int index = 1;
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
	public synchronized void go() {
		this.tblPortProvides = "imgtbl"+index+".tbl";
		index++;
		String cmd = "mImgtbl "+UnixUtil.home_dir+this.dirPortUses+" "+UnixUtil.home_dir+this.tblPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
