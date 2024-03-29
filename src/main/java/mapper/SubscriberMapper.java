
package mapper;


import dal.Subscriber;

import java.util.List;

public interface SubscriberMapper {
    Subscriber getSubscriberById(Integer id);

    List<Subscriber> getSubscribers();

    void insert(Subscriber subscriber);

    void delete(int id);


}
