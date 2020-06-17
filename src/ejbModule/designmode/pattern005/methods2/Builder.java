package ejbModule.designmode.pattern005.methods2;

import ejbModule.designmode.pattern005.methods2.Product;

/**
 * @author 包超
 * @title: Builder
 * @projectName DesignMode
 * @description: 建造者
 * @date 2020/6/17 001722:11
 */
public abstract class Builder {

    //汉堡
    abstract Builder bulidA(String mes);
    //饮料
    abstract Builder bulidB(String mes);
    //薯条
    abstract Builder bulidC(String mes);
    //甜品
    abstract Builder bulidD(String mes);
    //获取套餐
    abstract Product build();


}
