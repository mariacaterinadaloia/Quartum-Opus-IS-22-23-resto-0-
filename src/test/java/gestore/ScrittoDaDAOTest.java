package gestore;

import gestore.model.*;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.Date;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScrittoDaDAOTest {
    ScrittoDaDAO dao = new ScrittoDaDAO();
    ScrittoDaBean bean = new ScrittoDaBean();
    AutoreDAO ad = new AutoreDAO();;
    AutoreBean ab = new AutoreBean();

    @BeforeAll
    public void setUp() throws Exception {

        ab.setCodice("test01");
        ab.setCognome("D'Aloia");
        ab.setNome("Cate");
        ab.setDatanascita(Calendar.getInstance().getTime());
        ad.doInsert(ab);
        bean.setAutore(ab.getCodice());
        bean.setProdotto(93764321);
        dao.doInsert(bean);
    }

    @AfterAll
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getProdotto());
        ad.doDeleteByKey(ab.getCodice());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(dao.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveScrittoDATest() throws Exception {
        Assertions.assertTrue(dao.doRetrieveByKey(bean.getProdotto())!=null);
    }
}
