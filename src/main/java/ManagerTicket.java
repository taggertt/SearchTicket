public class ManagerTicket {

    private Repository repo;

    public ManagerTicket(Repository repo){
    this.repo = repo;
}

    public void addTicket(Ticket ticket){
    repo.add(ticket);
    }

    public Ticket[] getTickets() {
        Ticket[] all = repo.getTickets();
        return all;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        int copyToIndex = 0;
        int elements = 0;
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                copyToIndex++;
            }
        }
        result = new Ticket[copyToIndex];
        for (Ticket ticket: repo.getTickets()) {
            if (matches(ticket, from, to)) {
                result[elements] = ticket;
                elements++;
            }
        }
        return result;
    }
    public boolean matches (Ticket ticket, String searchFrom, String searchTo){
        if ((ticket.getDeparture().contains(searchFrom) || ticket.getArrived().contains(searchTo))) {
            return true;
        } else {
            return false;
        }
    }
}
