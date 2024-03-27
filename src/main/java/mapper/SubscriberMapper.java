
package mapper;


import dal.Subscriber;

import java.util.List;

public interface SubscriberMapper {
    Subscriber getSubscriberById(Integer id);

    List<Subscriber> getSubscriber();

}
