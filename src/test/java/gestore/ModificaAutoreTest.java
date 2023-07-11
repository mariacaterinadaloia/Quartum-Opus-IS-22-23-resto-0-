package gestore;

import gestore.control.InserisciAutoreController;
import gestore.control.ModificaAutoreController;
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

public class ModificaAutoreTest {
    private ModificaAutoreController servlet = new ModificaAutoreController();
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
    public void modifyNomeSuccesso() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaNome");
        Mockito.when(request.getParameter("name")).thenReturn("nome");
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void modifyCognomeSuccesso() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaCognome");
        Mockito.when(request.getParameter("surname")).thenReturn("ali");
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void modifyDataSuccesso() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaData");
        Mockito.when(request.getParameter("birthdate")).thenReturn("2022-06-22");
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void modifyNomeErrore() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaNome");
        Mockito.when(request.getParameter("name")).thenReturn(null);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }
    @Test
    public void modifyCognomeErrore() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaCognome");
        Mockito.when(request.getParameter("surname")).thenReturn(null);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }
    @Test
    public void modifyDataErrore() throws SQLException, ServletException, IOException, ParseException {

        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        Mockito.when(request.getParameter("codice")).thenReturn("934723");
        Mockito.when(request.getParameter("action")).thenReturn("modificaData");
        Mockito.when(request.getParameter("birthdate")).thenReturn(null);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }
}
