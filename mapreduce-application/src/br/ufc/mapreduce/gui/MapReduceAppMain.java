package br.ufc.mapreduce.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.ufc.mapreduce.dao.MapReduceComponentDAO;
import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.safeswl.ArchFileGenerator;
import br.ufc.mapreduce.util.MapReduceUtil;
import br.ufc.mapreduce.workflow.MapReduceWorkflow;

public class MapReduceAppMain extends JFrame {

	private MapReduceCenterPanel centerPanel;
	private MapReduceLateralPanel lateralPanel;
	private MapReduceBottonPanel bottomPanel;
	private MapReduceWorkflow workflow;
	private MapReduceComponentDAO componentDAO;
	
	private ArchFileGenerator archGenerator;
	
	 

	public MapReduceAppMain() {
		
		//DAO
		this.componentDAO = new MapReduceComponentDAO();
		 
		
		//workflow of acts
		this.workflow = new MapReduceWorkflow();
		
		// creating panels...
		this.centerPanel = new MapReduceCenterPanel(this.componentDAO);
		this.centerPanel.setWorkflow(workflow);
		 
		this.lateralPanel = new MapReduceLateralPanel();
		this.lateralPanel.setWorkflow(workflow);
		this.lateralPanel.setComponentDAO(componentDAO);
		this.lateralPanel.setCenterPanel(centerPanel);
		this.bottomPanel = new MapReduceBottonPanel();
		
		this.archGenerator = new ArchFileGenerator();
		

		//loading components...
		this.load();
		
		// container in main
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		// adding panels
		c.add(this.centerPanel, BorderLayout.CENTER);
		c.add(this.lateralPanel, BorderLayout.WEST);
		c.add(this.bottomPanel, BorderLayout.SOUTH);

		//menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menu.add(menuItemSave);
		
		JMenuItem menuItemLoad = new JMenuItem("Load");
		menu.add(menuItemLoad);
		
		JMenuItem menuItemArch = new JMenuItem("Arch XML");
		menu.add(menuItemArch);
		
		JMenuItem menuItemFlow = new JMenuItem("Flow XML");
		menu.add(menuItemFlow);
		
		JMenuItem menuItemRun = new JMenuItem("Run");
		menu.add(menuItemRun);
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		//actions
		menuItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MapReduceUtil.serializeWorkflow(workflow);
			}
		});
		
		menuItemLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				workflow = MapReduceUtil.deserializeWorkflow();
				//System.out.println(workflow);
				centerPanel.setWorkflow(workflow);
				centerPanel.updatePanel();
				lateralPanel.setWorkflow(workflow);
			}
		});
		
		
		menuItemArch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				archGenerator.generate(workflow);	
			}
		});
		
		// config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("MapReduce Expert GUI - Version 0.0.1");
		this.setVisible(true);
		this.pack();

	}
	
	private void load(){
		
		List<MapReduceComponent> components = this.componentDAO.listComponents();
		
		for(MapReduceComponent mc: components){
			this.lateralPanel.addTreeNode(mc);
		}
	}
	
	public static void main(String[] args) {
		new MapReduceAppMain();
	}
	
	public void printWorkflow(MapReduceWorkflow workflow){
		
	}
}
