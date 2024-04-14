package mapper;

import com.google.inject.Inject;
import dal.Subscriber;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;


public class Config  {

    SubscriberMapper subscriberMapper;
    SqlSessionFactory sqlSessionFactory;
    @Inject
    private SqlSession sqlSession; //This is to demonstrate injecting SqlSession object

    Reader reader = null;
    @Test

    public void insertUser(Subscriber subscriber)
    {
        SubscriberMapper subscriberMapper1 = sqlSession.getMapper(SubscriberMapper.class);
        subscriberMapper1.delete(2);
    }
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
