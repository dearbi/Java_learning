package 图书系统项目.book;

public class PairOfUidAndBookId {
    private int userId;
    private int bookId;
    public PairOfUidAndBookId(){

    }
    public PairOfUidAndBookId(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    //把对象序列化为JSON字符串的形式
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append(userId).append(",");
        json.append(bookId);
        return json.toString();
    }
}
