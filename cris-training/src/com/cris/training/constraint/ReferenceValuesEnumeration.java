package com.cris.training.constraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.cris.common.utilities.repository.RepositoryUtils;
import com.onwbp.adaptation.Adaptation;
import com.orchestranetworks.instance.ValueContext;
import com.orchestranetworks.instance.ValueContextForValidation;
import com.orchestranetworks.query.Query;
import com.orchestranetworks.query.QueryResult;
import com.orchestranetworks.query.Tuple;
import com.orchestranetworks.schema.ConstraintContext;
import com.orchestranetworks.schema.ConstraintEnumeration;
import com.orchestranetworks.schema.InvalidSchemaException;
import com.orchestranetworks.schema.Path;

public class ReferenceValuesEnumeration implements ConstraintEnumeration<String>{

	String referenceDataspace;
	String referenceDataset;
	String referenceCode;
	HashMap<String, String> referenceKeyValuePair = new HashMap<String, String>();

	
	
	@Override
	public void checkOccurrence(String arg0, ValueContextForValidation arg1) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void setup(ConstraintContext context) {
		// TODO Auto-generated method stub
		if (referenceDataspace == null || referenceDataset == null || referenceCode == null) {
			context.addError("Input parameters are not properly set. Please take a look.");
		}
	}

	@Override
	public String toUserDocumentation(Locale arg0, ValueContext arg1) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayOccurrence(String arg0, ValueContext arg1, Locale arg2) throws InvalidSchemaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getValues(ValueContext arg0) throws InvalidSchemaException {
		
		String referenceQuery = "SELECT s.\"$adaptation\" FROM \"/root/Reference_Value\" s "
				+ "WHERE FK_AS_STRING('reference_data','/root/Reference_Code', s.Ref_Code) = '" + referenceCode + "'";
		
		final Adaptation dataset = RepositoryUtils.getDataset(referenceDataspace, referenceDataset);
		Query<Tuple> queryTuple = dataset.createQuery(referenceQuery);
		QueryResult<Tuple> refCodeRecords = queryTuple.getResult();
		List<String> list = new ArrayList<String>();
		for (Tuple result : refCodeRecords) {
			Adaptation refCodeRecord = (Adaptation) result.get(0);// get 0 is for '*' in select * , If the query is like select col1, col2 then it would be different 
			String refVal = refCodeRecord.getString(Path.parse("./Ref_Value"));
			String refDisplay = refCodeRecord.getString(Path.parse("./Ref_Value_Display"));
			list.add(refVal);
			if (refVal.equalsIgnoreCase(refDisplay)) {
				referenceKeyValuePair.put(refVal, refDisplay);
			} else {
				referenceKeyValuePair.put(refVal, refVal + ", " + refDisplay);
			}
			
			
		}
		// TODO Auto-generated method stub
		return list;
	}

	public String getReferenceDataspace() {
		return referenceDataspace;
	}

	public void setReferenceDataspace(String referenceDataspace) {
		this.referenceDataspace = referenceDataspace;
	}

	public String getReferenceDataset() {
		return referenceDataset;
	}

	public void setReferenceDataset(String referenceDataset) {
		this.referenceDataset = referenceDataset;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public HashMap<String, String> getReferenceKeyValuePair() {
		return referenceKeyValuePair;
	}

	public void setReferenceKeyValuePair(HashMap<String, String> referenceKeyValuePair) {
		this.referenceKeyValuePair = referenceKeyValuePair;
	}

}
