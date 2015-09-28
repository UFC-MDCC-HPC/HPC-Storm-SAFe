package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class BottomPanel extends JPanel{

	private JTextPane consoleArea = new JTextPane();
	private StringBuffer content = new StringBuffer();
	private JScrollPane scroller;
	
	public BottomPanel() {
		this.setPreferredSize(new Dimension(900,150));
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.consoleArea.setContentType("text/html");
		this.scroller = new JScrollPane(this.consoleArea);
		this.add(this.scroller,BorderLayout.CENTER);
	}
	
	public void addText(String type, String text){
		content.append("<b>"+type+"</b> : " +text+"<br/>");
		this.consoleArea.setText(content.toString());
		
		 
	}
	
	
}
