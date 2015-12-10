package br.ufc.montage.util;

import java.util.ArrayList;
import java.util.List;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;

public class MontageUtil {

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
}
