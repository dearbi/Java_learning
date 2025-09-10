package book;

import constant.Constant;
import utils.AnalyzingBook;

import java.awt.print.Book;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class Library {

    private Book[] books;//当前图书数组
    private int bookCount;//实际存储的图书数量
    private AnalyzingBook analyzingBook = new AnalyzingBook();

    private static Library library ;

    public Scanner scanner = new Scanner(System.in);


    private Library() {
        loadAllBook();
    }


    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public static Library getLibrary() {
        if(library == null) {
            library = new Library();
        }
        return library;
    }

    //
    private void loadAllBook() {
        Book[] allBook = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
        books = new Book[Constant.DEFAULT_CAPACITY];
        if(allBook == null) {
            bookCount = 0;
        }else {
            int allBookLen = allBook.length;
            //3、10         5
            if(allBookLen > books.length) {
                books = new Book[allBookLen];
            }

            //拷贝读取到的元素 到内存books数组
            for (int i = 0; i < allBookLen; i++) {
                books[i] = allBook[i];
            }

            bookCount = allBookLen;
        }

    }


    private void storeBook() {
       analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
    }




    public void displyBook() {
        System.out.println("显示书籍");
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }

    }

    public void exit() {
        System.out.println("退出系统");
        System.exit(0);
    }

    public void addBook(Book book) {
        System.out.println("上架书籍...");
        //上架书籍
        if(bookCount >= books.length) {
            System.out.println("书架满了，不能存放了....");
            //TODO: 扩容
            return;
        }

        books[bookCount] = book;
        //当前书架的第一本树
        if(bookCount == 0) {
            book.setBookId(1);
        }else {
            //获取当前数组最后一本书
            Book bookLast = books[bookCount-1];
            book.setBookId(bookLast.getBookId()+1);
        }

        bookCount++;

        //写入文件（实时更新书籍信息到文件）
        storeBook();
        System.out.println("图书上架成功！！ 图书的名称是："+book.getTitle());
    }

    /*
    1,java,zhangsan,编程,1994,false,0,2023-09-24
    0,mysql,lisi,编程,1999,false,0,2024-02-10
    0,php,wangwu,编程,2020,false,0,2023-09-23
    0,西游记,吴承恩,小说,2024,false,0,2023-09-23
     */

    /**
     * 根据书籍Id 查找对应的书籍
     * @param bookId
     * @return
     */
    public Book searchById(int bookId) {

        for (int i = 0; i < bookCount; i++) {
            if(books[i].getBookId() == bookId) {
                return books[i];
            }
        }
        return null;
    }


    public void updateBook(Book book) {
        storeBook();
        System.out.println("更新书籍成功，更新后书籍信息如下：");
        System.out.println(book);
    }




    public void searchBook() {
        System.out.println("请输入你要查找的图书的名称：");
        String title = scanner.nextLine();

        Book book = searchBookByTitle(title);
        if(book == null) {
            System.out.println("没有你要查找的这本书！");
            return;
        }

        System.out.println("找到了你要查找的书，书的详细信息如下：");
        System.out.println(book);
    }

    public Book searchBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(int bookId) {
        loadAllBook();
        int index = searchByIdReturnIndex(bookId);
        if(index == -1) {
            System.out.println("没有你要删除的图书...");
            return;
        }
        int i = index;
        //i < 4-1  i<3  i===2  防止越界
        for (; i < bookCount-1; i++) {
            books[i] = books[i+1];
        }

        //books[i] = null;
        books[bookCount-1] = null;

        bookCount--;

        storeBook();
    }

    private int searchByIdReturnIndex(int bookId) {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getBookId()==bookId) {
                return i;
            }
        }
        return -1;
    }


    public void borrowCount() {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println("书籍名称："+book.getTitle()+" 借阅次数："+book.getBorrowCount());
        }
    }


    public void generateBook(int k) {
        loadAllBook();
        //2.把所有书籍放在 临时数据 进行排序
        Book[] tmp = new Book[getBookCount()];
        for (int i = 0; i < getBookCount(); i++) {
            tmp[i] = books[i];
        }

        Arrays.sort(tmp);//从大 到小的 排序

        //3. 把前k本书拷贝到新数组   可以不定义临时数组，直接输出前K个就行
        Book[] generateBooks = new Book[k];

        for (int i = 0; i < k; i++) {
            generateBooks[i] = tmp[i];
        }

        System.out.println("最受欢迎的前K本书如下：");
        for (int i = 0; i < k; i++) {
            Book book = generateBooks[i];
            System.out.println("书名："+ book.getTitle()+" 作者："+
                    book.getTitle()+" 借阅次数："+book.getBorrowCount());
        }


    }

    public void checkInventoryStatus() {
        loadAllBook();

        System.out.println("----------------------------");
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            String status = book.isBorrowed() ? "已借出" : "在馆";
            System.out.println("书名："+book.getTitle()+" 目前状态："+status);
        }
        System.out.println("----------------------------");
    }

    public void checkAndRemoveOldBooks() {
        loadAllBook();
        // 获取当前时间戳
        long currentTimestamp = System.currentTimeMillis();

        // 将当前时间戳转换为 LocalDate
        LocalDate currentDate = Instant.ofEpochMilli(currentTimestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();


        boolean flg = false;
        for (int i = 0; i < getBookCount(); i++) {
            Book book = books[i];
            //获取当前书籍的上架时间
            LocalDate specifiedDate = book.getShelfDate();

            // 计算两个日期之间的差值（以年为单位）
            long yearsBetween = ChronoUnit.YEARS.between(specifiedDate, currentDate);

            if(yearsBetween >= 1) {
                System.out.print("图书 " + book.getTitle() + " 已经上架超过一年，是否移除？ (y/n)：");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    //确认删除调用remove方法进行删除
                    removeBook(book.getBookId());
                    i--;  // 因为后面的书已经向前移动，所以要重新检查当前索引位置
                }
                flg = true;
            }
        }
        if(!flg) {
            System.out.println("没有上架超过一年的图书！");
        }
        storeBook();
    }


    public void borrowBook(int bookId) {
        loadAllBook();

        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getBookId() == bookId) {
                book.setBorrowed(true);
                book.incrementBorrowCount();
            }
        }

        storeBook();
    }

    public void returnBook(int bookId) {
        loadAllBook();

        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getBookId() == bookId) {
                book.setBorrowed(false);
                book.decreaseBorrowCount();
            }
        }

        storeBook();
    }
}
