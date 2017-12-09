package po.makefinancialdoc;

import java.util.ArrayList;

public class EntryListPO {
	
	// 条目清单
		protected ArrayList<String> entryName;// 条目名
		protected ArrayList<String> transferAmount;// 金额
		protected ArrayList<String> note;// 备注
		
		public EntryListPO(ArrayList<String> entryName,ArrayList<String> transferAmount,ArrayList<String> note) {
			this.transferAmount=transferAmount;
			this.entryName=entryName;
			this.note=note;
		}

		public ArrayList<String> getEntryName() {
			return entryName;
		}

		public void setEntryName(ArrayList<String> entryName) {
			this.entryName = entryName;
		}

		public ArrayList<String> getTransferAmount() {
			return transferAmount;
		}

		public void setTransferAmount(ArrayList<String> transferAmount) {
			this.transferAmount = transferAmount;
		}

		public ArrayList<String> getNote() {
			return note;
		}

		public void setNote(ArrayList<String> note) {
			this.note = note;
		}
	
}
