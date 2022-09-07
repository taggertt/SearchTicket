import java.util.Arrays;

public class Repository {

    public Ticket [] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket [] tmp = new Ticket [tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets= tmp;
        Arrays.sort(tickets);
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
            tickets = tmp;
        }
        Arrays.sort(tickets);
    }

    public Ticket[] getTickets() {
        return tickets;
    }
}
