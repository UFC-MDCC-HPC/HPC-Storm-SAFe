package br.ufc.montage.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;

import br.ufc.montage.dao.MontageComponentDAO;
import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.workflow.MontageWorkflow;

public class MontageAppMain extends JFrame {

	private MontageCenterPanel centerPanel;
	private MontageLateralPanel lateralPanel;
	private MontageBottonPanel bottomPanel;
	private MontageWorkflow workflow;
	private MontageComponentDAO componentDAO;
	 

	public MontageAppMain() {
		
		//DAO
		this.componentDAO = new MontageComponentDAO();
		 
		
		//workflow of acts
		this.workflow = new MontageWorkflow();
		
		// creating panels...
		this.centerPanel = new MontageCenterPanel(this.componentDAO);
		this.centerPanel.setWorkflow(workflow);
		 
		this.lateralPanel = new MontageLateralPanel();
		this.lateralPanel.setWorkflow(workflow);
		this.lateralPanel.setComponentDAO(componentDAO);
		this.lateralPanel.setCenterPanel(centerPanel);
		this.bottomPanel = new MontageBottonPanel();
		

		//loading components...
		this.load();
		
		// container in main
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		// adding panels
		c.add(this.centerPanel, BorderLayout.CENTER);
		c.add(this.lateralPanel, BorderLayout.WEST);
		c.add(this.bottomPanel, BorderLayout.SOUTH);

		// config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Montage Expert GUI - Version 0.0.1");
		this.setVisible(true);
		this.pack();

	}
	
	private void load(){
		
		List<MontageComponent> components = this.componentDAO.listComponents();
		
		for(MontageComponent mc: components){
			this.lateralPanel.addTreeNode(mc);
		}
	}
	
	public static void main(String[] args) {
		new MontageAppMain();
	}
}
