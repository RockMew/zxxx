package control;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Getcon
{
    private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
    private static String url = "jdbc:mysql://localhost:3306/lzz";// 连接url字符串
    private static String user = "root";// 数据库用户名
    private static String password = "123456";// 数据库密码

    static Connection conn = null; // 数据连接对象

    /*
     *
     * 获取数据库连接对象
     */
    public static Connection getConnection()
    {
        if (conn == null)
        {
            try
            {
                Class.forName(driver);
                conn = (Connection) DriverManager.getConnection(url, user,
                        password);
            }
            catch (Exception e)
            {
                System.out.println("MySQL connect error!");
            }

        }
        //System.out.println("ok");
        return conn; // 返回连接对象

    }

}
