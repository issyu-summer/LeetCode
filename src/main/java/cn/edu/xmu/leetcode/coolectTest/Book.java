package cn.edu.xmu.leetcode.coolectTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author summer
 * @date 2021/3/19 13:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {

    private String name;
    private Integer price;

    @Override
    public String toString(){
        return "{"+"name:"+name+","+"price:"+price+"}";
    }
}
