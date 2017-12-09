package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService{

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	*/
	private static final long serialVersionUID = -7653073542012573879L;
	private PromotionData promotion;
	
	protected PromotionDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> show() throws RemoteException {
		return null;
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
	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException {
		return null;
	}

}
