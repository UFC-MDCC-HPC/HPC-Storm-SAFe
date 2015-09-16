package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import br.ufc.mdcc.pargo.safe.application.MontageWorkflow;
import br.ufc.mdcc.pargo.safe.application.component.ComponentRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;
import br.ufc.mdcc.pargo.safe.xml.ParseMontageLibrary;



public class MainJFrame extends JFrame{

	private CenterPanel centerPanel;
	private LateralPanel lateralPanel;
	private BottomPanel bottomPanel;
	private UpperPanel upperPanel;
	private ComponentRepository repository;
	private MontageWorkflow workflow;
	
	public MainJFrame() {
		
		//creating panels...
		this.centerPanel = new CenterPanel();
		this.lateralPanel = new LateralPanel();
		this.bottomPanel = new BottomPanel();
		this.upperPanel = new UpperPanel();
		this.repository = new ComponentRepository();
		this.workflow = new MontageWorkflow();
		
		//container in main
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//adding panels
		c.add(this.centerPanel,BorderLayout.CENTER);
		c.add(this.lateralPanel,BorderLayout.WEST);
		c.add(this.bottomPanel,BorderLayout.SOUTH);
		c.add(this.upperPanel,BorderLayout.NORTH);
		
		//sharing...
		this.lateralPanel.setCenterPanel(centerPanel);
		this.lateralPanel.setRepository(repository);
		this.centerPanel.setBottomPanel(bottomPanel);
		this.centerPanel.setMontageWorkflow(workflow);
		
		//tree
		this.feed(this.lateralPanel);
		
		//config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Montage App Builder - Version 0.0.1");
		this.setVisible(true);
		this.pack();
		
	}
	
	
	private void feed(LateralPanel lp){
		ParseMontageLibrary pml = new ParseMontageLibrary(this.repository);
		pml.parseXML("src/m101-components.xml");
		for(MontageComponent mc:this.repository.getComponents()){
			this.lateralPanel.addTreeNode(mc);
		}
		
		
	}
	
	public static void main(String[] args) {
		new MainJFrame();
	}
}
