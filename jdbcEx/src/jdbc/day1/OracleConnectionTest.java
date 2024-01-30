package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {

    public static void main(String[] args) {
        //1) ojdbc.jar라이브러리 프로젝트에 추가하기 
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//192.168.30.21:1521/XE";   
        //오라클-오른쪽누르고 edit connection누르고 custom에 있는 주소 복사
        //서버 ip찾는 법 : cmd ->ipconfig -> IPv4 주소 = 서버의 ip
        //localhost는 서버의 ip(192.168.30.21)로 바뀔수도 있다 . / XE는 데이터베이스 이름 
        String user = "c##idev";
        String password = "1234";
        try{
            //2) ojdbc.jar라이브러리에 포함된 드라이버 클래스를 메모리에 로드 
            //  java6부터 jdbc4.0버전이 지원되고 그때부터 생략합니다 
            //  DriverManege 가 드라이버 클래스를 알아서 로드합니다.
            Class.forName(driver);      //Class.forName()로 런타임 시점에서 지정된 클래스이름 로드-> oracle.jdbc.driver.OracleDriver
                                        //ClassNotFoundException 체크드 익셉션->처리 필요 
            //3) Connection객체를 생성한다 - DriverManager드라이버 관리하는 유틸리티 클래스 
            //Connection 은 인터페이스에 대한 구현은 드라이버에 따라 정해진다.
            conn = DriverManager.getConnection(url, user, password);
                                        //SQLException 예외처리 필요 
            System.out.println("데이터베이스 연결객체 : " + conn);
            if(conn != null){
                System.out.println("Connection 객체의 구현 클래스 : " + conn.getClass().getName()); //Cpnnection구현객체 이름 확인해보려고
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        }catch (Exception e) {
            System.out.println("오라클 데이터베이스 연결 실패");
            System.out.println("예외 발생 : "+e.getMessage()) ;
        }finally{
            try {
                if(conn!= null) conn.close();
            } catch (Exception e) {
               
            }
        }

    }
    
}
/* 
 *  데이터베이스 연결객체 : oracle.jdbc.driver.T4CConnection@64d2d351
    Connection 객체의 구현 클래스 : oracle.jdbc.driver.T4CConnection     -> 오라클 Connection의 구현 클래스 
    오라클 데이터베이스 연결 성공
*/