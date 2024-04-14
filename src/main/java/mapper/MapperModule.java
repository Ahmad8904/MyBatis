package mapper;

import dal.Subscriber;
import mapper.SubscriberMapper;
import org.mybatis.guice.MyBatisModule;

public class MapperModule extends MyBatisModule {
    @Override
    protected void initialize() {



        addSimpleAlias(Subscriber.class);

        addMapperClass(SubscriberMapper.class);


    }
}
