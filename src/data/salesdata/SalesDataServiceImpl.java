package data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.salesdataservice.SalesDataService;
import po.SalesPO;

public class SalesDataServiceImpl implements SalesDataService{
	
	private SalesData sale;

	@Override
	public ResultMessage insertSale(SalesPO po) throws RemoteException {
		sale = new SalesData();
		try {
			sale.insert(po);
			return ResultMessage.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage deleteSale(String ID) throws RemoteException {
		return sale.delete(ID);
	}

	@Override
	public ResultMessage updateSale(SalesPO po) throws RemoteException {
		try {
			return sale.update(po);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<SalesPO> showSale() throws RemoteException {
		try {
			return sale.show();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException {
		return null;
	}

	@Override
	public String getSaleID() throws RemoteException {
		return null;
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return null;
	}
	
} 

