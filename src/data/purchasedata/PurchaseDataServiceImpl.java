package data.purchasedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.purchasedataservice.PurchaseDataService;
import po.PurchasePO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ8ÈÕ    
*/
public class PurchaseDataServiceImpl extends UnicastRemoteObject implements PurchaseDataService{

	private static final long serialVersionUID = 7329137070125442396L;
	private PurchaseData purchase;
	public PurchaseDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(PurchasePO po) throws RemoteException {
		purchase = new PurchaseData();
		return purchase.insert(po);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		purchase = new PurchaseData();
		return purchase.delete(ID);
	}

	@Override
	public ResultMessage update(PurchasePO po) throws RemoteException {
		purchase = new PurchaseData();
		return purchase.update(po);
	}

	@Override
	public ArrayList<PurchasePO> show() throws RemoteException {
		purchase = new PurchaseData();
		return purchase.show();
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		return null;
	}

	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}


	@Override
	public String getPurchaseID() throws RemoteException {
		return null;
	}

	@Override
	public String getPurchaseBackID() throws RemoteException {
		return null;
	}

}
