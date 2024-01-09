package object.day7;

public class Square extends Shape {
    
    
    public void setEtc(String etc){
        this.etc= etc;
    
    }
    public void setRound(int round){
        this.round = round;
        //오류 : Shape과 같은 패키지가 아니므로 
    }

    @Override
    public void draw(){
		System.out.println(this.getShapeName());
	}
    




}
