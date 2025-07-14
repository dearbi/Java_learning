package 图书系统项目.book;

import java.time.LocalDate;

public class Book implements Comparable<Book>{
    private int bookId; //书id
    private String title; // 书名
    private String author; // 作者
    private String category; // 类别
    private int publishYear; // 出版年份
    private boolean isBorrowed; // 借阅状态
    private int borrowCount; // 借阅次数
    private LocalDate shelfDate; // 上架时间

    // 构造函数，初始化图书对象 书籍ID、借阅状态和 借阅次数不⽤进⾏参数传递
    public Book(String title, String author, String category,
                int publishYear, LocalDate shelfDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publishYear = publishYear;
        this.isBorrowed = false;
        this.borrowCount = 0;
        this.shelfDate = shelfDate;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    public int getBorrowCount() {
        return borrowCount;
    }
    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }
    public void incrementBorrowCount() {
        this.borrowCount++;
    }
    public void decreaseBorrowCount() {
        this.borrowCount--;
    }
    public LocalDate getShelfDate() {
        return shelfDate;
    }
    public void setShelfDate(LocalDate shelfDate) {
        this.shelfDate = shelfDate;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ",title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publishYear=" + publishYear +
                ", isBorrowed=" + isBorrowed +
                ", borrowCount=" + borrowCount +", shelfDate=" + shelfDate +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}


