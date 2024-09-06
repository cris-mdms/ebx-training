package com.bct.user.registration.uiform.UserRegistration;

import com.bct.user.registration.paths.UserRegistrationPaths;
import com.orchestranetworks.ui.base.JsFunctionCall;
import com.orchestranetworks.ui.form.UIFormContext;
import com.orchestranetworks.ui.form.UIFormPane;
import com.orchestranetworks.ui.form.UIFormPaneWriter;
import com.orchestranetworks.ui.form.widget.UITextBox;

public class UserRegistrationMainPane implements UIFormPane {

	@Override
	public void writePane(UIFormPaneWriter writer, UIFormContext context) {
		// TODO Auto-generated method stub

		addJSFunction(writer);

		// Adds some HTML heading on the page.
		writer.add("<h3 style=\"color: blue;\"> User Registration Form </h3>");
		writer.add("<h3> You need to enter the IPAS ID of the user and details will be fetched.</h2>");

		// Horizontal Divider
		writer.add("<hr>");

		// Create a two table column structure and adds the table columns in the row.
		writer.add("<table>");
		{
			writer.add("<tr>");
			{
				writer.add("<td>");
				{
					// An option to call the javascript on the value change of text box for IPAS ID.
					// Create Call Object of the JS function
					JsFunctionCall jsFunctionCall = JsFunctionCall.on("apiCall");

					// Create text for the IPAS field.
					UITextBox ipasId = writer.newTextBox(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Ipas_Id);

					// Set the JS function call object on the IPAS ID text box. So if any value in
					// the IPAS ID is changed this function will be invoked.
					ipasId.setActionOnAfterValueChanged(jsFunctionCall);

					writer.startTableFormRow();

					writer.addFormRow(ipasId);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Name);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Last_Name);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Designation);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Department);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Entity);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_User_Type);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Mobile_Number);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Email);

					writer.endTableFormRow();
				}
				writer.add("</td>");

				writer.add("<td>");
				{
					writer.startTableFormRow();

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Mdm_User_Id);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Zone);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Divison);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Shed);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_User_Register_Approval);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Service_Status);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Asset_Designation_Code);

					writer.endTableFormRow();
				}
				writer.add("</td>");
			}
			writer.add("</tr>");
		}
		writer.add("</table>");
	}

	private void addJSFunction(UIFormPaneWriter pWriter) {
		
		pWriter.addJS("function apiCall(newValue) {\r\n" 
				+ " console.log(newValue); \r\n"
				+ " if (newValue === null || newValue === undefined || newValue === '') { \r\n"
				+ "		return; \r\n"
				+ "} \r\n"
				+ "	var ipasId = newValue; \r\n" 
				+ " var userName; \r\n" 
				+ " var userDepartment; \r\n" 
				+ " var userDesignation; \r\n"
				+ " var userZone = {key: \"\"}; \r\n" 
				+ " var userServingStatus; \r\n" 
				+ "	if (newValue == 'prashant') { \r\n "
				+ " 	userName = 'Prashant' \r\n"
				+ " 	userDepartment = 'BCT'; \r\n" 
				+ " 	userDesignation = 'Consultant'; \r\n"
				+ " 	userZone.key = 'CR'; \r\n" 
				+ " 	userServingStatus = 'Active'; \r\n"
				+ " } else { \r\n"
				+ "		userName=''; \r\n" 
				+ "		userDepartment=''; \r\n" 
				+ "		userDesignation=''; \r\n"
				+ "		userZone.key=''; \r\n" 
				+ "		userServingStatus = ''; \r\n" 
				+ "		ipasId='';  \r\n"
				+ "		ebx_alert('Enter only valid IPAS ID'); \r\n" 
				+ " } \r\n");

		pWriter.addJS_setNodeValue("userName",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Name);
		
		pWriter.addJS_setNodeValue("userDepartment",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Department);
		
		pWriter.addJS_setNodeValue("userDesignation",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Designation);

		pWriter.addJS_setNodeValue("userZone",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Zone);
		
		pWriter.addJS_setNodeValue("userServingStatus",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Service_Status);

		pWriter.addJS_setNodeValue("ipasId",
				UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Ipas_Id);
	

		pWriter.addJS("}");
	}
}