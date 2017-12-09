package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.PromotionType;
import dataservice.CommonDataService;
import po.PromotionPO;

public interface PromotionDataService extends CommonDataService<PromotionPO>{

	public static final String NAME = "PromotionData";

	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException;

	
}
