package collection.day10;
/*
 * 아래 Member 클래스는 생성될때 조건 1.초기화하면 변경 못합니다.
 *                                  2. hashCode,equals메소드 재정의
 * 이러한 객체를 value objct--> VO라고 부른다 
 * 
 */
public class Member {
    
    public Member(String name, int age){
        this.name = name;
        this.age = age;
        
    }
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    @Override
    public String toString() {
        return "Member [name=" + name +", age= " + age + "]\n";
    }


    //인스턴스 필드값으로 해시코드 생성하기 : name.hashCode()와 age정수값으로 계산
    @Override
    public int hashCode() {           
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());   // name.hashCode()
        result = prime * result + age;      //age
        return result;
    }

    //나와 대상의 인스턴스 필드값이 모두 같은지 검사하는 메소드
    //모두 같으면 참
    @Override
    public boolean equals(Object obj) {    //this 나, obj 대상 
        if (this == obj)                   
            return true;                   
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;        //obj다운캐스팅한거 
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    //결론 : 객체의 동일성(같은객체냐)을 검사하기 위해서 hashCode와 equals 메소드를 오버라이드 한다.
    //      해시코드값이 같고 인스턴스필드의 내용이 같으면 동일한 객체다.
    
    



    
}
