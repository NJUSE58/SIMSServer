package dataservice.memberdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.findtype.FindMemberType;
import dataservice.CommonDataService;
import po.MemberPO;


public interface MemberDataService extends CommonDataService<MemberPO>{

	public static final String NAME = "MemberData";  //rmi的名称
	
	/**
	 * 
	* @Title: find 
	* @Description: 传入keyword, 选择查找类型，进行查找, null为模糊查找
	* @param keyword
	* @param type
	* @throws RemoteException     
	* @return ArrayList<MemberPO>    
	 */
	public ArrayList<MemberPO> find(String keyword, FindMemberType type) throws RemoteException;

}
