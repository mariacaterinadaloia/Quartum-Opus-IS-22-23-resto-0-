package gestore;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.Date;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutoreDAOTest {
    AutoreDAO ad = new AutoreDAO();;
    AutoreBean ab = new AutoreBean();


    @BeforeAll
    public void setUp() throws Exception {
        ab.setCodice("test01");
        ab.setCognome("D'Aloia");
        ab.setNome("Cate");
        ab.setDatanascita(Calendar.getInstance().getTime());
        ad.doInsert(ab);
    }

    @AfterAll
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
        ad.doModifyDataNascita(ab, Calendar.getInstance().getTime());
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getDatanascita().getDate(), ab.getDatanascita().getDate());
    }

    @Test
    void updateCodiceAutore() throws Exception{
        ad.doModifyCognome(ab, "DiSi");
        Assertions.assertEquals(ad.doRetrieveByKey(ab.getCodice()).getCodice(), ab.getCodice());
    }

}
