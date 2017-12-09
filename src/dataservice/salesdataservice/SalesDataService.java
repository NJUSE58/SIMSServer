package dataservice.salesdataservice;

import java.rmi.RemoteException;

import dataservice.CommonDataService;
import po.SalesPO;

public interface SalesDataService extends CommonDataService<SalesPO> {

	public static final String NAME = "SaleData";  //rmi接口的名称
	public String getSaleID() throws RemoteException;
	public String getSaleBackID() throws RemoteException;
	
}
