package br.ufc.mdcc.pargo.safe.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormTaskPort;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

/**
 * First Services implementation.
 * 
 * @author jefferson
 *
 */
public class HPCStormServicesImpl implements IHPCStormServices {

	private Map<String, IHPCStormEnvUsesPort> envUsesMap;
	private Map<String, IHPCStormEnvProvidesPort> envProvMap;
	private Map<String, IHPCStormTaskPort> taskMap;

	private String host;
	private int port;

	public HPCStormServicesImpl(String host, int port) {
		this.envUsesMap = new HashMap<String, IHPCStormEnvUsesPort>();
		this.envProvMap = new HashMap<String, IHPCStormEnvProvidesPort>();
		this.taskMap = new HashMap<String, IHPCStormTaskPort>();

		//put this in a config file...
		this.host = host;
		this.port = port;
	}

	@Override
	public IHPCStormEnvUsesPort getUsesPort(String id) {

		return this.envUsesMap.get(id);
	}

	@Override
	public IHPCStormEnvProvidesPort getProvidesPort(String id) {

		return this.envProvMap.get(id);
	}

	@Override
	public void registerUsesPort(IHPCStormEnvUsesPort uses) {
		this.envUsesMap.put(uses.getId(), uses);
	}

	/**
	 * This method registers a provides environment port and run its service as
	 * a web service. NEM SEMPRE SERÁ UM WEB SERVICE! ESSE MÉTODO NÃO PODE
	 * CONTAR COM A PORTA SENDO UM WEB SERVICE. PORTANTO DEVE SER ALTERADO.
	 */
	@Override
	public void registerProvidesPort(IHPCStormEnvProvidesPort provides) {
		this.envProvMap.put(provides.getId(), provides);
		
		
		final String url = this.host + ":" + this.port + "/"
				+ provides.getName();
		// run port as a web service. Much better than RMI.
		RunServiceAsWebService rs = new RunServiceAsWebService(provides, url);
		rs.start();
		try {
			rs.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IHPCStormTaskPort getTaskPort(String id) {
		return this.taskMap.get(id);
	}

	@Override
	public void registerTaskPort(IHPCStormTaskPort taskPort) {
		this.taskMap.put(taskPort.getId(), taskPort);
	}

}

class RunServiceAsWebService extends Thread {

	private IHPCStormEnvProvidesPort service;
	private String url;

	public RunServiceAsWebService(IHPCStormEnvProvidesPort service, String url) {
		this.service = service;
		this.url = url;
	}

	@Override
	public void run() {
		SAFeConsoleLogger.write("INIT: Publishing " + service.getName()
				+ " at endpoint " + url);
		Endpoint.publish(url, service);
		SAFeConsoleLogger.write("END: Publishing " + service.getName()
				+ " at endpoint " + url);
	}
}