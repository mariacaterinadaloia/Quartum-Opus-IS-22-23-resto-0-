package gestore;

import gestore.control.InserisciAutoreController;
import gestore.control.InserisciProdottoController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class InserisciProdottoTest {
    private InserisciProdottoController servlet = new InserisciProdottoController();
    private static HttpServletRequest request ;
    private static HttpServletResponse response ;
    private static HttpSession session;

    @BeforeEach
    void setUp() throws Exception {
        request = Mockito.mock(HttpServletRequest.class) ;
        response = Mockito.mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        ServletContext context = Mockito.mock(ServletContext.class);
        Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(Mockito.mock(RequestDispatcher.class));
    }

    @AfterEach
    void tearDown() throws Exception {
        request=null;
        response=null;
    }
    @Test
    public void insertSuccesso() throws SQLException, ServletException, IOException, ParseException {

        String username="manuilmagnifico@hotmail.com";
        String testo="Magnifique";
        Long ISBN = 93764321L;

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("nome")).thenReturn("usernam");
        Mockito.when(request.getParameter("genere")).thenReturn("testo");
        Mockito.when(request.getParameter("isbn")).thenReturn(String.valueOf(6464));
        Mockito.when(request.getParameter("anno")).thenReturn(String.valueOf(2001));
        Mockito.when(request.getParameter("edizione")).thenReturn(String.valueOf(1));
        Mockito.when(request.getParameter("copertina")).thenReturn("test");
        Mockito.when(request.getParameter("casa")).thenReturn("test");
        Mockito.when(request.getParameter("prezzo")).thenReturn(String.valueOf(4.0));
        Mockito.when(request.getParameter("codiceAutore")).thenReturn("64524");
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void insertErrore() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("nome")).thenReturn("usernam");
        Mockito.when(request.getParameter("genere")).thenReturn("testo");
        Mockito.when(request.getParameter("isbn")).thenReturn(String.valueOf(6464));
        Mockito.when(request.getParameter("anno")).thenReturn(String.valueOf(2001));
        Mockito.when(request.getParameter("edizione")).thenReturn(String.valueOf(1));
        Mockito.when(request.getParameter("copertina")).thenReturn(null);
        Mockito.when(request.getParameter("casa")).thenReturn("test");
        Mockito.when(request.getParameter("prezzo")).thenReturn(String.valueOf(4.0));
        Mockito.when(request.getParameter("codiceAutore")).thenReturn("64524");
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore.", argument.getValue());
    }
}
