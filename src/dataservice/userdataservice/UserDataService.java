package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.findtype.FindUserType;
import dataservice.CommonDataService;
import po.UserPO;

public interface UserDataService extends CommonDataService<UserPO> {

	public static final String NAME = "UserData"; // rmiµÄÃû³Æ

	public boolean login(String id, String password) throws RemoteException;

	public ArrayList<UserPO> find(String info, FindUserType type) throws RemoteException;

}
