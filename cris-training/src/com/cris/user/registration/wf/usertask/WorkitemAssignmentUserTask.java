package com.cris.user.registration.wf.usertask;

import com.cris.common.utilities.repository.RepositoryUtils;
import com.onwbp.adaptation.Adaptation;
import com.onwbp.base.schema.instance.Context;
import com.onwbp.base.text.Severity;
import com.onwbp.base.text.UserMessage;
import com.orchestranetworks.interactions.SessionInteraction;
import com.orchestranetworks.interactions.InteractionHelper.ParametersMap;
import com.orchestranetworks.service.LoggingCategory;
import com.orchestranetworks.service.OperationException;
import com.orchestranetworks.service.UserReference;
import com.orchestranetworks.service.ValidationReport;
import com.orchestranetworks.workflow.CreationWorkItemSpec;
import com.orchestranetworks.workflow.UserTask;
import com.orchestranetworks.workflow.UserTaskBeforeWorkItemCompletionContext;
import com.orchestranetworks.workflow.UserTaskCreationContext;
import com.orchestranetworks.workflow.UserTaskWorkItemCompletionContext;

public class WorkitemAssignmentUserTask extends UserTask {
	String username;
//	final String CV_INITIATOR_USER = "initiator";

	@Override
	public void handleCreate(UserTaskCreationContext aContext) throws OperationException {
		// TODO Auto-generated method stub

		LoggingCategory.getWorkflow().info("Training WI Assignment UserTask: handleCreate");

		String initiatorUser = aContext.getVariableString(username);
		CreationWorkItemSpec wiSpec = CreationWorkItemSpec.forAllocation(UserReference.forUser(initiatorUser));
		String notificationMail = aContext.getAllocatedToNotificationMail();
		if (notificationMail != null) {
			wiSpec.setNotificationMail(notificationMail);
		}
		aContext.createWorkItem(wiSpec);
//		super.handleCreate(aContext);
	}

	@Override
	public void checkBeforeWorkItemCompletion(UserTaskBeforeWorkItemCompletionContext aContext) {
		// TODO Auto-generated method stub
//		String dataspace = aContext.getVariableString("dataspace");
		String dataset = aContext.getVariableString("dataset");
		String table = aContext.getVariableString("tablexpath");
		String dataspace = aContext.getVariableString("childds");

		LoggingCategory.getWorkflow().info("Dataspace is" + dataspace + "Dataset is " + dataset + "Table is" + table);
		SessionInteraction sessionInteraction = aContext.getSession().getInteraction(false);
		ParametersMap sessionParamMap = sessionInteraction.getInternalParameters();

		if (sessionParamMap != null) {
			String recordXPath = sessionParamMap.getVariableString("created");
			String primarykey = recordXPath.substring(recordXPath.indexOf("=") + 1, recordXPath.lastIndexOf("]"));
			LoggingCategory.getWorkflow().info("Primary Key is" + primarykey);
			Adaptation arecord = RepositoryUtils.getRecordFromPrimaryKey(dataspace, dataset, table, primarykey);
			if (aContext.isAcceptAction()) {

				ValidationReport validationReport = arecord.getValidationReport(true);
				int countOfErrors = validationReport.countItemsOfSeverity(Severity.ERROR);
				if (countOfErrors > 0) {
					aContext.reportMessage(
							UserMessage.createError("All errors should be resolved before submitting the record."));
					return; // return without saving

				}
			}

			super.checkBeforeWorkItemCompletion(aContext);

		}

		super.checkBeforeWorkItemCompletion(aContext);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
