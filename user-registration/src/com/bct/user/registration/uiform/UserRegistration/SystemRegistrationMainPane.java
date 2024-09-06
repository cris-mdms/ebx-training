package com.bct.user.registration.uiform.UserRegistration;

import com.bct.user.registration.paths.UserRegistrationPaths;
import com.orchestranetworks.ui.ResourceType;
import com.orchestranetworks.ui.form.UIFormContext;
import com.orchestranetworks.ui.form.UIFormPane;
import com.orchestranetworks.ui.form.UIFormPaneWriter;
import com.orchestranetworks.ui.form.widget.UIComboBox;
import com.orchestranetworks.ui.form.widget.UITextBox;

public class SystemRegistrationMainPane implements UIFormPane {

	@Override
	public void writePane(UIFormPaneWriter writer, UIFormContext context) {
		String cssUrl = context.getURLForResource(ResourceType.STYLESHEET, "UIFormCSS.css");
		writer.add("<link rel='stylesheet' type='text/css' href='").add(cssUrl).add("'>");

		// TODO Auto-generated method stub
		addJSFunction(writer);
		
		// Adds some HTML heading on the page.
		// Horizontal Divider
		writer.add("<div class='container'>");
		writer.add("Hello CSS");
				writer.add("</div>");
		writer.add("<hr>");
		writer.add("<div>");
		{
			writer.add("<h3 style=\"color: blue;\"> User Feedback Form </h3>");
			

		}
		
		writer.add("<table>");
		{
			// Create a two table column structure and adds the table columns in the row.

			writer.add("<tr>");
			{
				writer.add("<td>");
				{
					UITextBox Ipas_Id = writer.newTextBox(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Ipas_Id);
					writer.startTableFormRow();

					writer.addFormRow(Ipas_Id);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Name);

					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Last_Name);

					writer.endTableFormRow();

				}

				writer.add("</td>");

				writer.add("<td>");
				{
					writer.startTableFormRow();

//					writer.addFormRow(
//							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Mdm_User_Id);
//
					writer.addFormRow(
							UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Zone);

					writer.endTableFormRow();
				}
				writer.add("</td>");
			}
			writer.add("</tr>");
		}
		writer.add("</table>");
	}

	private void addJSFunction(UIFormPaneWriter writer) {
		// TODO Auto-generated method stub

	}

}
