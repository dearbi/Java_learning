/**
 * 商城订单管理业务类
 * 处理商品下单逻辑，演示异常抛出
 */
public class MallOrderService {
    /**
     * 下单方法
     * @param commodity 要购买的商品
     * @param buyNum 购买数量
     * @throws StockInsufficientException 库存不足时抛出该受检异常
     */
    public void placeOrder(Commodity commodity, int buyNum) throws StockInsufficientException {
        // 校验库存是否充足
        if (commodity.getStock() < buyNum) {
            // 抛出库存不足异常
            throw new StockInsufficientException("商品【" + commodity.getName() + "】库存不足！当前库存：" + commodity.getStock() + "，需要购买：" + buyNum);
        }
        // 扣减库存
        commodity.setStock(commodity.getStock() - buyNum);
        System.out.println("下单成功！购买商品：" + commodity.getName() + "，数量：" + buyNum + "，剩余库存：" + commodity.getStock());
    }
}

