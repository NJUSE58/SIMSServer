package data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.salesdataservice.SalesDataService;
import po.SalesPO;

public class SalesDataServiceImpl extends UnicastRemoteObject implements SalesDataService{
	private static final long serialVersionUID = 1L;
	SalesData sale = new SalesData();

	public SalesDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		try {
			sale.createTable();
			return ResultMessage.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	@Override
	public ResultMessage insert(SalesPO po) throws RemoteException {
		try {
			sale.insert(po);
			return ResultMessage.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return sale.delete(ID);
	}

	@Override
	public ResultMessage update(SalesPO po) throws RemoteException {
		try {
			return sale.update(po);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<SalesPO> show() throws RemoteException {
		try {
			return sale.show();
		}catch (Exception e) {
			// TODO: handle exception
		}
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
	public String getSaleID() throws RemoteException {
		return null;
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return null;
	}

	
} 

