package ejbModule.designmode.pattern005.methods1;

/**
 * @author 包超
 * @title: ConcreteBuilder
 * @projectName DesignMode
 * @description: 具体建造者 （工人）
 * @date 2020/6/17 001721:48
 */
public class ConcreteBuilder extends Builder{

    private Product product;
    public ConcreteBuilder(){
        this.product = new Product();
    }


    @Override
    void bulidA() {
        product.setBuildA("地基");
    }

    @Override
    void bulidB() {
        product.setBuildB("钢筋工程");
    }

    @Override
    void buildC() {
        product.setBuildC("铺电线");
    }

    @Override
    void buildD() {
        product.setBuildD("粉墙");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
