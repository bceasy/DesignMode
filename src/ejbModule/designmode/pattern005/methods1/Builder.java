package ejbModule.designmode.pattern005.methods1;

/**
 * @author 包超
 * @title: Builder
 * @projectName DesignMode
 * @description: 建造者
 * @date 2020/6/17 001721:35
 */
public abstract class Builder {

    /**
     * 地基
     */
    abstract void bulidA();

    /**
     * 钢筋工程
     */
     abstract void bulidB();

     /**
     * 铺电线
     */
     abstract void buildC();

    /**
     * 粉墙
     */
    abstract void buildD();

    /**
     * 完工 获取产品
     */
     abstract Product getProduct();


}
