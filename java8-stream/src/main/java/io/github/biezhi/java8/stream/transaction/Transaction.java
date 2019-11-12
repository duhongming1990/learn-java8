package io.github.biezhi.java8.stream.transaction;

/**
 * @author duhongming
 * @version 1.0
 * @description 贸易信息
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
public class Transaction{

    /**
     * 交易信息
     */
    private Trader trader;
    /**
     * 年
     */
    private int year;
    /**
     * 值
     */
    private int value;
}
