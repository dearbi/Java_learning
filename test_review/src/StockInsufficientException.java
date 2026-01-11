public class StockInsufficientException extends Exception {
    public StockInsufficientException(String message) {
        super(message);
    }
    public StockInsufficientException(){
        super();
    }

}
