package 反射枚举及lambda表达式;

public enum TestEnum {
    RED(1,"red"), GREEN(2,"green"), BLUE(3,"blue");

    private int ori;
    private String color;

    TestEnum(int ori, String color) {
        this.ori = ori;
        this.color = color;
    }

    public static void main(String[] args) {
        TestEnum[] testEnum = TestEnum.values();
        for (int i = 0; i < testEnum.length; i++) {
            System.out.print(testEnum[i] + "--->" + testEnum[i].ordinal());
            System.out.println();
        }
    }
}
