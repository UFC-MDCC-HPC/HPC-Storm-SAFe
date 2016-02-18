package br.ufc.mapreduce.safeswl;

import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.model.MapReduceTskPort;
import br.ufc.mapreduce.util.MapReduceUtil;
import br.ufc.mapreduce.workflow.MapReduceWorkflow;

public class FlowFileGenerator {
	
	 
	
	static String read_chunk = "read_chunk";
	static String perform = "perform";
	static String chunk_ready = "chunk_ready";
	static String read_source = "read_source";
	static String terminate = "terminate";
	static String write_sink = "write_sink";
	

	public static String generate(MapReduceWorkflow workflow){
		String res = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n "+
					 "<tns:workflow xmlns:tns=\"http://www.example.org/SAFe_workflow_V4\" \n"+
					 " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n"+
					 " xsi:schemaLocation=\"http://www.example.org/SAFe_workflow_V4 SAFe_workflow_V4.xsd \"> \n"+
					 "<tns:sequence_oper>\n\n";
		
		
		/*
		 * <!-- CONNECT -->
		<tns:operation>
			<tns:invoke_oper action="connect" id="2" />
		</tns:operation>
		 */
		for(MapReduceComponent cmp:workflow.listComponents()){
			if(cmp.getKind().equals(MapReduceComponent.COMPUTATION_KIND)){
				res+="<!--"+cmp.getName()+"-->\n";
				res+="<tns:operation>\n";
				res+="\t<tns:invoke_oper action=\"connect\" id=\""+cmp.getId()+"\" />\n";
				res+="</tns:operation>\n";
			}
		}
		
		/*
		 * <!-- splitter read source -->
		<tns:operation>
			<tns:invoke_oper action="compute" id="341" />
		</tns:operation>
		<!-- splitter perform -->
		<tns:operation>
			<tns:invoke_oper action="compute" id="352" />
		</tns:operation>
		 */
		res+="\n";
		for(MapReduceComponent cmp:workflow.listComponents()){
			 if(cmp.getName().startsWith("Splitter")){
				 
				 int id_read_source = MapReduceUtil.getActionIdByName(cmp, read_source);
				 int id_perform = MapReduceUtil.getActionIdByName(cmp, perform);
				 res+="<!--"+cmp.getName()+"-->\n";
				 res+="<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_read_source+"\" />\n"+
					  "</tns:operation>\n"+
		
					  "<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_perform+"\" />\n"+
					  "</tns:operation>\n";
			 }
		}
		res+="\n";
		
		res+="<tns:operation>\n"+
	         "<tns:iterate_oper max=\"-1\" iter_label=\"LABEL_A\">\n"+
		     "<tns:operation>\n"+
			 "<tns:choice_oper>\n\n";

		/*
		 * <tns:select action_id="453">
					<tns:operation>
						<tns:invoke_oper action="compute" id="451"/>
					</tns:operation>
					<tns:operation>
						<tns:invoke_oper action="compute" id="452"/>
					</tns:operation>
				</tns:select>
		 */
		for(MapReduceComponent cmp:workflow.listComponents()){
			if(cmp.getKind().equals(MapReduceComponent.COMPUTATION_KIND) &&
			   !cmp.getName().startsWith("Splitter")){
				int id_chunk_ready = MapReduceUtil.getActionIdByName(cmp, chunk_ready);
				int id_read_chunk = MapReduceUtil.getActionIdByName(cmp, read_chunk);
				int id_perform = MapReduceUtil.getActionIdByName(cmp, perform);
				res+="<!--"+cmp.getName()+"-->";
				res+="\n<tns:select action_id=\""+id_chunk_ready+"\">\n";
				res+="<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_read_chunk+"\" />\n"+
				      "</tns:operation>\n"+
			
					  "<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_perform+"\" />\n"+
					   "</tns:operation>\n";
				res+="</tns:select>\n\n";
			}
		}
		
		for(MapReduceComponent cmp:workflow.listComponents()){
			if(cmp.getName().startsWith("Splitter")){
				
				int id_terminate = MapReduceUtil.getActionIdByName(cmp, terminate);
				int id_write_sink = MapReduceUtil.getActionIdByName(cmp, write_sink);
				res+="<!--"+cmp.getName()+"-->";
				res+="\n<tns:select action_id=\""+id_terminate+"\">\n"+
				"<tns:operation>\n"+
				"\t<tns:invoke_oper action=\"compute\" id=\""+id_write_sink+"\"/>\n"+
				"</tns:operation>\n"+
				"<tns:operation>\n"+
				"\t<tns:break_oper base_label=\"LABEL_A\"/>\n"+
				"</tns:operation>\n"+
				"</tns:select>";
				
				int id_chunk_ready = MapReduceUtil.getActionIdByName(cmp, chunk_ready);
				int id_read_chunk = MapReduceUtil.getActionIdByName(cmp, read_chunk);
				int id_perform = MapReduceUtil.getActionIdByName(cmp, perform);
				res+="\n<tns:select action_id=\""+id_chunk_ready+"\">\n";
				res+="<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_read_chunk+"\" />\n"+
				      "</tns:operation>\n"+
			
					  "<tns:operation>\n"+
					  "\t<tns:invoke_oper action=\"compute\" id=\""+id_perform+"\" />\n"+
					   "</tns:operation>\n\n";
				res+="</tns:select>\n";
			}
		}
		

		res+="</tns:choice_oper>\n"+
			 "</tns:operation>\n"+
			 "</tns:iterate_oper>\n"+
			 "</tns:operation>\n\n";
		
		res+="</tns:sequence_oper>\n"+
			 "</tns:workflow>";
		
		//System.out.println(res);
		
		return res;
	}
	
	
}
