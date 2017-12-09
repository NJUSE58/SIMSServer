package po;

public class AccountBookPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String clerkID;

	public AccountBookPO(String id, String c) {
		super(id);
		clerkID = c;
	}

	

	public String getClerkID() {
		return this.clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}
}
