package ejbModule.java8;

/**
 * https://www.cnblogs.com/haixiang/p/11029639.html
 * @author 包超
 * @title: J8_003Lambda
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/8/11 001123:23
 */
public class J8_003Lambda {
    public static void main(String[] args) {


        /**
         * 语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)。
         */
        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("NoReturnOneParam param:" + a);
        };
        noReturnOneParam.method(6);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
            System.out.println("NoReturnMultiParam param:" + "{" + a +"," + + b +"}");
        };
        noReturnMultiParam.method(6, 8);

        //无参有返回值
        ReturnNoParam returnNoParam = () -> {
            System.out.print("ReturnNoParam");
            return 1;
        };

        int res = returnNoParam.method();
        System.out.println("return:" + res);

        //一个参数有返回值
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };

        int res2 = returnOneParam.method(6);
        System.out.println("return:" + res2);

        //多个参数有返回值
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b +"}");
            return 1;
        };

        int res3 = returnMultiParam.method(6, 8);
        System.out.println("return:" + res3);



        /**
         * Lambda 语法简化#
         * 我们可以通过观察以下代码来完成代码的进一步简化，写出更加优雅的代码。
         */

        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam lamdba1 = (a, b) -> {
            System.out.println("简化参数类型");
        };
        lamdba1.method(1, 2);

        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NoReturnOneParam lambda2 = a -> {
            System.out.println("简化参数小括号");
        };
        lambda2.method(1);

        //3.简化方法体大括号，如果方法条只有一条语句，则可以胜率方法体大括号
        NoReturnNoParam lambda3 = () -> System.out.println("简化方法体大括号");
        lambda3.method();

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam lambda4 = a -> a+3;
        System.out.println(lambda4.method(5));

        ReturnMultiParam lambda5 = (a, b) -> a+b;
        System.out.println(lambda5.method(1, 1));


        /**
         * Lambda 表达式常用示例#
         * lambda 表达式引用方法
         * 有时候我们不是必须要自己重写某个匿名内部类的方法，我们可以可以利用 lambda表达式的接口快速指向一个已经被实现的方法。
         */
         //​语法： 方法归属者::方法名 静态方法的归属者为类名，普通方法归属者为对象
        ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println(lambda1.method(3) +"          --------------->");

        //lambda2_test 引用了已经实现的 doubleNum 方法
        ReturnOneParam lambda2_test = J8_003Lambda::doubleNum;
        System.out.println(lambda2_test.method(3));

        J8_003Lambda exe = new J8_003Lambda();

        //lambda4 引用了已经实现的 addTwo 方法
        ReturnOneParam lambda4_test = exe::addTwo;
        System.out.println(lambda4_test.method(2));



    }

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }
}
/**多参数无返回*/
@FunctionalInterface
interface NoReturnMultiParam {
    void method(int a, int b);
}

/**无参无返回值*/
@FunctionalInterface
interface NoReturnNoParam {
    void method();
}

/**一个参数无返回*/
@FunctionalInterface
interface NoReturnOneParam {
    void method(int a);
}

/**多个参数有返回值*/
@FunctionalInterface
interface ReturnMultiParam {
    int method(int a, int b);
}

/*** 无参有返回*/
@FunctionalInterface
interface ReturnNoParam {
    int method();
}

/**一个参数有返回值*/
@FunctionalInterface
interface ReturnOneParam {
    int method(int a);
}
