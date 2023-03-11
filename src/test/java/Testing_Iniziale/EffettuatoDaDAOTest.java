package Testing_Iniziale;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.EffettuatoDaBean;
import gestore.model.EffettuatoDaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class EffettuatoDaDAOTest {
    EffettuatoDaDAO dao = new EffettuatoDaDAO();
    EffettuatoDaBean bean = new EffettuatoDaBean();


    @BeforeEach
    public void setUp() throws Exception {
        bean.setOrdine(9);
        bean.setUtente("tester");
        dao.doInsert(bean);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getOrdine());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue((dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveAutoreTest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getOrdine())!=null);
    }

    @Test
    void doRertrieveByUserTest() throws Exception{
        Assertions.assertTrue(!dao.getOrdersbyUser("tester").isEmpty());
    }
}
