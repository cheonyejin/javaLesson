package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {


    //Member객체를 비교하고 Member 배열 정렬도 할수있습니다 
    public static void main(String[] args) {
        Member momo = new Member("momo", 23);
        Member nana = new Member("nana", 20);

        System.out.println("모모와 나나를 비교 (나이기준) : ");
        System.out.println("\t" + momo.compareTo(nana) + " -> 양수이면 momo가 nana보다 나이가 많습니다.");

        Member dahy = new Member("dahyeon", 21);
        Member sana = new Member("sana", 22);

        Member[] members = new Member[4];
        members[0] = momo;
        members[1] = nana;
        members[2] = dahy;
        members[3] = sana;

        System.out.println("초기 members 배열 : " + Arrays.toString(members));
        Arrays.sort(members);
        System.out.println("정렬 후 members 배열 : " + Arrays.toString(members));



    }
    
}
