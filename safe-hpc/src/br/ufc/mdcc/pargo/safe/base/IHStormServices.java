package br.ufc.mdcc.pargo.safe.base;

import br.ufc.mdcc.pargo.safe.port.IHStormPort;

public interface IHStormServices {

	public Integer addProvidesPort(IHStormPort userPort);
	public void setUsesPort(IHStormPort userPort);
	public IHStormPort getProvidesPort(String portName);
	public Integer removeProvidesPort(String portName);
	public Integer removeUserPort(String portName);
}
