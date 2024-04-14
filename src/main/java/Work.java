import dal.Subscriber;
import mapper.SubscriberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Work {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        SubscriberMapper subscriberMapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
            List<Subscriber> subscribers = subscriberMapper.getSubscribers();
            Subscriber subscriber = subscriberMapper.getSubscriberById(101);
            subscriber.setName("asd");
         } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
