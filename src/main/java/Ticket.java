import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String departure;
    protected String arrived;
    protected int timeInTravel;

    public Ticket() {
    }

    public Ticket(int id, int price, String departure, String arrived, int timeInTravel) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrived = arrived;
        this.timeInTravel = timeInTravel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public int getTimeInTravel() {
        return timeInTravel;
    }

    public void setTimeInTravel(int timeInTravel) {
        this.timeInTravel = timeInTravel;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}