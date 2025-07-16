package 图书系统项目.User;

import 图书系统项目.book.Library;
import 图书系统项目.book.PairOfUidAndBookId;
import 图书系统项目.constant.Constant;
import 图书系统项目.utils.AnalyzingBorrowedBook;

import java.util.Scanner;

public class NormalUser extends User {
    // ⽤⼾已借阅的图书相关信息
    private PairOfUidAndBookId[] pairOfUidAndBookIds;
    // 当前书籍的借阅量
    private int borrowedCount;
    //最多借阅的图书数量
    private static final int BORROW_BOOK_MAX_NUM = 5;
    private final AnalyzingBorrowedBook analyzingBorrowedBook = new
            AnalyzingBorrowedBook();
    private Scanner scanner = null;
    private Library library = null;
    public NormalUser(String name, int userID) {
        super(name, userID, "普通用户");
        loadBorrowedBook();
    }

    private void loadBorrowedBook() {
        PairOfUidAndBookId[] allBorrowedBook;
        try {
//1.先加载⽂件当中的借阅信息
            allBorrowedBook= analyzingBorrowedBook.loadObject(Constant.BORROWED_BOOK_FILE_NAME);
//2. 默认已借阅的图书数组⼤⼩为BORROW_BOOK_MAX_NUM，这⾥也可以定义到常量
                    pairOfUidAndBookIds = new PairOfUidAndBookId[BORROW_BOOK_MAX_NUM];
//3.没有读取到已借阅的图书信息
            if (allBorrowedBook== null) {
                borrowedCount = 0;
            } else {
//4. 查看实际读取到的数组⻓度是多少？
                int allBorrowedBookLen= allBorrowedBook.length;
//5. 如果读取到了10本书被借阅 但是当前borrowedBooks数组⻓度⼩于10
                if (allBorrowedBookLen> pairOfUidAndBookIds.length) {
//6. 按照实际情况进⾏分配数组内存
                    pairOfUidAndBookIds = new
                            PairOfUidAndBookId[allBorrowedBookLen];
                }
//7.把数据拷⻉回到 已借阅图书信息的数组当中
                for (int i = 0; i < allBorrowedBookLen; i++) {
                    pairOfUidAndBookIds[i] = allBorrowedBook[i];
                }
//8.更新当前实际借阅书籍的书籍数量
                borrowedCount = allBorrowedBookLen;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

    private void storeBorrowedBook() {
    }


    @Override
    public int display() {
        System.out.println("普通⽤⼾ " + name + " 的操作菜单:");
        System.out.println("1. 查找图书");
        System.out.println("2. 打印所有的图书");
        System.out.println("3. 退出系统");
        System.out.println("4. 借阅图书");
        System.out.println("5. 归还图书");
        System.out.println("6. 查看当前个⼈借阅情况");
        System.out.println("请选择你的操作：");
        return scanner.nextInt();

    }

    public void borrowBook(String bookName) {
        System.out.println("普通⽤⼾ " + name + " 借阅了 " + bookName);
    }

    //归还图书
    public void returnBook() {
    }

    // 查看个⼈借阅情况
    public void viewBorrowBooks() {
    }

}
