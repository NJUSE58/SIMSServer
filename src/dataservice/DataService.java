package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataenum.ResultMessage;
import po.PersistObject;


/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ2ÈÕ    
*/
public interface DataService<PO extends PersistObject> extends Remote {

	public ResultMessage createTable() throws RemoteException;
	public void init() throws RemoteException;
	public String getID() throws RemoteException;
}
