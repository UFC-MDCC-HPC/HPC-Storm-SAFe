package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import br.ufc.mdcc.pargo.safe.expert.dao.IWorkflowDAO;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowDAOImpl;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;

public class ExpertMainJFrame extends JFrame {

	private ExpertCenterPanel centerPanel;
	private ExpertLateralPanel lateralPanel;
	private ExpertBottomPanel bottomPanel;
	private ExpertUpperPanel upperPanel;
	
	private IWorkflowDAO workflowDAO;

	public ExpertMainJFrame() {
		// creating panels...
		this.centerPanel = new ExpertCenterPanel();
		this.lateralPanel = new ExpertLateralPanel();
		this.bottomPanel = new ExpertBottomPanel();
		this.upperPanel = new ExpertUpperPanel();
		
		//creating DAO
		this.workflowDAO = new WorkflowDAOImpl();
		
		//feeding lateral panel
		for(WorkflowModel model:this.workflowDAO.load())
			this.lateralPanel.addTreeNodeApplication(model);
		

		// container in main
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		// adding panels
		c.add(this.centerPanel, BorderLayout.CENTER);
		c.add(this.lateralPanel, BorderLayout.WEST);
		c.add(this.bottomPanel, BorderLayout.SOUTH);
		c.add(this.upperPanel, BorderLayout.NORTH);

		// config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("SAFe Expert GUI - Version 0.0.1");
		this.setVisible(true);
		this.pack();
	}
	
	public static void main(String[] args) {
		new ExpertMainJFrame();
	}
}
