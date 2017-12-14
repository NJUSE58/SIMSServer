package po.FinancialBill;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

public class ReceiptBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private ArrayList<AccountListPO> accountListPOs;//转账列表
	
	private String total;//总额

	public ReceiptBillPO(String docID, String userID,String customerID,BillType billType,BillState billState
			,ArrayList<AccountListPO> accountListPOs,String total) {
		super(docID,userID,customerID,billType,billState);
		this.total=total;
		accountListPOs=new ArrayList<AccountListPO>();
	}

	public ArrayList<AccountListPO> getAccountListPOs() {
		return accountListPOs;
	}

	public void setAccountListPOs(ArrayList<AccountListPO> accountListPOs) {
		this.accountListPOs = accountListPOs;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
