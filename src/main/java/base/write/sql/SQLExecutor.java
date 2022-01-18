package base.write.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Handles the execution of queries to the database
 */
public class SQLExecutor {
    private Connection connection;
    private Statement statement;


    /**
     * Creates statement from given connection
     * @param connection - The conenction to execute queries on
     * @throws SQLException - If statement creation failed
     */
    public SQLExecutor(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    /**
     * Adds given query to list of queries to be executed
     * @param query - query to be added
     * @throws SQLException - If a database access error occurs
     */
    public void addBatch(String query) throws SQLException {
        this.statement.addBatch(query);
    }

    /**
     * Flushes current batch to the database
     * @return Result as int array of values representing amount of rows effected by each query in batch
     * @throws SQLException - If database access error occurs, or invalid query in batch
     */
    public int[] flush() throws SQLException {
        return this.statement.executeBatch();
    }

    /**
     * Executes a DDL query
     * @param query - The DDL query to be executed
     * @return True if execution returned Result Set, false otherwise
     * @throws SQLException - If database access error occurs, or timeout error
     */
    public boolean executeDDL(String query) throws SQLException {
        return this.statement.execute(query);
    }

    /**
     * Executes an update query
     * @param query - The update (insert / delete / update) query to be executed
     * @return Amount of rows effected
     * @throws SQLException - if database access error occurs, or timeout error
     */
    public int executeUpdate(String query) throws SQLException {
        return this.statement.executeUpdate(query);
    }

    /**
     * Executes a select query
     * @param query  - The select query to be executed
     * @return Result set returned from the database
     * @throws SQLException - If database access error occurs, or timeout error
     */
    public ResultSet executeSelect(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }
}
