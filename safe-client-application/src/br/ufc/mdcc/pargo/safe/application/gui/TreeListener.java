package br.ufc.mdcc.pargo.safe.application.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import br.ufc.mdcc.pargo.safe.application.component.ComponentRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;

public class TreeListener implements TreeSelectionListener {

	private JTree tree;
	private CenterPanel centerPanel;
	private ComponentRepository repository;


	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			// Nothing is selected.
			return;

		Object nodeInfo = node.getUserObject();
		if(!node.isLeaf()){
			MontageComponent ref = new MontageComponent(nodeInfo.toString().trim());
			MontageComponent mc = this.repository.getComponent(ref);
			if(mc!=null){
				this.centerPanel.updateInfo(mc);
			}
		}

	}


	public void setCenterPanel(CenterPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
	
	
	public void setTree(JTree tree) {
		this.tree = tree;
	}
	
	public void setRepository(ComponentRepository rep){
		this.repository = rep;
	}
	

}
