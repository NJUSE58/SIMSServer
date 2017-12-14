package dataservice.classificationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClassificationPO;


public interface ClassificationDataService extends Remote {

	public static final String NAME = "ClassificationData";
	
	public String getID(String fatherID) throws RemoteException;
}
