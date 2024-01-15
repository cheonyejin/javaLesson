package collection.day11;
import java.util.ArrayList;
import java.util.List;

//단어-고객  : JavaWord
//단어장-고객관리부 : JavaWordApp_V2
//메뉴 : 등록, 검색(이름, 그룹), 삭제, 수정, 전체 출력 
public class CustomerManageApp {

    private List<Customer> customers = new ArrayList<>();
    
    public static void main(String[] args) {
        CustomerManageApp app= new CustomerManageApp();
        app.start();
    }

    private void start() {

        initialize();
        //등록, 검색(이름, 그룹), 삭제, 수정, 전체 출력 
        System.out.println("<<고객관리부>>" +  ">".repeat(30));
        while (true) {
            System.out.println("\t메뉴를 선택하세요");
            System.out.println("\t 1. 신규고객 등록");
            System.out.println("\t 2. 고객 목록 조회 ");
            System.out.println("\t 3. 고객 정보 검색");
            System.out.println("\t 4. 고객 수정");      //chcp기본 코드 949 임
            System.out.println("\t 5. 고객 삭제");
            System.out.println("\t 6. 프로그램 종료");
            System.out.println("\t 선택 > ");   
            int select = Integer.parseInt(System.console().readLine()); 
            
            switch (select) {
                case 1:
                    addCustomer();     //신규고객 등록     
                    break;
                case 2:  listCustomer(); break;        //고객 목록 조회
                case 3:  searchCustomerBy(); break;        //고객 정보 검색
                case 4:  modifyCustomerBy(); break;        //고객 수정
                case 5:  removeCustomer(); break;        //고객 삭제
                case 6:  
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0); //main실행을 종료
                    break;       
    
                default:
                    System.out.println("잘못된 선택값입니다");
                    break;
            }//switch
        }//while
    }//start

    private void addCustomer() {
        System.out.println("신규 고객을 등록합니다");
        System.out.println("고객의 이름을 입력하세요.__");
        String name = System.console().readLine();
        System.out.println("고객의 전화번호를 입력하세요.__");
        String phone = System.console().readLine();
        System.out.println("고객의 그룹 정보를 입력하세요.(1: 일반 2.VIP 3.기타)__");
        int group = Integer.parseInt(System.console().readLine());

        customers.add(new Customer(name, phone, group));
    }

    private void printCustomerList(List<Customer> list) {
        for(Customer customer : list){
            System.out.println(String.format("%-20s %-30s %-20s",customer.getName(), customer.getPhone(), customer.getGroup()));
        }    
    }

    private void listCustomer() {
        System.out.println("\t 고객 목록 출력합니다.");
        System.out.println(String.format("%-20s %-30s %-20s", "NAME","   PHONE","   GROUP"));
        
        printCustomerList(customers);  
    }


    private void searchCustomerBy() {
        System.out.println("\t고객정보를  검색합니다. \n\t이름으로 검색은 1, 그룹으로 검색은 2 를 입력하세요 :");
        String name =null;
        List<Customer> list = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.println("검색할 고객의 이름을 입력하세요.__");
                name = System.console().readLine();
                list = searchAllCustomer(name); //searchAllWord : 일치하는 결과 모두 리턴하는 메소드
                break;
            case "2":
                System.out.println("검색할 고객의 그룹을 입력하세요.__");
                int group = Integer.parseInt(System.console().readLine());
                list = searchAllCustomer(group);
                break;
            default:
                System.out.println("1 혹은 2 만 입력하세요.");
                return;
        }
        if(list.size()==0){
            System.out.println("없는 고객입니다");
        }else   
        printCustomerList(list);     
    }
//이름으로 검색은 1
    private List<Customer> searchAllCustomer(String name){
        List<Customer> list = new ArrayList<>();        //list :검색결과를 저장할 리스트 
        for(Customer customer : customers){
            if (customer.getName().equals(name)) {
                list.add(customer);                         //일치하는 단어를 만날때마다 저장한다->for문
            }
        }
        return list;    
    }
 //그룹으로 검색은 2    
    private List<Customer> searchAllCustomer(int group) {
        List<Customer> list = new ArrayList<>();        //list :검색결과를 저장할 리스트 
        for(Customer customer : customers){
            if (customer.getGroup()==(group)) {
                list.add(customer);  
            }
        }
        return list;

    }

    private void modifyCustomerBy() {
        System.out.println("\t고객 정보를 수정합니다.");
        System.out.println("수정할 고객의 이름을 입력하세요.__");
        String name = System.console().readLine();
        // 해당 고객이 존재하는지 확인
        boolean isFound = false;
            for (Customer customer : customers) {
                if (customer.getName().equals(name)) {
                    isFound = true;
                    System.out.println("새로운 전화번호를 입력하세요.__");
                    String newPhone = System.console().readLine();
                    System.out.println("새로운 그룹 정보를 입력하세요.(1: 일반 2.VIP 3.기타)__");
                    int newGroup = Integer.parseInt(System.console().readLine());

                // 해당 고객의 정보 수정
                customer.modify_phone(newPhone, newGroup);
                System.out.println("고객의 정보가 수정되었습니다.");
                break;
        }
    }

    // 고객을 찾지 못한 경우
    if (!isFound) {
        System.out.println("해당하는 이름의 고객을 찾을 수 없습니다.");
    }
    }

    private void removeCustomer() {
        System.out.println("\t고객 정보를 삭제합니다.");
        System.out.println("삭제 고객의 이름을 입력하세요.__");
        String name = System.console().readLine();   
        boolean isfind = false;
        for (int i = 0; i <customers.size(); i++) { 
            if(customers.get(i).getName().equals(name)){
                isfind = true;
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요"+ customers.get(i));
                if(System.console().readLine().equals("n")){ 
                    continue;
                }else{
                    customers.remove(i);    //같은 값이 2개인 경우 먼저 입력된것이 삭제된다
                    System.out.println("고객의 정보가 삭제되었습니다.");
                     //삭제하고 나면 인덱스가 바뀐다 --> -1 주면 됨
                    //동일이름이 3개이상인 경우 1 (2는 건너뀜), 3 순서로 삭제가된다 
                    i--;
                }
            }
        }
        if (!isfind) {
            System.out.println("없는 고객입니다.");
        }
    }//removeWord

    private void initialize() {            
        // 1.일반 2.vip 3.기타
        customers.add(new Customer("서희주", "010-5678-9012", 1));
        customers.add(new Customer("서희주", "010-5678-9012", 2));
        customers.add(new Customer("서희주", "010-5678-9012", 3));
        customers.add(new Customer("서희주", "010-5678-9012", 1));
        customers.add(new Customer("김다민", "010-9012-3456", 1));
        customers.add(new Customer("이현지", "010-3456-7890", 1));
        customers.add(new Customer("변유정", "010-7890-1234", 1));
        customers.add(new Customer("전예진", "010-1234-5678", 2));
        customers.add(new Customer("조성호", "010-1234-5678", 2));
        customers.add(new Customer("유재석", "010-1234-5678", 3));
        customers.add(new Customer("강호동", "010-1234-5678", 3));
    }//initialize

}
