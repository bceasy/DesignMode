package ejbModule.designmode.pattern007;

/**
 *
 * 实现一个Type-c转VGA适配器，
 * 适配器实现方式有三种，这是第一种实现方式。
 * @author 包超
 * @title: Typec2Vga1
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/21 002112:19
 */
public class Typec2Vga1 extends Phone implements Vga{
    @Override
    public void vgaInterface() {
        typecPhone();
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中。。。");
        System.out.println("信息接口已转换成VGA接口，显示屏可以对接。");
    }
}
