package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import po.FinancialBill.PaymentBillPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
/**
 * 
* @ClassName: PaymentBillDataService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author lijie
* @date 2017年12月3日 上午11:42:48 
*
 */
public interface PaymentBillDataService extends Remote {

    public static final String NAME = "PaymentBillData";
	
	public ArrayList<PaymentBillPO> show(BillType type) throws RemoteException;

	
}
