package mapper;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;


public class Config extends AbstractModule {

    public static final Version MYSQL_VERSION = Version.v5_7_latest;

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_USERNAME = "test";
    public static final String JDBC_PASSWORD = "test";
    public static final String JDBC_DATABASE = "test";
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    Reader reader = null;

    SubscriberMapper subscriberMapper;


    @Override
    protected void configure() {
        EmbeddedMysql mysql = newMysqlServer();
        bind(EmbeddedMysql.class).toInstance(mysql);

        install(new PersistenceModule());

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

    public EmbeddedMysql newMysqlServer() {
        SqlSessionFactory sqlSessionFactory;

        MysqldConfig config = aMysqldConfig(MYSQL_VERSION)
                .withPort(3307)
                .withCharset(Charset.UTF8MB4)
                .withUser(JDBC_USERNAME, JDBC_PASSWORD)
                .withServerVariable(
                        "lower-case-table-names", 1
                )
                .withServerVariable(
                        "log_bin_trust_function_creators", true
                )
                .withServerVariable(
                        "sql_mode", ""
                )
                .build();

        return EmbeddedMysql
                .anEmbeddedMysql(config)
                .addSchema("test", classPathScript("test-schema.sql"))
                .start();
    }
}
