package dataservice.checktabledataservice;

import dataservice.CommonDataService;
import po.table.StatementOfOperationPO;

public interface StatementOfOperationDataService extends CommonDataService<StatementOfOperationPO>{
	public static final String NAME = "statementOfOperationData";
	
	public void viewRport(StatementOfOperationPO statementOfOperationPO);

	public void exportReport();
}
