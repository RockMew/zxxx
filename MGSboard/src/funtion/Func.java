package funtion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import control.Getcon;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import model.MessBoar;

public class Func {
	static PreparedStatement pstmt;
	static Connection conn = Getcon.getConnection();

	public static  ArrayList<MessBoar> findMbInfo(){
		try{
			ArrayList<MessBoar> al=new ArrayList<MessBoar>();
			pstmt=conn.prepareStatement("select * from messagess");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				MessBoar mb=new MessBoar();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setTime(rs.getDate(3));
				mb.setTitle(rs.getString(4));
				mb.setMessage(rs.getString(5));
				al.add(mb);
			}
			return al;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public String getName(int id) {
		String name = null;
		try {
			pstmt = conn
					.prepareStatement("select name from loginss where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}
			return name;
		} catch (Exception e) {
			
			return null;
		}
	}

	public boolean addInfo(MessBoar mb) {
		try {
			pstmt = conn
					.prepareStatement("insert into messagess values(?,?,?,?,?)");
			pstmt.setInt(1, mb.getId());
			pstmt.setString(2, mb.getName());
			pstmt.setDate(3, mb.getTime());
			pstmt.setString(4, mb.getTitle());
			pstmt.setString(5, mb.getMessage());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	public boolean insertUser(int id, String name, String password) {
		try {
			pstmt = conn
					.prepareStatement("insert into loginss values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

}
