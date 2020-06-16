package ejbModule.designmode.pattern004;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class ReadXML {
	public static Object getObject()
    {
        try
        {
        	
        	// (1) javax.xml.parsers 包中的DocumentBuilderFactory用于创建DOM模式的解析器对象 ， 
        	// DocumentBuilderFactory是一个抽象工厂类，它不能直接实例化，但该类提供了一个newInstance方法 ，
        	// 这个方法会根据本地平台默认安装的解析器，自动创建一个工厂的对象并返回
        	
        	//(2)调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂。
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            //(3) 调用工厂对象的 newDocumentBuilder方法得到 DOM 解析器对象。
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;                           
            doc=builder.parse(new File("src\\ejbModule\\designmode\\pattern004\\config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            //包路径下的类名
            String cName="ejbModule.designmode.pattern004."+classNode.getNodeValue();
            System.out.println("新类名："+cName);
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }  
        catch(Exception e)
        {
               e.printStackTrace();
               return null;
        }
    }
}
