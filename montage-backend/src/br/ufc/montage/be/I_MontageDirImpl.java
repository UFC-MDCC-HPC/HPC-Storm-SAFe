package br.ufc.montage.be;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.montage.be.I_MontageDir")
public class I_MontageDirImpl implements I_MontageDir{

	@Override
	public String getRawDir() {
		return "rawDir";
	}

	@Override
	public String getProjDir() {
		return "projDir";
	}

	@Override
	public String getCorrDir() {
		return "corrDir";
	}

	@Override
	public String getDiffDir() {
		return "diffDir";
	}

	@Override
	public String getDss2bDir() {
		return "dss2bDir";
	}

	@Override
	public String getDss2rDir() {
		return "dss2rDir";
	}

	@Override
	public String getDss2irDir() {
		return "dss2irDir";
	}

	@Override
	public String getFitsDir() {
		return "fitsDir";
	}

}
