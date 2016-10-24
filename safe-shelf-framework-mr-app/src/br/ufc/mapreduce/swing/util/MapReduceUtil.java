package br.ufc.mapreduce.swing.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.mapreduce.swing.model.MapReduceAction;
import br.ufc.mapreduce.swing.model.MapReduceComponent;
import br.ufc.mapreduce.swing.model.MapReduceEnvPort;
import br.ufc.mapreduce.swing.model.MapReduceTskPort;
import br.ufc.mapreduce.swing.workflow.MapReduceWorkflow;

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
	
	public static String writeToAFile(String fileName, String content){
		String path="/home/jefferson/moex_data/"+fileName;
		PrintWriter writer;
		try {
			writer = new PrintWriter(path, "UTF-8");
			writer.println(content);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
}
