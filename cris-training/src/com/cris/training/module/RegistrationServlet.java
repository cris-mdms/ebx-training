package com.cris.training.module;


import com.orchestranetworks.module.ModuleContextOnRepositoryStartup;
import com.orchestranetworks.module.ModuleRegistrationServlet;
import com.orchestranetworks.service.OperationException;

import module.ModuleLogger;

public class RegistrationServlet extends ModuleRegistrationServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void handleRepositoryStartup(ModuleContextOnRepositoryStartup aContext) throws OperationException {
		// TODO Auto-generated method stub
		
		super.handleRepositoryStartup(aContext);
		ModuleLogger.setModuleLogger(aContext.getLoggingCategory());
	}

	
	
}
