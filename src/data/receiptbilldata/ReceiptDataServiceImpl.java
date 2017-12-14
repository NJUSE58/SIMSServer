package data.receiptbilldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import po.FinancialBill.ReceiptBillPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ14ÈÕ    
*/
public class ReceiptDataServiceImpl implements ReceiptBillDataService {

	private ReceiptBillData receipt;
	
	public ReceiptDataServiceImpl() {
		receipt = new ReceiptBillData();
	}
	
	@Override
	public ResultMessage insertPaymentBill(ReceiptBillPO po) throws RemoteException {
		return receipt.insert(po);
	}

	@Override
	public ResultMessage deletePaymentBill(String id) throws RemoteException {
		return receipt.delete(id);
	}

	@Override
	public ResultMessage updatePaymentBill(ReceiptBillPO po) throws RemoteException {
		return receipt.update(po);
	}

	@Override
	public ArrayList<ReceiptBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException {
		return receipt.find(keyword, type);
	}

	@Override
	public ArrayList<ReceiptBillPO> showPaymentBill() throws RemoteException {
		return receipt.show();
	}

}
