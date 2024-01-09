package object.day6;

import java.util.Scanner;

public class AddQuizMain {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //입력을 받기 위한 
        AddQuiz[] quizzes = new AddQuiz[10]; //AddQuiz는 문제야 , 10문제니깐 크기를 10으로 정했어

        System.out.println("덧셈 10문제 퀴즈를 시작합니다.");

        /* 퀴즈 생성 하기 
        0 < 난수 < 1    => 로또 값처럼 1 <= 로또번호 <= 45
        원래 난수값 범위에 *45를 하고       0 < 난수*45 < 45   
        그 값에 다시 +1 하면 됩니다.        1 < 난수*45+1 < 46
        난수의 범위를 start ~ end 범위로 조정하려면
        (int)(Math.random()*(end-start+1))+start*/

        for (int i = 0; i < 10; i++) {
            int start = 11;
            int end = 99;
            int data1 = (int) (Math.random() * (end-start+1)) + 11; // 첫번째 정수
            int data2 = (int) (Math.random() * (end-start+1)) + 11; // 두번째 정수
            quizzes[i] = new AddQuiz(data1, data2);

            System.out.print((i + 1) + "번. " + data1 + " + " + data2 + " = ?\n답 입력하세요. >>> ");
            /*
             * (i + 1) 인이유는 i가 0부터 시작하기 때문에 1을 더한것이다 
             */
            int userAnswer = sc.nextInt();
            quizzes[i].setUserAnswer(userAnswer);
        }

        // 채점 및 결과 출력
        System.out.println("::::::::::::채점 하고 있습니다 ::::::::::::::::");
        System.out.println("\t문제 \t\t제출한답\t정답\t채점");

        for (int i = 0; i < 10; i++) {
            //boolean isCorrect = quizzes[i].checkAnswer();
            int actualAnswer = quizzes[i].getData1() + quizzes[i].getData2();
            System.out.println((i + 1) + "번.\t" + quizzes[i].getData1() + " + " + quizzes[i].getData2() +
                    "\t\t" + quizzes[i].getUserAnswer() + "\t\t" + actualAnswer + "\t\t" + (quizzes[i].isRight() ? "O" : "X"));
        }
    }
}
    



    

