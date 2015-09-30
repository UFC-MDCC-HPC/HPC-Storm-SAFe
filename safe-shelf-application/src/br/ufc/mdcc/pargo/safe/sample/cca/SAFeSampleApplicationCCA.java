package br.ufc.mdcc.pargo.safe.sample.cca;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class SAFeSampleApplicationCCA extends HShelfApplication {

	public SAFeSampleApplicationCCA(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}

	public static void main(String[] args) {
		SAFeSampleApplicationCCA sampleApp = new SAFeSampleApplicationCCA(
				"sample-app-cca");
		IHShelfService services = sampleApp.getServices();
		HShelfFramework framework = sampleApp.getFramework();

		// server
		/*ShelfServerComponent server = new ShelfServerComponent();
		server.setName("server");
		framework.addComponent(server);
		server.initialize();*/
		ShelfServerComponent server = (ShelfServerComponent)framework.createComponent("server", "br.ufc.mdcc.pargo.safe.sample.cca.ShelfServerComponent");
		server.initialize();
		

		// client
		ShelfClientComponent client = new ShelfClientComponent();
		client.setName("client");
		framework.addComponent(client);
		client.initialize();

		try {
			HShelfGoPort goClient = (HShelfGoPort) services
					.getProvidesPort("go-client");
			goClient.go();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
