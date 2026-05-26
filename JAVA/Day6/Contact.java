package JAVA.Day6;

public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name.trim();
        this.phone = phone.trim();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    @Override
    public String toString() {
        return String.format("  %-25s | %s", name, phone);
    }
}
