package br.ufc.mdcc.pargo.safe.port;

public interface IHPCStormPort {

	public static final String provides = "PROVIDES";
	public static final String uses = "USES";
	
	public String getType();
	public String getName();
	
}
