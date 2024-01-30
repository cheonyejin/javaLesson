package jdbc.day2;
//selectAll_1 - rs.next()활용해서 n번 인덱스의 컬럼값 가져오기 
//selectAll_2 - ㄴ 을 while문으로 반복 
//selectAll_3 - ㄴ 을 매핑으로 해보기 
//selectAll_4               ㄴ list인경우
// * 그러나 메소드에는 가급적 출력문을 만들지 않는다 => (selectAll_4 return 수정) + (main에서 메소드이용해서 출력문 만들기)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.day1.OracleConnetionUtil;
import project.vo.CustomerVO;

public class SelectDmlTest {




    public static void main(String[] args) {
        List<CustomerVO> result = selectAll_4();
        System.out.println("전체 회원 조회 결과 ");
        System.out.println(result);
    }


    public static  List<CustomerVO>selectAll_4() {
        //4. 레코드 행 1개를 자바 객체와 1:1 매핑하기 ->레코드 행이 많아서 List
        List<CustomerVO> list = new ArrayList<>();  
        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql) ){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerVO vo = new CustomerVO(rs.getString(1), 
                                                rs.getString(2), 
                                                rs.getString(3), 
                                                rs.getInt(4), 
                                                rs.getDate(5));
                list.add(vo);                                                       
            }
            
            //System.out.println("select결과 list : " + list);
        


    } catch (SQLException e) {
        System.out.println("예외 발생" + e.getMessage());
        e.printStackTrace();
        
    }return list;   //select조회결과를 자바 객체 list와 매핑한 결과 

    }//selectAll_4


    //3. 레코드 행 1개를 자바 객체와 1:1 매핑하기 :조회결과를 자바 객체로 만들어야 프로그램을 개발할수있다 
    public static void selectAll_3() {
        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql) ){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerVO vo = new CustomerVO(rs.getString(1), 
                                                rs.getString(2), 
                                                rs.getString(3), 
                                                rs.getInt(4), 
                                                rs.getDate(5));
                                                                        
            }

        }catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생" + e.getMessage());
            e.printStackTrace();
            
        }
    }

    
    //selectAll_1 -> while문  반복
    public static void selectAll_2() {
        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "select * from tbl_custom";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            
            while (rs.next()) {
                System.out.println(count++ + "번째 ");
                System.out.println(rs.getString("custom_id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("age"));
                System.out.println(rs.getString("reg_date"));
                System.out.println(rs.getTimestamp("reg_date"));
                
            }
            System.out.println("총 "+count+"개의 레코드 행을 조회했습니다 ");
        } catch (Exception e) {
            System.out.println("쿼리 예외 발생 : " + e.getMessage());
            e.printStackTrace();
        }  
    }//selectAll_2



    public static void selectAll_1(){
    
        //2. rs.next(); 로 결과 행 집합 안에서 레코드 끝까지  위치 이동 확인하기 
        Connection connection = OracleConnetionUtil.getConnection();
    
        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql) ){
            ResultSet rs = pstmt.executeQuery();        //ResultSet : 쿼리 실행하고 결과 행 집합을 처리하는 인터페이스 
    
            rs.next();  //결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야할 메소드 
                        //next()실행할때마다 re객체의 다음행을 접근할수있게 포인터가 이동한다
            System.out.println(rs.getString(1));     // 1번 인덱스 컬럼값 가져오기 
            System.out.println(rs.getString(2));     // 2번 인덱스 컬럼값 가져오기
            System.out.println(rs.getString(3));     // 3번 인덱스 컬럼값 가져오기
            System.out.println(rs.getString(4));     // 4번 인덱스 컬럼값 가져오기
            System.out.println(rs.getString(5));     // 5번 인덱스 컬럼값 가져오기 / java.sql.Data를 리턴한다
            System.out.println(rs.getTimestamp(5));  // 5번 인덱스 컬람값 가져오기 / java.sql.TimesTampㄹ르 리턴
    
    
    
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생" + e.getMessage());
            e.printStackTrace();
            
        }
    
    }//selectAll_1
    
    
}//class
