package br.ufc.montage.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ufc.montage.dao.MontageComponentDAO;
import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.workflow.MontageAct;
import br.ufc.montage.workflow.MontageWorkflow;

public class MontageCenterPanel extends JPanel{

	private MontageWorkflow workflow;
	private MontageComponentDAO componentDAO;
	 
	
	public MontageCenterPanel(MontageComponentDAO componentDAO) {
		this.componentDAO = componentDAO;
		this.setPreferredSize(new Dimension(650, 400));
		this.setLayout(new FlowLayout());
	}
	
	public void setWorkflow(MontageWorkflow workflow){
		this.workflow = workflow;
	}
	
	public void updatePanel(){
		
		this.removeAll();
		
		for(MontageAct act:this.workflow.listActs()){
			ActPanel actPanel = new ActPanel(act, workflow);
			this.add(actPanel);
		}
		
		this.updateUI();
	}

	 
}

class ActPanel extends JPanel{
	
	public ActPanel(final MontageAct act, final MontageWorkflow workflow) {
		
		 
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel labelTitle = new JLabel("ACT "+act.getPosition());
		this.add(labelTitle,BorderLayout.NORTH);
		JPanel panelComponents = new JPanel();
		panelComponents.setLayout(new FlowLayout());
		
		for(final MontageComponent c:act.listComponents()){
			JButton btn = new JButton(c.getName());
			panelComponents.add(btn);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MontageConnectionPanel conn = new MontageConnectionPanel(c, workflow, act.getPosition());
					int reply = JOptionPane.showConfirmDialog(null, conn, c.getName(),JOptionPane.YES_NO_CANCEL_OPTION);
					if(reply==JOptionPane.YES_OPTION){
						conn.analyseChoices();
					}else if (reply==JOptionPane.CANCEL_OPTION){
						workflow.deleteConnections(act.getPosition(), c.getName());
					}
				}
			});
		}
		this.add(panelComponents,BorderLayout.CENTER);
	}
}




