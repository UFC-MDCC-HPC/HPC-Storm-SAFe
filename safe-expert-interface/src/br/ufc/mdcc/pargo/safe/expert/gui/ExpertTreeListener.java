package br.ufc.mdcc.pargo.safe.expert.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;

public class ExpertTreeListener implements TreeSelectionListener {

	private JTree tree;
	private ExpertLateralPanel lateralPanel;
	private ExpertCenterPanel centerPanel;

	public ExpertTreeListener(ExpertLateralPanel lateralPanel) {
		this.lateralPanel = lateralPanel;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			// Nothing is selected.
			return;
		
		Object nodeInfo = node.getUserObject();
		WorkflowModel ref = this.lateralPanel.getWorkflowModel(nodeInfo
				.toString());
		if(ref!=null)
			this.centerPanel.updateWorkflowModelInfo(ref);


	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
	
	public void setCenterPanel(ExpertCenterPanel centerPanel){
		this.centerPanel = centerPanel;
	}

}
