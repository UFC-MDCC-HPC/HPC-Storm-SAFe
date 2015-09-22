package br.ufc.mdcc.pargo.safe.application.gui;

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

import br.ufc.mdcc.pargo.safe.application.ApplicationClient;
import br.ufc.mdcc.pargo.safe.application.MontageWorkflow;
import br.ufc.mdcc.pargo.safe.application.component.MontageApplication;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;
import br.ufc.mdcc.pargo.safe.util.GuiMsgs;

public class CenterPanel extends JPanel{
	
	
	private JLabel titleName = new JLabel("SELECT A COMPONENT");
	private JLabel inParamsLabel = new JLabel("IN PARAMETERS");
	private JLabel outParamsLabel = new JLabel("OUT PARAMETERS");
	
	private JPanel paramsLabelPanel = new JPanel();
	private JPanel inParamsPanel = new JPanel();
	private JPanel outParamsPanel = new JPanel();
	
	 
	private List<JTextField> inFields = new ArrayList<JTextField>();
	private List<JTextField> outFields = new ArrayList<JTextField>();
	
	private BottomPanel bottomPanel;
	private MontageComponent focusedComponent;
	private MontageApplication focusedApplication;
	private MontageWorkflow workflow;
	
	
	public CenterPanel() {
		this.setPreferredSize(new Dimension(650,400));
		this.setLayout(new BorderLayout());
		
		//look
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setBorder(BorderFactory.createLineBorder(Color.black));
		
		inParamsLabel.setVerticalAlignment(SwingConstants.TOP);
		
		//inParamsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		outParamsLabel.setVerticalAlignment(SwingConstants.TOP);
		//outParamsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//panels upper lables (fancy stuff)
		this.add(titleName,BorderLayout.NORTH);
		paramsLabelPanel.setLayout(new GridLayout(2,2));
		paramsLabelPanel.add(inParamsLabel);
		paramsLabelPanel.add(outParamsLabel);
		this.add(paramsLabelPanel, BorderLayout.CENTER);
		
		
		//panels por text fields
		this.inParamsPanel = new JPanel();
		this.inParamsPanel.setLayout(new GridLayout(0,2));
		this.outParamsPanel = new JPanel();
		this.outParamsPanel.setLayout(new GridLayout(0,2));
		
		paramsLabelPanel.add(inParamsPanel);
		paramsLabelPanel.add(outParamsPanel);
		
		//ok and finish button
		JButton okBtn = new JButton("OK");
		JButton finishBtn = new JButton("FINISH");
		JPanel btnPanel = new JPanel();
		btnPanel.add(okBtn);
		btnPanel.add(finishBtn);
		this.add(btnPanel,BorderLayout.SOUTH);
		
		//listeners for buttons...
		//BTN OK
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusedComponent!=null){
					int reply = JOptionPane.showConfirmDialog(null, "Confirm this component in workflow?",
															   "Confirm Component", JOptionPane.YES_NO_OPTION);
					if(reply==JOptionPane.YES_OPTION){
						bottomPanel.addText(GuiMsgs.COMPONENT_ADDED,focusedComponent.getName());
						getParamValues();
						workflow.addComponentToWorkflow(focusedComponent);
						clearDataGUI();
					}
					
				}
				
			}
		});
		//BTN FINISH
		finishBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int reply = JOptionPane.showConfirmDialog(null, "Finish workflow?",
						   "Confirm Workflow", JOptionPane.YES_NO_OPTION);
				if(reply==JOptionPane.YES_OPTION){
					System.out.println(workflow);
					clearDataGUI();
					
					reply = JOptionPane.showConfirmDialog(null, "Run workflow now?",
							   "Confirm running", JOptionPane.YES_NO_OPTION);
					if(reply==JOptionPane.YES_OPTION){
						ApplicationClient client = new ApplicationClient();
						client.run();
					}
					
				}
			}
		});
		 
	}

	public void updateInfoComponent(MontageComponent mc){
		this.focusedApplication = null;
		this.focusedComponent = mc;
		this.titleName.setText(mc.getName());
		
		this.clearDataGUI();
		
		for(MontageParam mp:mc.getInParams()){
			JPanel insideLabelPanel = new JPanel();
			insideLabelPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			insideLabelPanel.setLayout(new GridLayout(2,1));
			insideLabelPanel.add(new JLabel(mp.getName()));
			insideLabelPanel.add(new JLabel("("+mp.getType()+")"));
			
			inParamsPanel.add(insideLabelPanel);
			JTextField inField  = new JTextField();
			inField.setName(mp.getName());
			inParamsPanel.add(inField);
			this.inFields.add(inField);
		}
		
		for(MontageParam mp:mc.getOutParams()){
			JPanel insideLabelPanel = new JPanel();
			insideLabelPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			insideLabelPanel.setLayout(new GridLayout(2,1));
			insideLabelPanel.add(new JLabel(mp.getName()));
			insideLabelPanel.add(new JLabel("("+mp.getType()+")"));
			
			outParamsPanel.add(insideLabelPanel);
			JTextField outField  = new JTextField();
			outField.setName(mp.getName());
			outParamsPanel.add(outField);
			this.outFields.add(outField);
		}
		
		this.updateUI();
	}
	
	public void updateInfoApplication(MontageApplication mapp){
		
		this.focusedComponent = null;
		this.focusedApplication = mapp;
		this.titleName.setText(mapp.getName());
		
		this.clearDataGUI();
		
		for(MontageParam mp:mapp.getInParams()){
			JPanel insideLabelPanel = new JPanel();
			insideLabelPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			insideLabelPanel.setLayout(new GridLayout(2,1));
			insideLabelPanel.add(new JLabel(mp.getName()));
			insideLabelPanel.add(new JLabel("("+mp.getType()+")"));
			
			inParamsPanel.add(insideLabelPanel);
			JTextField inField  = new JTextField();
			inField.setName(mp.getName());
			inParamsPanel.add(inField);
			this.inFields.add(inField);
		}
		
		for(MontageParam mp:mapp.getOutParams()){
			JPanel insideLabelPanel = new JPanel();
			insideLabelPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			insideLabelPanel.setLayout(new GridLayout(2,1));
			insideLabelPanel.add(new JLabel(mp.getName()));
			insideLabelPanel.add(new JLabel("("+mp.getType()+")"));
			
			outParamsPanel.add(insideLabelPanel);
			JTextField outField  = new JTextField();
			outField.setName(mp.getName());
			outParamsPanel.add(outField);
			this.outFields.add(outField);
		}
		
		this.updateUI();
	}
	
	public void setBottomPanel(BottomPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}
	
	private void getParamValues(){
		for(JTextField inF:inFields){
			MontageParam mp = focusedComponent.getInParam(inF.getName());
			if(mp!=null){
				mp.setValue(inF.getText());
			}
		}
		for(JTextField outF:outFields){
			MontageParam mp = focusedComponent.getOutParam(outF.getName());
			if(mp!=null){
				mp.setValue(outF.getText());
			}
		}
	}
	
	public void setMontageWorkflow(MontageWorkflow workflow){
		this.workflow = workflow;
	}
	
	private void clearDataGUI(){
		this.inParamsPanel.removeAll();
		this.outParamsPanel.removeAll();
		this.inFields.clear();
		this.outFields.clear();
		this.updateUI();
	}
}
