package po.table;

import dataenum.BillType;
import dataenum.Warehouse;
import po.PersistObject;

/**
 * 经营历程表
 * 继承PersistObjct
 * 将原本的属性用private修饰，增加serialVersionUID,去掉date, 因为date在父类PersistObject自动生成
 * 修改者：lijie
 */
public class BusinessHistorySchedulePO extends PersistObject{
	private static final long serialVersionUID = 1L;
	//筛选条件
	private BillType type;
	private String customer;//客户
	private String clerkID;//业务员
	private Warehouse warehouse;//仓库
	
	/** 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @param type
	* @param @param customer
	* @param @param clerkID
	* @param @param warehouse    设定文件 
	* @return   返回类型 
	* @throws 
	*/
	public BusinessHistorySchedulePO(String id, BillType type, String customer, String clerkID, Warehouse warehouse) {
		super(id);
		this.type = type;
		this.customer = customer;
		this.clerkID = clerkID;
		this.warehouse = warehouse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BillType getType() {
		return type;
	}

	public String getCustomer() {
		return customer;
	}

	public String getClerkID() {
		return clerkID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setType(BillType type) {
		this.type = type;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
	
		
}
