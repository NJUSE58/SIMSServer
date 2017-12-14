package data.promotiondata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import po.PromotionPO;

/**     
*  
* @author Lijie 
* @date 2017年12月6日    
*/
public class PromotionData {

	public ResultMessage insert(PromotionPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		try {
			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery("select count(*) from promotion where id = " + po.getId());
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into promotion(id, object) values (?,?)";
					
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
			        ps.setObject(2, po);
			        ps.executeUpdate();
			        conn.commit();
			        ps.close();
			        conn.close();
			        return ResultMessage.SUCCESS;
				}
				else {
					System.out.println("促销策略ID已存在");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}
	
	public ResultMessage delete(String id) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage update(PromotionPO po) {
		return ResultMessage.FAIL;
	}
	
	public ArrayList<PromotionPO> find(String keyword, FindPromotionType type) {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		return list;
	}
	
	public ArrayList<PromotionPO> show() {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		return list;
	}
}
