import com.datastax.oss.driver.api.core.CqlSession;

public class OfferTableManager extends SimpleManager {
    public OfferTableManager(CqlSession session) {
        super(session);
    }

    public void createTable() {
        executeSimpleStatement(
                "CREATE TYPE Office (\n" +
                        "    uniqueID text,\n" +
                        "    address text,\n" +
                        "    rating int\n" +
                        ");");
        executeSimpleStatement(
                "CREATE TYPE Client (\n" +
                        "    name text,\n" +
                        "    surname text,\n" +
                        "    pesel text,\n" +
                        "    phoneNumber text\n" +
                        ");");
        executeSimpleStatement(
                "CREATE TABLE Offer (\n" +
                        "    id int PRIMARY KEY,\n" +
                        "    place text\n," +
                        "    climate text\n," +
                        "    rating int\n," +
                        "    client frozen<client>,\n" +
                        "    office frozen<office>,\n" +
                        ");");
    }
}