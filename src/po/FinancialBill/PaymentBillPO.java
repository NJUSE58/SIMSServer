package po.FinancialBill;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

public class PaymentBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private String total;//总额
	private String accountID;
	private ArrayList<EntryPO> entryListPO;//条目清单

	public PaymentBillPO (String docID,String userID,String customerID,String accountID,ArrayList<EntryPO> entryListPO,
			String total,BillType billType,BillState billState){
		super(docID,userID,customerID,billType,billState);
		entryListPO=new ArrayList<EntryPO>();
		this.accountID = accountID;
		this.total=total;
	}

	public String getAccountID(){
		return accountID;
	}

	public void setAccountID(String accountID){
		this.accountID = accountID;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public ArrayList<EntryPO> getEntryListPO() {
		return entryListPO;
	}

	public void setEntryListPO(ArrayList<EntryPO> entryListPO) {
		this.entryListPO = entryListPO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
