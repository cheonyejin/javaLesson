package etc.day15;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */
public class InstanceTest {

    public static void main(String[] args) {
        MyCalendar my = MyCalendar.getInstance();
        //MyCalendar my1 = new MyCalendar();
        //MyCalendar my2 = MyCalendar.object;

        YorCalender you1 = YorCalender.of("2024", "03");

        Member member = new Member("kkk",23,1110);
        System.out.println(member.getAge());
    
    
    
    }
    
}
//main메소드는 1개 파일에 1개만 있어야된다 
//public class도 1개파일에 1개만 있어야된다
//위의 2가지만 만족시키면 1개파일에 클래스는 여러개 만들수있다.

//룸북 lombok설치하면 아래의 코드들이 자동으로 된다
@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor
@ToString
@EqualsAndHashCode

class Member{
    private String name;
    private int age;
    private int point;
    //lombok라이브러리 : 메번 작성되는 아래의 메소드를 자동으로 만들어준다 
    //커스텀생성자
    //기본생성자
    //get
    //set
    //hashdode equals재정의
}



class MyCalendar {      //클래스
    private static MyCalendar object = new MyCalendar();
    //필드가 현재 클래스의 타입, 미리 생성자로 객체를 만듭니다 

    private MyCalendar() {// 생성자: prvate  , 다른 클래스에서 사용못한다
    }

    public static MyCalendar getInstance(){
        //미리 만들어진 현재 클래스 타입의 객체를 리턴
        return object;
    }

}

class YorCalender{

    private String month;
    private String day;
    private YorCalender(){}  //기본생성자       //다른클래스에서 new연산 사용못함

    public static YorCalender of(String month, String day){ 
        YorCalender result = new YorCalender();
        result.month = month;
        result.day = day;
        return result;
        
    }
    

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}