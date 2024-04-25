package mapper;

import dal.Payment;

import java.util.List;

public interface PaymentMapper {
    Payment getPaymentsById(Integer id);

    void insert(Payment payment);
    void delete(int id);

}
