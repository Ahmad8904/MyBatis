package mapper;

import dal.Payment;

import java.util.List;

public interface PaymentMapper {
    List<Payment> getPaymentsByIdSub(Integer id);
}
