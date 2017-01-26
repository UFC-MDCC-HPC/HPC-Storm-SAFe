package br.ufc.mdcc.pargo.safe.framework.fcore.client;

public class CoreClientTest {

	public static void main(String[] args) {
		ShelfCoreClient coreClient = new ShelfCoreClient();
		System.out.println(coreClient.resolve(""));
	}
}
