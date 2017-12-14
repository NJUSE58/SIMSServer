package data.salesdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import po.SalesPO;
import po.commodity.CommodityItemPO;

/**
 * 
 * @author Lijie
 * @date 2017年12月5日
 */
public class SalesData{

	public SalesData() throws RemoteException {
		super();
	}
	
	public void createTable() throws SQLException {
		Connection conn = DBManager.getConnection();
		String sql = "create table Sales (id varchar(25) not null, memberID varchar(20) not null, member varchar(20) not null, "
				+ "saleMan varchar(20), operator varchar(20), warehouse varchar(20), beforePrice double, allowance double, "
				+ "voucher double, afterPrice double, remark varchar(40), type varchar(20), state varchar(20);";
		
		try {
		    Statement s = conn.createStatement();
            s.execute(sql);
            s.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage insert(SalesPO po) throws RemoteException {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		Statement ps0;
		try {
			ps0 = conn.createStatement();

			ResultSet rs = ps0.executeQuery("select count(*) from userrole where id = " + po.getId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int count = 0;
		String sql = "" + "insert into sales values(?,?,?,?,?,?,?,?,?,?,?,?);";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, po.getId());
            ps.setString(2, po.getClientId());
            ps.setString(3, po.getClientName());
            ps.setString(4, po.getSaleMan());
            ps.setString(5, po.getOperator());
            ps.setString(6, String.valueOf(po.getWarehouse()));
            ps.setDouble(7, po.getBeforePrice());
            ps.setDouble(8, po.getAllowance());
            ps.setDouble(9, po.getVoucher());
            ps.setDouble(10, po.getAfterPrice());
            ps.setString(11, po.getRemark());
            ps.setString(12, String.valueOf(po.getType()));
            ps.setString(13, String.valueOf(po.getState()));
            ps.execute();
            ps.close();
            conn.close();
            return ResultMessage.SUCCESS;
        }catch(SQLException e){
            e.printStackTrace();    
            return ResultMessage.FAIL;
        }
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public SalesPO find(String ID) throws RemoteException {
		SalesPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "select * from sales where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<CommodityItemPO> commodities = null;
			BillType type = null;
			Warehouse warehouse = null;
			String temp = null;
			BillState state = null;
			if(rs.next()) {
				
				temp = rs.getString("type").toUpperCase();
				if(temp.equals(BillType.SALESBILL)) {
					type = BillType.SALESBILL;
				}
				else {
					type = BillType.SALESBACKBILL;
				}
				
				temp = rs.getString("warehouse").toUpperCase();
				if(temp.equals(Warehouse.WAREHOUSE1)) {
					warehouse = Warehouse.WAREHOUSE1;
				}
				else {
					warehouse = Warehouse.WAREHOUSE2;
				}
				
				temp = rs.getString("state").toUpperCase();
				if(temp.equals(BillState.COMMITED)) {
					state = BillState.COMMITED;
				}
				else if(temp.equals(BillState.DRAFT)) {
					state = BillState.DRAFT;
				}
				else if(temp.equals(BillState.FAIL)) {
					state = BillState.FAIL;
				}
				else {
					state = BillState.SUCCESS;
				}
				
				po = new SalesPO(rs.getString("id"), rs.getString("memberID"), rs.getString("member"), rs.getString("saleMan"), 
						rs.getString("operator"), warehouse, commodities, rs.getDouble("beforePrice"), rs.getDouble("Allowance"),
						rs.getDouble("voucher"), rs.getDouble("afterPrice"), rs.getString("remark"), type);
				po.setState(state);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public ResultMessage delete(String ID) throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from sales where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
	}

	public ResultMessage update(SalesPO po) throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update sales set memberID = ?, member = ?,"
				    + " saleMan = ?, operator = ?, warehouse = ?, beforePrice = ?,"
				    + " allowance = ?, voucher = ?, afterPrice = ?, remark = ?,"
				    + " type = ?, state = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getClientId());
	        ps.setString(2, po.getClientName());
	        ps.setString(3, po.getSaleMan());
	        ps.setString(4, po.getOperator());
	        ps.setString(5, String.valueOf(po.getWarehouse()));
	        ps.setDouble(6, po.getBeforePrice());
	        ps.setDouble(7, po.getAllowance());
	        ps.setDouble(8, po.getVoucher());
	        ps.setDouble(9, po.getAfterPrice());
	        ps.setString(10, po.getRemark());
	        ps.setString(11, String.valueOf(po.getType()));
	        ps.setString(12, String.valueOf(po.getState()));
	        ps.setString(13, po.getId());
	        ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	/**
	 * 
	* @Title: show 
	* @Description: 显示全部账单
	* @param @return
	* @param @throws RemoteException   
	* @return ArrayList<SalesPO>
	 */
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<SalesPO> show() throws RemoteException, SQLException {
		Connection conn = DBManager.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from sales;");
		
		ArrayList<SalesPO> list = new ArrayList<SalesPO>();
		SalesPO po = null;
		ArrayList<CommodityItemPO> commodities = null;
		BillType type = null;
		Warehouse warehouse = null;
		String temp = null;
		BillState state = null;
		while(rs.next()) {
			temp = rs.getString("type").toUpperCase();
			if(temp.equals(BillType.SALESBILL)) {
				type = BillType.SALESBILL;
			}
			else {
				type = BillType.SALESBACKBILL;
			}
			
			temp = rs.getString("warehouse").toUpperCase();
			if(temp.equals(Warehouse.WAREHOUSE1)) {
				warehouse = Warehouse.WAREHOUSE1;
			}
			else {
				warehouse = Warehouse.WAREHOUSE2;
			}
			
			temp = rs.getString("state").toUpperCase();
			if(temp.equals(BillState.COMMITED)) {
				state = BillState.COMMITED;
			}
			else if(temp.equals(BillState.DRAFT)) {
				state = BillState.DRAFT;
			}
			else if(temp.equals(BillState.FAIL)) {
				state = BillState.FAIL;
			}
			else {
				state = BillState.SUCCESS;
			}
			
			po = new SalesPO(rs.getString("id"), rs.getString("memberID"), rs.getString("member"), rs.getString("saleMan"), 
					rs.getString("operator"), warehouse, commodities, rs.getDouble("beforePrice"), rs.getDouble("Allowance"),
					rs.getDouble("voucher"), rs.getDouble("afterPrice"), rs.getString("remark"), type);
			po.setState(state);
			list.add(po);
		}
		return list;
	}

}
