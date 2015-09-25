package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufc.mdcc.pargo.safe.expert.client.SAFeClient;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowParameter;

public class ExpertCenterPanel extends JPanel {

	private WorkflowModel focusedWorkflowModel;
	private SAFeClient safeClient;
	private ExpertBottomPanel bottomPanel;

	private JLabel titleName = new JLabel("SELECT A WORKFLOW");
	private JLabel inParamsLabel = new JLabel("IN PARAMETERS");
	private JLabel outParamsLabel = new JLabel("OUT PARAMETERS");

	private JPanel paramsLabelPanel = new JPanel();
	private JPanel inParamsPanel = new JPanel();
	private JPanel outParamsPanel = new JPanel();

	private List<JTextField> inFields = new ArrayList<JTextField>();
	private List<JTextField> outFields = new ArrayList<JTextField>();

	public ExpertCenterPanel(SAFeClient safeClient) {
		this.safeClient = safeClient;
		this.setPreferredSize(new Dimension(650, 400));
		this.setLayout(new BorderLayout());

		// look
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setBorder(BorderFactory.createLineBorder(Color.black));

		inParamsLabel.setVerticalAlignment(SwingConstants.TOP);
		outParamsLabel.setVerticalAlignment(SwingConstants.TOP);

		// panels upper lables (fancy stuff)
		this.add(titleName, BorderLayout.NORTH);
		paramsLabelPanel.setLayout(new GridLayout(2, 2));
		paramsLabelPanel.add(inParamsLabel);
		paramsLabelPanel.add(outParamsLabel);
		this.add(paramsLabelPanel, BorderLayout.CENTER);

		// panels por text fields
		this.inParamsPanel = new JPanel();
		this.inParamsPanel.setLayout(new GridLayout(0, 2));
		this.outParamsPanel = new JPanel();
		this.outParamsPanel.setLayout(new GridLayout(0, 2));

		paramsLabelPanel.add(inParamsPanel);
		paramsLabelPanel.add(outParamsPanel);

		// ok and finish button
		JButton okBtn = new JButton("OK");
		JButton finishBtn = new JButton("FINISH");
		JPanel btnPanel = new JPanel();
		btnPanel.add(okBtn);
		btnPanel.add(finishBtn);
		this.add(btnPanel, BorderLayout.SOUTH);
		
		//button listeners
		this.okListener(okBtn);
		this.finishListener(finishBtn);
	}

	public void updateWorkflowModelInfo(WorkflowModel model) {
		this.focusedWorkflowModel = model;
		this.titleName.setText(model.getWorkflowName());

		this.clearDataGUI();

		for (WorkflowParameter parameter : model.getParameters()) {

			JPanel insideLabelPanel = new JPanel();
			insideLabelPanel.setBorder(BorderFactory
					.createLineBorder(Color.black));
			insideLabelPanel.setLayout(new GridLayout(2, 1));
			insideLabelPanel.add(new JLabel(parameter.getName()));
			insideLabelPanel.add(new JLabel("(" + parameter.getType() + ")"));

			if (parameter.getNature().equalsIgnoreCase("IN")) {

				inParamsPanel.add(insideLabelPanel);
				JTextField inField = new JTextField();
				inField.setName(parameter.getName());
				inParamsPanel.add(inField);
				this.inFields.add(inField);
			} else if (parameter.getNature().equalsIgnoreCase("OUT")) {
				outParamsPanel.add(insideLabelPanel);
				JTextField outField = new JTextField();
				outField.setName(parameter.getName());
				outParamsPanel.add(outField);
				this.outFields.add(outField);
			}

		}

		this.updateUI();
	}

	private void clearDataGUI() {
		this.inParamsPanel.removeAll();
		this.outParamsPanel.removeAll();
		this.inFields.clear();
		this.outFields.clear();
		this.updateUI();
	}

	private void okListener(JButton okBtn) {
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void finishListener(JButton finishBtn) {
		finishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusedWorkflowModel!=null){
					int reply = JOptionPane.showConfirmDialog(null, "Run workflow \""+focusedWorkflowModel.getWorkflowName()+"\" now?",
							   "Confirm Run", JOptionPane.YES_NO_OPTION);
					if(reply==JOptionPane.YES_OPTION){
						bottomPanel.addText("MSG", "Sending arch file...");
						safeClient.setSAFeSWLArchSource(focusedWorkflowModel.getArchXMLFilePath(),
													    focusedWorkflowModel.getArchFileName());
						bottomPanel.addText("MSG", "Sending flow file...");
						safeClient.setSAFeSWLFlowSource(focusedWorkflowModel.getFlowXMLFilePath(),
													    focusedWorkflowModel.getFlowFileName());
						bottomPanel.addText("MSG", "Runnning workflow...");
						safeClient.run();
					}	
				}
				
			}
		});
	}
	
	public void setBottomPanel(ExpertBottomPanel bottomPanel){
		this.bottomPanel = bottomPanel;
	}
}
