package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "SignupController", value = "/SignupController")
public class SignupController extends HttpServlet {

    private static final String insertError = "Errore sui parametri";
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String dataNascita = request.getParameter("dataNascita");

        LocalDate date = LocalDate.parse(dataNascita);
        Boolean checkName = nome.matches("[A-Za-z]+$");
        Boolean checkSurname = cognome.matches("[A-Za-z]+$");
        Boolean checkPassword = password.matches("(?=^.{8,}$)(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9]).*$");
        Boolean checkEmail = email.matches("^[a-zA-Z0-9.!#$%&*+=?^_`{|}~-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+$");

        //Controllo null e RegEx
        if(nome != null || cognome != null || email != null || password != null || dataNascita != null){


            if ( ! ( checkName && checkSurname  && checkPassword && checkEmail ) ){
                out.print("Errore");
                request.getSession().setAttribute("errorSignup", insertError);
                response.sendRedirect("/signup.jsp");
                return;
            }
        }
        else {
            out.print("Errore");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Errori nei parametri della richiesta!");
            return;
        }

        UtenteDAO um = new UtenteDAO();
        UtenteBean ut = null;
        //controllo se l'email è già esistente nel db
        try {
            ut = um.doRetrieveByKey(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ut.getMail() != null){
            out.print("Mail esistente.");
            request.getSession().setAttribute("errorSignup", "Email già inserita!");
            response.sendRedirect("/signup.jsp");
            return;
        }

        UtenteBean user = new UtenteBean();
        user.setMail(email);
        user.setNome(nome);
        user.setCognome(cognome);
        user.setPassword(password);
        user.setDatadinascita(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        user.setGestore(false);

        try{
            um.doInsert(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
        out.print("Successo.");
        response.sendRedirect("/login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
