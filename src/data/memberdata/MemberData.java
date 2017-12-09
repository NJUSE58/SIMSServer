package data.memberdata;

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
import java.util.ArrayList;

import data.DBManager;
import po.MemberPO;

/**
 * 
 * @author Lijie
 * @date 2017年12月7日
 */
public class MemberData {

	public void insert(MemberPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "insert into Member (object) values (?)";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from member where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(MemberPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update member set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberPO find(String id) {
		MemberPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "" + "select * from member where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 以下是读取的方法一定要注意了！
				try {
					Blob inblob = (Blob) rs.getBlob("object");
					InputStream is = inblob.getBinaryStream();
					BufferedInputStream input = new BufferedInputStream(is);

					byte[] buff = new byte[(int) inblob.length()];// 放到一个buff 字节数组
					while (-1 != (input.read(buff, 0, buff.length)));

					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));

					po = (MemberPO) in.readObject();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} // 从IO流中读取出来.可以得到一个对象了

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public ArrayList<MemberPO> show() {
		ArrayList<MemberPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from member";
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
                    MemberPO po = (MemberPO)in.readObject();                   //读出对象  
                      
                    list.add(po);  
                }  
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
		
	}
}
