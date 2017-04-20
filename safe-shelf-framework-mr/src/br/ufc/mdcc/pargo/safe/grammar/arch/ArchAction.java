package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchAction implements IArchObject {

	private String name;
	private ArchActionPort parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArchActionPort getParent() {
		return parent;
	}

	public void setParent(ArchActionPort parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ArchAction other = (ArchAction) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArchAction [name=" + name + "]";
	}

}
