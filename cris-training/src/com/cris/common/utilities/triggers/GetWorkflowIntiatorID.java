package com.cris.common.utilities.triggers;

import java.util.Locale;

import com.orchestranetworks.instance.BranchKey;
import com.orchestranetworks.instance.Repository;
import com.orchestranetworks.service.OperationException;
import com.orchestranetworks.service.Profile;
import com.orchestranetworks.service.Session;
import com.orchestranetworks.service.UserReference;
import com.orchestranetworks.workflow.MailSpec;
import com.orchestranetworks.workflow.ProcessInstance;
import com.orchestranetworks.workflow.ProcessInstanceKey;
import com.orchestranetworks.workflow.PublishedProcessKey;
import com.orchestranetworks.workflow.ScriptTaskBeanContext;
import com.orchestranetworks.workflow.ScriptTaskBean;
public class GetWorkflowIntiatorID extends ScriptTaskBean {
	String wfInstanceCreator;

	@Override
	public void executeScript(ScriptTaskBeanContext context) throws OperationException {
		// TODO Auto-generated method stub
		
		UserReference userReference = context.getProcessInstanceCreator();
		wfInstanceCreator=userReference.getUserId();
		
		
	}

	public String getWfInstanceCreator() {
		return wfInstanceCreator;
	}

	public void setWfInstanceCreator(String wfInstanceCreator) {
		this.wfInstanceCreator = wfInstanceCreator;
	}
	
}
