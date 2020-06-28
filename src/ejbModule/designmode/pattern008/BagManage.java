package ejbModule.designmode.pattern008;

import javax.swing.*;
import java.awt.*;

/**
 * @author 包超
 * @title: BagManage
 * @projectName DesignMode
 * @description: 运行测试
 * @date 2020/6/22 002223:09
 */
public class BagManage {

    public static void main(String[] args) {

        Color color;
        Bag bag;
        color = (Color) ReadXML.getObject("color");
        bag = (Bag)ReadXML.getObject("bag");
        bag.setColor(color);
        String name=bag.getName();
        show(name);
    }

    public static void show(String name){
        JFrame jf = new JFrame("桥接模式测试");
        Container container = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel(new ImageIcon("static/img/pattern008/"+name+".jpg"));
        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        container.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
