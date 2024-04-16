package mapper;

import org.mybatis.guice.MyBatisModule;

public class PersistenceModule extends MyBatisModule {
    @Override
    protected void initialize() {
        addMapperClass(SubscriberMapper.class);
        addMapperClass(PaymentMapper.class);

    }
}
