package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.findtype.FindCommodityType;
import po.commodity.CommodityPO;

public interface CommodityDataService extends Remote {
	
	public String getID(String fatherID) throws RemoteException;

	public ArrayList<String> getAllID() throws RemoteException;

	public ArrayList<CommodityPO> find(String keywords, FindCommodityType type) throws RemoteException;

}
