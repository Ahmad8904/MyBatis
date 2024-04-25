package mapper;

import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.ScriptResolver.classPathScript;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import module.PersistenceModule;
import org.apache.ibatis.session.SqlSessionFactory;



public class Config extends AbstractModule {

    public static final Version MYSQL_VERSION = Version.v5_7_latest;

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_USERNAME = "test";
    public static final String JDBC_PASSWORD = "test";
    public static final String JDBC_DATABASE = "test";

    @Override
    protected void configure() {
        EmbeddedMysql mysql = newMysqlServer();
        bind(EmbeddedMysql.class).toInstance(mysql);

        /*
            Connection pool parameters
         */
        bindConstant().annotatedWith(Names.named("jdbc.url")).to(
                String.format("jdbc:mysql://localhost:%d/test?autoReconnect=true",mysql.getConfig().getPort())
        );

        bindConstant().annotatedWith(Names.named("jdbc.driver")).to(JDBC_DRIVER);
        bindConstant().annotatedWith(Names.named("jdbc.username")).to(JDBC_USERNAME);
        bindConstant().annotatedWith(Names.named("jdbc.password")).to(JDBC_PASSWORD);

        install(new PersistenceModule());

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
