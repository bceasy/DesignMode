package ejbModule.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 *
 * 练习题
 * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
 (2) 交易员都在哪些不同的城市工作过？
 (3) 查找所有来自于剑桥的交易员，并按姓名排序。
 (4) 返回所有交易员的姓名字符串，按字母顺序排序。
 (5) 有没有交易员是在米兰工作的？
 (6) 打印生活在剑桥的交易员的所有交易额。
 (7) 所有交易中，最高的交易额是多少？
 (8) 找到交易额最小的交易。
 * Created by Administrator on 2020/8/22.
 */
public class J8_005Stream1 {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)  //给filter 传递一个谓词来选择2011年的交易
                .sorted(Comparator.comparing(Transaction::getValue))  //按照交易额进行排序
                .collect(Collectors.toList()); //将生成的stream中所有元素收集到一个List中
        System.out.println(tr2011);

        //方法一： 交易员都在哪些不同的城市工作过
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity()) //提取与交易相关的每位交易员的所在城市
                .distinct()  //只选择互不相同的城市
                .collect(Collectors.toList());
        //方法二： 你可以去掉distinct()，改用toSet()，这样就会把流转换为集合。
        Set<String> cities_toset = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        //查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader) //交易中提取所有交易员
                .filter(trader -> trader.getCity().equals("Cambridge")) //仅选择位于剑桥的交易员
                .distinct()  //确保没有重复
                .sorted(Comparator.comparing(trader -> trader.getName()))  //对生成的交易员流按照姓名进行排序
                .collect(Collectors.toList());

        //返回所有交易员的姓名字符串，按字母顺序排序 (此方法效率不高   所有字符串都被反复连接，每次迭代的时候都要建立一个新的String对象)
        String  traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()) //提取所有交易员的姓名，生成一个Strings 构成的stream
                .distinct()
                .sorted()
                .reduce("",(n1,n2) -> n1 + n2);
        System.out.println(traderStr);

        //方案二：
        String traderStr2 =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        //有没有交易员是在米兰工作的
        boolean milanBased =
                transactions.stream()
                        //把一个谓词传递给anyMatch,检查是否有交易员在米兰工作
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(t ->"Cambridge".equals(t.getTrader().getCity())) //选择住在剑桥的交易员所进行的交易
                .map(Transaction::getValue)  //提取这些交易的交易额
                .forEach(System.out::print); //打印每个值

        //所有交易中，最高的交易额是多少
        Optional<Integer> highestValue =
                transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);

        //找到交易额最小的交易
        Optional<Transaction> smallestTransaction =
                transactions.stream().reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

    }

}

/**
 * 交易员
 */
class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}

/**
 * 交易
 */
class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}

