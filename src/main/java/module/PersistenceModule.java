package module;

import com.google.inject.name.Names;

import mapper.PaymentMapper;
import mapper.SubscriberMapper;
import mapper.TariffMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

import javax.sql.DataSource;

public class PersistenceModule extends MyBatisModule {

    @Override
    protected void initialize() {
        bind(String.class).annotatedWith(Names.named("mybatis.environment.id")).toInstance("development");

        bind(DataSource.class).annotatedWith(Names.named("datasource")).toProvider(ViburDataSourceProvider.class);
        bindDataSourceProviderType(DatasourceProviderDelegate.class);

        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(SubscriberMapper.class);
        addMapperClass(PaymentMapper.class);
        addMapperClass(TariffMapper.class);


    }
}
