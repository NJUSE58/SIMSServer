package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.findtype.FindCommodityType;
import dataservice.CommonDataService;
import po.commodity.CommodityPO;

public interface CommodityDataService extends CommonDataService<CommodityPO>{
	public static final String NAME = "CommodityData";
	
	public String getID(String fatherID) throws RemoteException;

	public ArrayList<String> getAllID() throws RemoteException;

	public ArrayList<CommodityPO> find(String keywords, FindCommodityType type) throws RemoteException;

}
