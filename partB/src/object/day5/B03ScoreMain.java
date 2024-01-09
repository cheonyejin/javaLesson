package object.day5;

public class B03ScoreMain {


    //Score를 실행할 파일 

    
    public static void main(String[] args) {
     

        // 학생 4명의 성적을 저장해보세요 
        // 1학년 2명 : 모모momo, 다현dah   -> 3과목
        // 2학년 2명 : 나연nah, 쯔위ggw -> 4과목
        // 점수는 너가 정해 
        HWScore sc = new HWScore();             //HWScoe에서 내가 만든거 쓰려고 

        HWScore.Score momo = sc.new Score();    //HWscore 클래스 안에 Score클래스 있어 
        momo.setName("모모");                 //이름
        momo.setGrade(1);                    //학년
        int[] momosetGrade = {10,20,30};       //    점수 배열 넣어 
        momo.setJumsues(momosetGrade);          //점수

        HWScore.Score dah = sc.new Score();
        dah.setName("다현");                 //이름
        dah.setGrade(1);                    //학년
        int[] dahsetGrade = {40,50,60};       //    점수 배열 넣어 
        dah.setJumsues(dahsetGrade);          //점수


        HWScore.Score nah = sc.new Score();
        nah.setName("나연");                 //이름
        nah.setGrade(2);                    //학년
        int[] nahsetGrade = {70,80,90,100};   //    점수 배열 넣어 
        nah.setJumsues(nahsetGrade);          //점수

        HWScore.Score ggw = sc.new Score();
        ggw.setName("쯔위");                 //이름
        ggw.setGrade(2);                    //학년
        int[] ggwsetGrade = {110,120,130,140};//    점수 배열 넣어 
        ggw.setJumsues(ggwsetGrade);          //점수

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
