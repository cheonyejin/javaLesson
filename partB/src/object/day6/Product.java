package object.day6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Product {
    // private으로 선언을 먼저 한다 
    private String productName;
    private int price;
    private String company;
    private String[] etc;

    // 기본 생성자는 생략해도 되고 필요한 경우 써도 된다.
    public Product() {
    }
    //커스텀 생성자 만들기 
    public Product(String productName,int price, String company, String[] etc) {
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.etc = etc;
    }
    
    
    //getter
    public String getProductName() {
        return productName;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getCompany() {
        return company;
    }
    
    public String[] getEtc() {
        return etc;
    }

    public String getData(){
        return String.format("%15s\t %10d\t %-10s\t %-20s" , productName, price, company, Arrays.toString(etc));
        // %s 문자열 ,%d 정수(10진수) ,%f 부동소수점, %c 문자, %b 논리값, %x 정수(16진수), %o정수(8진수), %e 부동소수점(지수형식), %g 부동소수점(일반 형식)
        
    }




}
