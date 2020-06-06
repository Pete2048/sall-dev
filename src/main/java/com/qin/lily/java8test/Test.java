package com.qin.lily.java8test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @description:函数式接口---Lambda
 * @author: Pete
 * @date: Created in 2020/6/1 16:35
 * @modified By:
 */
public class Test {
    public static void main(String[] args) {
// 1 布尔表达式
//(List<String> list) -> list.isEmpty()       Predicate<T> T->boolean IntPredicate,LongPredicate, DoublePredicate
//        filterBeanToAnother();
// 2 消费一个对象
//(Apple a) ->System.out.println(a.getWeight())      Consumer<T> T->void IntConsumer,LongConsumer, DoubleConsumer
// 3 从一个对象中选择/提取
//(String s) -> s.length()      Function<T,R> T->R
// 4 创建对象
//() -> new Apple(10)      Supplier<T> ()->T BooleanSupplier,IntSupplier, LongSupplier,
//                DoubleSupplier
// 5       UnaryOperator<T> T->T IntUnaryOperator,
//                LongUnaryOperator,
//                DoubleUnaryOperator
// 6  合并两个值
//(int a, int b) -> a * b     BinaryOperator<T> (T,T)->T IntBinaryOperator,
//                LongBinaryOperator,
//                DoubleBinaryOperator
// 7       BiPredicate<L,R> (L,R)->boolean
// 8       BiConsumer<T,U> (T,U)->void ObjIntConsumer<T>,
//                ObjLongConsumer<T>,
//                ObjDoubleConsumer<T>
//                        BiFunction<T,U,R> (T,U)->R ToIntBiFunction<T,U>,
// 9       ToLongBiFunction<T,U>,
// 10       ToDoubleBiFunction<T,U>
//        找到2011年的所有交易并按交易额排序（从低到高）
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(alan, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //找到2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> tr2011 = transactions.stream()
                .filter(f -> f.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        //交易员都在哪些不同的城市工作过
        Set<String> cities = transactions.stream()
                .map(f -> f.getTrader().getCity())
                .collect(Collectors.toSet());
        //查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(f -> f.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        //返回所有交易员的姓名字符串，按字母顺序排序
        String traderStr = transactions.stream()
                .map(f -> f.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        //有没有交易员在米兰工作的
        boolean milan = transactions.stream()
                .anyMatch(f -> f.getTrader().getCity().equals("Milan"));
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(f -> f.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        //所以交易中最高的交易额
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

    }


    private static void filterBeanToAnother() {
        BeanMananer beanMananer = new BeanMananer();
        List<String> listOfStrings = Arrays.asList("李白","钟馗","","李元芳","王昭君","");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();//T->boolean   的实现
        List<String> nonEmpty = beanMananer.filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);//[李白, 钟馗, 李元芳, 王昭君]
    }
}
