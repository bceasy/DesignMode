package ejbModule.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.cnblogs.com/haixiang/p/11029639.html
 * @author 包超
 * @title: J8_002Lambda
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/8/11 001122:01
 */
public class J8_002Lambda {
    public static void main(String[] args) {

        //老版本 java 排列字符串
        //给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法
        List<String> names = Arrays.asList("peter","anna","mike","xenia");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//        System.out.println(names);

        //更简洁的语法 lambda表达式
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //更简短
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点
        Collections.sort(names, (a, b) -> b.compareTo(a));
        //Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。



    }
}
