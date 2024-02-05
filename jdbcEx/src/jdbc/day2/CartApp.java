package jdbc.day2;

import project.vo.BuyVo;

import project.dao.TblBuyDao;

/*
 * 순서 
 * 1. BuyVo.java에서 필드 , 생성자 , get , toString ,hashcode, equals
 * 2. TblBuyDao.java에서 DB연결, DB데이터 추가&삭제&변경 메소드 만들기 
 * 3. CartApp.java의 main에서 메뉴 만들기 -> inser(), delete(),modify()
 *                  main밖에서 메소드 메뉴 각각의 메소드 만들기 ->menu_insert(),menu_delete(),menu_modify()


 */
public class CartApp {
    public static void main(String[] args) {
        System.out.println("구매할 사용자 간편 로그인 필요합니다");
        System.out.println("아이디 입력 __");

        // 상품 목록을 선택한 *카테고리에 대해 보여주기
        // 또는 *상품명으로 검색
        // 또는 입력한 *아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매취소 buy_idx 조회)
        String customId = System.console().readLine();

        boolean run = true;

        while (run) { // 메뉴 선택을 반복할 while 루프 작성
            System.out.println("[1] 장바구니 담기 [2] 구매 취소 [3] 구매 수량 변경 [4] 구매 종료");

            int sel = Integer.parseInt(System.console().readLine());

            switch (sel) {
                case 1: // [1] 장바구니 담기
                    menu_insert(customId);
                    break;

                case 2: // [2] 구매취소
                    menu_delete();
                    break;
                case 3: // [3] 구매 수량 변경
                    menu_modify();
                    break;
                case 4: // [4] 구매 종료
                    System.exit(0); // main 벗어나서 종료하기
                    break;
                default:
                    break;
            }

        }
    }

    private static void menu_modify() {
        TblBuyDao dao = new TblBuyDao();

        System.out.println("변경할 수량 입력 __");
        int count = Integer.parseInt(System.console().readLine());
        System.out.println("buy_idx 입력 __");
        int buy_idx = Integer.parseInt(System.console().readLine());

        dao.modify(count, buy_idx);

        System.out.println(buy_idx + ", 수량 : " + count);
    }

    private static void menu_delete() {
        System.out.println("buy_idx 입력 __");
        int buy_idx = Integer.parseInt(System.console().readLine());

        TblBuyDao dao = new TblBuyDao();

        dao.delete(buy_idx);

        System.out.println("장바구니에서 삭제되었어요");
    }

    private static void menu_insert(String customId) {
        BuyVo vo = new BuyVo(0, customId, "CJBAb12g", 2, null);
        TblBuyDao dao = new TblBuyDao();
        dao.insert(vo);

        System.out.println(customId + "님 상품  " + vo.getPcode() + "를 장바구니에 추가했어요");

    }

}

// tbl_buy 테이블 대상을 insert, update, delete 할 수 있는 dao 클래스 만들기 TblBuyDao.java
// 테이블 컬럼과 1:1 대응되는 BuyVO.java 파일 작성
// 테이블 pk 컬럼 buy_idx 은 update, delete 할 로우를 식별할 필드입니다
