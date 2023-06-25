package utente;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.ScrittoDaBean;
import gestore.model.ScrittoDaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utente.model.OrdineBean;
import utente.model.OrdineDAO;

import java.util.Date;

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
