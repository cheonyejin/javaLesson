package object.day6;

public class AddQuiz {



    //2자리 덧셈연습, 2자리 정수는 11~99범위로 랜덤생성


    private int data1;
    private int data2;
    private int userAnswer; // 입력 받는 정수 값

    public int getData1() {
        return this.data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return this.data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(int userAnswer) {     //제출한 답
        this.userAnswer = userAnswer;
    }

    public boolean isRight() {                  //정답
        return userAnswer == (data1 + data2);
    }

    public AddQuiz(int data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
        

    }
    

}
