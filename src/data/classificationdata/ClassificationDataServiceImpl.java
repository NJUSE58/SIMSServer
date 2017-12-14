package data.classificationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ14ÈÕ    
*/
public class ClassificationDataServiceImpl implements ClassificationDataService{
	
	private ClassificationData classfication;
	
	public ClassificationDataServiceImpl() {
		classfication = new ClassificationData();
	}

	@Override
	public ResultMessage insertClassification(ClassificationPO po) throws RemoteException {
		return classfication.insert(po);
	}

	@Override
	public ResultMessage updateClassification(ClassificationPO po) throws RemoteException {
		return classfication.update(po);
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		return classfication.delete(id);
	}

	@Override
	public ArrayList<ClassificationPO> showClassification() throws RemoteException {
		return classfication.show();
	}

	@Override
	public ArrayList<ClassificationPO> findClassification(String keyword) throws RemoteException {
		return classfication.find(keyword);
	}

}
