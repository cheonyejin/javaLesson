package jdbc.day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//DB와  연결 후 DB에 데이터 넣는 방법 
//main-응용
//1. ??, VO  
//2. ??
//3. 지정값

import project.vo.CustomerVo;

public class InsertDMLTest {
    public static void main(String[] args) {
        System.out.println("우리 쇼핑몰[회원가입] 환영합니다.");
        System.out.println("주의사항: 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");

        System.out.println("아이디를 입력하세요. __");
        String customId = System.console().readLine();

        System.out.println("이름을 입력하세요. __");
        String name = System.console().readLine();

        System.out.println("이메일을 입력하세요. __");
        String email = System.console().readLine();

        System.out.println("나이를 입력하세요. __");
        // dao.modify(vo); ?

        System.out.println("우리 쇼핑몰 [회원탈퇴]입니다.");
        int age = Integer.parseInt(System.console().readLine());

        CustomerVo vo = new CustomerVo(customId, name, email, age, null);

        insert(vo);
        // 정리 : tbl_custom테이블은 회원정보를 저장합니다
        // 개발프로그럄은 '회원가입','로그인','회원정보수정','회원탈퇴'기능을 tbl_custom테이블에 대해 갖게 됩니다
        // -> 필요한 기능을 처리해야할 sql 실행 메소드를 DAO(Date Access Object)클래스에 모두 만듭니다.

    }// main

    // 1.최종적으로 사용될 insert메서드 입니다.
    public static void insert(CustomerVo vo) { // 메소드 실행 인자는 insert매개변수에 전달될 값
        Connection conn = OracleConnetionUtil.getConnection();
        if (conn != null)
            System.out.println("데이터베이스 연결 성공 !");
        System.out.println("Connecton : " + conn);

        String sql = "insert into tbl_custom(custom_id, name, email, age, reg_date)" + "values (?,?,?,?,sysdate)";
        try (

                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {

            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());

            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        } finally {

            OracleConnetionUtil.close(conn);
        }

    }

    // 2.insert sql에 리터럴값이 매개변수로
    public static void param_data() {
        Connection conn = OracleConnetionUtil.getConnection();
        if (conn != null)
            System.out.println("데이터베이스 연결 성공 !");
        System.out.println("Connecton : " + conn);

        String sql = "insert into tbl_custom(custom_id, name, email, age, reg_date)" + "values (?,?,?,?,sysdate)"; // 자바로
                                                                                                                   // DB에
                                                                                                                   // 데이터
                                                                                                                   // 넣기
        // preparedStatment는 매개변수를 ?로 표기하고 sql을 미리 컴파일합니다.
        // 매개변수?데 대입되는(바인딩)값은 sql execute메소드 이전에 설정(->setter)합니다.
        // 설정한다->setter 가져온다->getter
        try (
                // auto close를 위한try형식 - pstmt.close() 필요하므로 try-with-resources사용
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {

            // 매개변수 바인딩?는 순서대로 인덱스를 갖습니다.시작값1
            // 응용프로그램에서 매개변수에 저장될 값은 사용자 입력값입니다.
            pstmt.setString(1, "sana"); // 매개변수 바인딩
            pstmt.setString(2, "최사나");
            pstmt.setString(3, "sana@naver.com");
            pstmt.setInt(4, 26);

            pstmt.execute(); // sql실행 메소드 방법1)
            // pstmt.executeUpdate(); //sql실행 메소드 방법2) 리턴값 int는 반영된 행의 개수를 리턴
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        } finally {

            OracleConnetionUtil.close(conn); // OracleConnetionUtil에서 만든 close메소드를 이용해서 close하기
        }
    }

    // 3.insert 데이터값이 고정된 예시
    public static void fixedData() {
        Connection conn = OracleConnetionUtil.getConnection();
        if (conn != null)
            System.out.println("데이터베이스 연결 성공 !");
        System.out.println("Connecton : " + conn);

        String sql = "insert into tbl_custom(custom_id, name, email, age, reg_date)"
                + "values('nayeon','박나연','na@gmail.com',26,sysdate)"; // 자바로 DB에 데이터 넣기
        try (
                // auto close를 위한try형식 - pstmt.close() 필요하므로 try-with-resources사용
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {
            pstmt.execute(); // sql실행 메소드 방법1)
            // pstmt.executeUpdate(); //sql실행 메소드 방법2) 리턴값 int는 반영된 행의 개수를 리턴
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        } finally {

            OracleConnetionUtil.close(conn); // OracleConnetionUtil에서 만든 close메소드를 이용해서 close하기
        }

    }
}
