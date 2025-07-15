package 图书系统项目.constant;

public class Constant {
    public static final int CAPACITY = 5;
    public static final String ALL_BOOK_FILE_NAME = "D:\\java_code\\Java_learning\\JavaSE_Level1\\src\\allbooks.txt";
    //-------------------管理员相关操作管理----------------
//查找图书
    public static final int SEARCH_BOOK = 1;
    //显⽰图书
    public static final int DISPLAY_BOOK = 2;
    //退出系统
    public static final int EXIT = 3;
    //上架图书
    public static final int ADD_BOOK = 4;
    //更新图书
    public static final int UPDATE_BOOK = 5;
    //删除图书
    public static final int REMOVE_BOOK = 6;
    //查看图书的借阅次数
    public static final int BORROWED_BOOK_COUNT = 7;
    //查看受欢迎的图书
    public static final int GENERATE_BOOK = 8;
    //查看库存状态
    public static final int CHECK_INVENTORY_STATUS = 9;
    //按照类别 统计图书
    public static final int CATEGORIZE_BOOK_BY_CATEGORY = 10;
    //按照作者 统计图书
    public static final int CATEGORIZE_BOOK_BY_AUTHOR = 11;
    //移除上架超过1年的书籍
    public static final int CHECK_AND_REMOVE_OLD_BOOK = 12;
//-------------------普通⽤⼾相关操作管理----------------
//借阅图书
public static final int BORROWED_BOOK = 4;
    //归还图书
    public static final int RETURN_BOOK = 5;
    //查看个⼈借阅情况
    public static final int VIEW_BORROW_HISTORY_BOOK = 6;

}
