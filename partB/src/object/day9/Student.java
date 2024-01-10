package object.day9;

public class Student  {
    private String name;
    private int age;

    
    public Student (String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("\nStudents [name = %s, age %d ]",this.name,this.age);
    }
}
/*
 * Member클래스 comepareTo의 문제점: 비교 기준 또는 정렬방법을 변경하려면 클래스 내부의 
 *      compareTo 메소드 구현의 return을 일일이 변경해야된다 
 *      Member를 사용한 기존의 다른 프로그램에 영향
 */