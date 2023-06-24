package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "SignupController", value = "/SignupController")
public class SignupController extends HttpServlet {

    private static final String insertError = "Errore sui parametri";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



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
                request.setAttribute("errorSignup", insertError);
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
                return;
            }
        }
        else {
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
            request.setAttribute("errorSignup", "Email già inserita!");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
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

        response.sendRedirect(response.encodeURL(request.getContextPath() + "/login.jsp"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
