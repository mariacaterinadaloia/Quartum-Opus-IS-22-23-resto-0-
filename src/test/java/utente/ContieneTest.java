package utente;
import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import org.junit.jupiter.api.*;
import utente.model.*;

import java.util.Calendar;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContieneTest {
    OrdineBean ordineBean = new OrdineBean();
    OrdineDAO ordineDAO = new OrdineDAO();

    ProdottoBean prodottoBean = new ProdottoBean();
    ProdottoDAO prodottoDAO = new ProdottoDAO();

    UtenteDAO dao1 = new UtenteDAO();
    UtenteBean bean1 = new UtenteBean();
    ContieneBean bean = new ContieneBean();
    ContieneDAO dao = new ContieneDAO();
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
        dao1.doInsert(bean1);
        ordineBean.setId(4);
        ordineBean.setUtente("Test@java");
        ordineBean.setData(Calendar.getInstance().getTime());
        ordineDAO.doInsert(ordineBean);
        prodottoBean.setAnno(0);
        prodottoBean.setCopertina("c");
        prodottoBean.setNome("Test");
        prodottoBean.setCasaEditrice("Test");
        prodottoBean.setISBN(0);
        prodottoBean.setGenere("Test");
        prodottoBean.setPrezzo(0.0);
        prodottoDAO.doInsert(prodottoBean);
        bean.setProdotto(prodottoBean.getISBN());
        bean.setOrdine(ordineBean.getId());
        dao.doInsert(bean);
    }

    @AfterAll
    public void tearDown() throws Exception {
        ordineDAO.doDeleteByKey(ordineBean.getId());
        prodottoDAO.doDeleteByKey(prodottoBean.getISBN());
        dao1.doDeleteByKey(bean1.getMail());
    }

    @Test
    void doRetrieveByOrderIdTest() throws Exception{
        Assertions.assertTrue(dao.doRetrieveByOrderId(bean.getOrdine())!=null);
    }

}
