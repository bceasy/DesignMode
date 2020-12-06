package ejbModule.arithmetic;

/**
 *
 * 反转一个只有3位数的整数。
 * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
 * @author 包超
 * @title: Sf0003
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/12/6 000621:08
 */
public class Sf0003 {

    //例子
//    输入: number = 123
//    输出: 321

//    输入: number = 900
//    输出: 9
//https://blog.csdn.net/qq_37701443/article/details/81612099
     public static int reverseInteger(int number){
         int result = 0;
         StringBuffer sb = new StringBuffer();
         sb.append(number);
         result  = Integer.parseInt(sb.reverse() + "");
         return  result;
     }

     //数组遍历
     public static String reverse2(String s){
                        //将字符串转成字符数组
         char[] array = s.toCharArray();
         String reverse  = "";
         for (int i = array.length -1 ; i >= 0; i--){
             reverse += array[i];
         }
         return reverse;
     }

     //在新字符串前面添加
     public static String reverse3(String s){
         int length = s.length();
         String reverse = ""; //新建空字符串
         for(int i = 0; i < length ; i ++){
             reverse  = s.charAt(i) + reverse; //在新字符串前面添加读取字符，实现翻转
         }

         return reverse;
     }


    public static void main(String[] args) {
        int num = 90000;
        int result = reverseInteger(num);
        System.out.println(result);

        System.out.println(reverse2("abcdefg"));
        System.out.println(reverse3("abcdefg"));

    }

}
