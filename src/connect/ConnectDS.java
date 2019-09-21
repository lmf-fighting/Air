package connect;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ConnectDS {
	
	private static Connection connect;
	
	//数据库连接
	public Connection getConnect() throws ClassNotFoundException, SQLException{
		if(connect==null||connect.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wechat","root", "root");
		}

		return connect;
	}
	
	//查询数据库
	public ResultSet query(String sql) throws SQLException, ClassNotFoundException{
		
		Connection connect = this.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	//更新
	public boolean update(String sql) throws SQLException, ClassNotFoundException{
		Statement stmt = this.getConnect().createStatement();
		int i = stmt.executeUpdate(sql);
		return i>0;
	}
	
	public boolean delete(String sql) throws SQLException, ClassNotFoundException{
		Statement stmt = this.getConnect().createStatement();
		int i = stmt.executeUpdate(sql);
		return i>0;
	}
	
	public static void main(String[]args){
		
		ConnectDS cds = new ConnectDS();

		//String sql = "select * from infouser";
		//connect.query(sql);
		String sql = "insert into user value('2','xiaofeng','123','女')";
		try {
			cds.update(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		
	}
}