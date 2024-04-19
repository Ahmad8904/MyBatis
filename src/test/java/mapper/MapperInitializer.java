package mapper;

import com.google.inject.Inject;
import com.wix.mysql.EmbeddedMysql;
import dal.Subscriber;
import dal.Tariff;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.sql.DataSource;

@Test
@Guice
public class MapperInitializer {

    private final EmbeddedMysql mysql;
    private final DataSource datasource;

    private final SubscriberMapper subscriberMapper;


    @Inject
    public MapperInitializer(final SubscriberMapper subscriberMapper, final EmbeddedMysql mysql, final DataSource datasource) {
        this.mysql = mysql;
        this.datasource = datasource;
        this.subscriberMapper = subscriberMapper;

    }

    @BeforeSuite
    public void beforeSuite() throws Exception {

        datasource.getConnection();

    }

    @AfterSuite
    public void afterSuite() {

    }
}
