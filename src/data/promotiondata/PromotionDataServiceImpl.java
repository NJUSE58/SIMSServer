package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;

public class PromotionDataServiceImpl implements PromotionDataService{

	private PromotionData promotion;
	
	public PromotionDataServiceImpl() {
		promotion = new PromotionData();
	}
	

	@Override
	public ResultMessage insertPromotion(PromotionPO po) throws RemoteException {
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deletePromotion(String id) throws RemoteException {
		return promotion.delete(id);
	}

	@Override
	public ResultMessage updatePromotion(PromotionPO po) throws RemoteException {
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionPO> showPromotion() throws RemoteException {
		return promotion.show();
	}

	@Override
	public ArrayList<PromotionPO> findPromotion(String keyword, FindPromotionType type) throws RemoteException {
		return promotion.find(keyword, type);
	}


}
