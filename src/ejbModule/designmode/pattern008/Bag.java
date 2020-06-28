package ejbModule.designmode.pattern008;

/**
 * @author 包超
 * @title: Bag
 * @projectName DesignMode
 * @description: 抽象化角色：包
 * @date 2020/6/22 002222:55
 */
public abstract class Bag {

    protected Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public abstract String getName();

}
