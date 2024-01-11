package collection.day10;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry; //Map안에서 구성요소로 정의된 내부 클래스 
import java.util.Scanner;

public class C06TodayMenuVote {

    //Map연습
    public static void main(String[] args) {
        String menu = " 치킨, 스파게티, 곱창, 불고기 , 삼겹살";
        //투표결과를 map에 저장하기 
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("치킨", 0);
        map.put("스파게티", 0);
        map.put("곱창", 0);
        map.put("불고기", 0);
        map.put("삼겹살", 0);   //value가 null이면 value++를 못하잖아 0으로 바꿔

        System.out.println("메뉴를 투표합시다");
        System.out.println("메뉴: " + menu);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("영문 메뉴 이름 입력 : >>");
            String key = sc.nextLine();

            //입력 그만할거면
            if (key.equals("end"))  
            break;
            // 입력하면 
            if(map.containsKey(key)){
                int value = map.get(key);
                /*value++;
                map.put(key,value);*/  //아래의 한줄 코드와 같은거

                map.put(key,++value);   //++앞에 있는 이유는 value가 먼저고put이 2번째라 앞에 넣었다

            }else{
                //1. 없는 메뉴 추가 
                System.out.println("투표에 없는 메뉴이므로 , 추가하겠습니다");
                map.put(key, 1);    //새로운 메뉴 초기화
                menu +=" , "+key;
                //2. 없다고 알려주기 
                //System.out.println("선정된 메뉴 중 선택하시오.");

            }    


        }
        System.out.println("투표가 종료되었습니다");
        System.out.println(map);
        System.out.println(Collections.max(map.keySet()));   //key 중 최댓값
        System.out.println(Collections.max(map.values()));   //vlaue 중 최댓값
        //value 최대값의 key는 무엇인가 
        //key,value를 한쌍으로 만든 타입이 Entry
        Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,Entry<String, Integer> o2){
                return o1.getValue()-o2.getValue();
            }
            
        };
        
        Entry<String, Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        System.out.println("최다득표결과");
        System.out.println("메뉴 이름  : "+maxEntry.getKey());
        System.out.println("투표 수 : "+maxEntry.getValue());

        sc.close();


    }
    
}
