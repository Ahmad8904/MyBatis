package mapper;

import dal.Tariff;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

@Test
@Guice
public class TariffMapperTest {
    private final TariffMapper tariffMapper;

    @Inject
    public TariffMapperTest(TariffMapper tariffMapper) {
        this.tariffMapper = tariffMapper;
    }

    @Test
    public void TariffTest() {

        Tariff tarif = new Tariff().setDescr("Abs").setId(1L);
        Tariff tarif2 = new Tariff().setDescr("Dce").setId(2L);

        tariffMapper.insert(tarif);
        tariffMapper.insert(tarif2);
        System.out.println(tariffMapper.getTariffById(1).getDescr());
        System.out.println(tariffMapper.getTariffById(2).getDescr());

        tariffMapper.delete(1);
        assert tariffMapper.getTariffById(1) == null;

    }



}
