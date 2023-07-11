package gestore;

import gestore.control.InserisciAutoreController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InserisciAutoreTest {
    private InserisciAutoreController servlet = new InserisciAutoreController();
    private static HttpServletRequest request ;
    private static HttpServletResponse response ;
    private static HttpSession session;

    @BeforeAll
    void setUp() throws Exception {
        request = Mockito.mock(HttpServletRequest.class) ;
        response = Mockito.mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        ServletContext context = Mockito.mock(ServletContext.class);
        Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(Mockito.mock(RequestDispatcher.class));
    }

    @AfterAll
    void tearDown() throws Exception {
        request=null;
        response=null;
    }
    @Test
    public void insertSuccesso() throws SQLException, ServletException, IOException, ParseException {

        String nome="Ludovica";
        String cognome="Magnifique";
        String codice="64544";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("codice")).thenReturn(codice);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(String.valueOf(cognome));
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void insertErrore() throws SQLException, ServletException, IOException, ParseException {

        String nome="Ludovica";
        String cognome=null;
        String codice="64554";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("codice")).thenReturn(codice);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(null);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore.", argument.getValue());
    }
}
