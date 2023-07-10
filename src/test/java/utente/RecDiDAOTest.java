package utente;

import gestore.ProdottoDAOTest;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import org.junit.jupiter.api.*;
import utente.model.RecDiBean;
import utente.model.RecDiDAO;
import utente.model.RecensioneBean;
import utente.model.RecensioneDAO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecDiDAOTest {
    ProdottoBean bean2 = new ProdottoBean();
    ProdottoDAO dao2 = new ProdottoDAO();
    RecensioneBean bean3 = new RecensioneBean();
    RecensioneDAO dao3 = new RecensioneDAO();
    RecDiDAO dao = new RecDiDAO();
    RecDiBean bean = new RecDiBean();

    @BeforeAll
    public void setUp() throws Exception{
        bean2.setAnno(0);
        bean2.setCopertina("c");
        bean2.setNome("Test");
        bean2.setCasaEditrice("Test");
        bean2.setISBN((long) 11);
        bean2.setGenere("Test");
        dao2.doInsert(bean2);
        bean3.setText("test");
        dao3.doInsert(bean3);
        bean.setRecensione(3);
        bean.setProdotto((long) 11);
        dao.doInsert(bean);
    }

    @AfterAll
    public void tearDown() throws Exception {
        dao2.doDeleteByKey(bean2.getISBN());
        dao3.doDeleteByKey(3);
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
