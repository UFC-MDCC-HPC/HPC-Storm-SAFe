package br.ufc.m101.backend;

import br.ufc.m101.component.madd.MAddStartPorts;
import br.ufc.m101.component.mbgexec.MBgExecStartPorts;
import br.ufc.m101.component.mbgmodel.MBgModelStartPorts;
import br.ufc.m101.component.mdiffexec.MDiffExecStartPorts;
import br.ufc.m101.component.mfitexec.MFitExecStartPorts;
import br.ufc.m101.component.mimgtbl.MImgtblStartPorts;
import br.ufc.m101.component.mjpeg.MJpegStartPorts;
import br.ufc.m101.component.moverlaps.MOverlapsStartPorts;
import br.ufc.m101.component.mprojexec.MProjExecStartPorts;

public class StartAllPorts {

	public static void main(String[] args) {
		new MAddStartPorts().start();
		new MBgExecStartPorts().start();
		new MBgModelStartPorts().start();
		new MDiffExecStartPorts().start();
		new MFitExecStartPorts().start();
		new MImgtblStartPorts().start();
		new MJpegStartPorts().start();
		new MOverlapsStartPorts().start();
		new MProjExecStartPorts().start();
		
		
	}
}
