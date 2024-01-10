package object.day9;
/*인터페이스 예시 -비교 가능한 객체 만들기 
객체비교방법 1) Comparable 인터페이스 만들기 
Comparable<Member>는 <>안에 타입을 표시한다. 이런방식을 제너릭타입
        제너릭 타입: 클래스 또는 인터페이스의 메솓으ㅔ게 타입을 매개변수로 전달하기 위한 방식, 
        이 때 타입이 실행 시점에서 결정되기 때문
        기본형은 Wrapper클래스로 사용
        Comparable 인터페이스가 실행하는 메소드에 Member타입을 전달합니다
*/ 
public class Member implements Comparable<Member> {
    private String id;
    private int age;

    public Member(String id, int age){
        this.id = id;
        this.age = age;
    }
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Member [id=" + id +", age= " + age + "]\n";
    }
    //Compareble의 추상메소드 compareTo를 재정의 
    @Override
    public int compareTo(Member o) { 
        //compareTo()는 문자열을 비교하기 위한것 
        // 숫자 비교는 그냥 빼거나 더해 
           
        //메소드의 인자 타입 Member는 <>제너릭 타입과 같에 만들어진다.
        //현재 객체 this를 인자로 전달되는 Member객체롸 비교한다.
        //비교 기준은 요구사항에 따라 개발자가 정합니다.
        //this는 자신이 만든객체 
        //o는 인자 ?
        //만약에 나이로 한다면 
                 //1. return this.age - o.age;   //나이 오름차순
                 //2. return o.age-this.age;    //나이 내림차순
        //만약에 이름으로 한다면
                //3.return this.id.compareTo(o.id); //이름 오름차순
                //4. 
                return o.id.compareTo(this.id);   //이름 내림차순              
    }

    
}
