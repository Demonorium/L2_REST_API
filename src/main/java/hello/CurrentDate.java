package hello;

public class CurrentDate {
    private final String date;
    private final String time;

    public CurrentDate(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
