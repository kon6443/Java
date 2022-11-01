package practice.beans;

public class Device {
    private Battery battery;
    public Device() {
        this.battery = new Battery();
    }
    public void setBattery(Battery battery) {
        this.battery = battery;
    }
    public Battery getBattery() {
        return this.battery;
    }
}
