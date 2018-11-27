package cn.mldn.dlc;
/**
 * ����ר�Ÿ������ݿ��������رղ�������ʵ���������Ǿ���ζ��Ҫ�������ݿ⿪��
 * �����ڱ���Ĺ��췽����Ҫ�������ݿ������ļ��������ݿ�����ȡ��
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
	 * �ڹ��췽����Ϊconn�������ʵ����������ֱ��ȡ�����ݿ����Ӷ���
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
	//ȡ�����ݿ����Ӷ��󣬷���Connectionʵ��
	public Connection getConnection(){
		return this.conn;
		
	}
	//�ر����ݿⷽ��
	public void close(){
		if(this.conn!=null){//��ʾ�����Ӷ���
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
