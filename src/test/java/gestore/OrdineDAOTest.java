package gestore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;

public class OrdineDAOTest {
    OrdineDAO dao = new OrdineDAO();
    OrdineBean bean = new OrdineBean();


    @BeforeEach
    public void setUp() throws Exception {
        bean.setId(0);
        bean.setUtente("Test");
        bean.setData(null);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getId());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveOrdineTest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getId())!=null);
    }
}
