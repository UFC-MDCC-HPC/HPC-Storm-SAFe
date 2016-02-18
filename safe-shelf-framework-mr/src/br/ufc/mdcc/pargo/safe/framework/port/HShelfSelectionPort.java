package br.ufc.mdcc.pargo.safe.framework.port;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;

public class HShelfSelectionPort extends HShelfProvidesPort{

	private HShelfApplication app;

	public HShelfSelectionPort(HShelfApplication application){
		this.app = application;
	}
	
	public List<Object> selection(List<Object> objects){
		return this.app.selection(objects);
	}
	
}
