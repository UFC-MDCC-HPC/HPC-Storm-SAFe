package br.ufc.mdcc.pargo.safe.application.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpperPanel extends JPanel{

	public UpperPanel() {
		this.setPreferredSize(new Dimension(900,50));
		this.add(new JLabel("MONTAGE WORKFLOW BUILDER V.0.0.1"));
	}
}
