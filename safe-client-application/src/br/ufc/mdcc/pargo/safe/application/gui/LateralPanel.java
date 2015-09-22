package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import br.ufc.mdcc.pargo.safe.application.component.MontageRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageApplication;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;

public class LateralPanel extends JPanel{
	
	private JTree tree;
	private JScrollPane treeView;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode topComponents;
	private DefaultMutableTreeNode topApplications;
	private TreeListener treeListener;
	
	public LateralPanel() {
		//config
		this.setPreferredSize(new Dimension(250,400));
		this.setBackground(Color.DARK_GRAY);
		//create tree
		this.root = new DefaultMutableTreeNode("Montage");
		this.topComponents = new DefaultMutableTreeNode("Montage Components");
		this.topApplications = new DefaultMutableTreeNode("Montage Applications");
		this.root.add(this.topComponents);
		this.root.add(this.topApplications);
		this.tree = new JTree(this.root);
		this.treeListener = new TreeListener();
		
		//JScroll...
		this.treeView = new JScrollPane(this.tree);
		
		//layout
		this.setLayout(new BorderLayout());
		this.add(this.treeView,BorderLayout.CENTER);
		
		//listining events...
		tree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.treeListener.setTree(tree);
		tree.addTreeSelectionListener(this.treeListener);
		
	}
	
	public void addTreeNodeComponent(MontageComponent mc){
		 DefaultMutableTreeNode category = null;
		 category = new DefaultMutableTreeNode(mc.getName());
		 this.topComponents.add(category);
		 DefaultMutableTreeNode in = new DefaultMutableTreeNode("in");
		 for(MontageParam mp:mc.getInParams()){
			 DefaultMutableTreeNode param = new DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
			 in.add(param);
		 }
		 
		 DefaultMutableTreeNode out = new DefaultMutableTreeNode("out");
		 for(MontageParam mp:mc.getOutParams()){
			 DefaultMutableTreeNode param = new DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
			 out.add(param);
		 }
		 category.add(in);
		 category.add(out);
		 this.tree.expandRow(0);
		 this.tree.updateUI();
	}
	
	public void addTreeNodeApplication(MontageApplication mapp){
		 DefaultMutableTreeNode category = null;
		 category = new DefaultMutableTreeNode(mapp.getName());
		 this.topApplications.add(category);
		 DefaultMutableTreeNode in = new DefaultMutableTreeNode("in");
		 for(MontageParam mp:mapp.getInParams()){
			 DefaultMutableTreeNode param = new DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
			 in.add(param);
		 }
		 
		 DefaultMutableTreeNode out = new DefaultMutableTreeNode("out");
		 for(MontageParam mp:mapp.getOutParams()){
			 DefaultMutableTreeNode param = new DefaultMutableTreeNode(mp.getName()+" : "+mp.getType());
			 out.add(param);
		 }
		 category.add(in);
		 category.add(out);
		 this.tree.expandRow(0);
		 this.tree.updateUI();
	}

	public void setCenterPanel(CenterPanel centerPanel){
		this.treeListener.setCenterPanel(centerPanel);
	}
	
	public void setRepository(MontageRepository repository){
		this.treeListener.setRepository(repository);
	}
	
	
}
