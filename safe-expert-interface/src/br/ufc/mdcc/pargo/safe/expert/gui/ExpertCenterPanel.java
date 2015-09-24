package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;

public class ExpertCenterPanel extends JPanel {

	private WorkflowModel focusedWorkflowModel;

	private JLabel titleName = new JLabel("SELECT A WORKFLOW");
	private JLabel inParamsLabel = new JLabel("IN PARAMETERS");
	private JLabel outParamsLabel = new JLabel("OUT PARAMETERS");

	private JPanel paramsLabelPanel = new JPanel();
	private JPanel inParamsPanel = new JPanel();
	private JPanel outParamsPanel = new JPanel();

	public ExpertCenterPanel() {
		this.setPreferredSize(new Dimension(650, 400));
		this.setLayout(new BorderLayout());

		// look
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setBorder(BorderFactory.createLineBorder(Color.black));

		inParamsLabel.setVerticalAlignment(SwingConstants.TOP);
		outParamsLabel.setVerticalAlignment(SwingConstants.TOP);

		// panels upper lables (fancy stuff)
		this.add(titleName, BorderLayout.NORTH);
		paramsLabelPanel.setLayout(new GridLayout(1, 2));
		paramsLabelPanel.add(inParamsLabel);
		paramsLabelPanel.add(outParamsLabel);
		this.add(paramsLabelPanel, BorderLayout.CENTER);
	}

	public void updateWorkflowModelInfo(WorkflowModel model) {
		this.focusedWorkflowModel = model;
	}
}
