package br.ufc.mdcc.pargo.safe.expert.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeListener implements TreeSelectionListener {

	private JTree tree;

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			// Nothing is selected.
			return;

		Object nodeInfo = node.getUserObject();
		if (!node.isLeaf()) {

			

		}

	}

}
