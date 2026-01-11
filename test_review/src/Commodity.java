public abstract class Commodity {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Commodity(String id, String name, double price, int stock) throws StockInsufficientException {
        // 检查价格是否合法
        if (price <= 0) {
            throw new IllegalPriceException("price must be greater than 0");
        }
        // 检查库存是否合法
        if (stock < 0) {
            throw new StockInsufficientException("stock must be greater than or equal to 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }
    //普通方法：获取商品信息
    public String getCommodityInfo() {
        return "商品编号: " + id + ", 商品名称: " + name + ", 商品价格: " + price + ", 商品库存: " + stock;
    }
    //抽象方法：计算商品折扣价
    public abstract double calculateDiscountPrice();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
