package dataservice.billdataservice;

import java.util.Date;

import dataenum.BillState;
import dataenum.BillType;
public interface BillDataService {

	public Date getDate();
	public BillType getType();
	public BillState getState();

}
