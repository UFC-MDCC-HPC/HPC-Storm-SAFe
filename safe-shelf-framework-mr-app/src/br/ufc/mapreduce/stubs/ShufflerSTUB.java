package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.tsk.TaskChunkSTUB;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ShufflerSTUB extends HShelfComponent{

	private TaskChunkSTUB taskChunk;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.taskChunk = new TaskChunkSTUB();
		this.taskChunk.setName("shuffler-task-chunk");
		try {
			this.services.registerTaskPort(taskChunk);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
