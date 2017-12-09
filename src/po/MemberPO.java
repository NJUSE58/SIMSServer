package po;

import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.UserRole;

public class MemberPO extends PersistObject {

	private static final long serialVersionUID = 1L;
	private MemberCategory category;
	private MemberLevel level;
	private String name;
	private String phone;
	private String address;
	private String post;
	private String email;
	private double receivableLimit; // 应收额度
	private double receivable; // 应收
	private double payable; // 应付
	private String saleMan; // 默认业务员

	/**
	 * @Description: TODO(这里用一句话描述这个方法的作用) @param @param id @param @param
	 *               category @param @param level @param @param name @param @param
	 *               phone @param @param adress @param @param post @param @param
	 *               email @param @param rereceivableLimit @param @param saleMan
	 *               设定文件 @return 返回类型 @throws
	 */
	public MemberPO(String id, MemberCategory category, MemberLevel level, String name, String phone, String adress,
			String post, String email, double rereceivableLimit, String saleMan) {
		super(id);
		this.category = category;
		this.level = level;
		this.name = name;
		this.phone = phone;
		this.address = adress;
		this.post = post;
		this.email = email;
		this.receivableLimit = rereceivableLimit;
		this.saleMan = saleMan;
	}

	public MemberCategory getCategory() {
		return category;
	}

	public void setCategory(MemberCategory category) {
		this.category = category;
	}

	public MemberLevel getLevel() {
		return level;
	}

	public void setLevel(MemberLevel level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRereceivableLimit() {
		return receivableLimit;
	}

	/**
	 * 
	 * @Title: setRereceivableLimit @Description: 应收额度仅最高权限可修改 ,仅有总经理可以修改 @param
	 *         rereceivableLimit, role @return 是否修改成功 @throws
	 */
	public boolean setRereceivableLimit(double rereceivableLimit, UserRole role) {
		if (role.equals(UserRole.GENERAL_MANAGER)) {
			this.receivableLimit = rereceivableLimit;
			return true;
		} else {
			return false;
		}
	}

	public double getReceivable() {
		return receivable;
	}

	public void setReceivable(double receivable) {
		this.receivable = receivable;
	}

	public double getPayable() {
		return payable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}

	@Override
	public String toString() {
		return id + "," + category.value + "," + level.value + "," + name + "," + phone + "," + address + "," + post + "," + email
				+ "," + receivableLimit + receivable + "," + payable + "," + "," + saleMan;
	}

}
