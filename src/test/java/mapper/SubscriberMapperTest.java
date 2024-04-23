package mapper;

import dal.Subscriber;
import dal.Tariff;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

@Test
@Guice
public class SubscriberMapperTest {

    private final SubscriberMapper subscriberMapper;

    @Inject
    public SubscriberMapperTest(SubscriberMapper subscriberMapper) {
        this.subscriberMapper = subscriberMapper;
    }

    @AfterTest
    public void clear() {
        subscriberMapper.delete(1);
        assert subscriberMapper.getSubscriberById(1) == null;

    }

    @Test
    public void SubscriberTest() {
        var s = new Subscriber().setName("firstName").setId(1L);
        var tarif = new Tariff();
        tarif.setId(2L);
        s.setTariff(tarif);
        subscriberMapper.insert(s);

        assert subscriberMapper.getSubscriberById(1).getName().equals(s.getName());


    }


}