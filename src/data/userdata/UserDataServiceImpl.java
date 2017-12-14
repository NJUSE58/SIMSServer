package data.userdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DBManager;
import data.userdata.UserData;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataServiceImpl implements UserDataService {

	private UserData user;
	
	public UserDataServiceImpl() throws RemoteException {
		super();
		user = new UserData();
	}
	
	public static void main(String[] args) throws RemoteException {
		UserDataServiceImpl u = new UserDataServiceImpl();
		UserPO p = new UserPO("000004", "panxingyu", "123", UserRole.USER_MANAGER, null);
//		u.insertUser(p);
		ArrayList<UserPO> list = u.findUser("000004", FindUserType.ID);
		for(UserPO po: list) {
			System.out.println(po.toString());
		}
		System.out.println(u.login("000003", "admin"));
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		return user.insert(po);
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		return user.delete(ID);
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		return user.update(po);
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		return user.show();
	}


	@Override
	public boolean login(String id, String password) throws RemoteException {
		ArrayList<UserPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from userrole";
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
                    UserPO po = (UserPO)in.readObject();                   //读出对象  
                      
                    list.add(po);  
                }  
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  

		for (UserPO po: list) {
			if (id.equals(String.valueOf(po.getID())) && password.equals(String.valueOf(po.getPassword()))){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		return user.find(info, type);
	}


	

	
}
