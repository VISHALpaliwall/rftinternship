package JAVA.Day4;

public class AC extends Device {

    // BONUS: Temperature control
    private int temperature; // in Celsius
    private String mode; // Cool, Heat, Fan

    public AC(String name) {
        super(name);
        this.temperature = 24;
        this.mode = "Cool";
    }

    public void setTemperature(int temp) {
        if (!isOn) {
            System.out.println(name + " is OFF. Turn it on first.");
            return;
        }
        if (temp < 16 || temp > 30) {
            System.out.println("Temperature must be between 16°C and 30°C.");
            return;
        }
        this.temperature = temp;
        System.out.println(name + " temperature set to " + temperature + "°C.");
    }

    public void setMode(String mode) {
        if (!isOn) {
            System.out.println(name + " is OFF. Turn it on first.");
            return;
        }
        String m = mode.trim().toLowerCase();
        if (m.equals("cool") || m.equals("heat") || m.equals("fan")) {
            this.mode = mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase();
            System.out.println(name + " mode set to " + this.mode + ".");
        } else {
            System.out.println("Invalid mode. Choose: Cool, Heat, or Fan.");
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("---------------------------");
        System.out.println("Device  : " + name);
        System.out.println("Type    : AC");
        System.out.println("Status  : " + (isOn ? "ON" : "OFF"));
        if (isOn) {
            System.out.println("Temp    : " + temperature + "°C");
            System.out.println("Mode    : " + mode);
        }
        System.out.println("---------------------------");
    }
}