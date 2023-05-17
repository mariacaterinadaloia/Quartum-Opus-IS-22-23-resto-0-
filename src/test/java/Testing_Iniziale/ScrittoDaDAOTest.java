package Testing_Iniziale;

import gestore.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ScrittoDaDAOTest {
    ScrittoDaDAO dao = new ScrittoDaDAO();
    ScrittoDaBean bean = new ScrittoDaBean();


    @BeforeEach
    public void setUp() throws Exception {
        AutoreDAO ad = new AutoreDAO();;
        AutoreBean ab = new AutoreBean();
        ab.setCodice("test01");
        ab.setCognome("D'Aloia");
        ab.setNome("Cate");
        ab.setDatanascita(new Date());
        ad.doInsert(ab);
        bean.setAutore(ab.getCodice());
        bean.setProdotto(93764321);
        dao.doInsert(bean);
    }

    @AfterEach
    public void tearDown() throws Exception {
        dao.doDeleteByKey(bean.getProdotto());
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
