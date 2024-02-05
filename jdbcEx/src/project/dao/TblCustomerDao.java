package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// 테이블 데이터에 접근하는 객체

import jdbc.day1.OracleConnetionUtil;
import project.vo.CustomerVo;

public class TblCustomerDao {

    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원가입
    public void join(CustomerVo vo) {
        // 할일1. sql작성하기
        String sql = "insert into tbl_custom(custom_id, name, email, age, reg_date)" + "values (?,?,?,?,sysdate)";
        try ( // autoclose
                Connection connection = getConnection(); // Connection 객체를 생성
                PreparedStatement pstmt = connection.prepareStatement(sql); // prepareStatement : 미리 컴파일된 SQL 문장을 나타내는
                                                                            // 객체
        ) {
            // 할일2. 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다.)
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());

        } // finally 없음 : try with resource 를 쓰면 autoclose가 되므로 finally안해도 된다.

    }

    // 회원 정보 수정
    public void modify(CustomerVo vo) {
        String sql = "UPDATE TBL_CUSTOM SET EMAIL = ?, age = ? WHERE CUSTOM_ID = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("modify 실행 예외 발생: " + e.getMessage());
        }
    }

    // 회원 탈퇴
    public void delete(String customerId) {
        String sql = "DELETE FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, customerId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생: " + e.getMessage());
        }
    }

    // 회원 정보 조회 : 조회결과 행 개수는 ? select * from tbl_custom where custom_id = ?
    // ㄴ 0 개 : 조회 결과 없다 : 조회결과가 있다면 반드시 1개
    // ㄴ 리턴 타입 CustomerVo

    public CustomerVo getCustomer(String customoerId) {
        CustomerVo vo = null;
        String sql = "select * from tbl_custom where custom_id = ?";

        try (
                Connection connection = OracleConnetionUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, customoerId); // 매개변수 전달하는 코드
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { // 첫번째 행 조회결과 있으면 true, 없으면 false
                // 객체를 만들어서 vo변수에 참조시키기
                vo = new CustomerVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5));

            }
        } catch (SQLException e) {
            System.out.println("getCustomer 예외 발생 : " + e.getMessage());

        }

        return vo;
    }

    // 모든 회원 정보 조회 : 관리자를 위한 기능
    public List<CustomerVo> allCustomers() {
        List<CustomerVo> list = new ArrayList<>();
        Connection connection = OracleConnetionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerVo vo = new CustomerVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5));
                list.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("예외 발생" + e.getMessage());
            e.printStackTrace();

        }
        return list;

    }// selectAll_4 복붙함

}
