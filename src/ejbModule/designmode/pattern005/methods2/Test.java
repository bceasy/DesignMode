package ejbModule.designmode.pattern005.methods2;

/**
 * @author 包超
 * @title: Test
 * @projectName DesignMode
 * @description: 测试
 * @date 2020/6/17 001722:31
 */
public class Test {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Product build = concreteBuilder.bulidA("牛肉煲").bulidD("冰淇淋").build();
        System.out.println(build.toString());
    }


}
