package gestore;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AutoreDAOTest {
    AutoreDAO ad = new AutoreDAO();;
    AutoreBean ab = new AutoreBean();


    @BeforeEach
    public void setUp() throws Exception {
        ab.setCodice("test01");
        ab.setCognome("D'Aloia");
        ab.setNome("Cate");
        ab.setDatanascita(new Date());
        ad.doInsert(ab);
    }

    @AfterEach
    public void tearDown() throws Exception {
        ad.doDeleteByKey(ab.getCodice());
    }

    @Test
    void testRetrieveAll() throws Exception {
        Assertions.assertTrue(!(ad.doRetrieveAll().isEmpty()));
    }

    @Test
    void retrieveAutoreTest() throws Exception {
        Assertions.assertTrue(ad.doRetrieveByKey(ab.getCodice())!=null);
    }

    @Test
    void updateNomeAutoreTest() throws Exception {
        ad.doModifyNome(ab, "Veronica");
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getNome(), ab.getNome());
    }

    @Test
    void updateCognomeAutore() throws Exception{
        ad.doModifyCognome(ab, "DiSi");
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getCognome(), ab.getCognome());
    }

    @Test
    void updateDateAutore() throws Exception{
        ad.doModifyDataNascita(ab, null);
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getDatanascita(), ab.getDatanascita());
    }

    @Test
    void updateCodiceAutore() throws Exception{
        ad.doModifyCognome(ab, "DiSi");
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getCodice(), ab.getCodice());
    }

}
