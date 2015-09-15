package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import br.ufc.mdcc.pargo.safe.application.component.ComponentRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;



public class MainJFrame extends JFrame{

	private CenterPanel centerPanel;
	private LateralPanel lateralPanel;
	private BottomPanel bottomPanel;
	private UpperPanel upperPanel;
	private ComponentRepository repository;
	
	public MainJFrame() {
		
		//creating panels...
		this.centerPanel = new CenterPanel();
		this.lateralPanel = new LateralPanel();
		this.bottomPanel = new BottomPanel();
		this.upperPanel = new UpperPanel();
		this.repository = new ComponentRepository();
		
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
		
		//tree
		this.feed(this.lateralPanel);
		
		//config
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Montage App Builder - Version 0.0.1");
		this.setVisible(true);
		this.pack();
		
	}
	
	//apagar depois...apenas teste
	private void feed(LateralPanel lp){
		MontageComponent mc1 = new MontageComponent("mImgtbl");
		mc1.addInParam(new MontageParam("img_dir", MontageParam.DIR_TYPE));
		mc1.addInParam(new MontageParam("out_name", MontageParam.PARAM_TYPE));
		mc1.addOutParam(new MontageParam("tbl_file", MontageParam.FILE_TYPE));
		
		MontageComponent mc2 = new MontageComponent("mAdd");
		MontageComponent mc3 = new MontageComponent("mProjExec");
		MontageComponent mc4 = new MontageComponent("mJpeg");
		MontageComponent mc5 = new MontageComponent("mBgModel");
		MontageComponent mc6 = new MontageComponent("mBgExec");
		MontageComponent mc7 = new MontageComponent("mFitExec");
		
		this.repository.addComponent(mc1);
		this.repository.addComponent(mc2);
		this.repository.addComponent(mc3);
		this.repository.addComponent(mc4);
		this.repository.addComponent(mc5);
		this.repository.addComponent(mc6);
		this.repository.addComponent(mc7);
		
		for(MontageComponent mc:this.repository.getComponents()){
			this.lateralPanel.addTreeNode(mc);
		}
		
		
	}
	
	public static void main(String[] args) {
		new MainJFrame();
	}
}
