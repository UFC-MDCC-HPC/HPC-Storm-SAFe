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

	public void run() {
		// initialize

		HShelfFramework framework = this.getFramework();

		// server
		ShelfServerConsumer server = (ShelfServerConsumer) framework
				.createComponent("server",
						"br.ufc.mdcc.pargo.safe.sample.pc.ShelfServerConsumer");
		framework.addComponent(server);
		server.initialize(); // maybe a port?

		// client
		ShelfClientProducer client = (ShelfClientProducer) framework
				.createComponent("server",
						"br.ufc.mdcc.pargo.safe.sample.pc.ShelfClientProducer");
		framework.addComponent(client);
		client.initialize();

		// run client by getting his go port
		try {
			ShelfPortGoClientProducer goClient = (ShelfPortGoClientProducer) services
					.getProvidesPort("go-producer");
			goClient.go();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SAFeProducerConsumer pc = new SAFeProducerConsumer("app-safe-consumer");
		pc.run();
	}
}
