package br.ufc.mdcc.pargo.safe.port.conn;

import br.ufc.mdcc.pargo.safe.exception.HPCStormException;
import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

public interface IHPCStormConnectionRepository {

	public String createConnection(IHPCStormUses<?> uses,
			IHPCStormProvides<?> provides) throws HPCStormException;

	public UsesProvidesConnection getConnection(String id);

}