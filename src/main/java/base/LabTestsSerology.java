package base;

import base.parse.CSVParser;
import base.parse.Parser;
import base.types.labTest.serology.LabTestSerology;
import base.write.Writer;
import base.write.types.SqlWriter;
import base.write.types.sql.SQLConnector;
import base.write.types.sql.SQLExecutor;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The main class for Sampler - Stage D
 */
public class LabTestsSerology {
    private Parser<CSVRecord> parser;
    private Writer<LabTestSerology> writer;

    private SQLConnector connector;
    private SQLExecutor executor;

    public LabTestsSerology() {
        try {
            this.parser = new CSVParser("serologyCsvFilePath");
            this.connector = new SQLConnector();
            this.executor = new SQLExecutor(this.connector.connect());
            this.writer = new SqlWriter<>(executor, "serologyTableName");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the table
     */
    private void createTable() {
        String createTableQuery =   "if not (exists (select   *" +
                "from   INFORMATION_SCHEMA.TABLES" +
                "where  TABLE_SCHEMA = 'LabResults' and" +
                "TABLE_NAME = 'LabResults_SerologyKits'))" +
                "begin" +
                "create table LabResults_SerologyKits (" +
                "idNum          INT," +
                "idType         INT," +
                "firstName      VARCHAR(255)," +
                "lastName       VARCHAR(255)," +
                "resultDate     DATE," +
                "birthDate      DATE," +
                "labCode        CHAR(5)," +
                "stickerNumber  VARCHAR(255)," +
                "antidotes      INT," +
                "kitNumber      INT," +
                "validAntidotes BIT";
    }

    /**
     * Streams data from csv file to the database
     */
    public void streamData() {
        // TODO

        try {
            this.connector.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
