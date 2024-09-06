package com.cris.user.registration.wf.usertask;

import com.orchestranetworks.service.OperationException;
import com.orchestranetworks.workflow.UserTask;
import com.orchestranetworks.workflow.UserTaskWorkItemCompletionContext;

public class WorkTaskApprovalUserTask extends UserTask{
	
	@Override
	public void handleWorkItemCompletion(UserTaskWorkItemCompletionContext aContext) throws OperationException {
		// TODO Auto-generated method stub
		
	
		
		aContext.setVariableString("approver", aContext.getCompletedWorkItem().getUserReference().getUserId());
	
		super.handleWorkItemCompletion(aContext);
		
	}

}
