package ejbModule.designmode.pattern004;

/**
 * 具体工厂：韶关农场类
 * @author Administrator
 *
 */
public class SGfarm implements Farm {

	@Override
	public Animal newAnimal() {
		System.out.println("新牛出生！");
		Animal animal = new Cattle();
		return animal;
	}

	@Override
	public Plant newPlant() {
		System.out.println("蔬菜长成！");
		return new Vegetables();
	}

}
