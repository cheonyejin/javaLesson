package object.day9_MakeQuestion;

import java.util.Arrays;

public class Q1 {

    public class Score{

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
            // 성적 합계 메소드 
            public int Sum() {          
                int sum = 0;           
                for (int k : jumsues) {              
                    sum += k;                        
                }
             
                return sum;
            }
    
            //성적 평균
            public double Average() {  
                int sum = Sum();
                return (double) sum / jumsues.length;       
            }                                             
    }
}
