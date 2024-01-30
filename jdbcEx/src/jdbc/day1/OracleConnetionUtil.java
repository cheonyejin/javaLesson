package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnetionUtil {
    //상수(final)는 대문자로 쓴다
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";;
    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/XE";   
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    //Connection 타입 객체 생성하는 메서드 
    //Connection conn = OracleConnectionUtil.getConnection();로 사용할것입니다 
    public static Connection getConnection(){

        Connection conn = null;

        try{     
            Class.forName(DRIVER); 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e ){
            System.out.println("데이터 베이스 연결 예외 발생합니다.\n\t : " + e.getMessage());
        }
        return conn;               
    }
    //실행순서 : 1) getConnection 2)SQL실행 3) close
    //SQL실헹 : 개발 프로그램에서 가장 많이 실행하는 SQL은 DML입니다. (select, insert,update,delete)
    //          OracleConnetionUtil 는 1)단계, 3)단계에서 사용될것이다.





    //인자로 전달된 Connection객체를 clode.sql실행이 종료되면 close해야됩니다 
    public static void close(Connection conn){
        try {
            if(conn !=null)conn.close();
            
        } catch (SQLException e) {
           System.out.println("데이터베이스 연결 해제 예외 발생\n\t");
        }
    }
}

