package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicParallel extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		ParallelJob[] threads = new ParallelJob[element.getChildren().size()];
		
		//creating threads
		for(int i=element.getChildren().size()-1, j=0;i>=0;i--,j++){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			ParallelJob pj = new ParallelJob(child);
			threads[j] = pj;
		}
		
		//starting threads
		SAFeConsoleLogger.write("STARTING PARALLEL TASKS");
		for(ParallelJob job:threads){
			job.run(); //NOT PARALLEL (TESTING)
			//job.start(); // IN PARALLEL
		}
			
		
		//join threads
		for(ParallelJob job:threads){
			try {
				job.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SAFeConsoleLogger.write("ENDED PARALLEL TASKS");
		
	}

}

class ParallelJob extends Thread{
	
	SAFeOrchestrationElement child;
	
	public ParallelJob(SAFeOrchestrationElement child){
		this.child = child;
	}
	
	@Override
	public void run() {
		this.child.run();
		
	}
}
