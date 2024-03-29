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
    public Subscriber setId(Long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Subscriber setName(String name) {
        this.name = name;
        return this;
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
