package dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import po.PersistObject;

/**     
*  通用的数据层接口，包括数据的增删改查
* @author Lijie 
* @date 2017年12月2日    
*/
public interface CommonDataService<PO extends PersistObject> extends DataService<PO> {

	public ResultMessage insert(PO po) throws RemoteException;
	public ResultMessage delete(String ID) throws RemoteException;
	public ResultMessage update(PO po) throws RemoteException;
	public ArrayList<PO> show() throws RemoteException;
}
