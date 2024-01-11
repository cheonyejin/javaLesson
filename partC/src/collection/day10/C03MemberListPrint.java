package collection.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class C03MemberListPrint {

    public static void main(String[] args) {
        List<Member> list =new ArrayList<>();
        
        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));

        //toString 재정의된 출력말고 직접 이름과 나이를 모두 출력
        System.out.println(String.format("%15s\t %5s","이름","나이"));
        for(int i= 0; i<list.size(); i++){

            Member temp = list.get(i);
            System.out.println(String.format("%15s\t %15s",temp.getName(), temp.getAge()));

            //System.out.println(String.format("%15s\t %15s",list.get(i).getName(), list.get(i).getAge()));      위에꺼랑 같은 의미임 

            //컬렉션에서는 반복자Iterator로 데이터에 접근합ㄴ니다 
            //반복자를 이용한 출력

            System.out.println("____________________반복자를 이용한 출력_________________");
            Iterator<Member> iterator = list.iterator();
            int count = 0;
            while (iterator.hasNext()) {                //반복자가 접근할 다음 데이터가 있으면 참
                Member t = iterator.next();          //반복자가 다음데이터를 가져옵니다 
                System.out.println("\t count = " + count++ + ", 요소 = " + t);
                
            }
            //Iterator로 동작하는 for문 
            System.out.println();
            System.out.println("__________________iterator로 for출력_________________");
            count = 0;
            for (Member member : list) {
                System.out.println("\t count = " + count++ + ", 요소 = " + temp);
                
            }
            





        }
    }
                        
}
