package generic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<Bean> {
    ArrayList<Bean> doRetrieveAll() throws SQLException;
    Bean doRetrieveByKey(Object key) throws SQLException;
    void doDeleteByKey(Object key) throws SQLException;
    void doModifyByKey(Object key, Bean bean) throws SQLException;
    void doInsert(Bean bean) throws SQLException;

}
