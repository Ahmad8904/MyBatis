package mapper;

import dal.Subscriber;
import dal.Tariff;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Reader;


public class SubscriberMapperTest {

    SubscriberMapper subscriberMapper;
    SqlSessionFactory sqlSessionFactory;
    Reader reader = null;


    @AfterTest
    public void clear() {
        subscriberMapper.delete(2);
    }

    @Test
    public void SubscriberTest() {
        try {

            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        var s = new Subscriber().setName("firstName").setId(2L);
        var tarif = new Tariff();
        tarif.setId(2L);

        s.setTariff(tarif);
        subscriberMapper.insert(s);

    }

}