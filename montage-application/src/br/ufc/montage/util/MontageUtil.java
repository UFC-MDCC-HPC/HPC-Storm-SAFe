package br.ufc.montage.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;
import br.ufc.montage.workflow.MontageWorkflow;

public class MontageUtil {
	
	public static final String path_ser = "/home/jefferson/workflow.dat"; 

	public static List<MontageComponent> createComponents(){
		
		List<MontageComponent> components = new ArrayList<MontageComponent>();
		
		//Application
		MontageComponent application = new MontageComponent();
		application.setName("application");
		
		MontageEnvPort templateHDRPort = new MontageEnvPort();
		templateHDRPort.setName("template_hdr");
		templateHDRPort.setType(MontageEnvPort.PROVIDES_PORT);
		application.addEnvPort(templateHDRPort);
		
		MontageEnvPort rawImagesPort = new MontageEnvPort();
		rawImagesPort.setName("rawImages");
		rawImagesPort.setType(MontageEnvPort.PROVIDES_PORT);
		application.addEnvPort(rawImagesPort);
		
		//MpROJEC
		
		
		components.add(application);
		
		return components;
	}
	
	public static void serializeWorkflow(MontageWorkflow workflow){
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
	
	public static MontageWorkflow deserializeWorkflow(){
		MontageWorkflow workflow = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(path_ser);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         workflow = (MontageWorkflow) in.readObject();
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
}
