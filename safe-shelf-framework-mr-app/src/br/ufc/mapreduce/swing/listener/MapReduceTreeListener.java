package br.ufc.mapreduce.swing.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import br.ufc.mapreduce.swing.dao.MapReduceComponentDAO;
import br.ufc.mapreduce.swing.gui.MapReduceCenterPanel;
import br.ufc.mapreduce.swing.gui.MapReduceLateralPanel;
import br.ufc.mapreduce.swing.model.MapReduceComponent;
import br.ufc.mapreduce.swing.workflow.MapReduceAct;
import br.ufc.mapreduce.swing.workflow.MapReduceWorkflow;

public class MapReduceTreeListener extends MouseAdapter implements
		TreeSelectionListener {

	private JTree tree;
	private MapReduceLateralPanel montageLateralPanel;
	private MapReduceWorkflow workflow;
	private MapReduceComponentDAO componentDAO;
	private MapReduceCenterPanel centerPanel;

	public MapReduceTreeListener(MapReduceLateralPanel montageLateralPanel) {
		this.montageLateralPanel = montageLateralPanel;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
		this.tree.addMouseListener(this);

	}

	public void setMontageLateralPanel(MapReduceLateralPanel montageLateralPanel) {
		this.montageLateralPanel = montageLateralPanel;
	}

	public void setWorkflow(MapReduceWorkflow workflow) {
		this.workflow = workflow;
	}

	public void setComponentDAO(MapReduceComponentDAO componentDAO) {
		this.componentDAO = componentDAO;
	}
	
	public void setCenterPanel(MapReduceCenterPanel centerPanel){
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
				MapReduceComponent component = componentDAO
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
		MapReduceComponent component = this.componentDAO
				.getComponentByName(nodeInfo.toString().trim());
		if (component != null) {

		}
	}

}
