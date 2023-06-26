package gestore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;

public class ProdottoDAOTest {
    ProdottoDAO dao = new ProdottoDAO();
    ProdottoBean bean = new ProdottoBean();

    @BeforeEach
    public void setUp() throws Exception {
        bean.setAnno(0);
        bean.setCopertina("c");
        bean.setNome("Test");
        bean.setCasa_editrice("Test");
        bean.setISBN(0);
        bean.setGenere("Test");
        dao.doInsert(bean);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getISBN());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveProdottoTest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getISBN())!=null);
    }
    @Test
    void updateProdottoGenere() throws Exception{
        dao.doModifyGenere(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getGenere(), bean.getGenere());
    }
    @Test
    void updateProdottoISBN() throws Exception{
        dao.doModifyISBN(bean, 1L);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getISBN(), bean.getISBN());
    }
    @Test
    void updateProdottoNome() throws Exception{
        dao.doModifyNome(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getNome(), bean.getNome());
    }

    @Test
    void updateProdottoAnno() throws Exception{
        dao.doModifyAnno(bean, 2);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getAnno(), bean.getAnno());
    }

    @Test
    void updateProdottoEdizione() throws Exception{
        dao.doModifyEdizione(bean, 2);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getEdizione(), bean.getEdizione());
    }

    @Test
    void updateProdottoCasaEditrice() throws Exception{
        dao.doModifyGenere(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getCasaEditrice(), bean.getCasaEditrice());
    }

    @Test
    void updateProdottoCopertina() throws Exception{
        dao.doModifyCopertina(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getCopertina(), bean.getCopertina());
    }

    @Test
    void doRetrieveByGenreTest() throws Exception{
        Assertions.assertTrue(!(dao.doRetrieveByGenre("Test").isEmpty()));
    }

    @Test
    void doRetrieveByNomeTest() throws Exception{
        Assertions.assertTrue(dao.doRetrieveByNome("Test")!=null);
    }
}
