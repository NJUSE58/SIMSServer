package data.purchasedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataservice.purchasedataservice.PurchaseDataService;
import po.PurchasePO;

/**     
*  
* @author Lijie 
* @date 2017ƒÍ12‘¬8»’    
*/
public class PurchaseDataServiceImpl implements PurchaseDataService{

	private PurchaseData purchase;
	
	public PurchaseDataServiceImpl() {
		purchase = new PurchaseData();
	}
	
	public static void main(String[] args) throws RemoteException {
		PurchaseDataServiceImpl p = new PurchaseDataServiceImpl();
		PurchasePO po1 = new PurchasePO("00001", "00011", "¿ÓΩ‹", Warehouse.WAREHOUSE1, "¡ı«’", null, "≤‚ ‘1", 10000, BillType.PURCHASEBILL);
		PurchasePO po2 = new PurchasePO("00002", "00012", "Õı≤”≤”", Warehouse.WAREHOUSE2, "¡ı«’1", null, "≤‚ ‘2", 10000, BillType.PURCHASEBILL);
		PurchasePO po3 = new PurchasePO("00003", "00013", "œﬂ¥˙", Warehouse.WAREHOUSE2, "¡ı«’2", null, "≤‚ ‘3", 10000, BillType.PURCHASEBILL);

		p.insertPurchase(po1);
		p.insertPurchase(po2);
		p.insertPurchase(po3);
//		p.deletePurchase("00003");
		ArrayList<PurchasePO> list = p.showPurchase();
		for (PurchasePO pu : list) {
			System.out.println(pu.getId() + " " + pu.getMember());
		}
	}
	
	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return purchase.insert(po);
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return purchase.delete(ID);
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return purchase.update(po);
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return purchase.show();
	}


	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return purchase.find(keyword, type);
	}

}
