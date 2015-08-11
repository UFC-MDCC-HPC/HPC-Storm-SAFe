package br.ufc.mdcc.pargo.safe.grammar.arch.contract;

import java.util.ArrayList;
import java.util.List;

public class ArchUnitMappingType {

	private Integer unitId;
	private Integer unitIndex;
	private List<Integer> nodes;
	
	public ArchUnitMappingType() {
		this.nodes = new ArrayList<Integer>();
	}
	
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getUnitIndex() {
		return unitIndex;
	}
	public void setUnitIndex(Integer unitIndex) {
		this.unitIndex = unitIndex;
	}
	
	public void addNode(Integer node){
		this.nodes.add(node);
	}

	public List<Integer> getNodes() {
		return nodes;
	}
	
	@Override
	public String toString() {
		return "ArchUnitMappingType [unitId=" + unitId + ", unitIndex="
				+ unitIndex + ", nodes=" + nodes + "]";
	}
	
}
