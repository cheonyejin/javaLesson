package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnetionUtil;
import project.vo.CustomerBuyVo;
import project.vo.CustomerVO;
import project.vo.BuyVO;

/**
 * tbl_buy DAO : tbl_buy 테이블 데이터에 접근하는 객체
 * insert, update, delete
 */
public class TblBuyDao {
    //DB 연결하기 
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//192.168.30.21:1521/xe";  //192.168.30.21
    public static final String USERNAME ="c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //DB에 데이터 넣기 
    public void insert(BuyVO vo){
        String sql = "insert into tbl_buy(buy_idx, customid, pcode, quantity, buy_date) "+
                    "values(buy_pk_seq.nextval,?,?,?,sysdate)";
           
        try (   
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);   //-->>>with resource
        ) {
            // 매개변수 바인딩
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            pstmt.executeUpdate();
            
        } catch (Exception e) {
           System.out.println("[1]장바구니담기 오류 발생 : " + e.getMessage());
        }//finally 없음 : try with resource 를  쓰면 autoclose가 되므로  finally안해도 된다.
    
        
    }

    //DB 데이터 삭제 
    public void delete(int buy_idx){
        String sql = "delete from tbl_buy where buy_idx = ?";
           
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setInt(1, buy_idx);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
           System.out.println("[2]구매 상품 삭제 오류 발생 : " + e.getMessage());
        }
        
    }

    //DB 데이터 수정 --> Pk는 행 식별합니다. 특정 행을 수정하려면 WHERE의 조건컬럼은 PK이다. buy_idx(PK)
    //무엇으로 검색해서 00하지 ? 에서 무엇=PK

    public void modify(int count, int buy_idx){
        String sql = "update tbl_buy set quantity=? where buy_idx = ?";
           
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setInt(1, count);
            pstmt.setInt(2, buy_idx);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
           System.out.println("[3]구매 상품 수량 변경 오류 발생 : " + e.getMessage());
        }
        
    }

    //mypage 기능의 메소드
    // selectCustomerBuyList -> TblBuyDao에 만들어라
    // 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVO를 만들어야 한다.
    public List<CustomerBuyVo> selectCustBuyVO(String customerId) {
        List<CustomerBuyVo> list = new ArrayList<>();
        Connection connection = OracleConnetionUtil.getConnection();
    
        String sql = "SELECT BUY_IDX , tb.PCODE , PNAME, PRICE ,QUANTITY , BUY_DATE\r\n"+ 
        "FROM TBL_BUY tb\r\n"+ 
        "JOIN TBL_PRODUCT tp\r\n"+ 
        "ON tb.PCODE  = tp.PCODE\r\n"+ 
        "WHERE tb.CUSTOMID = ? \r\n"+
        "ORDER BY BUY_DATE DESC";

    try (
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, customerId);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            // BuyVO 생성자에 맞게 컬럼 값을 전달       //import java.sql.Timestamp;    **sql아니면 오류나 
            CustomerBuyVo vo = new CustomerBuyVo(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getInt(5),
                                                rs.getTimestamp(6)); 
            list.add(vo);
        }

    }catch (SQLException e) {
        System.out.println("selectBycategory 예외 발생" + e.getMessage());
        e.printStackTrace();
    }
    return list;
    }
}
    

