package ejbModule.arithmetic;

import java.time.Month;

/**
 *
 * 兔子问题
 * 斐波那契数列求值
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 * @author 包超
 * @title: Sf0001_Rabbit
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/28 002821:20
 */
public class Sf0001_Rabbit {
    public static  final int MONTH = 15;

    public static void main(String [] args){

         long f1 = 1L,f2 = 1L;
         long f ;
         for (int i = 3 ; i<MONTH; i++){
             f = f1 + f2;
             f1 = f2;
             f2 = f;
             System.out.println("第" + i + "个月的兔子对数：" + f2);
         }

//        for(int i = 1 ; i<MONTH;i++){
//            System.out.println("第"+i+"个月的兔子对数："+fib(i));
//        }
    }

    public  static int fib(int month){
        if(month == 1 || month == 2){
            return 1;
        }else {
            return fib(month -1) + fib(month -2);
        }

    }
}
