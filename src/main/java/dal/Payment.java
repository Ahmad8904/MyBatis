package dal;

public class Payment {

    private Long id;
    private Integer summa;
    private Subscriber subscriber;

    public Long getId() {
        return id;
    }
    public Payment setId(Long id) {
        this.id = id;
        return this;
    }
    public Integer getSumma() {
        return summa;
    }
    public Payment setSumma(Integer summa) {
        this.summa = summa;
        return this;
    }
    public long getSubscriber() {
        return subscriber.getId();
    }
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
     }

}
