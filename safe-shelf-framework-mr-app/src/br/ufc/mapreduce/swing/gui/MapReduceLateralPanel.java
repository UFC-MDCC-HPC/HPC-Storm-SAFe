package br.ufc.mapreduce.swing.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import br.ufc.mapreduce.swing.dao.MapReduceComponentDAO;
import br.ufc.mapreduce.swing.listener.MapReduceTreeListener;
import br.ufc.mapreduce.swing.model.MapReduceAction;
import br.ufc.mapreduce.swing.model.MapReduceComponent;
import br.ufc.mapreduce.swing.model.MapReduceEnvPort;
import br.ufc.mapreduce.swing.model.MapReduceTskPort;
import br.ufc.mapreduce.swing.workflow.MapReduceWorkflow;

public class MapReduceLateralPanel extends JPanel {

	private JTree tree;
	private MapReduceTreeListener treeListener;
	private JScrollPane treeView;
	private DefaultMutableTreeNode root;
	private MapReduceWorkflow workflow;
	private MapReduceComponentDAO componentDAO;
	private MapReduceCenterPanel centerPanel;

	public MapReduceLateralPanel() {
		// config
		this.setPreferredSize(new Dimension(250, 400));
		this.setBackground(Color.DARK_GRAY);

		// tree initializer
		this.root = new DefaultMutableTreeNode("MAPREDUCE");
		this.tree = new JTree(this.root);

		// JScroll...
		this.treeView = new JScrollPane(this.tree);

		// tree listener
		this.treeListener = new MapReduceTreeListener(this);
		// listining events...
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.treeListener.setTree(tree);
		tree.addTreeSelectionListener(this.treeListener);

		// layout
		this.setLayout(new BorderLayout());
		this.add(this.treeView, BorderLayout.CENTER);
	}
	
	
	
	public void setWorkflow(MapReduceWorkflow workflow) {
		this.workflow = workflow;
		this.treeListener.setWorkflow(workflow);
	}

	public void setComponentDAO(MapReduceComponentDAO componentDAO){
		this.componentDAO = componentDAO;
		this.treeListener.setComponentDAO(componentDAO);
	}
	
	public void setCenterPanel(MapReduceCenterPanel centerPanel){
		this.centerPanel = centerPanel;
		this.treeListener.setCenterPanel(centerPanel);
	}

	public void addTreeNode(MapReduceComponent component){
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(component.getName());
		this.root.add(node);
		
		if(component.getEnvPorts()!=null && component.getEnvPorts().size()>0){
			DefaultMutableTreeNode envNode = new DefaultMutableTreeNode("env_ports");
			node.add(envNode);
			DefaultMutableTreeNode typeP = new DefaultMutableTreeNode("provides");
			DefaultMutableTreeNode typeU = new DefaultMutableTreeNode("uses");
			for(MapReduceEnvPort env:component.getEnvPorts()){
				//DefaultMutableTreeNode port = new DefaultMutableTreeNode(env.getId_component()+"-"+env.getName());
				DefaultMutableTreeNode port = new DefaultMutableTreeNode(env.getName());
				if(env.getType().equals(MapReduceEnvPort.PROVIDES_PORT)){
					typeP.add(port);
				}else typeU.add(port);
			}
			
			if(typeP.getChildCount()>0) envNode.add(typeP);
			if(typeU.getChildCount()>0) envNode.add(typeU);
		}
		
		if(component.getTskPorts()!=null && component.getTskPorts().size()>0){
			DefaultMutableTreeNode tskNode = new DefaultMutableTreeNode("tsk_ports");
			node.add(tskNode);
			for(MapReduceTskPort tsk:component.getTskPorts()){
				//DefaultMutableTreeNode port = new DefaultMutableTreeNode(tsk.getId_component()+"-"+tsk.getName());
				DefaultMutableTreeNode port = new DefaultMutableTreeNode(tsk.getName());
				tskNode.add(port);
				for(MapReduceAction action:tsk.getActions()){
					DefaultMutableTreeNode actionNode = new DefaultMutableTreeNode(action.getId()+"-"+action.getName());
					port.add(actionNode);
				}
			}
		}
		
		this.tree.expandRow(0);
		this.tree.updateUI();
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

}
