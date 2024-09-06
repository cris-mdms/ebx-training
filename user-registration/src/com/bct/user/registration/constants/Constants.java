package com.bct.user.registration.constants;

import com.bct.common.utilities.repository.RepositoryUtils;
import com.onwbp.adaptation.Adaptation;
import com.onwbp.adaptation.AdaptationTable;

public class Constants {
	public static final String USER_REGISTRATION_DATASPACENAME = "user_data";

	public static final String USER_REGISTRATION_DATASETNAME = "user_data";
	public static final Adaptation USER_REGISTRATION_DATASET = RepositoryUtils
			.getDataset(USER_REGISTRATION_DATASPACENAME, USER_REGISTRATION_DATASETNAME);

	public static final String USER_REGISTRATION_ALLOWED_ZONETABLE = "/root/User_Permissions_Zone";
	public static final AdaptationTable ZONE_TABLE = RepositoryUtils.getTable(USER_REGISTRATION_DATASET,
			USER_REGISTRATION_ALLOWED_ZONETABLE);

	public static final String USER_REGISTRATION_ALLOWED_DIVISIONTABLE = "/root/User_Permissions_Division";
	public static final AdaptationTable DIVISION_TABLE = RepositoryUtils.getTable(USER_REGISTRATION_DATASET,
			USER_REGISTRATION_ALLOWED_DIVISIONTABLE);

	public static final String USER_REGISTRATION_ALLOWED_SHEDTABLE = "/root/User_Permissions_Shed";
	public static final AdaptationTable SHED_TABLE = RepositoryUtils.getTable(USER_REGISTRATION_DATASET,
			USER_REGISTRATION_ALLOWED_SHEDTABLE);

	public static final String USER_REGISTRATION_TABLE = "/root/User_Registration_Details";

}
