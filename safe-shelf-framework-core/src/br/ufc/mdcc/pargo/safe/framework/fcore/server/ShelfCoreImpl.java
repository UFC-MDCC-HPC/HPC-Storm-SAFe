/*
 * HOW TO COMPILE THE STUBS:
 * 0: RUN CorePublisher TO KNOW WHERE wsdl IS.
 * 1: GO TO SRC PROJECT FOLDER
 * 2: RUN wsimport -p br.ufc.mdcc.pargo.safe.framework.fcore.stub -keep http://localhost:8888/core?wsdl
 * 3: REFRESH SRC FOLDER
 */
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
		this.databaseMap.put("cluster_a", "cluster_a-param-values");
		this.databaseMap.put("datasource", "datasource_a-param-values");
		this.databaseMap.put("datasink", "datasink-param-values");
		
		
		
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
	
	/**STUBS**/
	@Override
	public String resolve(String contract) {
		// TODO Auto-generated method stub
		System.out.println("RESOLVE " + contract);
		return "resolve";
	}

	@Override
	public String deploy(String wsession, String componentReference) {
		// TODO Auto-generated method stub
		System.out.println("DEPLOY " + componentReference);
		return "resolve";
	}

	@Override
	public String instantiate(String wsession, String componentReference) {
		// TODO Auto-generated method stub
		System.out.println("INSTANTIATE " + componentReference);
		return "resolve";
	}

	@Override
	public void release(String ID) {
		System.out.println("release " + ID);	
	}

	@Override
	public String listParameter(String contract) {
		String out = this.databaseMap.get(contract);
		System.out.println("listParameter " + out);
		return out;
	}

	@Override
	public void setComponentList(String componentList) {
		System.out.println("setComponentList: "+componentList);
		
	}

	/**WORKFLOW**/
	@Override
	public Object openWorkflowSession(String safeSWLCode) {
		System.out.println("openWorkflowSession: "+safeSWLCode);
		return new Integer(0);
	}

	@Override
	public void registerContract(String contract) {
		System.out.println("registerContract: "+contract);
		
	}

	@Override
	public void closeWorkflowSession(String session) {
		System.out.println("closeWorkflowSession: "+session);
		
	}

}
