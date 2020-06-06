package com.qin.lily.java8test;

import lombok.Data;

/**
 * @description:交易
 * @author: Pete
 * @date: Created in 2020/6/6 10:43
 * @modified By:
 */
@Data
public class Transaction {
    private final Trader Trader;
    private final int year;
    private final int value;

}
