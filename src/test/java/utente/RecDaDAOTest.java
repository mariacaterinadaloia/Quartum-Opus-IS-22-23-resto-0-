package utente;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import org.junit.jupiter.api.*;
import utente.model.*;

import java.util.Calendar;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecDaDAOTest {
        RecDaDAO dao = new RecDaDAO();
        RecDaBean bean = new RecDaBean();

        UtenteDAO dao1 = new UtenteDAO();
        UtenteBean bean1 = new UtenteBean();
        ProdottoDAO dao2 = new ProdottoDAO();
        ProdottoBean bean2 = new ProdottoBean();
        RecensioneBean bean3 = new RecensioneBean();
        RecensioneDAO dao3 = new RecensioneDAO();

        @BeforeAll
        public void setUp() throws Exception {
            bean1.setCognome("Test");
            bean1.setDatadinascita(Calendar.getInstance().getTime());
            bean1.setNome("Test");
            bean1.setGestore(false);
            bean1.setMail("Test@java");
            bean1.setPassword("TestPass");
            bean.setUtente("Test@java");
            dao1.doInsert(bean1);
            bean3.setIdRecensione(3);
            bean3.setText("test");
            dao3.doInsert(bean3);
            bean.setRecensione(3);
            bean.setUtente("Test@java");
            dao.doInsert(bean);

        }

        @AfterAll
        public void tearDown() throws Exception {
            dao1.doDeleteByKey(bean1.getMail());
            dao3.doDeleteByKey(bean3.getIdRecensione());
        }

        @Test
        void testRetrieveAll() throws Exception {
            Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
        }

        @Test
        void retrieveByKeyTest() throws Exception {
            Assertions.assertTrue(dao.doRetrieveByKey(bean.getRecensione())!=null);
        }

}


