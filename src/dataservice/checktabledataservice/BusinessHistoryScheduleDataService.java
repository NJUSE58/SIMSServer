package dataservice.checktabledataservice;

import java.rmi.Remote;

import po.PersistObject;
import po.FinancialBill.FinancialDocPO;
import po.table.BusinessHistorySchedulePO;

/**
 * 查看经营历程表
 */
public interface BusinessHistoryScheduleDataService extends Remote {
	public static final String NAME = "BusinessHistoryScheduleData";
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//红冲
	
	public void writeOffAndCopy(PersistObject billPO);//红冲并复制
}
