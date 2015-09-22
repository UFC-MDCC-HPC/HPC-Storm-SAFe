package br.ufc.mdcc.pargo.safe.application.service;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

/**
 * SAFe Server Side
 * @author jefferson
 *
 */
public class StartServerAppService {

	public static void main(String[] args) {
		IHPCStormApplicationServer server = new HPCStormApplicationServerImpl();
		String url = "http://localhost:10100/appserver-ws";
		Endpoint.publish(url, server);
		SAFeConsoleLogger.write("SAFe App server is up in: "+url);

	}
}
