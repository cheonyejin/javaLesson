package project.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

//loombook이용하기 
@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class ProductVO { 

    public String pcode;
    public String category;
    public String pname;
    public int price;

    

    @Override
    public String toString() {
        return String.format("%6s %15s %40s\t %,8d", category,pcode,pname,price);
    }

    


    
}
