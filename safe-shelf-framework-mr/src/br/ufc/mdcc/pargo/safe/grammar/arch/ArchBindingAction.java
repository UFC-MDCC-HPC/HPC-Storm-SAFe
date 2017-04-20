package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchBindingAction extends ArchBinding{

	private List<ArchPeer> peersList;
	
	public ArchBindingAction() {
		this.peersList = new ArrayList<ArchPeer>();
	}

	public List<ArchPeer> getPeersList() {
		return peersList;
	}

	public void setPeersList(List<ArchPeer> peersList) {
		this.peersList = peersList;
	}

	public void addArchPeer(ArchPeer peer){
		this.peersList.add(peer);
	}
	
	@Override
	public String toString() {
		String res=  "ArchBindingAction [peersList]";
		for(ArchPeer peer:peersList){
			res+="\n\t"+peer;
		}
		return res;
	}
	
	
}
