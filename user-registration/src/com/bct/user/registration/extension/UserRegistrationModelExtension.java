package com.bct.user.registration.extension;


import com.bct.user.registration.paths.UserRegistrationPaths;
import com.bct.user.registration.permission.UserRecordAccessRule;
import com.orchestranetworks.schema.SchemaExtensions;
import com.orchestranetworks.schema.SchemaExtensionsContext;

public class UserRegistrationModelExtension implements SchemaExtensions{

	@Override
	public void defineExtensions(SchemaExtensionsContext context) {
		
		// Adds the access rule "UserRecordAccessRule", on the User Registration Table. 
		context.setAccessRuleOnOccurrence(UserRegistrationPaths._Root_Business_Users_Registration_Details.getPathInSchema(),
				new UserRecordAccessRule());
	}
}
