package 接口2.克隆接口;

public class Money implements Cloneable{
    public double money=9.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
