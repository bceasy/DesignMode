package ejbModule.designmode.pattern007;

/**
 *
 * 定义一个显示屏
 * 与适配器对接
 * @author 包超
 * @title: Screen
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/21 002112:38
 */
public class Screen {
    //https://www.cnblogs.com/luohanguo/p/10334291.html
    public static void main(String[] args) {
        //第一种适配器用法
        System.out.println("-------------第一种适配器------------");
        Vga vga = new Typec2Vga1();
        vga.vgaInterface();
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");

        //第二种适配器用法
        System.out.println("-------------第二种适配器------------");
        Vga vga1 = new Typec2Vga2(new Phone());
        vga1.vgaInterface();
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");

        //第三种适配器用法
        System.out.println("-------------第三种适配器------------");
        VgaAdapter adapter = new VgaAdapter();
        adapter.typec();
        adapter.typec2vga();
        adapter.typec2hdmi();
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");
    }

}
