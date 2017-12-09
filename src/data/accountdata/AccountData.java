package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import po.AccountPO;

/**     
*  
* @author Lijie 
* @date 2017年12月3日    
*/
public class AccountData {

	public AccountData() throws RemoteException{
		super();
	}
	
    public ResultMessage createTable() throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "create table account (id varchar(30) not null, name varchar(20) not null, money double);";
		try {
			Statement s = conn.createStatement();
			s.execute(sql);
			s.close();
            conn.close();
            return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}


	public ResultMessage insert(AccountPO po) throws RemoteException {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		String sql = "" + "insert into account values(?,?,?);";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, po.getID());
            ps.setString(2, po.getName());
            ps.setDouble(3, po.getMoney());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();    
        }
		return null;
	}
	

	public ResultMessage delete(String ID) throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from account where id = ?";
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

	public ResultMessage update(AccountPO po) throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update account set name = ?, money = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getName());
			ps.setDouble(2, po.getMoney());
			ps.setString(3, po.getID());
	        ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<AccountPO> show() throws RemoteException {
		return null;
	}


	public AccountPO find(String ID) throws RemoteException {
		return null;
	}

	public ArrayList<AccountPO> find(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	
}
