package JAVA.Day4;

public class Fan extends Device {

    // BONUS: Speed levels 1-5
    private int speed;

    public Fan(String name) {
        super(name);
        this.speed = 1;
    }

    public void setSpeed(int level) {
        if (!isOn) {
            System.out.println(name + " is OFF. Turn it on first.");
            return;
        }
        if (level < 1 || level > 5) {
            System.out.println("Fan speed must be between 1 (slow) and 5 (fastest).");
            return;
        }
        this.speed = level;
        System.out.println(name + " speed set to level " + speed + ".");
    }

    public int getSpeed() {
        return speed;
    }

    private String getSpeedLabel() {
        switch (speed) {
            case 1:
                return "Very Slow";
            case 2:
                return "Slow";
            case 3:
                return "Medium";
            case 4:
                return "Fast";
            case 5:
                return "Turbo";
            default:
                return "Unknown";
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("---------------------------");
        System.out.println("Device  : " + name);
        System.out.println("Type    : Fan");
        System.out.println("Status  : " + (isOn ? "ON" : "OFF"));
        if (isOn) {
            System.out.println("Speed   : Level " + speed + " (" + getSpeedLabel() + ")");
        }
        System.out.println("---------------------------");
    }
}