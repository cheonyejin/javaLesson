package collection.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;

public class C05MapExample {

    public static void main(String[] args) {

        /*
        Map은 인터페이스다. 
        Map<K,V> :key값으로 nalue 가져오기  
                key와 value는 모든타입 Object입니다
                key는 중복된 값을 가질 수 없습니다. 
                key와 value모두 순서가 없습니다.
                        Map에  1. 입력한 순서로 접근하고 싶으면 LinkedHashMap을 쓴다 
                                2. (key기준 )정렬된 방식으로 접근하고 싶으면 TreeMap을 쓴다 
        Map의 구성요소: key, value
        key는 set특성을 가지고 있다
        */

        //1.입력한 순서 정렬 
        //Map<String,String> map = new HashMap<>();
        //2.key 기준 정렬 
        Map<String,String> map = new TreeMap();         
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");      //key 값은 중독될수 없다 
                                                // 그러므로 트와이스는 지워지고 원더걸스가 남는다
        map.put("js", "뉴진스");
        System.out.println("map 의 크기 = " + map.size());      // 5 :  중복을 제외해서 
        System.out.println("map 에 저장된 문자열 = " + map);

        //Map의 get메소드 테스트
        System.out.println("_____________Map의 get메소드 테스트________________");
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.println("찾을 값에 대한 key를 입력해라>>>");
            String key = sc.nextLine();
            if (key.equals("end"))
            break;
            System.out.println("당신이 원하는 key의 값은" + map.get(key));
        }

        //1. Iterator 반복자를 이용한 set 의 값 가져오기
        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        System.out.println("\t map.keySet() ? : " + map.keySet());  //맵의 key만 가져와서 set 생성
        Iterator<String> mapIterator = map.keySet().iterator();     //key값으로 반복자를 생성
        int cnt =0;
        while(mapIterator.hasNext()) {
            String temp =mapIterator.next();                        //반복자가 가져온 값은 key입니다.
            System.out.println(String.format("count=%d , key= %s , value=%s", 
                                                            cnt++,
                                                            temp,           //key
                                                            map.get(temp)   //value
                                                            ));
        }//while

        //2. for 반복자를 이용한 set 의 값 가져오기 
        System.out.println("_________for반복자 출력하기 ______");
        for(String key: map.keySet())
            System.out.println(String.format("count=%d, key = %s, value = %s,",
                                                            cnt++,
                                                            key,           //key
                                                            map.get(key)   //value
                                                            ));

        //조회 해보기
        System.out.println("map.values() : "+map.values());
        System.out.println("map.containsKey(\"tt\") 있음? : "+map.containsKey("tt"));
        System.out.println("map.containsKey(\"js\")있음? : "+map.containsKey("js"));
        System.out.println("map.containsValue(\"잇지\") 있음? : "+ map.containsValue("잇지"));
      
    }//main
    
}
