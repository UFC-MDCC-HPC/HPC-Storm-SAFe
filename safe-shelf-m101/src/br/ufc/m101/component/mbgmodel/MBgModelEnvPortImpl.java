package br.ufc.m101.component.mbgmodel;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mbgmodel.MBgModelEnvPort")
public class MBgModelEnvPortImpl implements MBgModelEnvPort{

	private MBgModel mBgModel;
	
	public void setMBgModel(MBgModel mBgModel){
		this.mBgModel = mBgModel;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mBgModel.setParams(params);
	}
}
