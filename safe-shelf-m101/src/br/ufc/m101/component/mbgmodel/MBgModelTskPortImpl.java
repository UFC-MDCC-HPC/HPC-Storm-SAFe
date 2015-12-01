package br.ufc.m101.component.mbgmodel;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mbgmodel.MBgModelTskPort")
public class MBgModelTskPortImpl implements MBgModelTskPort{

	private MBgModel mBgModel;
	
	public void setMBgModel(MBgModel mBgModel){
		this.mBgModel = mBgModel;
	}
	
	@WebMethod
	public void go(){
		this.mBgModel.go();
	}
}
