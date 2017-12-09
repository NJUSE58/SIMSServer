package dataservice.purchasedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.CommonDataService;
import po.PurchasePO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public interface PurchaseDataService extends CommonDataService<PurchasePO> {

	public static final String NAME = "PurchaseData";
	
	public String getPurchaseID() throws RemoteException;
	
	public String getPurchaseBackID() throws RemoteException;
}
