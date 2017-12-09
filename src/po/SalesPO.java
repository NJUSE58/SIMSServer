package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commodity.CommodityItemPO;


public class SalesPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String clientName; // 客户姓名
	private String operator; // 操作员
	private String saleMan; // 业务员
	private Warehouse warehouse; // 仓库
	private double beforePrice; // 折让前价格
	private double allowance; // 折让金额
	private double voucher; // 代金券金额
	private double afterPrice; // 折让后金额
	private String remark; // 备注
	private ArrayList<CommodityItemPO> commodities; // 商品清单
	private BillState state;
	private BillType type;

	
	public SalesPO() {
		
	}

	public SalesPO(String id, String clientId, String clientName, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemPO> commodities, double beforePrice, double allowance, double voucher,
			double afterPrice, String remark, BillType type) {
		super(id);
		this.clientId = clientId;
		this.clientName = clientName;
		this.operator = operator;
		this.saleMan = saleMan;
		this.warehouse = warehouse;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.commodities = commodities;
		this.state = BillState.COMMITED;
		this.type = type;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public String getOperator() {
		return operator;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public double getBeforePrice() {
		return beforePrice;
	}

	public double getAllowance() {
		return allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public double getAfterPrice() {
		return afterPrice;
	}

	public String getRemark() {
		return remark;
	}

	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}

	public BillState getState() {
		return state;
	}

	public BillType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SalesPO [ID=" + this.id + ", clientID=" + this.clientId + ", client=" + this.clientName + ", salesman="
				+ this.saleMan + ", operator=" + this.operator + ", Warehouse=" + this.warehouse + ", commodities="
				+ this.commodities + ", beforePrice=" + this.beforePrice + ", allowance=" + this.allowance
				+ ", voucher=" + this.voucher + ", afterPrice=" + this.afterPrice + ", remark=" + this.remark
				+ ", type=" + this.type + ", state=" + this.state + "]";
	}

}
