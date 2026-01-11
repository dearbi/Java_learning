import java.util.ArrayList;
import java.util.List;

public class JavaComprehensiveDemo {
    public static void main(String[] args) throws StockInsufficientException {
        //1. 接口静态调用
        System.out.println("===== 接口静态方法调用 =====");
        ElectronicDevice.getDeviceTypeDesc();

        //2. 类与对象：实例化普通类（手机和平板）
        MobilePhone iphone = new MobilePhone("123456", "Apple iPhone 14", 9999.99, 100, "Apple", "iOS");
        TabletPC ipad = new TabletPC("654321", "Apple iPad Pro", 12999.99, 50, 12.9);
        System.out.println("===== 类与对象：实例化普通类 =====");
        try{
            MobilePhone mobilePhone = new MobilePhone("123456", "Apple iPhone 14", 9999.99, 100, "Apple", "iOS");
            TabletPC tabletPC = new TabletPC("654321", "Apple iPad Pro", 12999.99, 50, 12.9);
        }catch(IllegalPriceException | StockInsufficientException e){
            System.out.println(e.getMessage());
        }

        // 3. 对象方法调用：普通方法、重写方法、特有方法
        System.out.println("\n===== 对象方法调用 =====");
        System.out.println(iphone.getCommodityInfo());
        System.out.println("手机折扣价：" + iphone.calculateDiscountPrice() + "元");
        iphone.startUp();
        iphone.selfCheck();
        iphone.makeCall("13800138000");
        iphone.shutDown();

        System.out.println("\n" + ipad.getCommodityInfo());
        System.out.println("平板折扣价：" + ipad.calculateDiscountPrice() + "元");
        ipad.startUp();
        ipad.selfCheck(); // 使用接口默认方法
        ipad.writeNote("Java知识点复习笔记");
        ipad.shutDown();

        // 4. 多态演示：父类引用指向子类对象
        System.out.println("\n===== 多态演示 =====");
        Commodity commodity1 = new MobilePhone("M002", "华为Mate 60", 6999, 100, "华为", "HarmonyOS 4");
        Commodity commodity2 = new TabletPC("T002", "华为MatePad", 2999, 80, 10.4);
        List<Commodity> commodityList = new ArrayList<>();
        commodityList.add(commodity1);
        commodityList.add(commodity2);
        commodityList.add(iphone);
        commodityList.add(ipad);

        // 遍历集合，演示多态特性
        for (Commodity comm : commodityList) {
            System.out.println("\n" + comm.getCommodityInfo() + "，折扣价：" + comm.calculateDiscountPrice() + "元");
            // 向下转型：调用子类特有方法
            if (comm instanceof MobilePhone) {
                MobilePhone phone = (MobilePhone) comm;
                phone.makeCall("10086");
            }
            if (comm instanceof TabletPC) {
                TabletPC tablet = (TabletPC) comm;
                tablet.writeNote("多态演示笔记");
            }
        }

        // 5. 异常处理：捕获自定义受检异常
        System.out.println("\n===== 异常捕获与处理 =====");
        MallOrderService orderService = new MallOrderService();
        try {
            // 正常下单
            orderService.placeOrder(iphone, 10);
            // 库存不足下单（触发StockInsufficientException）
            orderService.placeOrder(iphone, 50);
        } catch (StockInsufficientException e) {
            System.out.println("下单失败：" + e.getMessage());
        } finally {
            System.out.println("订单操作执行完毕（finally块始终执行）");
        }
    }
}

