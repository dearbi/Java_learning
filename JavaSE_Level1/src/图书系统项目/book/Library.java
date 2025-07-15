package 图书系统项目.book;

import 图书系统项目.constant.Constant;
import 图书系统项目.utils.AnalyzingBook;

import java.io.IOException;

public class Library {
    private Book[] books;//当前图书数组
    private int bookCount;//实际存储的图书数量
    private AnalyzingBook analyzingBook = new AnalyzingBook();
    private static Library library=Library.getInstance();

    public Library() {
        //当调⽤该构造⽅法的时候，要加载⽂件当中的数据进⾏到books数组当中
        loadAllBook();
    }
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }

    private void loadAllBook()  {
        try {
             //1. 读取⽂件内容
            Book[] allBook =
                    analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
                //默认⼤⼩为5
            books = new Book[Constant.CAPACITY];
                //2. 是否有数据 没有数据 有效书籍个数为 0
            if (allBook == null) {
                bookCount = 0;
            } else {
                //3. 查看实际书籍⻓度是多少 是否⼤于默认的⻓度5
                int allBookLen = allBook.length;
                //3.1 ⼤于默认⻓度 books数组 分配实际的⼤⼩
                if (allBookLen > books.length) {
                //按照实际情况进⾏分配数组内存
                    books = new Book[allBookLen];
                }
                //3.2 把读到的元素进⾏赋值
                for (int i = 0; i < allBookLen; i++) {
                    books[i] = allBook[i];
                }
                //4.修改实际有效书籍个数
                bookCount = allBookLen;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //存储图书到⽂件中
    private void storeBook() {
        try {
            analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void searchBook() {
        System.out.println("查找图书");
    }

    public void displayBooks() {
        System.out.println("显示书籍");
    }

    public void exit() {
        System.out.println("退出系统");
    }

    public void addBook(Book book) {
        System.out.println("上架书籍");
    }
}
