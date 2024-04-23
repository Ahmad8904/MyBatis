package mapper;

import com.google.inject.Inject;
import com.wix.mysql.EmbeddedMysql;
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

    @Inject
    public MapperInitializer( final EmbeddedMysql mysql, final DataSource datasource) {
        this.mysql = mysql;
        this.datasource = datasource;
    }

    @AfterSuite
    public void afterSuite() {
        mysql.stop();
    }
}
