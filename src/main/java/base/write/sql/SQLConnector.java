package base.write.sql;

import base.config.Configurations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Handles the connection to a SQL database
 */
public class SQLConnector {
    /* Connection data */
    private String dbms;
    private String server;
    private int port;
    private String dbName;

    /* Connection string */
    private String connectionString;

    /* Connection */
    private Connection connection;


    /**
     * Fetch relevant data from configurations
     * @throws IOException - If configurations reading failed
     */
    public SQLConnector() throws IOException {
        Configurations configurations = new Configurations();
        this.dbms = configurations.get("dbms");
        this.server = configurations.get("server");
        this.port = Integer.parseInt(configurations.get("port"));
        this.dbName = configurations.get("dbName");

        this.connectionString = buildConnectionString();
    }

    /**
     * Build the connection string
     * @return The connection string
     */
    private String buildConnectionString() {
        return String.format("jdbc:%s://%s:%d;databaseName=%s", this.dbms, this.server, this.port, this.dbName);
    }

    /**
     * Create a connection to the DB
     * @return The connection
     * @throws SQLException - If connection failed
     */
    public Connection connect() throws SQLException {
        this.connection = DriverManager.getConnection(this.connectionString);
        return this.connection;
    }

    /**
     * Close the connection to the DB
     * @throws SQLException - If a database access error occurs
     */
    public void close() throws SQLException {
        this.connection.close();
    }

    public String getDbms() {
        return dbms;
    }

    public String getServer() {
        return server;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public Connection getConnection() {
        return connection;
    }
}
