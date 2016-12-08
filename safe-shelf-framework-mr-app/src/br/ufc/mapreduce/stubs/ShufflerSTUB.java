package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ShufflerSTUB extends HShelfComponent{

	private HShelfTaskPort taskChunk;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.taskChunk = new HShelfTaskPort();
		this.taskChunk.setName("shuffler-task-chunk");
		
		try {
			this.services.registerTaskPort(taskChunk);
			MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("port-A-shuffler-provides");
			this.services.setProvidesPort(provides);
			this.services.registerUsesPort("port-B-shuffler-uses", null);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
