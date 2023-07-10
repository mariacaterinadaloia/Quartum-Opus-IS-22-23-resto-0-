package utente;

import org.junit.jupiter.api.*;
import utente.model.RecensioneBean;
import utente.model.RecensioneDAO;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecensioneDAOTest {
    RecensioneDAO dao = new RecensioneDAO();
    RecensioneBean bean = new RecensioneBean();
    @BeforeAll
    public void setUp() throws Exception{
        bean.setIdRecensione(3);
        bean.setText("test");
        dao.doInsert(bean);
    }

    @AfterAll
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
        bean.setText("ca bello");
        System.out.println(dao.doRetrieveByKey(bean.getIdRecensione()).getText() );
        dao.doModifyByKey(bean.getIdRecensione(), bean);
        Assertions.assertEquals(dao.doRetrieveByKey(bean.getIdRecensione()).getText(), bean.getText());
    }
}
