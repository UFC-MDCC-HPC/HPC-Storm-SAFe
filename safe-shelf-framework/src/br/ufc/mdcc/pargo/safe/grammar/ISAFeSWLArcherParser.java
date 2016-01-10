package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;

public interface ISAFeSWLArcherParser {

	public SAFeOrquestrationArchitecture getArchitecture();
	public ArchComponent getArchComponentByID(Integer id);
	public ArchAction getArchActionId(Integer id);
	public String getProvidesPortNameByUsesPortName(String usesPortName);
	public String getPartnerBByPartnerAName(String partnerAName);
	public boolean isThereEnvironmentConnection(String uses, String provides);
	public boolean isThereTaskConnection(String partnerA, String partnerB);
	public ArchApplication getArchApplication();
	public ArchWorkflow getArchWorkflow();
}
