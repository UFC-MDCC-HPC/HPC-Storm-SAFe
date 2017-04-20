package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchPeer implements IArchObject{

	private String idComponent;
	private String idPort;
	
	public String getIdComponent() {
		return idComponent;
	}
	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}
	public String getIdPort() {
		return idPort;
	}
	public void setIdPort(String idPort) {
		this.idPort = idPort;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComponent == null) ? 0 : idComponent.hashCode());
		result = prime * result + ((idPort == null) ? 0 : idPort.hashCode());
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
		ArchPeer other = (ArchPeer) obj;
		if (idComponent == null) {
			if (other.idComponent != null)
				return false;
		} else if (!idComponent.equals(other.idComponent))
			return false;
		if (idPort == null) {
			if (other.idPort != null)
				return false;
		} else if (!idPort.equals(other.idPort))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ArchPeer [idComponent=" + idComponent + ", idPort=" + idPort
				+ "]";
	}
	
	
	
}
