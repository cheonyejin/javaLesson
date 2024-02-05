package jdbc.teamC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.dao.TblBuyMenuDao;
import project.dao.TblMembersDao;
import project.dao.TblMenuDao;
import project.vo.BuyMenuVo;
import project.vo.MemberBuyVo;

public class MainApp {
    private TblBuyMenuDao buymenuDao = new TblBuyMenuDao();
    private TblMembersDao membersDao = new TblMembersDao();
    private TblMenuDao menuDao = new TblMenuDao();
    private List<BuyMenuVo> cart = new ArrayList<>(); // 장바구니 만들기
    private Map<String, Integer> priceMap = new HashMap<>(); // 장바구니 목록 보여줄때 쓸
    private String code; // 입력받을 회원아이디

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.start();

    }

    private MainApp() {
        this.priceMap = menuDao.getPriceTable();
    }

    public void start() {

        System.out.println("어서오세오. 맥도날드입니다");
        System.out.println(" [로그인]을 해주세요.");
        System.out.println("\n아이디를 입력하세요__");
        code = System.console().readLine();
        System.out.println(code + "님 환영합니다");
        boolean run = true;
        while (run) {
            showMenu();

            System.out.println("\n이용하실 메뉴의 번호를 입력하세요.");
            String select = System.console().readLine();
            switch (select) {
                case "1": // [1]상품 구매
                    show1page();
                    break;
                case "2": // [2]구매한 상품 보기
                    showMyPage(code);
                    break;

                case "3": // [2]회원정보 수정
                    show2page();
                    break;
                case "4": // [3]종료
                    run = false;
                    break;
                default:
                    break;
            }

        }

    }

    private void showMenu() {
        System.out.println("_________________________________________________________");
        System.out.println("\n[1]상품 구매    [2]구매한 상품 보기    [3]회원정보 수정  [4]종료");
        System.out.println("_________________________________________________________");

    }

    private void show1page() {// [1]상품 구매
        // 메뉴 출력 메서드
        boolean run = true;

        while (run) {
            System.out.println("\n::: 장바구니::: [1] 담기    [2] 삭제    [3]목록   [4] 구매    [5]이전 화면");
            System.out.println("이용하실 메뉴의 번호를 입력하세요.");
            String select = System.console().readLine();

            switch (select) {
                case "1":
                    addCartItem(code);
                    break;
                case "2":
                    removeCartItem();
                    break;
                case "3":
                    showCartList(code);
                    break;
                case "4":
                    buyCartItems();
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    break;
            }
        }

    }

    private void addCartItem(String customerid) {
        System.out.println(".................. 장바구니 :: 상품 담기 ...................");
        System.out.print("구매할 상품코드 입력하세요.__");
        String menu_id = System.console().readLine();
        System.out.print("구매할 수량 입력하세요.__");
        int menu_quantity = Integer.parseInt(System.console().readLine());
        cart.add(new BuyMenuVo(0, customerid, menu_id, menu_quantity, null));
        System.out.println("\n상품을 담았습니다.");
    }

    private void removeCartItem() {
        System.out.println(".................. 장바구니 :: 상품 삭제 ...................");
        System.out.print("삭제할 상품의 번호를 입력하세요. (번호 확인은 장바구니 빼기 메뉴에서 확인할수있습니다)  \n");
        int idx = Integer.parseInt(System.console().readLine());

        if (idx < 0 || idx >= cart.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        cart.remove(idx);
        System.out.println("물품을 장바구니에서 삭제했습니다.");
    }

    private void showCartList(String customerid) {
        long totalMoney = 0;
        System.out.println(".................. 장바구니 :: 담은 상품 보기...................");
        for (int i = 0; i < cart.size(); i++) {
            int price = cart.get(i).getMenuQuantity() * priceMap.get(cart.get(i).getMenuId());
            System.out.println("번호: " + i + "  " + cart.get(i) + "  금액 : " + price);
            totalMoney += price;
        }

        System.out.println("총 결제 금액 : " + totalMoney);
    }

    public void buyCartItems() {
        if (cart.size() == 0) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        long totalMoney = 0;
        System.out.println(" 장바구니 물품 모두 구매");
        int result = buymenuDao.allAtOnes(cart);
        if (result > 0) {
            for (int i = 0; i < cart.size(); i++) {
                int price = cart.get(i).getMenuQuantity() * priceMap.get(cart.get(i).getMenuId());
                totalMoney += price;
            }
            System.out.println("금액 : " + totalMoney);
            System.out.println("장바구니 물품구매가 정상적으로 완료되었습니다.");
            cart.clear();
        } else {
            System.out.println("장바구니 물품 구매 실패 하였습니다.");
        }
    }

    // [2] 관련 메소드
    // selectMemberBuyList: TblBuyMenu
    // MemberBuyVo 클래스 생성
    private void showMyPage(String customerid) {
        List<MemberBuyVo> result = buymenuDao.selectMemberBuy(customerid);
        for (MemberBuyVo vo : result)
            System.out.println(vo);

    }

    // [3]회원정보 수정
    // 관련 메소드 TblMembersDao에 만들었음
    private void show2page() {// TblMembersDao에 만들었음

        boolean run = true;
        while (run) {
            System.out.println("____________________________________________________________________________");
            System.out.println("\n:::고객정보:::[1]이메일 변경  [2]전화번호 변경    [3]이전 화면으로 돌아가기");
            System.out.println("____________________________________________________________________________");
            System.out.println("이용하실 메뉴의 번호를 입력하세요.");
            String select = System.console().readLine();
            switch (select) {
                case "1":
                    System.out.println("새로운 이메일을 입력하세요");
                    String EMAIL = System.console().readLine();
                    membersDao.modifyEmail(code, EMAIL);
                    break;
                case "2":
                    System.out.println("새로운 전화번호를 입력하세요");
                    String phone_number = System.console().readLine();
                    membersDao.modifyEmail(code, phone_number);
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    break;
            }

        }

    }

}
