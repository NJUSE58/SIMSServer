package dataservice.checktabledataservice;

import java.rmi.Remote;
import po.table.StatementOfOperationPO;

public interface StatementOfOperationDataService extends Remote{
	public static final String NAME = "statementOfOperationData";
	
	public void viewRport(StatementOfOperationPO statementOfOperationPO);

	public void exportReport();
}
