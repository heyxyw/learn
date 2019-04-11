package com.zhouq.java8.stream;

import com.sun.deploy.trace.TraceLevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/14 21:57
 */
public class StreamInAction {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011 年发生的所有交易,并按照交易额排序,从低到高

        List<Transaction> transactions1 = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
        System.out.println(transactions1);

        //交易员都在哪些不同的城市工作过

        List<String> collect = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());
        System.out.println(collect);

        //查找所有来自剑桥的交易员并按姓名排序

        List<Trader> cambridge = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .collect(toList());
        System.out.println(cambridge);


        //返回所有交易员的行字符串,按字母顺序排序
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct() 
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(reduce);

        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(traderStr);


        //有没有交易员是在米兰工作的

        boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(milanBased);


        //打印在剑桥工作的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);

        //打印在剑桥工作的交易员的所有交易额总额
        Integer cambridge1 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).reduce(Integer::sum).get();
        System.out.println(cambridge1);


        //所有交易额中最高的是多少
        Integer max = transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::max).get();
        System.out.println(max);

        //查询交易额最小的交易
        Transaction transaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).get();
        System.out.println(transaction);

        Transaction min = transactions.stream().min(Comparator.comparing(Transaction::getValue)).get();
        Transaction max1 = transactions.stream().max(Comparator.comparing(Transaction::getValue)).get();

        System.out.println(min);
        System.out.println(max1);

    }

}
