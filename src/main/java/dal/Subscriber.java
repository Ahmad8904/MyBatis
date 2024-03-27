package dal;


 import java.sql.Connection;
 import java.util.List;

public class Subscriber {
    private Long id;
    private String name;
    private Tariff tariff;
    private List<Payment> payments;
    private List<Connection> connections;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Tariff getTariff() {
        return tariff;
    }
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
    public List<Payment> getPayments() {
        return payments;
    }
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    public List<Connection> getConnections() {
        return connections;
    }

}
