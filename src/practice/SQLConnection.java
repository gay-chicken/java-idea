package practice;

import java.sql.*;

public class SQLConnection {
        private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        //mysql8.0之后需要加上时区  ?serverTimezone=UTC
        private static final String URL = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
        private static final String USER_NAME = "root";
        private static final String PASSWORD = "include20010926";

    public static void main(String[] args) {
        Connection connection = null;
        try{
            //mysql5.5之后可以省略
            //Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);;
            //执行的命令
            String COM="SELECT * FROM city";
            PreparedStatement p = connection.prepareStatement(COM);
            ResultSet result=p.executeQuery();
            while(result.next()){
                                                            //栏位名称
                System.out.println("Name: "+result.getString("Name"));
            }
            result.close();
            p.close();
        }  catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try{
                    connection.close();
                    System.out.println("not free all");
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
