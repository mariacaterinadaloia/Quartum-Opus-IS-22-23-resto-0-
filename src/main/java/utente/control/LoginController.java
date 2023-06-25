package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    UtenteBean user;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteBean utenteBean = new UtenteBean();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        System.out.println(email);
        System.out.println(password);

        if(email == null || password == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Errore nei parametri della richiesta");
        }
        else if(checkLogin(email, password)){
            request.getSession().setAttribute("user", user);
            out.print("Login effettuato con successo.");
            response.sendRedirect(response.encodeURL(request.getContextPath() + "/index.jsp"));
        }
        else{
            System.out.println("Errore");
            out.print("Password non valida.");
            request.setAttribute("error", true);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    private boolean checkLogin(String email, String  password){
        UtenteDAO dao = new UtenteDAO();
        try{
            user = dao.doRetrieveByKey(email);
            System.out.println(user.getNome());
            if(user.getPassword().equals(password))
                return true;
        } catch (SQLException e){
            return false;
        }
        return false;
    }
}
