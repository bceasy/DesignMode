package ejbModule.designmode.pattern007;

/**
 * 实现一个Type-c转VGA适配器，
 * 适配器实现方式有三种，这是第二种实现方式。
 * @author 包超
 * @title: Typec2Vga2
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/21 002112:23
 */
public class Typec2Vga2 implements Vga{

    private Phone phone;

    public Typec2Vga2(Phone phone){
         this.phone = phone;
    }

    @Override
    public void vgaInterface() {

        if(phone != null){

            phone.typecPhone();
            System.out.println("接收到Type-c接口信息，信息转成Vga接口中。。。");
            System.out.println("信息已转换成VGA接口，显示屏可以对接。");
        }

    }
}
