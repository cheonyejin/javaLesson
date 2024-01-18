package etc.day15;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * 자바에서 날짜 형식을 지원하는 클래스 3가지 
 * 1. java.util의 Date,Calendar 클래스 : jdk 1.1~ 
 * 2. java.sql의 Date,Timestamp 클래스 : jdk 1.1~ (데이터베이스와 연동되는 타입)
 * 3. java.time의 LocalDate, LocalTime, LocalDAteTime 클래스 : jdk 1.8~
 *                     ㄴ 날짜와 시간과 관된 많은 클래스들과 메소드가 제공
 */
public class JavaDataTypeTest {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("###,###,###,###");        
        //DecimalFormat : 천자리마다 구분선을 넣는다던가, 소숫점 몇자리까지 포함할 것인지 정함
        //기본적으로 ms 
        long now = System.currentTimeMillis();
        System.out.println("1. 현재시간을 1970년 1월 1일 0시 기준으로 구합니다 . 단위: ms(1/1000초)");
        System.out.println("\t현재시간 = " + now + " ms");                                      //1705537578901
        System.out.println("\t현재시간 = " + df.format(now) + "ms");                            //1,705,537,578,901
        System.out.println("---현재시간을 ms로 구하는 방식은 모든 프로그래밍 언어에서 사용합니다.---");
        System.out.println("_____________________________________________");
        
        System.out.println("\n2. 약 54년을 직접ms로 계산해봅니다");
        long oneday = 24*60*60*1000;    //1년 24시간에 대한 ms
        long onetyear = 365*oneday;
        System.out.println("\t1일 24시간 = "+df.format(oneday)+" ms");                          //86,400,000
        System.out.println("\t1년 365일 = "+df.format(onetyear)+" ms");                         //31,536,000,000
        System.out.println("\t54년 = "+df.format(54*oneday)+" ms");                             //4,665,600,000
        System.out.println("\t55년 = "+df.format(54*onetyear)+" ms");                           //1,702,944,000,00
        System.out.println("_____________________________________________");

        //이렇게 쓰면 현실세계의 시간과의 괴리감이 있다-> java.

        System.out.println("\n3. 날짜 클래스로 객체 생성합니다,");
        System.out.println("java.util Date클래스 : " + new Date());                             //Thu Jan 18 09:26:18 KST 2024
        System.out.println("java.util Date클래스.getTime() : " + new Date().getTime());         //1705537578933
        System.out.println("_____________________________________________");

        //java.sql.Date클래스는 기본 생성자 동작이 없다. *long*타입 인자(ms단위)가 필요하다.  
        System.out.println("java.sql Date클래스 : " + new java.sql.Date(54*onetyear));          //2023-12-19
        System.out.println("java.sql Date클래스 : " + new java.sql.Date(new Date().getTime())); //2024-01-18

        System.out.println("_____________________________________________");
        System.out.println("java.util Calender클래스 : " + Calendar.getInstance());             //
        System.out.println("--> private생성자이고 객체를 만들어 전달해주는 gerInstance 메소드");






    }
}

p
