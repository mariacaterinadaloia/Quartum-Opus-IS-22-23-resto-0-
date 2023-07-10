package utente;

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
import utente.control.InserisciRecensioneController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class InserisciRecensioneTest {
    private static InserisciRecensioneController servlet = new InserisciRecensioneController();
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

        Mockito.when(request.getParameter("mail")).thenReturn(username);
        Mockito.when(request.getParameter("testoRec")).thenReturn(testo);
        Mockito.when(request.getParameter("ISBN")).thenReturn(String.valueOf(ISBN));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Recensione inserita con successo", argument.getValue());
    }
    @Test
    public void insertErrore() throws SQLException, ServletException, IOException, ParseException {

        String username="manuilmagnifico@hotmail.com";
        String testo=null;
        Long ISBN = 93764321L;

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("mail")).thenReturn(username);
        Mockito.when(request.getParameter("testoRec")).thenReturn(testo);
        Mockito.when(request.getParameter("ISBN")).thenReturn(String.valueOf(ISBN));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore nell'inserimento", argument.getValue());
    }
}
