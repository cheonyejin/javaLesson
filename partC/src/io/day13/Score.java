package io.day13;

public class Score {
    private String name;
    private int korean;
    private int english;
    private int math;

    //드래그 오른쪽 소스작업->generate constructor 누르면 만들어짐
    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }
    public String getName() {
        return name;
    }
    public int getKorean() {
        return korean;
    }

    public String datas(){
        return name + ","+ korean+ ","+english+","+math;
    }
    @Override
    public String toString() {
        return "Score [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }
    

    
}
