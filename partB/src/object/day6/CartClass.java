package object.day6;

public class CartClass {

    private String userid;
    private String[] products;
    private int[] prices;
    private int total_Money;

    public String getUserid(){
        return userid;
    }
    public String[] getProductName(){
        return products;
    }
    public int[] getPrices(){
        return prices;
    }
    public int getTotalMoney(){
        return total_Money;
    }

    public void setUserid(String id){
        this.userid = id;
    }
    public void setProductName(String[] name){
        this.products = name;
    }
    
    public void setPrices(int[] prices){
        this.prices = prices;
    }
    /*public void setTotalMoney(int totalmoney){
        this.total_Money= totalmoney;
   
    }*/


    //추가적인 인스턴스 메소드 : 해결방법
    // 상품 총 가격 합계 메소드 
    public int total_Money(int[] select){       // total money는 int[]가 아니고 int이다.
        int sum = 0;
        for(int i=0; i<select.length;i++){ 
            int temp = select[i];   //select가  -1이면 선택 종료 였잖아 근데 크기를 5로 설정했잖아 
            if(temp == -1) break;
            sum += prices[temp];
        }
        return sum;
    }
    
}
      
    
    



