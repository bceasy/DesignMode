package ejbModule.designmode.pattern005.methods2;

/**
 * @author 包超
 * @title: ConcreteBuilder
 * @projectName DesignMode
 * @description: 具体建造者(服务员)
 * @date 2020/6/17 001722:19
 */
public class ConcreteBuilder extends Builder{

    private Product product;
    public ConcreteBuilder(){
        product = new Product();
    }

    @Override
    Builder bulidA(String mes) {
        product.setBuildA(mes);
        return this;
    }

    @Override
    Builder bulidB(String mes) {
        product.setBuildB(mes);
        return this;
    }

    @Override
    Builder bulidC(String mes) {
        product.setBuildC(mes);
        return this;
    }

    @Override
    Builder bulidD(String mes) {
        product.setBuildD(mes);
        return this;
    }

    @Override
    Product build() {
        return product;
    }
}
