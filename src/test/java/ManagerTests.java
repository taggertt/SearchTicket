import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;

public class ManagerTests {

    Repository repo = new Repository();

    ManagerTicket mt = new ManagerTicket(repo);

    Ticket ticket = new Ticket(1, 4000 , "svo" , "led" , 60);

    Ticket ticket1 = new Ticket(2, 6000, "cek", "led", 160);

    Ticket ticket2 = new Ticket(3, 5000, "dme", "ufa", 120);

    Ticket ticket3 = new Ticket(4, 4000, "cek", "ovb", 90);

    @BeforeEach
    public void setup() {
        repo.add(ticket);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
    }

    @Test
    public void searchByFewMatches() {
        Ticket[] expected = {ticket, ticket3, ticket1};
        Ticket[] actual = mt.findAll("cek", "led");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNotMatches() {
        Ticket[] expected = {};
        Ticket[] actual = mt.findAll("jfk", "lht");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneMatch() {
        Ticket[] expected = {ticket};
        Ticket[] actual = mt.findAll("svo", "jfk");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTicket() {
        repo.removeById(4);
        Ticket[] expected = {ticket, ticket2, ticket1};
        Ticket[] actual = mt.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }
}
