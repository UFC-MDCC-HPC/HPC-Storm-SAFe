package br.ufc.mdcc.pargo.safe.port;

import javax.jws.WebService;

@WebService
public interface IHPCStormEnvProvidesPort 
	extends IHPCStormEnvPort{
	
	public String getURL();
	public void setURL(String url);
}

