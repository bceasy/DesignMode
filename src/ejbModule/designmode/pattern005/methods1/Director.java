package ejbModule.designmode.pattern005.methods1;

/**
 * @author 包超
 * @title: Director
 * @projectName DesignMode
 * @description: 指挥者
 * @date 2020/6/17 001721:52
 */
public class Director {

    public Product create(Builder builder){
        builder.bulidA();
        builder.bulidB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }

}
