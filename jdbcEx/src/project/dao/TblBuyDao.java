package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnetionUtil;
import project.vo.CustomerBuyVo;
import project.vo.BuyVo;

/**
 * tbl_buy DAO : tbl_buy 테이블 데이터에 접근하는 객체
 * insert, update, delete
 */
public class TblBuyDao {
    // DB 연결하기
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe"; // 192.168.30.21
    public static final String USERNAME = "c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // executeUpdate() : insert, update, delete가 정상실행되면 1을 리턴
    // 특히 update, delete는 조건에 맞는 행이 없어서 반영된 행이 없으면 0을 리턴
    // DB에 데이터 넣기
    public int insert(BuyVo vo) {
        String sql = "insert into tbl_buy(buy_idx, customid, pcode, quantity, buy_date) " +
                "values(buy_pk_seq.nextval,?,?,?,sysdate)";
        int result = 0;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql); // -->>>with resource
        ) {
            // 매개변수 바인딩
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            // CustomId , pcode 는 참조테이블에 존재하는 값으로 안하면 무결성위반 오류
            System.out.println("[1]장바구니담기 오류 발생 : " + e.getMessage());
        } // finally 없음 : try with resource 를 쓰면 autoclose가 되므로 finally안해도 된다.

        return result;
    }

    // DB 데이터 삭제
    public int delete(int buy_idx) {
        String sql = "delete from tbl_buy where buy_idx = ?";
        int result = 0;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            // 매개변수 바인딩
            pstmt.setInt(1, buy_idx);
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            // buy_idx 컬럼에 없는 값이면 오류는 아지만 update 반영한 행의 갯수가 0이된다
            System.out.println("[2]구매 상품 삭제 오류 발생 : " + e.getMessage());
        }
        return result;

    }

    // DB 데이터 수정 --> Pk는 행 식별합니다. 특정 행을 수정하려면 WHERE의 조건컬럼은 PK이다. buy_idx(PK)
    // 무엇으로 검색해서 00하지 ? 에서 무엇=PK

    public int modify(int quantity, int buy_idx) {
        String sql = "update tbl_buy set quantity=? where buy_idx = ?";
        int result = 0;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            // 매개변수 바인딩
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, buy_idx);
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            // buy_idx 컬럼에 없는 값이면 오류는 아지만 update 반영한 행의 갯수가 0이된다
            System.out.println("[3]구매 상품 수량 변경 오류 발생 : " + e.getMessage());
        }
        return result;

    }

    // mypage 기능의 메소드
    // selectCustomerBuyList -> TblBuyDao에 만들어라
    // 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVO를 만들어야 한다.
    public List<CustomerBuyVo> selectCustBuyVO(String customerId) {
        List<CustomerBuyVo> list = new ArrayList<>();
        Connection connection = OracleConnetionUtil.getConnection();

        String sql = "SELECT BUY_IDX , tb.PCODE , PNAME, PRICE ,QUANTITY , BUY_DATE\r\n" +
                "FROM TBL_BUY tb\r\n" +
                "JOIN TBL_PRODUCT tp\r\n" +
                "ON tb.PCODE  = tp.PCODE\r\n" +
                "WHERE tb.CUSTOMID = ? \r\n" +
                "ORDER BY BUY_DATE DESC";

        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customerId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // BuyVO 생성자에 맞게 컬럼 값을 전달 //import java.sql.Timestamp; **sql아니면 오류나
                CustomerBuyVo vo = new CustomerBuyVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getTimestamp(6));
                list.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("selectBycategory 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<CustomerBuyVo> selectCustomerBuyList(String costumerId) {
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, TB.PCODE, PNAME,PRICE,QUANTITY ,BUY_DATE \r\n" +
                "FROM TBL_BUY tb \r\n" +
                "JOIN TBL_PRODUCT tp \r\n" +
                "ON TB.PCODE = TP.PCODE \r\n" +
                "WHERE TB.CUSTOMID =? \r\n" +
                "ORDER by BUY_DATE desc";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, costumerId);
            ResultSet rs = pstmt.executeQuery();
            // pstmt.executeQuery();//executeUpdate() write용 executeQuery() read용- 잘못됨
            while (rs.next()) {
                list.add(new CustomerBuyVo(rs.getInt("BUY_IDX"),
                        rs.getString("PCODE"),
                        rs.getString("PNAME"),
                        rs.getInt("PRICE"),
                        rs.getInt("QUANTITY"),
                        rs.getTimestamp("BUY_DATE")));
            }
        } catch (SQLException e) {
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
        }
        return list;
    }

    // 장바구니 모두 구매
    // 배치는 일괄처리 : 실행할 insert, update, delete 등의 데이터 저장 DML여러개 모야 두었다가 한번에 실행시킵니다
    // 트랜잭션 : 여러 SQL을 하나로 묶은 작업 단위
    // - 트랜잭션 rollback(); : 문제가 발생했을 때, 트랜잭션의 변경 사항을 취소하고 이전 상태로 되돌린다
    // - 트랜잭션 commit(); : 모든 변경 내용을 확정지어 데이터베이스에 반영
    // 예시 : cart에 저장된 상품 중 하나라도 참조값이 없는 pcode가 있으면 rollback, 모두 정상이면 commit
    // 트랜잭션 commit모드가 auto-> 수동으로 변경. --> connection.setAutoCommit(false);
    // connection한개에 sql문 한개인데 이건 여러개다.
    // 똑같은 sql문인데 매개변수만 바꿔서 쓸때 ->프로시저

    public int insertMany(List<BuyVo> cart) { // 여러번(cart크기) 의 insert를 실행합니다
        String sql = "INSERT INTO TBL_BUY VALUES(buy_pk_seq.nextval,?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false); // commit모드가 auto-> 수동으로 변경
            for (BuyVo vo : cart) { // 반복
                pstmt.setString(1, vo.getCustomId());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch(); // sql모아두기 . insert sql에 대입되는 매개 변수값이 매번 다릅니다.
                count++;
            }
            pstmt.executeBatch(); // 모아둔 SQL일괄실행하기 실핼중 무결성 오류가 발생하면 rollback
            // 원래였으면 count = pstmt.executeUpdate();였을텐데 for문 반복하니까 count++
            connection.commit(); // 커밋해서 DB에 적용
        } catch (SQLException e) { // 예외가 발생하면
            //
            try {
                connection.rollback(); // 롤백해서 되돌려
            } catch (SQLException e1) {
            }
            count = -1;
            ;
            System.out.println("구매 불가능한 상품이 있습니다 ");
            System.out.println("장바구니 구매 실행예외 : " + e.getMessage());
        } finally { // 정상실행과 예외 모두에 대해 자원해제
            try { // 트랜잭션 처리를 위해 connection을 사용해야 하므로 직접 close했습니다
                pstmt.close();
            } catch (SQLException e1) {
            }
        }
        //
        return count;
    }

    // 2024.02.01 /날짜별 구매금액 조회
    public int money_of_dayByCustomer(String customid, String buydate) {
        String sql = "{ call money_of_day(?,?,?) }";
        int money = 0;
        try (
                Connection connection = getConnection();
                CallableStatement cstmt = connection.prepareCall(sql)) {
            // 프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            // 프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate(); // 프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);

        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }

}
