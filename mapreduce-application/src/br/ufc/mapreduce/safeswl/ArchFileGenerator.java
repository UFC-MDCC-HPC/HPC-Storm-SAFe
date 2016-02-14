package br.ufc.mapreduce.safeswl;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mapreduce.model.MapReduceAction;
import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.model.MapReduceEnvPort;
import br.ufc.mapreduce.model.MapReduceTskPort;
import br.ufc.mapreduce.util.MapReduceUtil;
import br.ufc.mapreduce.workflow.MapReduceEnvConnection;
import br.ufc.mapreduce.workflow.MapReduceTskConnection;
import br.ufc.mapreduce.workflow.MapReduceWorkflow;

public class ArchFileGenerator {

	private String application = "";
	private String workflowStr = "";
	private List<String> body = new ArrayList<String>();
	private List<String> envs = new ArrayList<String>();
	private List<String> tsks = new ArrayList<String>();
	private MapReduceWorkflow workflow;
	
	public void generate(MapReduceWorkflow workflow){
		this.workflow = workflow;
		String geral = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
						"<tns:architecture xmlns:tns=\"http://www.example.org/SAFe_architecture_V4\" \n"+ 
						" xmlns:tns1=\"http://www.example.org/instantiator\" \n"+ 
						" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n"+ 
						" xsi:schemaLocation=\"http://www.example.org/SAFe_architecture_V4 SAFe_architecture_V4.xsd\"> \n\n\n";
		for(MapReduceComponent cmp:workflow.listComponents()){
			String res = this.generateComponentXML(cmp);
			if(cmp.getName().equalsIgnoreCase("application")){
				this.application = res;
			}else if(cmp.getName().equalsIgnoreCase("workflow")){
				this.workflowStr = res;
			}else{
				this.body.add(res);
			}
		}
		
		for(int i=0;i<workflow.listActs().size();i++){
			List<MapReduceEnvConnection> envConns = workflow.listMontageEnvConnectionsByActPosition(i);
			if(envConns!=null)
			for(MapReduceEnvConnection ec:envConns){
				String ecStr = this.generateEnvBindingXML(ec);
				envs.add(ecStr);
			}
		}
		
		for(int i=0;i<workflow.listActs().size();i++){
			List<MapReduceTskConnection> tskConns = workflow.listMontageTskConnectionsByActPosition(i);
			if(tskConns!=null)
			for(MapReduceTskConnection tc:tskConns){
				String tcStr = this.generateTaskBindingXML(tc);
				tsks.add(tcStr);
			}
		}
		
		
		geral+=application;
		geral+=workflowStr+"\n";
		geral+="<tns:body>\n";
		for(String in:this.body){
			geral+=in;
		}
		geral+="</tns:body>\n\n";
		
		for(String in:this.envs){
			geral+=in;
		}
		geral+="\n\n";
		
		for(String in:this.tsks){
			geral+=in;
		}
		
		geral+="\n\n</tns:architecture>";
		System.out.println(geral);
		
	}
	
	/*<tns:computation name="Mapper" id="3">
    <tns:uses_port id="41" name="mapper-uses" id_component="3"/>
  	<tns:provides_port id="43" name="mapper-provides" id_component="3"/>
  	<tns:contract id="31">
        <tns:uri>http://tempuri-client.org</tns:uri>
     </tns:contract>
    <tns:task_port name="mapper-task-chunk" id="45" id_component="3">
      	<tns:action id="451" name="read_chunk"/>
      	<tns:action id="452" name="perform"/>
      	<tns:action id="453" name="chunk_ready"/>	
    </tns:task_port>
  </tns:computation>*/
  
	public String generateComponentXML(MapReduceComponent component){
		String res = "";
		String comp_name = component.getName();
		int comp_id = component.getId();
		res +="<tns:computation name=\""+comp_name+"\" id=\""+comp_id+"\">\n";
		
		for(MapReduceEnvPort env:component.getEnvPorts()){
			if(env.getType().equals("USES_PORT")){
				res+="\t<tns:uses_port id=\""+env.getId()+"\" name=\""+env.getName()+"\" id_component=\""+env.getId_component()+"\"/>\n";
			}
		}
		
		
		for(MapReduceEnvPort env:component.getEnvPorts()){
			if(env.getType().equals("PROVIDES_PORT")){
				res+="\t<tns:provides_port id=\""+env.getId()+"\" name=\""+env.getName()+"\" id_component=\""+env.getId_component()+"\"/>\n";
			}
		}
		
		if(component.getContract()!=null && !component.getContract().equals("")){
			res+="\t<tns:contract id=\""+component.getId()*10+"\">\n";
			res+="\t\t<tns:uri>"+component.getContract()+"</tns:uri>\n";
			res+="\t</tns:contract>\n";		
		}
		
		for(MapReduceTskPort tsk:component.getTskPorts()){
			
			if(tsk.getActions()!=null && tsk.getActions().size()>0){
				res+="\t<tns:task_port name=\""+tsk.getName()+"\" id=\""+tsk.getId()+"\" id_component=\""+tsk.getId_component()+"\">\n";
				for(MapReduceAction action: tsk.getActions()){
					res+="\t\t<tns:action id=\""+action.getId()+"\" name=\""+action.getName()+"\"/>\n";
				}
				res+="\t</tns:task_port>\n";
			}else{
				res+="\t<tns:task_port name=\""+tsk.getName()+"\" id=\""+tsk.getId()+"\" id_component=\""+tsk.getId_component()+"\"/>\n";
			}
			
			 
		}
		
		
		res+="</tns:computation>\n";
		return res;
	}
	
	/*
	 * <tns:env_binding>
  	<tns:uses_port id="13" name="port_SAFeSWL" id_component="0"/> 
  	<tns:provides_port id="21" name="port_SAFeSWL" id_component="1"/>
  </tns:env_binding>
	 */
	public String generateEnvBindingXML(MapReduceEnvConnection envConn){
		String res="<tns:env_binding>\n";
		MapReduceEnvPort uses = MapReduceUtil.getEnvPortByName(this.workflow, envConn.getUsesPortName(),"USES_PORT");
		MapReduceEnvPort provides = MapReduceUtil.getEnvPortByName(this.workflow, envConn.getProvidesPortName(),"PROVIDES_PORT");
		res+="\t<tns:uses_port id=\""+ uses.getId()+"\" name=\""+uses.getName()+"\" id_component=\""+uses.getId_component()+"\"/>\n";
		res+="\t<tns:provides_port id=\""+provides.getId()+"\" name=\""+provides.getName()+"\" id_component=\""+provides.getId_component()+"\"/>\n";		
		res+="</tns:env_binding>\n";
		return res;
	}
	
	/*<tns:task_binding>
  	<tns:left_peer id="23" name="wf-splitter-ss" id_component="1"/>
  	<tns:right_peer name="splitter-task-ss" id="34" id_component="2"/>
  </tns:task_binding>
	 */
	public String generateTaskBindingXML(MapReduceTskConnection tskConn){
		String res = "<tns:task_binding>\n";
		MapReduceTskPort ta = MapReduceUtil.getTskPortByName(workflow, tskConn.getPortAName());
		MapReduceTskPort tb = MapReduceUtil.getTskPortByName(workflow, tskConn.getPortBName());
		res+="\t<tns:left_peer id=\""+ta.getId()+"\" name=\""+ta.getName()+"\" id_component=\""+ta.getId_component()+"\"/>\n";
		res+="\t<tns:right_peer name=\""+tb.getName()+"\" id=\""+tb.getId()+"\" id_component=\""+tb.getId_component()+"\"/>\n";
		res+="</tns:task_binding>";
		
		return res;
	}
}
