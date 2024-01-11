package collection.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {
    public static void main(String[] args) {
        List<Member> list =new ArrayList<>();
        
        list.add(new Member("momo", 23));
        list.add(new Member("nana", 23));
        list.add(new Member("momo", 23));
        list.add(new Member("dahy", 23));
        list.add(new Member("sana", 23));
        
        //hashCode,equals메소드를 Member에 재정의 하기 전과 후를 비교해보자.
        // 컴파일러는 객쳉릐 hashCode가 같으면 equlas를 검사한다 
        // 일단 통과하면 동일한 객체로 인식한다 
        // 동일한 객체는 remove, indexof를 통해 삭제 및 조회가 가능하다
    
        
        System.out.println("현재 리스트 내용 : "+list + ", 크기 : "+ list.size());
        list.remove(new Member("momo", 23));    // 삭제 안됨
        System.out.println("삭제 후 리스트 내용 : "+list + ", 크기 : "+ list.size());

        
        System.out.println("특정 멤버 조회 : "+list.indexOf(new Member("momo", 23))); // 조회 안됨

        //왜 안돼 ? : new Member()를 통해서 새로운 객체가 생긴다 
        //             인스턴스 필드가 같다고 동일한 객체가 아니다 
        //             remove.indexof은 동일한 객체를 삭제하거나 조회하는것이다 
        // 참고 : String은 문자열 리터럴이 같으면 주소가 같다 
        //        List는 문자열이 같다고 다 같은건 아니다 
        //일반적으로 만들어진 클래스는 hashcode로 메모리의 참조위치가 결정된다 -> hashcode가 같으면 동일한 객체이다. 
        //                                          인스턴스 필드의 내용이 같으면 hashcode를 동일하게 재정의한다.

        /*list.sort(null);
        System.out.println("정렬 후 "+ list);*/


        list.sort(new Comparator<Member>() {
            public int compare(Member o1, Member o2) {      // 나이 오름

                return o1.getAge()-o2.getAge();     
            }
        });
    
        //List의 static메소드 : 테스트용 리스트 만들때 많이 사용합니다 -> 불변객체여서 
        List<String> names = List.of("momo","dahy","nana","sana");
        System.out.println("\n정렬 후 "+ list);

        names.add("xxyyzz");    //-> List<String>은 불변객체여서 추가 못함 오류 남 


    }
    
}
