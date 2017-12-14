package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import po.FinancialBill.ReceiptBillPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
public interface ReceiptBillDataService extends Remote{

	public ResultMessage insertPaymentBill(ReceiptBillPO po) throws RemoteException;

	public ResultMessage deletePaymentBill(String id) throws RemoteException;

	public ResultMessage updatePaymentBill(ReceiptBillPO po) throws RemoteException;

	public ArrayList<ReceiptBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException;

	public ArrayList<ReceiptBillPO> showPaymentBill() throws RemoteException;

}
