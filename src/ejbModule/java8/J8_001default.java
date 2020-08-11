package ejbModule.java8;

/**
 *
 * https://www.jianshu.com/p/0bf8fe0f153b
 * @author 包超
 * @title: J8_001default
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/8/11 001121:34
 */
public interface J8_001default {
    double calculate(int a);

    //Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
    default double sqrt(int a){
        //平方根
        return Math.sqrt(a);
    }

    public static void main(String[] args) {

        J8_001default j8_001default = new J8_001default() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(j8_001default.calculate(100));
        System.out.println(j8_001default.sqrt(16));

    }
}
