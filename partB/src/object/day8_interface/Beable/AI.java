package object.day8_interface.Beable;

public class AI implements Thinkable {
    protected char op;

    public char getOp() {
        return this.op;
    }

    public void setOp(char op) {
        this.op = op;
    }


    @Override
    public int calculate(int a, int b) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;

            default:
                result = -9999;
        }
        return result;
    }

    @Override
    public void think() {
        System.out.println("학습된 정보를 수집해서 결정합니다");
        
    }

    @Override
    public String beAble() {
        return "생각할수있음.";
    }

    
    
}
