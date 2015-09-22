package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;
import br.ufc.mdcc.pargo.safe.expert.xml.SAFeApplicationXMLParser;

public class ExpertLateralPanel extends JPanel {

	private JTree tree;
	private JScrollPane treeView;
	private DefaultMutableTreeNode root;
	private SAFeApplicationXMLParser parser;
	
	public ExpertLateralPanel() {
		// config
		this.setPreferredSize(new Dimension(250, 400));
		this.setBackground(Color.DARK_GRAY);

		// tree initializer
		this.root = new DefaultMutableTreeNode("SAFe Applications");
		this.tree = new JTree(this.root);

		// JScroll...
		this.treeView = new JScrollPane(this.tree);

		// layout
		this.setLayout(new BorderLayout());
		this.add(this.treeView, BorderLayout.CENTER);
		
		//XML Parser
		this.parser = new SAFeApplicationXMLParser();
	}

	public void addTreeNodeApplication(WorkflowModel model) {
		DefaultMutableTreeNode node 
			= new DefaultMutableTreeNode(model.getWorkflowName());
		this.root.add(node);
		//read XML here!
		this.parser.parseXMLApplication(model.getArchXMLFilePath());
		
		/*
		 * this.topApplications.add(category); DefaultMutableTreeNode in = new
		 * DefaultMutableTreeNode("in"); for(MontageParam
		 * mp:mapp.getInParams()){ DefaultMutableTreeNode param = new
		 * DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
		 * in.add(param); }
		 * 
		 * DefaultMutableTreeNode out = new DefaultMutableTreeNode("out");
		 * for(MontageParam mp:mapp.getOutParams()){ DefaultMutableTreeNode
		 * param = new DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
		 * out.add(param); } category.add(in); category.add(out);
		 */
		this.tree.expandRow(0);
		this.tree.updateUI();
	}
	
	 
}
