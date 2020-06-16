package ejbModule.designmode.pattern004;

/**
 * 抽象工厂模式
 * @author Administrator
 *
 */
public class FarmTest {

	public static void main(String[] args) {
		
		 try
	        {          
	            Farm f;
	            Animal a;
	            Plant p;
	            f=(Farm) ReadXML.getObject();
	            a=f.newAnimal();
	            p=f.newPlant();
	            a.show();
	            p.show();
	        }
	        catch(Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		
		
	}
	
}
