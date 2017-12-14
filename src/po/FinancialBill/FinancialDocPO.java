package po.FinancialBill;

import dataenum.BillState;
import dataenum.BillType;
import po.BillPO;

public class FinancialDocPO extends BillPO {
	
	private static final long serialVersionUID = 1L;
	protected String docID;//单据编号
	protected String userID;//当前登录用户的ID
	protected String customerID;//客户ID

	public FinancialDocPO(String docID,String userID,String customerID,
			BillType billType,BillState billState){
		super(billType, billState);
		this.docID=docID;
		this.userID=userID;
		this.customerID=customerID;
		this.billType=billType;
		this.billState=billState;

	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	
	

}
