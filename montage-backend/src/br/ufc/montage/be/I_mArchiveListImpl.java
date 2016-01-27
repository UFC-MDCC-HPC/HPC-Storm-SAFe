package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mArchiveList")
public class I_mArchiveListImpl implements I_mArchiveList{

	private String tblProvides;
	private String rawUses;
	private String[] bands = {"DSS2B","DSS2R", "DSS2IR"};
	private int index = 0;
	
	@Override
	public String getTblProvides() {
		return this.tblProvides;
	}

	@Override
	public void setRawUses(String value) {
		this.rawUses = value;
	}

	@Override
	public void go() {
		this.tblProvides = "remote.tbl";
		String dir = UnixUtil.home_dir+this.rawUses;
		String cmd = "mArchiveList dss "+ bands[index]+" \"56.5 23.75\" 3 3 "+UnixUtil.home_dir+this.rawUses+"/"+this.tblProvides;
		System.out.println(cmd);
		UnixUtil.executeBinBash(cmd, dir);
		index++;
		
		
		
	}

}
