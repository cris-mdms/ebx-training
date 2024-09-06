package com.bct.user.registration.uiform.UserRegistration;

import com.orchestranetworks.ui.form.UIForm;
import com.orchestranetworks.ui.form.UIFormBody;
import com.orchestranetworks.ui.form.UIFormContext;
import com.orchestranetworks.ui.form.UIFormPaneWithTabs;

public class SystemRegistrationUIForm extends UIForm {

	/*
	 * Specifies the body of the form. Default implementation does nothing, that is,
	 * the default body will be displayed.
	 */
	@Override
	public void defineBody(UIFormBody body, UIFormContext context) {

		// This layout divides the form into a set of tabs.
		UIFormPaneWithTabs uiTabs = new UIFormPaneWithTabs();

		// Add the home tab for the layout.
		uiTabs.addTab("Customized Loco Registration Form", new SystemRegistrationMainPane());
		
		// Defines the custom form content, overriding the form that is automatically
		// generated from the data model.
		body.setContent(uiTabs);
		
	}

}
