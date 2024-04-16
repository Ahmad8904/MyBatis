package mapper;

import com.google.inject.Inject;
import dal.Subscriber;
import dal.Tariff;
 import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class SubscriberMapperTest  {

   @Inject
   SubscriberMapper subscriberMapper;

    @AfterTest
    public void clear() {
        subscriberMapper.delete(2);
    }

    @Test
    public void SubscriberTest() {
//        subscriberMapper = session.getMapper(SubscriberMapper.class);
        var s = new Subscriber().setName("firstName").setId(2L);
        var tarif = new Tariff();
        tarif.setId(2L);

        s.setTariff(tarif);
        subscriberMapper.insert(s);

    }


}