package gestore;

import gestore.control.ModificaAutoreController;
import gestore.control.ModificaProdottoController;
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

public class ModificaProdottoTest {
    private ModificaProdottoController servlet = new ModificaProdottoController();
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static HttpSession session;

    @BeforeEach
    void setUp() throws Exception {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        ServletContext context = Mockito.mock(ServletContext.class);
        Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(Mockito.mock(RequestDispatcher.class));
    }

    @AfterEach
    void tearDown() throws Exception {
        request = null;
        response = null;
    }

    @Test
    public void modifyNomeSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyNome");
        Mockito.when(request.getParameter("nome")).thenReturn("nome");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyGenereSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyGenere");
        Mockito.when(request.getParameter("genere")).thenReturn("nome");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyAnnoSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyAnno");
        Mockito.when(request.getParameter("anno")).thenReturn("2003");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyEdizioneSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyEdizione");
        Mockito.when(request.getParameter("edizione")).thenReturn("2");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyCasaSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyCasa");
        Mockito.when(request.getParameter("casa")).thenReturn("nome");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifycopertinaSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyCopertina");
        Mockito.when(request.getParameter("copertina")).thenReturn("nome");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyPrezzoSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyPrezzo");
        Mockito.when(request.getParameter("prezzo")).thenReturn("19.5");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }
    @Test
    public void modifyNomeErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyNome");
        Mockito.when(request.getParameter("nome")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyGenereErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyGenere");
        Mockito.when(request.getParameter("genere")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyAnnoErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyAnno");
        Mockito.when(request.getParameter("anno")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyEdizioneErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyEdizione");
        Mockito.when(request.getParameter("edizione")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyCasaErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyCasa");
        Mockito.when(request.getParameter("casa")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifycopertinaErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyCopertina");
        Mockito.when(request.getParameter("copertina")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyPrezzoErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyPrezzo");
        Mockito.when(request.getParameter("prezzo")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }

    @Test
    public void modifyLinkSuccesso() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyLink");
        Mockito.when(request.getParameter("link")).thenReturn("linkDownload");
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());
    }

    @Test
    public void modifyLinkErrore() throws SQLException, ServletException, IOException, ParseException {
        PrintWriter out = Mockito.mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("action")).thenReturn("modifyLink");
        Mockito.when(request.getParameter("link")).thenReturn(null);
        Mockito.when(request.getParameter("codice")).thenReturn(String.valueOf(93764321));
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());
    }
}