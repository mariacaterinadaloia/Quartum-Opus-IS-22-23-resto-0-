package utente;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utente.model.*;

public class RecDaDAOTest {
        RecDaDAO dao = new RecDaDAO();
        RecDaBean bean = new RecDaBean();

        UtenteDAO dao1 = new UtenteDAO();
        UtenteBean bean1 = new UtenteBean();
        ProdottoDAO dao2 = new ProdottoDAO();
        ProdottoBean bean2 = new ProdottoBean();
        RecensioneBean bean3 = new RecensioneBean();
        RecensioneDAO dao3 = new RecensioneDAO();

        @BeforeEach
        public void setUp() throws Exception {
            bean1.setCognome("Test");
            bean1.setDatadinascita(null);
            bean1.setNome("Test");
            bean1.setGestore(false);
            bean1.setMail("Test@java");
            bean1.setPassword("TestPass");
            bean.setUtente("Test@java");
            dao1.doInsert(bean1);
            bean3.setIdRecensione(1000);
            bean3.setText("test");
            dao3.doInsert(bean3);
            bean.setRecensione(1000);
            bean.setUtente("Test@java");
            dao.doInsert(bean);

        }

        @AfterEach
        public void tearDown() throws Exception {
            dao.doDeleteByKey(bean.getRecensione());
        }

        @Test
        void testRetrieveAll() throws Exception {
            Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
        }

        @Test
        void retrieveUtenteDATest() throws Exception {
            Assertions.assertTrue(dao.doRetrieveByKey(bean.getRecensione())!=null);
        }

        @Test
        void doModifyTest() throws Exception{
            dao.doModifyByKey("NewPass", bean);
            Assertions.assertEquals(dao.doRetrieveByKey(bean.getRecensione()).getUtente(), bean.getUtente());
        }
}


