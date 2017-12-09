package dataservice.classificationdataservice;

import java.rmi.RemoteException;

import dataservice.CommonDataService;
import po.ClassificationPO;


public interface ClassificationDataService extends CommonDataService<ClassificationPO> {

	public static final String NAME = "ClassificationData";
	
	public String getID(String fatherID) throws RemoteException;
}
