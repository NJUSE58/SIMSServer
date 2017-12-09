package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import data.userdata.UserDataServiceImpl;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
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
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService {

	private static final long serialVersionUID = 4029039744279087114L;

	private UserDataService user;

	public DataRemoteObject() throws RemoteException {

		user = new UserDataServiceImpl();
	}


	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		return user.insert(po);
	}


	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return user.delete(ID);
	}


	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return user.update(po);
	}


	@Override
	public ArrayList<UserPO> show() throws RemoteException {
		return user.show();
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
	public boolean login(String id, String password) throws RemoteException {
		return user.login(id, password);
	}


	@Override
	public ArrayList<UserPO> find(String info, FindUserType type) throws RemoteException {
		return user.find(info, type);
	}

}
