package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mArchiveExec")
public class I_mArchiveExecImpl implements I_mArchiveExec{

	private String tblUses;
	private String dirUses;
	
	@Override
	public void setTblUses(String value) {
		this.tblUses = value;
		
	}
	@Override
	public void setDirUses(String value) {
		this.dirUses = value;
		
	}
	@Override
	public void go() {
		String dir = UnixUtil.home_dir+dirUses;
		String cmd = " mArchiveExec "+UnixUtil.home_dir+dirUses+"/"+tblUses;
		System.out.println(cmd);
		UnixUtil.executeBinBash(cmd, dir);
		
		
	}
}
