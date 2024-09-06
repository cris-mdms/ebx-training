package com.bct.user.registration.permission;


import com.bct.user.registration.constants.Constants;
import com.bct.user.registration.paths.UserRegistrationPaths;
import com.onwbp.adaptation.Adaptation;
import com.onwbp.adaptation.PrimaryKey;
import com.orchestranetworks.instance.Repository;
import com.orchestranetworks.schema.Path;
import com.orchestranetworks.schema.SchemaNode;
import com.orchestranetworks.service.AccessPermission;
import com.orchestranetworks.service.AccessRule;
import com.orchestranetworks.service.Role;
import com.orchestranetworks.service.Session;
import com.orchestranetworks.service.UserReference;
import com.orchestranetworks.service.directory.DirectoryHandler;


public class UserRecordAccessRule implements AccessRule{

	@Override
	public AccessPermission getPermission(Adaptation adaption, Session session, SchemaNode schemanode) {
		// TODO Auto-generated method stub
		if(adaption.isSchemaInstance())
			return AccessPermission.getReadWrite();
		
		Repository repo =Repository.getDefault();
		DirectoryHandler directoryHandler = DirectoryHandler.getInstance(repo);
		String userid = session.getUserReference().getUserId();
		UserReference uref=session.getUserReference();
		
		boolean isShedUser = session.isUserInRole(Role.forSpecificRole("Shed_User"));
		final String shedValue = (String) adaption.get(UserRegistrationPaths._Root_Business_Users_Registration_Details._Root_Business_Users_Registration_Details_Shed);
	//	.get(LocomotivePaths._Root_Locomotive._Root_Locomotive_LocoBasicInfo_LocoOwningShed)
//		ModuleLogger.getModuleLogger().info("Shed: " + shedValue);

		
		if (isShedUser) {

//			ModuleLogger.getModuleLogger().info("Shed: " + shedValue + ", User ID: " + userId);

			// If the user is the shed user.
			Adaptation userPermissionsShedRecord = Constants.SHED_TABLE
					.lookupAdaptationByPrimaryKey(PrimaryKey.parseString(userid + "|" + shedValue));

			if (userPermissionsShedRecord == null)
				return AccessPermission.getHidden();
			else
												
				return AccessPermission.getReadWrite();
		}
		return AccessPermission.getHidden();
	}
	
	

}
