package dal;

public class Tariff {
    private Long id;
    private String descr;

    public Long getId() {
        return id;
    }
    public Tariff setId(Long id) {
        this.id = id;
        return this;
    }
    public String getDescr() {
        return descr;
    }
    public Tariff setDescr(String descr) {
        this.descr = descr;
        return this;
    }
}
