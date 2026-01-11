/**
 * 手机类：普通类
 *  继承Commodity抽象类，实现ElectronicDevice接口
 */
public class MobilePhone extends Commodity implements ElectronicDevice {
    //手机特有的属性
    private String brand;
    private String system;
    public MobilePhone(String id, String name, double price, int stock, String brand, String system) throws StockInsufficientException {
        super(id, name, price, stock);
        this.brand = brand;
        this.system = system;
    }

    @Override
    public double calculateDiscountPrice() {
        return super.getPrice()*0.8;
    }

    @Override
    public void startUp() {
        System.out.println(brand + "手机正在启动" +"系统为"+ system);
    }

    @Override
    public void shutDown() {
        System.out.println(brand + "手机正在关闭" +"系统为"+ system);
    }

    @Override
    public void selfCheck() {
        System.out.println(brand + "手机正在自检" +"系统为"+ system);
    }

    public void makeCall(String number) {
        System.out.println(brand + "手机正在拨打电话" +"系统为"+ system +"号码为"+number);
    }

    @Override
    public String getCommodityInfo() {
        return super.getCommodityInfo()+" "+brand+" "+system;
    }

}
