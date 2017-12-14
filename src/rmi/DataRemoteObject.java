package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import data.memberdata.MemberDataServiceImpl;
import data.promotiondata.PromotionDataServiceImpl;
import data.purchasedata.PurchaseDataServiceImpl;
import data.salesdata.SalesDataServiceImpl;
import data.userdata.UserDataServiceImpl;
import data_stub.UserDataService_Stub;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBookType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindPromotionType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.accountbookdataservice.AccountBookDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountBookPO;
import po.MemberPO;
import po.PromotionPO;
import po.PurchasePO;
import po.SalesPO;
import po.UserPO;


/**
 *
 * @author 王灿灿
 * @version 2017-11-28
 */

/**
 *
 * @ClassName: DataRemoteObject
 * @Description: 数据层的增删改查等通用操作
 * @author lijie
 * @date 2017年12月3日 下午7:00:46
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService, MemberDataService, SalesDataService, 
    PromotionDataService, PurchaseDataService, AccountBookDataService {

	private static final long serialVersionUID = 4029039744279087114L;

	private UserDataService user;
	private MemberDataService member;
	private SalesDataService sale;
	private PromotionDataService promotion;
	private PurchaseDataService purchase;
	private AccountBookDataService accountbook;

	public DataRemoteObject() throws RemoteException {

		user = new UserDataServiceImpl();
		member = new MemberDataServiceImpl();
		sale = new SalesDataServiceImpl();
		promotion = new PromotionDataServiceImpl();
		purchase = new PurchaseDataServiceImpl();
	}


	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		return user.insertUser(po);
	}


	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		return user.deleteUser(ID);
	}


	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		return user.updateUser(po);
	}


	@Override
	public boolean login(String id, String password) throws RemoteException {
		return user.login(id, password);
	}


	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		return user.findUser(info, type);
	}


	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		return member.findMember(keyword, type);
	}


	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		return member.insertMember(po);
	}


	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		return member.deleteMember(ID);
	}


	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		return member.updateMember(po);
	}


	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		return user.showUser();
	}


	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		return member.showMember();
	}


	@Override
	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException {
		return sale.findSale(info, type);
	}


	@Override
	public ResultMessage insertSale(SalesPO po) throws RemoteException {
		return sale.insertSale(po);
	}


	@Override
	public ResultMessage deleteSale(String ID) throws RemoteException {
		return sale.deleteSale(ID);
	}


	@Override
	public ResultMessage updateSale(SalesPO po) throws RemoteException {
		return sale.updateSale(po);
	}


	@Override
	public ArrayList<SalesPO> showSale() throws RemoteException {
		return sale.showSale();
	}
	
	@Override
	public String getSaleID() throws RemoteException {
		return sale.getSaleID();
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return sale.getSaleBackID();
	}


	@Override
	public ResultMessage insertPromotion(PromotionPO po) throws RemoteException {
		return promotion.insertPromotion(po);
	}


	@Override
	public ResultMessage deletePromotion(String ID) throws RemoteException {
		return promotion.deletePromotion(ID);
	}


	@Override
	public ResultMessage updatePromotion(PromotionPO po) throws RemoteException {
		return promotion.updatePromotion(po);
	}


	@Override
	public ArrayList<PromotionPO> findPromotion(String keyword, FindPromotionType type) throws RemoteException {
		return promotion.findPromotion(keyword, type);
	}


	@Override
	public ArrayList<PromotionPO> showPromotion() throws RemoteException {
		return promotion.showPromotion();
	}
	


	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return purchase.insertPurchase(po);
	}


	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return purchase.deletePurchase(ID);
	}


	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return purchase.updatePurchase(po);
	}


	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return purchase.findPurchase(keyword, type);
	}


	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return purchase.showPurchase();
	}


	@Override
	public ResultMessage insertAccountBook(AccountBookPO po) throws RemoteException {
		return null;
	}


	@Override
	public ResultMessage deleteAccountBook(String ID) throws RemoteException {
		return null;
	}


	@Override
	public ResultMessage updateAccountBook(AccountBookPO po) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<AccountBookPO> showAccountBook() throws RemoteException {
		return null;
	}

}
