package ejbModule.java8;

import ejbModule.designmode.pattern005.methods1.Test;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * @author 包超
 * @title: J8_004Lambda
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/8/16 001614:25
 */
public class J8_004Lambda {


    public void method1(){

        //先前
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };
        //lambda
        Comparator<Apple> byWeight1 = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    //函数式接口 ： 定义一个抽象方法的接口
    @FunctionalInterface
    interface Predicate<T>{
        boolean test(T t);
    }



    public static void process(Runnable runnable){
        runnable.run();
    }

    public static String processFile() throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    @FunctionalInterface
    interface BufferedReaderProcessor{
        String process(BufferedReader bufferedReader) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor processor) throws Exception{
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))){
            //处理BufferedReader 对象
            return processor.process(bufferedReader);
        }
    }

    //java.util.function 第一的方法


    // 1.java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，它接受泛型
    //T对象，并返回一个boolean。
    public static  <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T s : list){
            if (p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
    //2. java.util.function.Consumer<T>定义了一个名叫accept的抽象方法，它接受泛型T
    //的对象，没有返回（void）
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T i : list){
            c.accept(i);
        }
    }

    //3. java.util.function.Function<T, R>接口定义了一个叫作apply的方法，它接受一个
    //泛型T的对象，并返回一个泛型R的对象。
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> reslut = new ArrayList<>();
        for (T s:list){
            reslut.add(f.apply(s));
        }
        return reslut;
    }

    public static void main(String[] args) throws Exception {
        //使用lambda
        Runnable runnable = () -> System.out.println("Hello World 1");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        //lambda 可以被赋值给一个变量，或传递给一个接受函数式接口做完参数的方法就好了。
        //表达式的签名要和函数式接口的抽象方法一样。

        //打印 hello world1
        process(runnable);
        //打印 hello world2
        process(runnable1);
        //利用传递的lambda 打印 hello world3
        process(() -> System.out.println("Hello world 3！"));

        //处理一行
        //String onLine = processFile((BufferedReader br) -> br.readLine());
        //处理两行
        //String towLine = processFile((BufferedReader br) ->br.readLine() + br.readLine());

        //模拟 Predicate 接口的使用
        Predicate<String> nonEmptyStringPredicate = (String s) -> s.isEmpty();
        List<String> listOfStrings = Arrays.asList("aa","bb","cc");
        List<String> nonEmpty =  filter(listOfStrings,nonEmptyStringPredicate);

        // 模拟Consumer 接口的使用
        forEach(listOfStrings,(String s) -> System.out.println(s));

        //Function 模拟
        List<Integer> l = map(Arrays.asList("baochao","bcniubi","xiaobaobao"),(String s) -> s.length());

        //避免自动装箱的操作
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        //true（无装箱）
        System.out.println(evenNumbers.test(1000));
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        //false（装箱）
        System.out.println(oddNumbers.test(1000));






    }





}

class Apple{

    Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

class TestSupplier{
    private int age;
    TestSupplier(){
        System.out.println(age);
    }

    public static void main(String[] args) {
        //穿件suppliter容器，声明为TestSuppliter类型，此时不会调用对象的构造方法，既不会创建对象
        Supplier<TestSupplier> supplierSupplier = TestSupplier::new;
        //调用get()方法，此时会调用对象的构造方法，即获得真正的对象。
        supplierSupplier.get();
        //每次get都会调用构造方法，即获得的对象不同。
        supplierSupplier.get();

        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

}



