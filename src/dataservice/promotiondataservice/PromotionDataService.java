package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import po.PromotionPO;

public interface PromotionDataService extends Remote{

	public static final String NAME = "PromotionData";
	
	public ResultMessage insertPromotion(PromotionPO po) throws RemoteException;
	
	public ResultMessage deletePromotion(String ID) throws RemoteException;
	
	public ResultMessage updatePromotion(PromotionPO po) throws RemoteException;
	
	public ArrayList<PromotionPO> findPromotion(String keyword, FindPromotionType type) throws RemoteException;

	public ArrayList<PromotionPO> showPromotion() throws RemoteException;

	
}
