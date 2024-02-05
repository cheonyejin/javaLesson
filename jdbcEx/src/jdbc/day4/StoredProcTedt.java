package jdbc.day4;
//19.프로시저sql 파일의 저장프로시저 예제 2 관련 코드 -99줄
import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.day1.OracleConnetionUtil;

public class StoredProcTedt {
    public static void main(String[] args) {
        
    }
    public static void exec_money_of_day(){
        System.out.println("고객 ID와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.println("고객ID입력_");
        String customid = System.console().readLine();

        System.out.println("구매날짜입력_");
        String buydate =  System.console().readLine();

        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "{ call money_of_day(?,?,?) }"; 
    
    try (

        CallableStatement cstmt = connection.prepareCall(sql)){
        //프로시저의 in매개변수값 전달
        cstmt.setString(1, customid);
        cstmt.setString(2, buydate);
        //프로시저 out매개변수 타입설정 
        cstmt.registerOutParameter(3, Types.NUMERIC);
        //프로시저 실행
        cstmt.executeUpdate();

        String result = String.format("%s 고객님이 %s에 구매한 총 구매금액 : %,8d", customid,buydate,cstmt.getInt(3));
        System.out.println(result);



        }catch (SQLException e) {
        System.out.println("프로시저 실행 예외 : "+ e.getMessage());
        }
    }


    public static void exec_max_customer(){
        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "{ call money_of_day(?,?) }";   
        try (

            //프로시저 실행 인터페이스 CallableStatement의메소드 prepareCall로 객체 생성하기 
            CallableStatement cstmt = connection.prepareCall(sql)   
         ) {
            //프로시저 실행결과 out 파라미터 1번 인덱스의 오라클 데이터 타입 지정하기 -고객이름
            cstmt.registerOutParameter(1, Types.VARCHAR);
            //프로시저 실행결과 out 파라미터 2번 인덱스의 오라클 데이터 타입 지정하기 -고객나이
            cstmt.registerOutParameter(2, Types.NUMERIC);
            //프로시저 실행하기
            cstmt.executeUpdate();
            //프로시저 실행 결과 out파라미터 값은 cstmt.객체에 저장됩니다 

            //쇼핑몰 관리지가 원하는 정보 
            System.out.println("구매수량이 가장 많은 고객 정보 조회한 결과입니다 ");
            //인데스 1번 out실행 결과값 가져오기 
            System.out.println("고객 이름 : " + cstmt.getString(1));
            //인데스 2번 out실행 결과값 가져오기 
            System.out.println("구매 수량 : " + cstmt.getInt(2));

        }catch (SQLException e) {
            System.out.println("프로시저 실행 예외 : "+ e.getMessage());
        }
    }
    
}
