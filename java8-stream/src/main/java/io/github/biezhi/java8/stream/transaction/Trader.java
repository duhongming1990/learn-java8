package io.github.biezhi.java8.stream.transaction;

/**
 * @author duhongming
 * @version 1.0
 * @description 贸易
 * @date 2019-08-31 14:43
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public  class Trader{
    /**
     * 交易名
     */
    private String name;
    /**
     * 交易城市
     */
    private String city;

}
