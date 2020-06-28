package ejbModule.designmode.pattern008;

/**
 * @author 包超
 * @title: Wallet
 * @projectName DesignMode
 * @description: 扩展抽象化角色： 钱包
 * @date 2020/6/22 002223:00
 */
public class Wallet extends Bag{

    @Override
    public String getName() {
        return color.getColor() + "Wallet";
    }
}
