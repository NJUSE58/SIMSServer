package po.table;

import dataenum.Warehouse;
import po.PersistObject;

/**
 * 销售明细表 继承PersistObjct 将原本的属性用private修饰，增加serialVersionUID,去掉date, 因为date在父类PersistObject自动生成 
 * 将clerkID转String
 * 修改者：lijie
 */
public class SaleSchedulePO extends PersistObject {
	private static final long serialVersionUID = 1L;
	// 筛选条件
	private String tradeName;// 商品名
	private String customer;// 客户
	private String clerkID;// 业务员
	private Warehouse warehouse;// 仓库

	
	public SaleSchedulePO(String id, String tradeName, String customer, String clerkID, Warehouse warehouse) {
		super(id);
		this.tradeName = tradeName;
		this.customer = customer;
		this.clerkID = clerkID;
		this.warehouse = warehouse;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
