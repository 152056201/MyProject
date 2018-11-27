package cn.mldn.dlc;
/**
 * 本类专门负责数据库的连接与关闭操作，在实例化对象是就意味着要进行数据库开发
 * 所以在本类的构造方法里要进行数据库驱动的加载与数据库连接取得
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBDURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	private Connection conn = null;
	/**
	 * 在构造方法里为conn对象进行实例化，可以直接取得数据库连接对象
	 * @throws Exception 
	 */
	public DateBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBDURL,USER,PASSWORD);
			/*System.out.println("...");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//取得数据库连接对象，返回Connection实例
	public Connection getConnection(){
		return this.conn;
		
	}
	//关闭数据库方法
	public void close(){
		if(this.conn!=null){//表示有连接对象
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*public static void main(String[] args) {
		DateBaseConnection db = new DateBaseConnection();
		db.getConnection();
	}*/

}
