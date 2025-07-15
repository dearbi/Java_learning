package 图书系统项目.User;

import 图书系统项目.book.Library;
import 图书系统项目.constant.Constant;
import 图书系统项目.utils.PermissionException;

public class ProxyUser {
    private User realUser;
    private Library library=new Library();

    public ProxyUser(User user) {
        this.realUser = user;
    }

    public User getRealUser() {
        return realUser;
    }


    private void checkRealUserWhetherAdminUser(String msg) {
        if (!(realUser instanceof AdminUser)) {
            throw new PermissionException(msg);
        }
    }

    private void cheackRealUserWhetherNoramlUser(String msg) {
        if (!(realUser instanceof NormalUser)) {
            throw new PermissionException(msg);
        }
    }

    public void borrowBook(String bookName) {
        System.out.println("Proxy: 检查⽤⼾权限");
        if (realUser instanceof NormalUser) {
            ((NormalUser) realUser).borrowBook(bookName);
        } else if (realUser instanceof AdminUser) {
            System.out.println("您没有权限借阅书籍，请以普通⽤⼾的⽅式借阅书籍");
        }
    }

    public void addBook(String bookName) {
        System.out.println("Proxy: 检查书本状态");
        if (realUser instanceof NormalUser) {
            ((AdminUser) realUser).addBook(bookName);
        } else if (realUser instanceof AdminUser) {
            System.out.println("您没有权限上架书籍，请以管理员⽤⼾的⽅式上架书籍");
        }
    }

    //其他操作
    //添加书籍操作
    public void addBook() {
        System.out.println("上架图书");
        checkRealUserWhetherAdminUser("用户没有使用权限");
        ((AdminUser)realUser).addBook();
    }

    //更新书籍操作
    public void updateBook() {
        System.out.println("更新图书");
    }

    //移除图书
    public void removeBook() {
        System.out.println("删除图书");
    }

    //查看图书的借阅次数
    public void borrowCount() {
        System.out.println("查阅图书借阅次数");
    }

    //查看最受欢迎的前K本书
    public void generateBook() {
        System.out.println("最受欢迎图书");
    }

    //查看库存状态
    public void checkInventoryStatus() {
        System.out.println("查看图书库存状态");
    }

    //按照类别 统计图书
    public void categorizeBooksByCategory() {
        System.out.println("类别统计");
    }

    //按照作者 统计图书
    public void categorizeBooksByAuthor() {
        System.out.println("作者统计");
    }

    //移除上架超过1年的书籍
    public void checkAndRemoveOldBooks() {
        System.out.println("移除1年以上的图书");
    }

    //--------------------------------普通相关⽅法-----------------------------
//
    //借阅图书
    public void borrowBook() {
        System.out.println("借阅图书");
    }

    //归还图书
    public void returnBook() {
        System.out.println("归还图书");
    }

    //查看个⼈借阅情况
    public void viewBorrowHistory() {
        System.out.println("查看借阅历史");
    }


    public void handleOperation(int choice) {
        if (realUser instanceof AdminUser) {
// 管理员操作
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                    break;
                case Constant.ADD_BOOK:
                    addBook();
                    break;
                case Constant.UPDATE_BOOK:
                    updateBook();
                    break;
                case Constant.REMOVE_BOOK:
                    removeBook();
                    break;
                case Constant.BORROWED_BOOK_COUNT:
                    borrowCount();
                    break;
                case Constant.GENERATE_BOOK:
                    generateBook();
                    break;
                case Constant.CHECK_INVENTORY_STATUS:
                    checkInventoryStatus();
                    break;
                case Constant.CATEGORIZE_BOOK_BY_CATEGORY:
                    categorizeBooksByCategory();
                    break;
                case Constant.CATEGORIZE_BOOK_BY_AUTHOR:
                    categorizeBooksByAuthor();
                    break;
                case Constant.CHECK_AND_REMOVE_OLD_BOOK:
                    checkAndRemoveOldBooks();
                    break;
                default:
                    System.out.println("⽆效的操作。");
            }
        } else if (realUser instanceof NormalUser) {
// 普通⽤⼾操作
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                case Constant.BORROWED_BOOK:
                    borrowBook();
                    break;
                case Constant.RETURN_BOOK:
                    returnBook();
                    break;
                case Constant.VIEW_BORROW_HISTORY_BOOK:
                    viewBorrowHistory();
                    break;
                default:
                    System.out.println("⽆效的操作。");
            }
        }
    }
}
