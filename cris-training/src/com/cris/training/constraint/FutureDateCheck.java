package com.cris.training.constraint;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.orchestranetworks.instance.ValueContext;
import com.orchestranetworks.instance.ValueContextForValidation;
import com.orchestranetworks.schema.Constraint;
import com.orchestranetworks.schema.ConstraintContext;
import com.orchestranetworks.schema.InvalidSchemaException;
import com.orchestranetworks.service.LoggingCategory;

public class FutureDateCheck implements Constraint<Date> {

	@Override
	public void checkOccurrence(Date arg0, ValueContextForValidation arg1) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		Date todayDate = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStringFormat = formatter.format(todayDate);
		
		LoggingCategory.getWorkflow().info("Today Date " + dateStringFormat);
		LoggingCategory.getWorkflow().info("Field Date " + formatter.format(arg0));
		
		if (arg0 != null) {
			if (arg0.after(todayDate)) {
				arg1
						.addError("The date should not exceed from current date i.e future date is not allowed");
			}
		}
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

}
