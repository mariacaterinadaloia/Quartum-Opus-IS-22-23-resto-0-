package utente;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utente.model.RecensioneBean;
import utente.model.RecensioneDAO;

public class RecensioneDAOTest {
    RecensioneDAO dao = new RecensioneDAO();
    RecensioneBean bean = new RecensioneBean();
    @BeforeEach
    public void setUp() throws Exception{
        bean.setIdRecensione(1000);
        bean.setText("test");
        dao.doInsert(bean);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getIdRecensione());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveUtenteDATest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getIdRecensione())!=null);
    }

    @Test
    void doModifyTest() throws Exception{
        dao.doModifyByKey("NewPass", bean);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getIdRecensione()).getText(), bean.getText());
    }
}
