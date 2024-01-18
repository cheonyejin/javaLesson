package etc.day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDAteTimeTest {
    public static void main(String[] args) {
        System.out.println(" 1. 현재 날짜와 시간을 구하여 출력하기 "); 
        //객체생성메소드 now()  : new연산을 대신함
        LocalDate currenDate = LocalDate.now();                    
        System.out.println("\tLocalDate 현재 날짜 : " + currenDate);        //2024-01-18

        LocalTime currentTiem = LocalTime.now();                            //10억분의 1초 (ns)까지 구해준다.
        System.out.println("\tLocalTime 현재 날짜 : " + currentTiem);       //09:44:49.744973200
        
        LocalDateTime currenDateTiem = LocalDateTime.now();
        System.out.println("\tLocalDateTime 현재 날짜 : " + currenDateTiem);//2024-01-18T09:44:49.744973200  : T 로 날짜 시간 구분



        System.out.println(" 2. 특정 날짜와 시간을 지정해서 객체를 생성한다. => .of ");
        // .of() : 객체를 생성하고 값을 초기화 합니다. 
        LocalDate mybirth = LocalDate.of(2000, 9, 10);
        LocalTime mybirth_time = LocalTime.of(17, 19, 0);
        System.out.println("\t LocalDate.of(2000, 9, 10) "+ mybirth);
        System.out.println("\t LocalTime.of(17, 19, 0) "+ mybirth_time);

        //java.time 패키지에있는  다른 클래스 테스트해보기
        System.out.println(" 3. 날짜 사이의 간격을 계산해보기");
        System.out.println("내가 태어난지 ...년 ... 월 ...일이 지났습니다");
        Period a = Period.between(mybirth, currenDate);                         //Period : 
        System.out.println(a.getYears() + " 년");                                           //23 년
        System.out.println(a.getMonths() + " 월");                                          //4 월
        System.out.println(a.getDays() + " 일");                                            //8 일

        System.out.println(" 4. 날짜 사이의 간격 나눠서 계산하기(단위 : 년 ,월 ,일)");
        System.out.println("\t 내가 태어나서 ..년/월/일 지났습니다 ");          //ChronoUnit: 
        System.out.println(ChronoUnit.YEARS.between(mybirth, currenDate)+ " 년");           //23 년
        System.out.println(ChronoUnit.MONTHS.between(mybirth, currenDate)+ " 월");          //280 월
        System.out.println(ChronoUnit.DAYS.between(mybirth, currenDate)+ " 일");            //8530 일


        System.out.println(" 5. 내 생일로부터 10000일 이후 날짜는? ");
        LocalDate after10000 = mybirth.plusDays(10000);              //내 생일  +
        System.out.println("내 생일로부터 10000일 이후 날짜는 : " + after10000);            //2028-01-27


        System.out.println(" 6. 오늘 날짜로부터 10000일 이전 날짜는? ");
        LocalDate before10000 = currenDate.minusDays(10000);    //현재시간 - 
        System.out.println("오늘 날짜로부터 10000일 이전 날짜는? : " + before10000);        //1996-09-01

        System.out.println(" 7. 계산 검증 테스트 -3일 이전");
        System.out.println(currenDateTiem.minusDays(3));
        System.out.println(currenDateTiem.plusDays(3));


        System.out.println(" 8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");

        // 년 yyyy 월 MM(대문자) 일 dd 시간 hh 분 mm 초 ss
        System.out.println(currenDate.format(formatter));
        System.out.println(currenDateTiem.format(formatter1));     //출력할때도 Date, Time,DateTime 신경써서 





    }
    
}
