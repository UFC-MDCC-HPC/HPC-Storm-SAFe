package br.ufc.montage.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import br.ufc.montage.dao.MontageComponentDAO;
import br.ufc.montage.gui.MontageCenterPanel;
import br.ufc.montage.gui.MontageLateralPanel;
import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.workflow.MontageAct;
import br.ufc.montage.workflow.MontageWorkflow;

public class MontageTreeListener extends MouseAdapter implements
		TreeSelectionListener {

	private JTree tree;
	private MontageLateralPanel montageLateralPanel;
	private MontageWorkflow workflow;
	private MontageComponentDAO componentDAO;
	private MontageCenterPanel centerPanel;

	public MontageTreeListener(MontageLateralPanel montageLateralPanel) {
		this.montageLateralPanel = montageLateralPanel;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
		this.tree.addMouseListener(this);

	}

	public void setMontageLateralPanel(MontageLateralPanel montageLateralPanel) {
		this.montageLateralPanel = montageLateralPanel;
	}

	public void setWorkflow(MontageWorkflow workflow) {
		this.workflow = workflow;
	}

	public void setComponentDAO(MontageComponentDAO componentDAO) {
		this.componentDAO = componentDAO;
	}
	
	public void setCenterPanel(MontageCenterPanel centerPanel){
		this.centerPanel = centerPanel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int selRow = tree.getRowForLocation(e.getX(), e.getY());
		TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		if (selRow != -1) {
			if (e.getClickCount() == 1) {
				// mySingleClick(selRow, selPath);
			} else if (e.getClickCount() == 2) {
				Object selectedNode = ((DefaultMutableTreeNode) selPath
						.getLastPathComponent()).getUserObject();
				MontageComponent component = componentDAO
						.getComponentByName(selectedNode.toString().trim());
				if (component != null) {
					int reply = JOptionPane.showConfirmDialog(null,
							"Add this component?", "Add Component",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						Integer actPosition = Integer.parseInt(JOptionPane.showInputDialog("Set Act", 0));
						this.workflow.addComponentToAct(component, actPosition);
						this.centerPanel.updatePanel();
					} 
				}//component
			}
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();
		if (node == null)
			return;
		Object nodeInfo = node.getUserObject();
		MontageComponent component = this.componentDAO
				.getComponentByName(nodeInfo.toString().trim());
		if (component != null) {

		}
	}

}
