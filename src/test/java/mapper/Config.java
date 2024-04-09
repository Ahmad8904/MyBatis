package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeSuite;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Reader;

public class Config {

    SubscriberMapper subscriberMapper;
    SqlSessionFactory sqlSessionFactory;
    Reader reader = null;
    @BeforeSuite
    public void connect()

    {
        try {

            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
             subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
