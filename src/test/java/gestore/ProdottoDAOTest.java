package gestore;

import org.junit.jupiter.api.*;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProdottoDAOTest {
    ProdottoDAO dao = new ProdottoDAO();
    ProdottoBean bean = new ProdottoBean();

    @BeforeEach
    public void setUp() throws Exception {
        bean.setAnno(0);
        bean.setCopertina("c");
        bean.setNome("Test");
        bean.setCasaEditrice("Test");
        bean.setISBN(100);
        bean.setGenere("Test");
        bean.setPrezzo(0.0);
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
        dao.doModifyGenere(bean, "test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getGenere(),"test2");
    }
    @Test
    void updateProdottoISBN() throws Exception{
        dao.doModifyISBN(bean, 200L);
        bean.setISBN(200L);
        Assertions.assertEquals(dao.doRetrieveByKey(200L).getISBN(), 200L);
    }
    @Test
    void updateProdottoNome() throws Exception{
        dao.doModifyNome(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getNome(), "Test2");
    }

    @Test
    void updateProdottoAnno() throws Exception{
        dao.doModifyAnno(bean, 2);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getAnno(), 2);
    }

    @Test
    void updateProdottoEdizione() throws Exception{
        dao.doModifyEdizione(bean, 2);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getEdizione(), 2);
    }

    @Test
    void updateProdottoCasaEditrice() throws Exception{
        dao.doModifyCasaEditrice(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getCasaEditrice(),"Test2");
    }

    @Test
    void updateProdottoCopertina() throws Exception{
        dao.doModifyCopertina(bean, "Test2");
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getISBN()).getCopertina(), "Test2");
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
