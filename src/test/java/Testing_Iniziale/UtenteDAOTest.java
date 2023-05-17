package Testing_Iniziale;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.ScrittoDaBean;
import gestore.model.ScrittoDaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.util.Date;

public class UtenteDAOTest {
    UtenteDAO dao = new UtenteDAO();
    UtenteBean bean = new UtenteBean();


    @BeforeEach
    public void setUp() throws Exception {
        bean.setCognome("Test");
        bean.setDatadinascita(null);
        bean.setNome("Test");
        bean.setGestore(false);
        bean.setMail("Test@java");
        bean.setPassword("TestPass");
        dao.doInsert(bean);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getMail());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveUtenteDATest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getMail())!=null);
    }

    @Test
    void doModifyTest() throws Exception{
        dao.doModifyByKey("NewPass", bean);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getMail()).getPassword(), bean.getPassword());
    }
}
