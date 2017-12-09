package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.userdata.UserData;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataServiceImpl implements UserDataService {

	private UserData user;
	
	public UserDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		user = new UserData();
		return user.insert(po);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		user = new UserData();
		return user.delete(ID);
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		user = new UserData();
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
		user = new UserData();
		ArrayList<UserPO> list = user.show();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID().equals(id) && list.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<UserPO> find(String info, FindUserType type) throws RemoteException {
		user = new UserData();
		return user.find(info, type);
	}


	

	
}
