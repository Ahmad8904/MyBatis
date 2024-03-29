package mapper;

import dal.Subscriber;
import dal.Tariff;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

public class SubscriberMapperTest extends TestCase {

    SubscriberMapper subscriberMapper;

    @Test
    public void SubscriberTest() {
        SqlSessionFactory sqlSessionFactory;
        SubscriberMapper subscriberMapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
            var s = new Subscriber().setName("firstName").setId(3L);
            var tarif=new Tariff();
            tarif.setId(1L);

            s.setTariff(tarif);
            subscriberMapper.insert(s);
            subscriberMapper.delete(1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}