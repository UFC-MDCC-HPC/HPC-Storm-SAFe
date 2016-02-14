package br.ufc.mapreduce.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufc.mapreduce.model.MapReduceAction;
import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.model.MapReduceEnvPort;
import br.ufc.mapreduce.model.MapReduceTskPort;
import br.ufc.mapreduce.workflow.MapReduceWorkflow;

public class MapReduceUtil {
	
	public static final String path_ser = "/home/jefferson/moex_data/mapreduce.dat";
	private static int id = 100;

	public static List<MapReduceComponent> createComponents(){
		
		List<MapReduceComponent> components = new ArrayList<MapReduceComponent>();
		
		//Application
		MapReduceComponent application = new MapReduceComponent();
		application.setName("application");
		
		MapReduceEnvPort templateHDRPort = new MapReduceEnvPort();
		templateHDRPort.setName("template_hdr");
		templateHDRPort.setType(MapReduceEnvPort.PROVIDES_PORT);
		application.addEnvPort(templateHDRPort);
		
		MapReduceEnvPort rawImagesPort = new MapReduceEnvPort();
		rawImagesPort.setName("rawImages");
		rawImagesPort.setType(MapReduceEnvPort.PROVIDES_PORT);
		application.addEnvPort(rawImagesPort);
		
		//MpROJEC
		
		
		components.add(application);
		
		return components;
	}
	
	public static void serializeWorkflow(MapReduceWorkflow workflow){
		 try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(path_ser);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(workflow);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in "+path_ser);
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public static MapReduceWorkflow deserializeWorkflow(){
		MapReduceWorkflow workflow = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(path_ser);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         workflow = (MapReduceWorkflow) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Workflow class not found");
	         c.printStackTrace();
	         return null;
	      }
		return workflow;
	}
	
	public static MapReduceEnvPort getEnvPortByName(MapReduceWorkflow workflow, String name, String type){
		for(MapReduceComponent cmp:workflow.listComponents()){
			for(MapReduceEnvPort env:cmp.getEnvPorts()){
				if(env.getName().equals(name) && env.getType().equals(type))
					return env;
			}
		}
		return null;
	}
	
	public static MapReduceTskPort getTskPortByName(MapReduceWorkflow workflow, String name){
		for(MapReduceComponent cmp:workflow.listComponents()){
			for(MapReduceTskPort tsk:cmp.getTskPorts()){
				if(tsk.getName().equals(name))
					return tsk;
			}
		}
		return null;
	}
	
	public static int getActionIdByName(MapReduceComponent cmp,String name){
		int id = -1;
		for(MapReduceTskPort tsk:cmp.getTskPorts()){
			for(MapReduceAction action: tsk.getActions()){
				if(action.getName().equals(name))
					return action.getId();
			}
		}
		return id;
	}
	
	public static int generateID(){
		return MapReduceUtil.id++;
	}
}
