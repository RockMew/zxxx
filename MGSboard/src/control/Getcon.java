package control;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Getcon
{
    private static String driver = "com.mysql.jdbc.Driver";// ���ݿ������ַ���
    private static String url = "jdbc:mysql://localhost:3306/lzz";// ����url�ַ���
    private static String user = "root";// ���ݿ��û���
    private static String password = "123456";// ���ݿ�����

    static Connection conn = null; // �������Ӷ���

    /*
     *
     * ��ȡ���ݿ����Ӷ���
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
        return conn; // �������Ӷ���

    }

}
