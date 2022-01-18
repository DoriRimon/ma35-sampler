package base.write.types;

import base.config.Configurations;
import base.write.Writer;
import base.write.types.sql.SQLExecutor;

import java.io.IOException;

public class SqlWriter<T> implements Writer<T> {
    private SQLExecutor executor;
    private String table;

    public SqlWriter(SQLExecutor executor, String tableKey) throws IOException {
        Configurations configurations = new Configurations();

        this.executor = executor;
        this.table = configurations.get(tableKey);
    }

    @Override
    public void write(T object) throws IOException {
        // TODO
        // String insertQuery = String.format("INSERT INTO %s VALUES (", this.table);
    }

    @Override
    public void flush() throws IOException {

    }
}
