package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationOperation;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class SAFeVisitorImpl implements ISAFeVisitor{

	//logic package.
	private String logicPkg = "br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic";
	
	@Override
	public void visit(SAFeOrchestrationElement element) {
		 
		SAFeConsoleLogger.write("Enter visit for " + element.getOperationStr());
		
		//first case, the workflow element. Justo go on...
		if(element.getOperation().equals(SAFeOrchestrationOperation.WORKFLOW))
			for(SAFeOrchestrationElement child:element.getChildren()){
				child.run();
		}
		else{
			//calling logic for this type of operation via reflection
			String logicFullClassName = this.logicPkg+".Logic"+element.getOperationStr();
			try {
				Class<?> c = Class.forName(logicFullClassName);
				AbstractSAFeElementLogic logicClass = (AbstractSAFeElementLogic)c.newInstance();
				logicClass.logic(element);
			} catch (ClassNotFoundException e) {
				SAFeConsoleLogger.write(logicFullClassName+" NOT FOUND");
				//e.printStackTrace();
			} catch (InstantiationException e) {
				SAFeConsoleLogger.write(logicFullClassName+" CLASS NOT INSTANTIATED");
				//e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	
}
