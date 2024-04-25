package mapper;

import dal.Tariff;


public interface TariffMapper {

    Tariff getTariffById(Integer id);

    void insert(Tariff tariff);
    void delete(int id);

}
