package mapper;

import dal.Subscriber;
import dal.Tariff;
import junit.framework.TestCase;
 import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
 import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.Reader;


public class SubscriberMapperTest extends TestCase {

    SubscriberMapper subscriberMapper;
    SqlSessionFactory sqlSessionFactory;
     Reader reader = null;
@BeforeTest
public void connectDB(){
    try {

        reader = Resources
            .getResourceAsReader("mybatis-config.xml");

    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
     subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
     } catch (IOException e) {
         throw new RuntimeException(e);
    }
}

@AfterTest
public void clear(){
    subscriberMapper.delete(2);


}
    @Test
    public void SubscriberTest() {


            var s = new Subscriber().setName("firstName").setId(2L);
            var tarif=new Tariff();
            tarif.setId(2L);

            s.setTariff(tarif);
            subscriberMapper.insert(s);

    }

}