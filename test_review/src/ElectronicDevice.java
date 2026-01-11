public interface ElectronicDevice {
    void startUp();
    void shutDown();
    default void selfCheck() {
        System.out.println("self check");
    }
    static void getDeviceTypeDesc() {
        System.out.println("electronic device");
    }
}
