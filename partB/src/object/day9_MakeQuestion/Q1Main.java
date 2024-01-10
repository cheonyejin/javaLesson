package object.day9_MakeQuestion;

import object.day9_MakeQuestion.Q1;

public class Q1Main {
    public static void main(String[] args) {
        /* 
        문제 출제자: C조 전예진
        문제 범위 : partB day5
        day5 내용: get set배우기, 성적저장하고 평균 및 합계 출력하기
        */ 

        Q1 sc = new Q1();            

        Q1.Score momo = sc.new Score();    
        momo.setName("모모");                
        momo.setGrade(1);                    
        int[] momosetGrade = {10,20,30};      
        momo.setJumsues(momosetGrade);       

        Q1.Score dah = sc.new Score();
        dah.setName("다현");                
        dah.setGrade(1);                
        int[] dahsetGrade = {40,50,60};     
        dah.setJumsues(dahsetGrade);         

        Q1.Score nah = sc.new Score();
        nah.setName("나연");               
        int[] nahsetGrade = {70,80,90,100};   
        nah.setJumsues(nahsetGrade);          

        Q1.Score ggw = sc.new Score();
        ggw.setName("쯔위");               
        ggw.setGrade(2);                    
        int[] ggwsetGrade = {110,120,130,140};
        ggw.setJumsues(ggwsetGrade);          

        //모든 인스턴스를 확인하는 과정
        momo.printScore();
        dah.printScore();
        nah.printScore();
        ggw.printScore();

        System.out.println("모모 점수 총합계 : " + momo.Sum());
        System.out.println("모모 점수 평균 : " + momo.Average());
        System.out.println("\n다현 점수 합계 : " + dah.Sum());
        System.out.println("다현 점수 평균 : " + dah.Average());
        System.out.println("\n나연 점수 평균 : " + nah.Average());
        System.out.println("나연 점수 합계 : " + nah.Sum());
        System.out.println("\n쯔위 점수 평균 : " + ggw.Average());
        System.out.println("쯔위 점수 합계 : " + ggw.Sum());
        
    }
    
}
    