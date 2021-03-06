package data.promotiondata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
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
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from promotion where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage update(PromotionPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update promotion set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	
	public ArrayList<PromotionPO> find(String keyword, FindPromotionType type) {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from promotion";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象 
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象  
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象  
                byte[] buff = new byte[(int) inBlob.length()];
                
                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中  
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff)); 
                    PromotionPO po = (PromotionPO) in.readObject();
                    switch (type) {
					case TYPE:
						if (keyword.equals(po.getType().value)) list.add(po);
						break;
					case ID:
						if (keyword.equals(po.getId())) list.add(po);
						break;
					case TIMEINTERVAL:
						if (keyword.equals(po.getBeginDate())) list.add(po);
						break;
					default:
						break;
					}
               }
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
	}
	
	public ArrayList<PromotionPO> show() {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from promotion";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象 
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象  
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象  
                byte[] buff = new byte[(int) inBlob.length()];
                
                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中  
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff)); 
                    PromotionPO po = (PromotionPO) in.readObject();
                    list.add(po);
                }
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
	}
}
