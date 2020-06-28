package ejbModule.designmode.pattern008;

/**
 * @author 包超
 * @title: HandBag
 * @projectName DesignMode
 * @description: 扩展抽象化角色：挎包
 * @date 2020/6/22 002222:57
 */
public class HandBag extends Bag{


    @Override
    public String getName() {
        return color.getColor() + "HandBag";
    }

}
