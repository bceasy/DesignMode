package ejbModule.arithmetic;

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 * @author 包超
 * @title: Sf0002_Daffodils
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/28 002823:01
 */
public class Sf0002_Daffodils {

    public static void main(String[] args) {
        int a , b , c;
        int data;
        for (int i = 100 ; i < 999 ; i ++ ){
            //百位数
            a = i / 100 ;
            //十位
            b = (i - 100 * a) /10;
            //个位
            c = i  - 100 * a - 10 * b;

            data = a*a*a + b*b*b + c*c*c;
            if(i == data)
                System.out.println(i);
        }

    }

}
