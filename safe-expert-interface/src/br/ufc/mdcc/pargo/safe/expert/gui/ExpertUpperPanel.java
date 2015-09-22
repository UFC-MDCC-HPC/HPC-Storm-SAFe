package br.ufc.mdcc.pargo.safe.expert.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExpertUpperPanel extends JPanel{

	public ExpertUpperPanel() {
		this.setPreferredSize(new Dimension(900,50));
		this.add(new JLabel("SAFe Expert GUI V.0.0.1"));
	}
}
