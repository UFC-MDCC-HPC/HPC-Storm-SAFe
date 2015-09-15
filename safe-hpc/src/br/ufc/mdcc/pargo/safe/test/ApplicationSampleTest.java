package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;
import br.ufc.mdcc.pargo.safe.application.sample.ApplicationSample;

public class ApplicationSampleTest {

public static void main(String[] args) {
		
		HPCStormApplication app = new ApplicationSample();
		//calls framework.start...
		app.run();
	}
}
