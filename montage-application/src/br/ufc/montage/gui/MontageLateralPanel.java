package br.ufc.montage.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import br.ufc.montage.dao.MontageComponentDAO;
import br.ufc.montage.listener.MontageTreeListener;
import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;
import br.ufc.montage.model.MontageTskPort;
import br.ufc.montage.workflow.MontageWorkflow;

public class MontageLateralPanel extends JPanel {

	private JTree tree;
	private MontageTreeListener treeListener;
	private JScrollPane treeView;
	private DefaultMutableTreeNode root;
	private MontageWorkflow workflow;
	private MontageComponentDAO componentDAO;
	private MontageCenterPanel centerPanel;

	public MontageLateralPanel() {
		// config
		this.setPreferredSize(new Dimension(250, 400));
		this.setBackground(Color.DARK_GRAY);

		// tree initializer
		this.root = new DefaultMutableTreeNode("MONTAGE");
		this.tree = new JTree(this.root);

		// JScroll...
		this.treeView = new JScrollPane(this.tree);

		// tree listener
		this.treeListener = new MontageTreeListener(this);
		// listining events...
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.treeListener.setTree(tree);
		tree.addTreeSelectionListener(this.treeListener);

		// layout
		this.setLayout(new BorderLayout());
		this.add(this.treeView, BorderLayout.CENTER);
	}
	
	
	
	public void setWorkflow(MontageWorkflow workflow) {
		this.workflow = workflow;
		this.treeListener.setWorkflow(workflow);
	}

	public void setComponentDAO(MontageComponentDAO componentDAO){
		this.componentDAO = componentDAO;
		this.treeListener.setComponentDAO(componentDAO);
	}
	
	public void setCenterPanel(MontageCenterPanel centerPanel){
		this.centerPanel = centerPanel;
		this.treeListener.setCenterPanel(centerPanel);
	}

	public void addTreeNode(MontageComponent component){
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(component.getName());
		this.root.add(node);
		
		if(component.getEnvPorts()!=null && component.getEnvPorts().size()>0){
			DefaultMutableTreeNode envNode = new DefaultMutableTreeNode("env_ports");
			node.add(envNode);
			DefaultMutableTreeNode typeP = new DefaultMutableTreeNode("provides");
			DefaultMutableTreeNode typeU = new DefaultMutableTreeNode("uses");
			for(MontageEnvPort env:component.getEnvPorts()){
				DefaultMutableTreeNode port = new DefaultMutableTreeNode(env.getName());
				 
				if(env.getType().equals(MontageEnvPort.PROVIDES_PORT)){
					typeP.add(port);
				}else typeU.add(port);
			}
			
			if(typeP.getChildCount()>0) envNode.add(typeP);
			if(typeU.getChildCount()>0) envNode.add(typeU);
		}
		
		if(component.getTskPorts()!=null && component.getTskPorts().size()>0){
			DefaultMutableTreeNode tskNode = new DefaultMutableTreeNode("tsk_ports");
			node.add(tskNode);
			for(MontageTskPort tsk:component.getTskPorts()){
				DefaultMutableTreeNode port = new DefaultMutableTreeNode(tsk.getName());
				tskNode.add(port);
			}
		}
		
		this.tree.expandRow(0);
		this.tree.updateUI();
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

}
