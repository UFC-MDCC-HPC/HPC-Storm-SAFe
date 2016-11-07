package br.ufc.mdcc.pargo.safe.framework.port;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;

public class HShelfSelectionPort extends HShelfProvidesPort{

	private HShelfApplication app;

	public HShelfSelectionPort(HShelfApplication application){
		this.app = application;
	}
	
	public Object selection(Object objects){
		return this.app.selection(objects);
	}
	
}
