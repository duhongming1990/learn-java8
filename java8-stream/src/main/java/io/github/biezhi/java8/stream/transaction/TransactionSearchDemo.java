package io.github.biezhi.java8.stream.transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author duhongming
 * @version 1.0
 * @description 流式贸易查询
 * @date 2019-08-31 14:46
 */
public class TransactionSearchDemo {
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
                new Transaction(alan, 2012, 950));

        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        Set<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                //distinct() + collect(toList())
                .collect(toSet());

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
//                .reduce("",(n1,n2)->n1+n2);
                .collect(joining());

        Boolean isMilan = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));


        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
//                .forEach(transaction -> System.out.println(transaction.getValue()));

        Optional<Integer> value = transactions.stream()
                .max(comparing(Transaction::getValue))
                .map(Transaction::getValue);

        Optional<Transaction> transaction = transactions.stream()
                .min(comparing(Transaction::getValue));


    }
}
