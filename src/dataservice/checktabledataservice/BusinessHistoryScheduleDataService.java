package dataservice.checktabledataservice;

import dataservice.CommonDataService;
import po.PersistObject;
import po.makefinancialdoc.FinancialDocPO;
import po.table.BusinessHistorySchedulePO;

/**
 * 查看经营历程表
 */
public interface BusinessHistoryScheduleDataService extends CommonDataService<BusinessHistorySchedulePO>{
	public static final String NAME = "BusinessHistoryScheduleData";
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//红冲
	
	public void writeOffAndCopy(PersistObject billPO);//红冲并复制
}
