package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import br.ufc.mdcc.pargo.safe.application.MontageWorkflow;
import br.ufc.mdcc.pargo.safe.application.component.MontageRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageApplication;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;
import br.ufc.mdcc.pargo.safe.xml.ParseMontageXML;

public class MainJFrame extends JFrame {

	private CenterPanel centerPanel;
	private LateralPanel lateralPanel;
	private BottomPanel bottomPanel;
	private UpperPanel upperPanel;
	private MontageRepository repository;
	private MontageWorkflow workflow;

	public MainJFrame() {

		// creating panels...
		this.centerPanel = new CenterPanel();
		this.lateralPanel = new LateralPanel();
		this.bottomPanel = new BottomPanel();
		this.upperPanel = new UpperPanel();
		this.repository = new MontageRepository();
		this.workflow = new MontageWorkflow();

		// container in main
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		// adding panels
		c.add(this.centerPanel, BorderLayout.CENTER);
		c.add(this.lateralPanel, BorderLayout.WEST);
		c.add(this.bottomPanel, BorderLayout.SOUTH);
		c.add(this.upperPanel, BorderLayout.NORTH);

		// sharing...
		this.lateralPanel.setCenterPanel(centerPanel);
		this.lateralPanel.setRepository(repository);
		this.centerPanel.setBottomPanel(bottomPanel);
		this.centerPanel.setMontageWorkflow(workflow);

		// tree
		this.feed(this.lateralPanel);

		// config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Montage App Builder - Version 0.0.1");
		this.setVisible(true);
		this.pack();

	}

	private void feed(LateralPanel lp) {
		ParseMontageXML pml = new ParseMontageXML(this.repository);
		// components
		pml.parseXMLComponents("src/montage-components.xml");
		for (MontageComponent mc : this.repository.getComponents()) {
			this.lateralPanel.addTreeNodeComponent(mc);
		}
		// components
		pml.parseXMLApplications("src/montage-applications.xml");
		for (MontageApplication mapp : this.repository.getApplications()) {
			
			this.lateralPanel.addTreeNodeApplication(mapp);
		}

	}

	public static void main(String[] args) {
		new MainJFrame();
	}
}
