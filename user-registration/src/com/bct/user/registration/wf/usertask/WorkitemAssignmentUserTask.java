package com.bct.user.registration.wf.usertask;


import com.bct.common.utilities.repository.RepositoryUtils;
import com.onwbp.adaptation.Adaptation;
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

public class WorkitemAssignmentUserTask extends UserTask {

	final String CV_INITIATOR_USER = "initatorUser";

	@Override
	public void handleCreate(UserTaskCreationContext context) throws OperationException {
		LoggingCategory.getWorkflow().info("Training WI Assignment UserTask: handleCreate");

		String initatorUser = context.getVariableString(CV_INITIATOR_USER);
		CreationWorkItemSpec wiSpec = CreationWorkItemSpec.forAllocation(UserReference.forUser(initatorUser));
		String notificationMail = context.getAllocatedToNotificationMail();
		if (notificationMail != null)
			wiSpec.setNotificationMail(notificationMail);

		context.createWorkItem(wiSpec);
	}

	@Override
	public void checkBeforeWorkItemCompletion(UserTaskBeforeWorkItemCompletionContext context) {

		String dataspace = context.getVariableString("dataspace");
		String dataset = context.getVariableString("dataset");
		String table = context.getVariableString("table");

		SessionInteraction sessionInteraction = context.getSession().getInteraction(false);
		ParametersMap sessionParamMap = sessionInteraction.getInternalParameters();
		if (sessionParamMap != null) {
			String recordXPath = sessionParamMap.getVariableString("created");

			String primaryKey = recordXPath.substring(recordXPath.indexOf("=") + 1, recordXPath.lastIndexOf("]"));
			Adaptation record = RepositoryUtils.getRecordFromQuotedPrimaryKey(dataspace, dataset, table, primaryKey);

			if (context.isAcceptAction()) {

				ValidationReport validationReport = record.getValidationReport(true);

				int countOfErrors = validationReport.countItemsOfSeverity(Severity.ERROR);

				if (countOfErrors > 0) {
					context.reportMessage(
							UserMessage.createError("All errors should be resolved before submitting the record."));
					return;
				}
			}
		}
		super.checkBeforeWorkItemCompletion(context);
	}
}