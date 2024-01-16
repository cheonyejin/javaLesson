package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();
        //List인터페이스를 구현한 클래스가 ArrayList이다.

        strlist.add("트와이스");
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");

        System.out.println("문자열 List strlist size : " + strlist.size());
        System.out.println("\n데이터 추가");
        System.out.println("르세라핌");
        System.out.println("항목추가 후 리스트 : " + strlist);  //Arraylist클래스의 toString메서드 실행 

        System.out.println("\n데이터삭제 ");    //remove 오버로딩
        strlist.remove("원더걸스 ");            //메소드 인자 타입이 int와 sstring 2가지로 동작
        strlist.remove(1);                  //ARRAyList클래스의  String

        //아래의 2개의 메소드 비교 
    
        strlist.add(2,"99999");     //추가
        strlist.set(2, "!!!!!");    //수정
        System.out.println("항목 변경 후 : " + strlist);
        System.out.println(strlist.get(0));
        System.out.println(strlist.get(3));
       // System.out.println(strlist.get(9));     오류 : 요소 없음
       /*
       List 구현 클래스 특징 : 배열처럼 인덱스를 갖습니다. 인덱스가 있다는 것은 데이터의 순서가 있다는 의미이다.
       배열에 없는 삭제 기능이 있습니다.
       그 외에도 조회 관련 기능 등 조작과 조회를 다양하게 할 수 있습니다.
        
       */
       //addAll
       List<String> sublist = new ArrayList<>();
       sublist.add("방탄소년단");
       sublist.add("세븐틴");
       strlist.addAll(sublist);
       System.out.println("addAll sublist 후 : "+strlist);
       strlist.add("아이브");
       System.out.println("이미 저장된 값도 또 추가되나요 ? "+strlist);

       //리스트에서 요소찾기 
       //1.contains
       //2.indexOf
       //3.LastindexOf
        System.out.println("\n\n리스트에서 항목 찾기");
        System.out.println("\t 리스트에 처음 `아이브` 어디 있음? " + strlist.indexOf("아이브"));
        System.out.println("\t 리스트에 마지막 `아이브` 어디 있음? " + strlist.lastIndexOf("아이브"));
        System.out.println("\t 리스트에 `뉴진스` 있음? " + strlist.contains("뉴진스"));
        System.out.println("\t 리스트에 `뉴진스` 어디 있음? " + strlist.indexOf("뉴진스"));


        
//
}
}