package br.ufc.mapreduce.swing.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.mapreduce.swing.model.MapReduceComponent;
import br.ufc.mapreduce.swing.model.MapReduceEnvPort;
import br.ufc.mapreduce.swing.model.MapReduceTskPort;
import br.ufc.mapreduce.swing.workflow.MapReduceEnvConnection;
import br.ufc.mapreduce.swing.workflow.MapReduceTskConnection;
import br.ufc.mapreduce.swing.workflow.MapReduceWorkflow;

public class MapReducePopUpPanel extends JPanel {

	List<String> labelEnvList;
	List<JComboBox<String>> comboBoxEnvList;
	List<String> labelTskList;
	List<JComboBox<String>> comboBoxTskList;
	MapReduceComponent component;
	MapReduceWorkflow workflow;
	Integer actPosition;
	JFileChooser fileChooser = new JFileChooser();
	String contractPath="";

	public MapReducePopUpPanel(MapReduceComponent component,
			MapReduceWorkflow workflow, Integer actPosition) {
		this.component = component;
		this.workflow = workflow;
		this.actPosition = actPosition;
		this.setPreferredSize(new Dimension(400, 400));
		this.setLayout(new GridLayout(0, 2));

		 
		
		this.add(new JLabel("USES PORTS"));
		this.add(new JLabel("PROVIDES PORTS"));

		// ENV
		Vector<String> comboStringsEnv = new Vector<String>();
		comboStringsEnv.add("NONE");
		for (MapReduceComponent c : workflow.listComponents()) {
			if (!c.getName().equals(component.getName())) {
				for (MapReduceEnvPort p : c.getEnvPorts()) {
					if (p.getType().equals(MapReduceEnvPort.PROVIDES_PORT)) {
						comboStringsEnv.add(c.getName() + "#" + p.getName());
					}
				}
			}
		}

		labelEnvList = new ArrayList<String>();
		comboBoxEnvList = new ArrayList<JComboBox<String>>();

		for (MapReduceEnvPort env : component.getEnvPorts()) {
			if (env.getType().equals(MapReduceEnvPort.USES_PORT)) {

				JLabel label = new JLabel(env.getName());
				JComboBox<String> comboBox = new JComboBox<String>(
						comboStringsEnv);

				this.add(label);
				labelEnvList.add(env.getName());

				String selected = this.getEnvString(this.actPosition,
						this.component.getName(), env.getName());
				if (selected != null)
					comboBox.setSelectedItem(selected);

				this.add(comboBox);
				comboBoxEnvList.add(comboBox);
			}
		}

		// TASK
		if (this.component.getKind().equals(MapReduceComponent.WORKFLOW_KIND)) {
			this.add(new JLabel("TASK PORT A"));
			this.add(new JLabel("TASK PORT B"));

			Vector<String> comboStringsTask = new Vector<String>();
			comboStringsTask.add("NONE");
			for (MapReduceComponent c : workflow.listComponents()) {
				if (!c.getName().equals(component.getName())) {
					for (MapReduceTskPort p : c.getTskPorts()) {
						comboStringsTask.add(c.getName() + "#" + p.getName());

					}
				}
			}

			labelTskList = new ArrayList<String>();
			comboBoxTskList = new ArrayList<JComboBox<String>>();
			for (MapReduceTskPort tsk : component.getTskPorts()) {

				JLabel label = new JLabel(tsk.getName());
				JComboBox<String> comboBox = new JComboBox<String>(
						comboStringsTask);

				this.add(label);
				labelTskList.add(tsk.getName());

				String selected = this.getTskString(this.actPosition,
						this.component.getName(), tsk.getName());
				if (selected != null) {
					comboBox.setSelectedItem(selected);
				}

				this.add(comboBox);

				comboBoxTskList.add(comboBox);

			}
		}
		
		
		if(component.getKind().equals(MapReduceComponent.COMPUTATION_KIND)){
			JLabel labelFile = new JLabel("Contextual Contract: ");
			this.add(labelFile);
			JButton buttonFile = new JButton("Select File...");
			buttonFile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 int returnValue = fileChooser.showOpenDialog(MapReducePopUpPanel.this);
					 if (returnValue == JFileChooser.APPROVE_OPTION) {
			                File file = fileChooser.getSelectedFile();
			                //System.out.println(file.getAbsolutePath());
			                contractPath = file.getAbsolutePath();
					 }
				}
			});
			this.add(buttonFile);
			
			
		}
		
		

	}

	public void analyseChoices() {
		int i = 0;
		for (JComboBox<String> cb : this.comboBoxEnvList) {

			String envCb = (String) cb.getSelectedItem();
			String relatedUses = this.labelEnvList.get(i);
			// System.out.println(relatedUses+"->"+envCb);
			if (!(envCb.equals("NONE"))) {

				String[] provs = envCb.split("#");

				MapReduceEnvConnection envConn = new MapReduceEnvConnection(
						provs[0], provs[1], this.component.getName(),
						relatedUses);
				this.workflow.addEnvConn(envConn, this.actPosition);
				System.out.println(envConn);
			}

			i++;
		}

		if (this.component.getKind().equals(MapReduceComponent.WORKFLOW_KIND)) {
			i = 0;
			for (JComboBox<String> cb : this.comboBoxTskList) {
				String tskCb = (String) cb.getSelectedItem();
				String relatedTsk = this.labelTskList.get(i);
				// System.out.println(relatedTsk+"-"+tskCb);
				if (!(tskCb.equals("NONE"))) {
					String[] tsks = tskCb.split("#");
					MapReduceTskConnection tskConn = new MapReduceTskConnection(
							this.component.getName(), relatedTsk, tsks[0],
							tsks[1]);
					this.workflow.addTskConn(tskConn, this.actPosition);
					System.out.println(tskConn);
				}
				i++;
			}
		}
		
		if(contractPath!=null && !contractPath.equals("")){
			this.component.setContract(contractPath);
		}
	}

	private String getEnvString(Integer pos, String compUsesName,
			String compUsesPort) {
		List<MapReduceEnvConnection> envConns = this.workflow
				.listMontageEnvConnectionsByActPosition(pos);
		if (envConns == null)
			return null;

		for (MapReduceEnvConnection ec : envConns) {
			if (ec.getUsesCompName().equals(compUsesName)
					&& ec.getUsesPortName().equals(compUsesPort)) {
				return ec.getProvidesCompName() + "#"
						+ ec.getProvidesPortName();
			}
		}

		return null;
	}

	private String getTskString(Integer pos, String compAName, String compAPort) {
		List<MapReduceTskConnection> tskConns = this.workflow
				.listMontageTskConnectionsByActPosition(pos);
		if (tskConns == null)
			return null;

		for (MapReduceTskConnection tsk : tskConns) {
			if (tsk.getComponentAName().equals(compAName)
					&& tsk.getPortAName().equals(compAPort)) {
				return tsk.getComponentBName() + "#" + tsk.getPortBName();
			}
		}

		return null;
	}

}
