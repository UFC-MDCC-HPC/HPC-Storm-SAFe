package br.ufc.mdcc.pargo.safe.application.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import br.ufc.mdcc.pargo.safe.application.component.MontageRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageApplication;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;

public class TreeListener implements TreeSelectionListener {

	private JTree tree;
	private CenterPanel centerPanel;
	private MontageRepository repository;


	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			// Nothing is selected.
			return;

		Object nodeInfo = node.getUserObject();
		if(!node.isLeaf()){
		
			
			//try component...
			MontageComponent refComp = new MontageComponent(nodeInfo.toString().trim());
			MontageComponent mc = this.repository.getComponent(refComp);
			if(mc!=null){
				this.centerPanel.updateInfoComponent(mc);
			}
			
			//try application
			MontageApplication refApp = new MontageApplication(nodeInfo.toString().trim());
			MontageApplication mapp = this.repository.getApplication(refApp);
			if(mapp!=null){
				this.centerPanel.updateInfoApplication(mapp);
			}
			
		}

	}


	public void setCenterPanel(CenterPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
	
	
	public void setTree(JTree tree) {
		this.tree = tree;
	}
	
	public void setRepository(MontageRepository rep){
		this.repository = rep;
	}
	

}
