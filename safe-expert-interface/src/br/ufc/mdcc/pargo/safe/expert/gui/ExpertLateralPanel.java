package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowParameter;
import br.ufc.mdcc.pargo.safe.expert.xml.SAFeApplicationXMLParser;

public class ExpertLateralPanel extends JPanel {

	private JTree tree;
	private JScrollPane treeView;
	private DefaultMutableTreeNode root;
	private SAFeApplicationXMLParser parser;
	private ExpertTreeListener treeListener;
	
	private Map<String, WorkflowModel> treeNodeMap;

	public ExpertLateralPanel() {
		// config
		this.setPreferredSize(new Dimension(250, 400));
		this.setBackground(Color.DARK_GRAY);

		// tree initializer
		this.root = new DefaultMutableTreeNode("SAFe Applications");
		this.tree = new JTree(this.root);

		// JScroll...
		this.treeView = new JScrollPane(this.tree);

		// tree listener
		this.treeListener = new ExpertTreeListener(this);
		// listining events...
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.treeListener.setTree(tree);
		tree.addTreeSelectionListener(this.treeListener);
		//treeNodeMap
		this.treeNodeMap = new HashMap<String, WorkflowModel>();

		// layout
		this.setLayout(new BorderLayout());
		this.add(this.treeView, BorderLayout.CENTER);

		// XML Parser
		this.parser = new SAFeApplicationXMLParser();
	}

	public void addTreeNodeApplication(WorkflowModel model) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(
				model.getWorkflowName());
		this.root.add(node);
		// read XML here!
		this.parser.parseXMLWorkflow(model.getArchXMLFilePath(), model);
		for (WorkflowParameter parameter : model.getParameters()) {
			DefaultMutableTreeNode parameterNode = new DefaultMutableTreeNode(
					parameter.getName());
			node.add(parameterNode);
		}

		this.treeNodeMap.put(model.getWorkflowName(), model);
		this.tree.expandRow(0);
		this.tree.updateUI();
	}
	
	public WorkflowModel getWorkflowModel(String key){
		return this.treeNodeMap.get(key);
	}

	public void setCenterPanel(ExpertCenterPanel centerPanel){
		this.treeListener.setCenterPanel(centerPanel);
	}
}
