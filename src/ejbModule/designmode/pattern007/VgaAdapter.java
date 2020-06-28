package ejbModule.designmode.pattern007;

/**
 * 实现一个VGA适配器,同理还可以实现一个HDMI适配器
 * 适配器实现方式有三种，这是第三种实现方式。
 * @author 包超
 * @title: VgaAdapter
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/21 002112:36
 */
public class VgaAdapter extends Adapter{

    public void typec(){
        System.out.println("信息从Typec口的手机输出。");
    }

    public void typec2vga(){
        System.out.println("接收到Type-c接口，信息转成VGA接口中。。。");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }

}
