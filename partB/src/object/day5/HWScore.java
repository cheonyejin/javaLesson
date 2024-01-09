package object.day5;

import java.util.Arrays;


        //MyClass2 보고 따라함
        
public class HWScore {

    //학생들의 성적을 객체로 만들어줄 클래스 - 객체를 만든다- 인스턴스 -private
    //인스턴스 필드는 인스턴스 메서드를 다 만들어야한다 
    public class Score{

        // 변수 선언
        private String name;
        private int grade;
        private int[] jumsues;

        //getter

        public String getName(){  

            return name;    
        }
        public int getGrade(){    
            return grade;
        }
        public int[] getJumsues(){    
            return jumsues;             
        }
    
        //setter

        public void setName(String n){  

            name = n ;    
        }
        public void setGrade(int g){    
            grade = g;
        }
        public void setJumsues(int[] j){    
            jumsues = new int[j.length];
            for (int i = 0; i < j.length ; i ++)
                jumsues[i] = j[i];             
        }

        //모든 인스턴스 필드를 확인하는 printScore() 메소드 
        public void printScore(){
        System.out.println("name = " + name + " grade= " + grade + 
        " jumsues= "  + Arrays.toString(jumsues));
        }

        // 성적 합계 메소드 만들거야 
        public int Sum() {          //메소드 이름이 Sum인거야 
            int sum = 0;            //이걸로 리턴하려고 만들었어 
            for (int k : jumsues) {              
                sum += k;                        
            }
            /* 위랑 아래랑 같은 코드임 위는 좀 더 간단하게 바꾼거임
            for(int i=0; i<jumsues.length;i++){
                    sum+=jumsues[i];
                     */            
            return sum;
        }
        /*  : 는 in같은 의미이다 
         *  int[] momosetGrade = {10,20,30};       
         *  momo.setJumsues(momosetGrade);  
         *  위의 코드에서 받은 점수값을 객체에 jumsues에 저장했다 
         * 
        */

        //성적 평균
        public double Average() {   //메소드 이름이 Average인거야 
            int sum = Sum();
            return (double) sum / jumsues.length;       //평균은 합계나누기 과목수 
        }                                               //과목수는 점수의 갯수이지

         /* Array.stream 을 사용하면 아래의 코드처럼 간단해진다 
        하지만 배우지 않았으니 메소드를 만드는 방법을 사용한다 

        // 각 학생의 성적 합계를 계산하는 메소드
        public int sum() {
            return Arrays.stream(jumsues).sum();
            //Arrays.stream
        }

        // 각 학생의 성적 평균을 계산하는 메소드
        public double average() {
            return Arrays.stream(jumsues).average().orElse(0.0);
        }
        */       

    }
}
