package 图书系统项目.utils;

import com.bit.utils.FileUtils;
import 图书系统项目.book.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnalyzingBook {
    public void storeObject(Book[] books, String filename) throws IOException
    {
        int booksUseLen = 0;
        //1.先计算有多少本有效书
        for(int i=0;i<books.length;i++){
            if(books[i] != null) {
                booksUseLen++;
            }
        }
        StringBuilder jsonArray = new StringBuilder();
        for(int i = 0; i < booksUseLen; i++){
            if(books[i] != null) {
                jsonArray.append(books[i].toJSON());
                if (i != booksUseLen-1) {
                    //⼀本书籍完成后以\n进⾏分割
                    jsonArray.append("\n");
                }
            }
            //数据写⼊⽂件
            FileUtils.writeFile(jsonArray.toString(),filename);

        }
    }
    public Book[] loadObject(String filename) throws IOException {
        //1. 从⽂件读取数据
        String content = FileUtils.readFile(filename);
        if (content == null || content.isEmpty()) {
            System.out.println("File is empty or does not exist: " + filename);
            return null;
        }
        //2. 使⽤\n作为分隔符进⾏字符串分割
        String[] bookJsonStrings = content.split("\n");
        //3. 把对应字符串“组装”成书籍对象
        Book[] bookList = new Book[bookJsonStrings.length];
        for (int i = 0;i < bookJsonStrings.length;i++) {
            Book book = parseBookJson(bookJsonStrings[i]);
            bookList[i] = book;
        }
        return bookList;
    }
    private Book parseBookJson(String json) {
        //1. 检查json是否是空的
        if(json.isEmpty()) {
            return null;
        }
        //2. 使⽤逗号分割出每个属性的值
        String[] pairs = json.split(",");
        //3. 每个属性进⾏转化赋值
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowCount = Integer.parseInt(pairs[6]);
        LocalDate shelfDate = LocalDate.parse(pairs[7]);
        if (title != null && author != null && category != null && shelfDate != null) {
            Book book = new Book(title, author, category, publishYear, shelfDate);
            book.setBorrowed(isBorrowed);
            book.setBorrowCount(borrowCount);
            book.setBookId(bookId);
            return book;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        AnalyzingBook analyzeBook = new AnalyzingBook();
        analyzeBook.loadObject("D:\\java_code\\Java_learning\\JavaSE_Level1\\src\\allbooks.txt");
    }
    public static void main1(String[] args) throws IOException {
        Book[] books = new Book[4];
        books[0] = new Book("java", "gaobo", "编程", 1994, LocalDate.of(2023, 9, 24));
        books[1] = new Book("mysql", "lisi", "编程", 1999, LocalDate.of(2024, 2, 10));
        books[2] = new Book("php", "gaobo", "编程", 2020, LocalDate.of(2023, 9, 23));
        books[3] = new Book("西游记", "吴承恩", "⼩说", 2024, LocalDate.of(2023, 9, 23));
        AnalyzingBook analyzeBook = new AnalyzingBook();
        analyzeBook.storeObject(books,"D:\\java_code\\Java_learning\\JavaSE_Level1\\src\\allbooks.txt");
    }
}
