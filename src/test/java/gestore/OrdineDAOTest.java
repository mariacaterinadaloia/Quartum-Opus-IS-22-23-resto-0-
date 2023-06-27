package gestore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.util.Calendar;
import java.util.Date;

public class OrdineDAOTest {
    OrdineDAO dao = new OrdineDAO();
    OrdineBean bean = new OrdineBean();

    UtenteDAO dao1 = new UtenteDAO();
    UtenteBean bean1 = new UtenteBean();
    @BeforeEach
    public void setUp() throws Exception {
        bean1.setCognome("Test");
        bean1.setDatadinascita(Calendar.getInstance().getTime());
        bean1.setNome("Test");
        bean1.setGestore(false);
        bean1.setMail("Test@java1");
        bean1.setPassword("TestPass");
        bean.setUtente("Test@java");
        dao1.doInsert(bean1);
        bean.setId(0);
        bean.setUtente("Test@java");
        bean.setData(Calendar.getInstance().getTime());
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
