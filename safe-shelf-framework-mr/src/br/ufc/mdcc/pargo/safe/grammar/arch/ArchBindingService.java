package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchBindingService extends ArchBinding {

	private ArchUserPort userPort;
	private ArchProviderPort providerPort;

	public ArchUserPort getUserPort() {
		return userPort;
	}

	public void setUserPort(ArchUserPort userPort) {
		this.userPort = userPort;
	}

	public ArchProviderPort getProviderPort() {
		return providerPort;
	}

	public void setProviderPort(ArchProviderPort providerPort) {
		this.providerPort = providerPort;
	}

	@Override
	public String toString() {
		return "ArchBindingService [userPort=" + userPort + ", providerPort="
				+ providerPort + "]";
	}

}
