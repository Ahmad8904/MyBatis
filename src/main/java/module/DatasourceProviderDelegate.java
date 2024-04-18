package module;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.sql.DataSource;

public class DatasourceProviderDelegate implements Provider<DataSource> {
    private final DataSource datasource;

    @Inject
    public DatasourceProviderDelegate(@Named("datasource") DataSource datasource) {
        this.datasource = datasource;
    }

    public DataSource get() {
        return this.datasource;
    }
}
