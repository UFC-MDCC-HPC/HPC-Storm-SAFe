package br.ufc.mdcc.pargo.safe.sample.pc;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class SAFeProducerConsumer extends HShelfApplication {

	public SAFeProducerConsumer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}

	public static void main(String[] args) {
		SAFeProducerConsumer sampleApp = new SAFeProducerConsumer(
				"sample-app-cca");
		IHShelfService services = sampleApp.getServices();
		HShelfFramework framework = sampleApp.getFramework();

		// server
		ShelfServerConsumer server = new ShelfServerConsumer();
		server.setName("server");
		framework.addComponent(server);
		server.initialize();

		// client
		ShelfClientProducer client = new ShelfClientProducer();
		client.setName("client");
		framework.addComponent(client);
		client.initialize();

		try {
			ShelfPortGoClientProducer goClient = (ShelfPortGoClientProducer) services
					.getProvidesPort("go-producer");
			goClient.go();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
