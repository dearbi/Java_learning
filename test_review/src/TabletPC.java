public class TabletPC extends Commodity implements ElectronicDevice {
    private double screenSize;

    public TabletPC(String id, String name, double price, int stock, double screenSize) throws StockInsufficientException {
        super(id, name, price, stock);
        this.screenSize = screenSize;
    }

    @Override
    public double calculateDiscountPrice() {
        return getPrice() * 0.75;
    }

    @Override
    public void startUp() {
        System.out.println(screenSize + "英寸平板正在启动...");
    }

    @Override
    public void shutDown() {
        System.out.println(screenSize + "英寸平板正在关闭...");
    }
    public void writeNote(String content) {
        System.out.println(screenSize + "英寸平板正在写笔记..."+content);
    }

    @Override
    public String getCommodityInfo() {
        return super.getCommodityInfo()+" 屏幕尺寸："+screenSize;
    }
}
