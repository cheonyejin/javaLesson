package jdbc.day2;

import project.dao.TblCustomerDao;
import project.vo.CustomerVO;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.println("[고객관리 시스템]고객을 조회합니다 ");
        System.out.println("고객 아이디 입력");
        String customerId = System.console().readLine();
        System.out.println("\n____________조회결과______________");


        TblCustomerDao dao = new TblCustomerDao();
        CustomerVO vo = dao.getCustomer(customerId);
        if(vo == null){
            System.out.println("조회한 고객이 존재하지 않습니다.");
        }else
        System.out.println(vo);




    }
    
}
