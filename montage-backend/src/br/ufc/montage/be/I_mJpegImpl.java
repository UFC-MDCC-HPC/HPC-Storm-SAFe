package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_mJpeg")
public class I_mJpegImpl implements I_mJpeg{

	private String jpgPortProvides;
	private String fitsPortUses;
	
	@Override
	public String getJpgPortProvides() {
		return this.jpgPortProvides;
	}

	@Override
	public void setFitsPortUses(String value) {
		this.fitsPortUses = value;
	}

	@Override
	public void go() {
		this.jpgPortProvides = "m101_mosaic.jpg";
		String cmd = "mJPEG -gray " + UnixUtil.home_dir+this.fitsPortUses + " 0s max gaussian-log -out " + UnixUtil.home_dir+this.jpgPortProvides;
		System.out.println(cmd);
		UnixUtil.executeCommand(cmd);
	}

}
