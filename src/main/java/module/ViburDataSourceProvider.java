package module;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;
import org.vibur.dbcp.ViburDBCPDataSource;

public class ViburDataSourceProvider implements Provider<DataSource> {
    private final String jdbcDriver;
    private final String jdbcUrl;
    private final String jdbcLogin;
    private final String jdbcPassword;
    private final PoolOptions poolOptions;

    @Inject
    public ViburDataSourceProvider(@Named("jdbc.driver") String jdbcDriver, @Named("jdbc.url") String jdbcUrl, @Named("jdbc.username") String jdbcLogin, @Named("jdbc.password") String jdbcPassword, PoolOptions poolOptions) {
        this.jdbcDriver = jdbcDriver;
        this.jdbcUrl = jdbcUrl;
        this.jdbcLogin = jdbcLogin;
        this.jdbcPassword = jdbcPassword;
        this.poolOptions = poolOptions;
    }

    public ViburDataSourceProvider(@Named("jdbc.driver") String jdbcDriver, @Named("jdbc.url") String jdbcUrl, @Named("jdbc.username") String jdbcLogin, @Named("jdbc.password") String jdbcPassword) {
        this(jdbcDriver, jdbcUrl, jdbcLogin, jdbcPassword, new PoolOptions());
    }

    public DataSource get() {
        ViburDBCPDataSource ds;
        try {
            Driver driver = (Driver)Class.forName(this.jdbcDriver, true, this.getClass().getClassLoader()).newInstance();
            ds = new ViburDBCPDataSource();
            ds.setDriver(driver);
        } catch (ReflectiveOperationException var3) {
            throw new RuntimeException(var3);
        }

        ds.setDriverProperties(this.getDriverProperties());
        ds.setJdbcUrl(this.jdbcUrl);
        ds.setUsername(this.jdbcLogin);
        ds.setPassword(this.jdbcPassword);
        ds.setPoolMaxSize(this.poolOptions.poolMaxSize);
        ds.setPoolInitialSize(this.poolOptions.poolInitialSize);
        ds.setTestConnectionQuery("SELECT TRUE");
        ds.setAcquireRetryDelayInMs(this.poolOptions.retryDelayMs);
        ds.setAcquireRetryAttempts(this.poolOptions.retryAttempts);
        ds.setConnectionTimeoutInMs(TimeUnit.SECONDS.toMillis((long)this.poolOptions.connectionTimeout));
        ds.setDefaultAutoCommit(true);
        ds.setLogStackTraceForLongQueryExecution(true);
        ds.setLogQueryExecutionLongerThanMs((long)((int)TimeUnit.SECONDS.toMillis((long)this.poolOptions.queryExecutionLoggingThresholdTimeout)));
        ds.setEnableJMX(true);
        ds.start();
        return ds;
    }

    protected Properties getDriverProperties() {
        return new Properties();
    }



    public static class PoolOptions {
        @Inject(
                optional = true
        )
        @Named("vibur.pool.initial.size")
        int poolInitialSize = 10;
        @Inject(
                optional = true
        )
        @Named("vibur.pool.max.size")
        int poolMaxSize = 100;
        @Inject(
                optional = true
        )
        @Named("vibur.recovery.delay.ms")
        long retryDelayMs;
        @Inject(
                optional = true
        )
        @Named("vibur.recovery.attempts")
        int retryAttempts;
        @Inject(
                optional = true
        )
        @Named("vibur.connection.timeout.sec")
        int connectionTimeout;
        @Inject(
                optional = true
        )
        @Named("vibur.log.long.queries.threshold.sec")
        int queryExecutionLoggingThresholdTimeout;

        public PoolOptions() {
            this.retryDelayMs = TimeUnit.SECONDS.toMillis(5L);
            this.retryAttempts = 12;
            this.connectionTimeout = 60;
            this.queryExecutionLoggingThresholdTimeout = 25;
        }
    }
}
