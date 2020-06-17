package ejbModule.designmode.pattern005.methods2;

/**
 * @author 包超
 * @title: Product
 * @projectName DesignMode
 * @description: 产品（麦当劳套餐）
 * @date 2020/6/17 001722:12
 */
public class Product {

    private String buildA = "汉堡";
    private String buildB = "饮料";
    private String buildC = "薯条";
    private String buildD = "甜品";

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}' + "组成套餐";
    }
}
