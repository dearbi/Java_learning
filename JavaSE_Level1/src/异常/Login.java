package 异常;

public class Login {
    public String username="bit";
    public String password="123";

    public void loginInfo(String username, String password) throws UserNameException, PasswordException {
        if (!this.username.equals(username)) {
//            System.out.println("用户名有问题...");
            throw new UserNameException();
//            return;
        }
        if (!this.password.equals(password)) {
//            System.out.println("密码有问题...");
            throw new PasswordException();

//            return;
        }
        System.out.println("登录成功！");
    }

    public static void main(String[] args) {
        Login login = new Login();
        try {
            login.loginInfo("bit", "1223");
        } catch (UserNameException e) {
            System.out.println("捕获了User异常");
        }
        catch (PasswordException e){
            System.out.println("捕获了Password异常");
        }
    }
}