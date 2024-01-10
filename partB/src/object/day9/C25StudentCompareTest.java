package object.day9;

import java.util.Arrays;
import java.util.Comparator;

public class C25StudentCompareTest {
    //Arrays.sort메소드에 두번째 인자로 Comparetro인터페이스 객체를 전달하면 
                    //비교 기준과 정렬방법을 실행시점에서 결정되게 할수있다 
    public static void main(String[] args) {

        Student[] students = new Student[4];
        students[0] = new Student("장모모", 23);
        students[1] = new Student("박나연", 22);
        students[2] = new Student("김다면", 24);
        students[3] = new Student("사나", 21);
        
        System.out.println("초기 students배열 : " + Arrays.toString(students));
        //Arrays.sort(students);      // 오류 :Student객체를 Comparable이 아니다. 


         Comparator<Student> nameAscending = new Comparator<Student>() {  
            @Override
            public int compare(Student o1, Student o2) {    //인자 2개 비교
                //return o1.age()-o2.age();             -> 오류: Student클래스에서 private int age; 으로 선언해서 age()말고 getAge()를 써야됨
                //음수 리턴하면 교환하지 않는다
                // 1. 나이 오름 return o1.getAge()-o2.getAge();         o1 > o2이면 양수 , 교환     -> 오름차순
                // 2. 나이 내림 return o2.getAge()-o1.getAge();         o1 > o2이면 음수 , 교환안함 -> 내림차순
                // 3. 이름 오름
                                return o1.getName().compareTo(o2.getName());                        
                // 4. 이름 내림 return o2.getName().compareTo(o1.getName()); 

                /*
                return값은 왼쪽,오른쪽일때 오름-내림 상관없이 교환을 *당*해도 되는 경우를 음수값으로 리턴하면 된다 
                즉, sort 메소드 정렬 알고리즘은 양수로 리턴해야 교환이 되는것
                걍, 나>남 일때 
                나(기준) - 남 : 오름
                남 - 나 : 내림 
                */
                
            }
        };
        Arrays.sort(students,nameAscending);
        System.out.println("이름 오름차순 정렬 후 student배열 : " + Arrays.toString(students));



        // 한번만 사용하는 경우 Comparator 변수 선언하지 않고 바로 인자로 전달한다 / 실무에서는 이 방법을 더 많이 쓴다 
        Arrays.sort(students,new Comparator<Student>() { 
            @Override
            public int compare(Student o1, Student o2) {    
                return o1.getName().compareTo(o2.getName()); 
            }
        });
        System.out.println("이름 오름차순 정렬 후 student배열 : " + Arrays.toString(students));



        //이름 오름 : 이 람다식은 Comparator구현 클래스 정의 
        //                          추상메소드 1개는 comparae
        //                          메소드의 인자는 Student 타입o1, o2
        //                          메소드 실행과 리턴은 {몸통}에 작성
        Arrays.sort(students,(o1, o2) ->{
            return o1.getName().compareTo(o2.getName());
        });
        System.out.println("이름 오름차순 정렬 후 student배열 : " + Arrays.toString(students));

        //C21에 int배열 오름차순은 그냥 하면 됨

    }
    
}
