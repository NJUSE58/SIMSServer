package po;
/**     
*  
* @author Lijie 
* @date 2017年12月2日    
*/

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commodity.CommodityItemPO;

public class PurchasePO extends PersistObject {

	private static final long serialVersionUID = 1L;
	private String memberID;
	private String member;
	private Warehouse warehouse;
	private String operator;
	private ArrayList<CommodityItemPO> commodities;
	private String remark;
	private double sum;
	private BillType type;
	private BillState state;
	/** 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @param memberID
	* @param @param member
	* @param @param warehouse
	* @param @param operator
	* @param @param commodities
	* @param @param remark
	* @param @param sum
	* @param @param type    设定文件 
	* @return   返回类型 
	* @throws 
	*/
	public PurchasePO(String id, String memberID, String member, Warehouse warehouse, String operator,
			ArrayList<CommodityItemPO> commodities, String remark, double sum, BillType type) {
		super(id);
		this.memberID = memberID;
		this.member = member;
		this.warehouse = warehouse;
		this.operator = operator;
		this.commodities = commodities;
		this.remark = remark;
		this.sum = sum;
		this.type = type;
		this.state = BillState.COMMITED;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMemberID() {
		return memberID;
	}
	public String getMember() {
		return member;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public String getOperator() {
		return operator;
	}
	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}
	public String getRemark() {
		return remark;
	}
	public double getSum() {
		return sum;
	}
	public BillType getType() {
		return type;
	}
	public BillState getState() {
		return state;
	}
	
	public void setState(BillState state) {
		this.state = state;
	}
	
	
}
