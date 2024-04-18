package mapper;

import dal.Payment;
import dal.Tariff;
import org.testng.annotations.Test;

public class PaymentMapperTest {

PaymentMapper paymentMapper;
    @Test
    public void paymentTest() {

        var payment = new Payment();

        payment.setId(1L);
        payment.setSumma(25);

    }


}
