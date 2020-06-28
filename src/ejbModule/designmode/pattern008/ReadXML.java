package ejbModule.designmode.pattern008;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

/**
 * @author 包超
 * @title: ReadXML
 * @projectName DesignMode
 * @description: 读取配置文件
 * @date 2020/6/22 002223:02
 */
public class ReadXML {

    public static Object getObject(String args){

        try {
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=  builder.parse(new File("src\\ejbModule\\designmode\\pattern008\\config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=null;
            if(args.equals("color"))
            {
                classNode=nl.item(0).getFirstChild();
            }
            else if(args.equals("bag"))
            {
                classNode=nl.item(1).getFirstChild();
            }
            String cName="ejbModule.designmode.pattern008."+classNode.getNodeValue();
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

}
