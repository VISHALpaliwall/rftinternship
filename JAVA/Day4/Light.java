package JAVA.Day4;

public class Light extends Device {

    private int brightness; // 1 to 100

    public Light(String name) {
        super(name);
        this.brightness = 100;
    }

    public void setBrightness(int level) {
        if (!isOn) {
            System.out.println(name + " is OFF. Turn it on first.");
            return;
        }
        if (level < 1 || level > 100) {
            System.out.println("Brightness must be between 1 and 100.");
            return;
        }
        this.brightness = level;
        System.out.println(name + " brightness set to " + brightness + "%.");
    }

    @Override
    public void displayStatus() {
        System.out.println("---------------------------");
        System.out.println("Device  : " + name);
        System.out.println("Type    : Light");
        System.out.println("Status  : " + (isOn ? "ON" : "OFF"));
        if (isOn) {
            System.out.println("Brightness: " + brightness + "%");
        }
        System.out.println("---------------------------");
    }
}