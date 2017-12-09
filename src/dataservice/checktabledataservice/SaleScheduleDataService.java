package dataservice.checktabledataservice;

import dataservice.CommonDataService;
import po.table.SaleSchedulePO;

public interface SaleScheduleDataService extends CommonDataService<SaleSchedulePO>{
	public static final String NAME = "SaleScheduleData";
	
	public void viewReport(SaleSchedulePO saleSchedulePO);
	
	public void exportReport();
}
