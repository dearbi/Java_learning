package 图书系统项目.User;

import java.util.Scanner;

public class AdminUser extends User{
    Scanner scanner = new Scanner(System.in);
    public AdminUser(String name, int userID) {
        super(name, userID,"管理员");
    }
    @Override
    public int display() {
        System.out.println("管理员 " + name + " 的操作菜单:");
        System.out.println("1. 查找图书");
        System.out.println("2. 打印所有的图书");
        System.out.println("3. 退出系统");
        System.out.println("4. 上架图书");
        System.out.println("5. 修改图书");
        System.out.println("6. 下架图书");
        System.out.println("7. 统计借阅次数");
        System.out.println("8. 查看最后欢迎的前K本书");
        System.out.println("9. 查看库存状态");
        System.out.println("10. 按类别统计图书 ");
        System.out.println("11. 按作者统计图书 ");
        System.out.println("12. 检查超过⼀年未下架的图书");
        System.out.println("请选择你的操作：");
        return scanner.nextInt();
    }
    public void addBook(String bookName) {
        System.out.println("管理员 " + name + " 上架了 " + bookName);
    }
    //其他操作⽅法
    //上架图书
    public void addBook() {
    }
    //图书修改 ⽀持修改书名 作者 类别
    public void updateBook() {
    }
    //删除书籍
    public void removeBook() {
    }
    //统计每本书的借阅次数
    public void borrowCount() {
    }
    //查询最受欢迎的前n本书
    public void generateBook() {
    }
    //查看库存状态
    public void checkInventoryStatus() {
    }
    //按照类别 统计图书
    public void categorizeBooksByCategory() {
    }//按照作者统计图书
    public void categorizeBooksByAuthor() {
    }
    //并移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
    }
    public void exit() {
    }
}
