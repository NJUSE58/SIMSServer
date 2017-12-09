package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import po.PersistObject;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-2
 * 
 */
public class AccountDataServiceMySqlImpl extends UnicastRemoteObject implements AccountDataService{

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	*/
	private static final long serialVersionUID = -2234101610458753475L;
	private AccountData account = null;
	
	protected AccountDataServiceMySqlImpl() throws RemoteException {
		super();
	}
	
	@Override
	public ResultMessage createTable() throws RemoteException {
		account = new AccountData();
		return account.createTable();
	}
	
	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		account = new AccountData();
		return account.insert(po);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		account = new AccountData();
		return account.delete(ID);
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		account = new AccountData();
		return account.update(po);
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		account = new AccountData();
		return account.show();
	}


	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> find(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() {
		return null;
	}

	@Override
	public ResultMessage enterItem(ArrayList<String> idList, ArrayList<String> moneyList) {
		return null;
	}

	@Override
	public ResultMessage newBuild(PersistObject po) {
		return null;
	}

	@Override
	public ResultMessage saveChange(ArrayList<PersistObject> persistObjects) {
		return null;
	}
	
	
}
