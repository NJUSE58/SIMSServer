package dataservice.classificationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import po.ClassificationPO;


public interface ClassificationDataService extends Remote {
	
	public ResultMessage insertClassification(ClassificationPO po) throws RemoteException;
	
	public ResultMessage updateClassification(ClassificationPO po) throws RemoteException;
	
	public ResultMessage deleteClassification(String id) throws RemoteException;
	
	public ArrayList<ClassificationPO> showClassification() throws RemoteException;
	public ArrayList<ClassificationPO> findClassification(String keyword) throws RemoteException;
}
