package br.ufc.montage.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.ufc.montage.dao.MontageComponentDAO;
import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.util.MontageUtil;
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
				MontageUtil.serializeWorkflow(workflow);
			}
		});
		
		menuItemLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				workflow = MontageUtil.deserializeWorkflow();
				//System.out.println(workflow);
				centerPanel.setWorkflow(workflow);
				centerPanel.updatePanel();
			}
		});
		
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
