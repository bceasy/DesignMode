package ejbModule.designmode.pattern005.methods1;

/**
 * 建造者模式  方式一  参考链接：https://www.jianshu.com/p/47329a94f5dc
 * @author Administrator
 *
 */
public class Test {

    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.create(new ConcreteBuilder());
        System.out.println(product.toString());
    }

}
