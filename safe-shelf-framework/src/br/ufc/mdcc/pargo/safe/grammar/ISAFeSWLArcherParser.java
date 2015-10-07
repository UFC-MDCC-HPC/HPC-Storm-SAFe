package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;

public interface ISAFeSWLArcherParser {

	public SAFeOrquestrationArchitecture getArchitecture();
	public ArchComponent getArchComponentByID(Integer id);
	public ArchAction getArchActionId(Integer id);
}
