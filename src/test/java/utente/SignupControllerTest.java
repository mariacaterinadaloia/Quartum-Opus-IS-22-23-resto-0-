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
import utente.control.SignupController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SignupControllerTest {
    private static final SignupController servlet = new SignupController();
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static HttpSession session;

    @BeforeEach
    void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        ServletContext context = mock(ServletContext.class);
        Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(mock(RequestDispatcher.class));
    }

    @AfterEach
    void tearDown() throws Exception {
        request = null;
        response = null;
    }


    @Test
    public void registrazioneConSuccesso() throws SQLException, ServletException, IOException, ParseException {
        String password = "mmmManue1.";
        String email = "manuel1@gmail.com";
        String nome = "Manuel";
        String cognome = "Sica";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);


        Mockito.verify(out).print(argument.capture());
        assertEquals("Successo.", argument.getValue());


    }


    @Test
    public void nomeNonValido() throws SQLException, ServletException, IOException, ParseException {
        String username = "manueeee";
        String password = "mmmManue1.";
        String password2 = "mmmManue1.";
        String email = "manuel1@gmail.com";
        String nome = "Manuel1";
        String cognome = "Sica";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta = "Benevento";
        String domanda = "Città preferita";

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);

        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());

    }

    @Test
    public void cognomeNonValido() throws SQLException, ServletException, IOException, ParseException {
        String username = "manueee";
        String password2 = "mmmManue1.";
        String password = "mmmManue1.";
        String email = "manuel1@gmail.com";
        String nome = "Manuel";
        String cognome = "Sica.";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta = "Benevento";
        String domanda = "Città preferita";

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);

        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());

    }


    @Test
    public void mailNonValido() throws SQLException, ServletException, IOException, ParseException {
        String username = "manueeee";
        String password = "mmmManue1.";
        String password2 = "mmmManue1.";
        String email = "manuelgmailcom";
        String nome = "Manuel";
        String cognome = "Sica";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta = "Benevento";
        String domanda = "Città preferita";

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);

        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());

    }

    @Test
    public void mailEsistente() throws SQLException, ServletException, IOException, ParseException {
        String username = "mmmmaaaaaayyyyyyyy";
        String password = "mmmManue1.";
        String password2 = "mmmManue1.";
        String email = "manuilmagnifico@hotmail.com";
        String nome = "Manuel";
        String cognome = "Sica";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta = "Benevento";
        String domanda = "Città preferita";

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);

        Mockito.verify(out).print(argument.capture());
        assertEquals("Mail esistente.", argument.getValue());

    }

    @Test
    public void passwordNonValido() throws SQLException, ServletException, IOException, ParseException {
        String username = "manueeeee";
        String password = "mmmManue.";
        String password2 = "mmmManue.";
        String email = "manuel1@gmail.com";
        String nome = "Manuel";
        String cognome = "Sica";
        String d = "2001-05-23";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta = "Benevento";
        String domanda = "Città preferita";

        PrintWriter out = mock(PrintWriter.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("dataNascita")).thenReturn(d);
        Mockito.when(response.getWriter()).thenReturn(out);

        servlet.doPost(request, response);

        Mockito.verify(out).print(argument.capture());
        assertEquals("Errore", argument.getValue());

    }
}