package ejbModule.designmode.pattern004;

/**
 * 抽象工厂 农场类
 * @author Administrator
 *
 */
public interface Farm {
	
	public Animal newAnimal();
    public Plant newPlant();

}
