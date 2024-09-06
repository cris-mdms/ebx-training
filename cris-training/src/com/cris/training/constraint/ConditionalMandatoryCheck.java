package com.cris.training.constraint;

import java.util.Locale;

import com.orchestranetworks.instance.ValueContext;
import com.orchestranetworks.instance.ValueContextForValidation;
import com.orchestranetworks.schema.Constraint;
import com.orchestranetworks.schema.ConstraintContext;
import com.orchestranetworks.schema.ConstraintOnNull;
import com.orchestranetworks.schema.InvalidSchemaException;
import com.orchestranetworks.schema.Path;

import module.ModuleLogger;

public class ConditionalMandatoryCheck implements ConstraintOnNull, Constraint<Object>{
	String relativeFieldPath;// path of status field
	String errorMessage;//" commissioning date should not be null
	@Override
	public void checkOccurrence(Object arg0, ValueContextForValidation arg1) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setup(ConstraintContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toUserDocumentation(Locale arg0, ValueContext arg1) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkNull(ValueContextForValidation validationContext) throws InvalidSchemaException {
				
		// TODO Auto-generated method stub
		ModuleLogger.getModuleLogger().info("Relative Field Path " + relativeFieldPath);
		ModuleLogger.getModuleLogger().info("Error message " + errorMessage);

		String dependentFieldValue = (String) validationContext.getValue(Path.parse(relativeFieldPath));
		ModuleLogger.getModuleLogger().info("dependentFieldValue " + dependentFieldValue);

		if (dependentFieldValue != null &&(dependentFieldValue.equals("C")) ) {
			ModuleLogger.getModuleLogger().info("Inside if statement");
			validationContext.addError(errorMessage);
		}
	}

	public String getRelativeFieldPath() {
		return relativeFieldPath;
	}

	public void setRelativeFieldPath(String relativeFieldPath) {
		this.relativeFieldPath = relativeFieldPath;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
