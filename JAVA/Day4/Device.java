package JAVA.Day4;

public abstract class Device {

    protected String name;
    protected boolean isOn;

    public Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    // Each device displays its own status — must override
    public abstract void displayStatus();
}
