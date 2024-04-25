package mapper;

import dal.Payment;
import dal.Subscriber;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

@Test
@Guice
public class PaymentMapperTest {

    private final PaymentMapper paymentMapper;

    @Inject
    public PaymentMapperTest(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }


    @Test
    public void PaymentTest() {

        var subscriber = new Subscriber();
        subscriber.setId(1L);
        Payment s = new Payment().setId(1L).setSumma(15);

        s.setSubscriber(subscriber);

        paymentMapper.insert(s);

        paymentMapper.delete(1);
        assert paymentMapper.getPaymentsById(1) == null;


    }
}
