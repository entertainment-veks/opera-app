package hibernate.model.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }
}
