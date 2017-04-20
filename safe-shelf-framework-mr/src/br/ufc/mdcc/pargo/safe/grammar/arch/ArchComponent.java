package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchComponent implements IArchObject {

	private String idComponent;
	private String kind;
	private ArchContract contract;
	private List<ArchUserPort> userPortList;
	private List<ArchProviderPort> providerPortList;
	private List<ArchActionPort> actionPortList;

	public ArchComponent() {
		this.userPortList = new ArrayList<ArchUserPort>();
		this.providerPortList = new ArrayList<ArchProviderPort>();
		this.actionPortList = new ArrayList<ArchActionPort>();
	}

	public String getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}

	public ArchContract getContract() {
		return contract;
	}

	public void setContract(ArchContract contract) {
		this.contract = contract;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<ArchUserPort> getUsesPortList() {
		return userPortList;
	}

	public void setUserPortList(List<ArchUserPort> userPortList) {
		this.userPortList = userPortList;
	}
	
	public void addUserPort(ArchUserPort userPort){
		this.userPortList.add(userPort);
	}

	public List<ArchProviderPort> getProviderPortList() {
		return providerPortList;
	}

	public void setProviderPortList(List<ArchProviderPort> providerPortList) {
		this.providerPortList = providerPortList;
	}
	
	public void addProviderPort(ArchProviderPort providerPort){
		this.providerPortList.add(providerPort);
	}

	public List<ArchActionPort> getActionPortList() {
		return actionPortList;
	}

	public void setActionPortList(List<ArchActionPort> actionPortList) {
		this.actionPortList = actionPortList;
	}

	public void addActionPort(ArchActionPort action) {
		this.actionPortList.add(action);
	}

	public ArchAction getArchActionByName(String idActionPort, String name) {
		ArchActionPort actionPortDummy = new ArchActionPort();
		actionPortDummy.setIdPort(idActionPort);
		Integer index = this.actionPortList.indexOf(actionPortDummy);
		if (index >= 0) {
			ArchActionPort actionPort = this.actionPortList.get(index);
			if (actionPort != null) {
				return actionPort.getArchActionByName(name);
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComponent == null) ? 0 : idComponent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchComponent other = (ArchComponent) obj;
		if (idComponent == null) {
			if (other.idComponent != null)
				return false;
		} else if (!idComponent.equals(other.idComponent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String res = "ArchComponent [idComponent=" + idComponent + "]";
		for (ArchUserPort uses : userPortList) {
			res += "\n\t" + uses.toString();
		}
		for (ArchProviderPort provides : providerPortList) {
			res += "\n\t" + provides.toString();
		}
		for (ArchActionPort action : actionPortList) {
			res += "\n\t" + action.toString();
		}
		return res;
	}

}
