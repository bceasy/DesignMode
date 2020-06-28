package ejbModule.designmode.pattern007;

/**
 *
 *
 原理：借助抽象类来实现适配器功能。
 定义三个接口
 * @author 包超
 * @title: Target
 * @projectName DesignMode
 * @description: TODO
 * @date 2020/6/21 002112:32
 */
public interface Target {

    void typec();
    void typec2vga();
    void typec2hdmi();

}
