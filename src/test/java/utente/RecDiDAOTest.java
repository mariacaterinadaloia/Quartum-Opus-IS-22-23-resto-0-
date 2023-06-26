package utente;

import gestore.ProdottoDAOTest;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utente.model.RecDiBean;
import utente.model.RecDiDAO;
import utente.model.RecensioneBean;
import utente.model.RecensioneDAO;

public class RecDiDAOTest {
    ProdottoBean bean2 = new ProdottoBean();
    ProdottoDAO dao2 = new ProdottoDAO();
    RecensioneBean bean3 = new RecensioneBean();
    RecensioneDAO dao3 = new RecensioneDAO();
    RecDiDAO dao = new RecDiDAO();
    RecDiBean bean = new RecDiBean();

    @BeforeEach
    public void setUp() throws Exception{
        bean2.setAnno(0);
        bean2.setCopertina("c");
        bean2.setNome("Test");
        bean2.setCasaEditrice("Test");
        bean2.setISBN(0);
        bean2.setGenere("Testthrows Exception {");
        dao2.doInsert(bean2);
        bean3.setIdRecensione(1000);
        bean3.setText("test");
        dao3.doInsert(bean3);
        bean.setRecensione(1000);
        bean.setProdotto(0);
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
        bean2.setAnno(0);
        bean2.setCopertina("c");
        bean2.setNome("Test");
        bean2.setCasaEditrice("Test");
        bean2.setISBN(1);
        bean2.setGenere("Test");
        dao2.doInsert(bean2);
        dao.doModifyByKey(1, bean);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getRecensione()).getProdotto(), bean.getProdotto());
    }
}
