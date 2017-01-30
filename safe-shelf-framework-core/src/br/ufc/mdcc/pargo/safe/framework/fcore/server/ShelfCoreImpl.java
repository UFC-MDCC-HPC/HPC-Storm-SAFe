package br.ufc.mdcc.pargo.safe.framework.fcore.server;

import java.util.HashMap;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.framework.fcore.server.IShelfCore")
public class ShelfCoreImpl implements IShelfCore{

	private HashMap<String, String> databaseMap;
	
	public ShelfCoreImpl() {
		this.databaseMap = new HashMap<String, String>();
		this.databaseMap.put("splitter", "splitter-param-values");
		this.databaseMap.put("mapper", "mapper-param-values");
		this.databaseMap.put("shuffler", "shuffler-param-values");
		this.databaseMap.put("reducer", "reducer-param-values");
		this.databaseMap.put("combiner", "combiner-param-values");
		
		this.databaseMap.put("combiner", "combiner-param-values");
		this.databaseMap.put("corrdir", "corrdir-param-values");
		this.databaseMap.put("diffdir", "diffdir-param-values");
		this.databaseMap.put("madd", "madd-param-values");
		this.databaseMap.put("mbgexec", "mbgexec-param-values");
		this.databaseMap.put("mbgmodel", "mbgmodel-param-values");
		this.databaseMap.put("mdiffexec", "mdiffexec-param-values");
		this.databaseMap.put("mfitexec", "mfitexec-param-values");
		this.databaseMap.put("mimgtbl", "mimgtbl-param-values");
		this.databaseMap.put("mjpeg", "mjpeg-param-values");
		this.databaseMap.put("moverlaps", "moverlaps-param-values");
		this.databaseMap.put("mprojexec", "mprojexec-param-values");
		this.databaseMap.put("projdir", "projdir-param-values");
		this.databaseMap.put("rawdir", "rawdir-param-values");
	}
	
	@Override
	public String resolve(String contract) {
		// TODO Auto-generated method stub
		System.out.println("RESOLVE " + contract);
		return "resolve";
	}

	@Override
	public String deploy(String safeSWLCode, String componentReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String instantiate(String wsession, String reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release(String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listParameter(String contract) {
		String out = this.databaseMap.get(contract);
		System.out.println("listParameter " + out);
		return out;
	}

	@Override
	public void setComponentList(String componentList) {
		// TODO Auto-generated method stub
		
	}

}
