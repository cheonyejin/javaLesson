package collection.day11;


//고객 정보 클래스이다.
public class Customer {
    private String name;
    private String phone;
    private int group;// 1.일반 2.vip 3.기타

    // 커스텀 생성자 
    public Customer (String name, String phone , int group){
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        return this.name + "," + this.phone + "," + this.group;
    }
    //get
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    
    public int getGroup() {
        return group;
    }

    //수정하는 메소드
    public void modify_phone(String phone, int group){
        this.phone = phone;
        this.group = group;
    }


}
