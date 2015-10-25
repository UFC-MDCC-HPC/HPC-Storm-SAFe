package br.ufc.mdcc.pargo.safe.framework.core;


public class HShelfCoreImpl implements IHShelfCore{

	String xmlRecordsClient = 
	"<component id=\"2\" name=\"client\">"+
		"<port id=\"20\" name=\"env-client\" url=\"http://localhost:10005/client-env?wsdl\" />"+
		"<port id=\"21\" name=\"task-client\" url=\"http://localhost:10004/client-task?wsdl\" />"+
	"</component>";
	String xmlRecordsServer =
	"<component id=\"3\" name=\"server\">"+
		"<port id=\"30\" name=\"env-server\" url=\"http://localhost:10003/server-env?wsdl\" />"+
		"<port id=\"31\" name=\"task-server\" url=\"http://localhost:10002/server-task?wsdl\" />"+
	"</component>";
	
	
	@Override
	public String resolve(String contract) {
		return "<xml></xml>";
	}

	@Override
	public String deploy(String candidates) {
		return "<xml></xml>";
	}

	@Override
	public String instantiate(String ID) {
		if(ID.equalsIgnoreCase("2")) return this.xmlRecordsClient;
		return this.xmlRecordsServer;
	}

	@Override
	public void release(String ID) {
		
	}
	
	/*
	//TESTING
	public void test(){
		HShelfCoreXMLReaderImpl reader = new HShelfCoreXMLReaderImpl();
		HShelfComponentCoreInfo c =reader.readComponent(xmlRecords, "3");
		System.out.println(c);
	}
	//TESTING
	public static void main(String[] args) {
		HShelfCoreImpl impl = new HShelfCoreImpl();
		impl.test();
	}*/

}
