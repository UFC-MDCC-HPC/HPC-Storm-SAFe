package br.ufc.mdcc.pargo.safe.expert.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.expert.util.FileUtil;

public class WorkflowDAOImpl implements IWorkflowDAO{

	@Override
	public List<WorkflowModel> load() {
		
		List<WorkflowModel> workflows = new ArrayList<WorkflowModel>();
		
		String safeExpertDir = FileUtil.readProperty("safe_expert_dir");
		List<String> fileNames = FileUtil.listFiles(safeExpertDir);
	
		for(String fileFlowName:fileNames){
			if(fileFlowName.contains("flow")){
				for(String fileArchName:fileNames){
					if(fileArchName.contains("arch")){
						
						String fileArch = fileArchName.replaceAll("-arch", ""); 
						String fileFlow = fileFlowName.replaceAll("-flow", "");	
						String workflowName = fileArch;
						if(fileArch.equals(fileFlow)){
							WorkflowModel wfModel = new WorkflowModel();
							wfModel.setWorkflowName(workflowName);
							wfModel.setArchXMLFilePath(safeExpertDir+fileArchName);
							wfModel.setFlowXMLFilePath(safeExpertDir+fileFlowName);
							workflows.add(wfModel);
						}
						
					}
				}
			}
			
		}
		
		
		
		return workflows;
	}

}
