package gestore.control;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "InserisciAutoreController", value = "/InserisciAutoreController")
public class InserisciAutoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codice = request.getParameter("codice");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String dataNascita = request.getParameter("dataNascita");
        System.out.println(codice + nome + cognome + dataNascita);
        LocalDate data = LocalDate.parse(dataNascita);

        if(codice == null || nome == null || cognome == null || dataNascita == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Errori nei parametri della richiesta!");
            return;
        }

        AutoreBean autore = new AutoreBean();
        autore.setCodice(codice);
        autore.setNome(nome);
        autore.setCognome(cognome);
        autore.setDatanascita(Date.from(data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        AutoreDAO dao = new AutoreDAO();
        try{
            dao.doInsert(autore);
        } catch(SQLException e){
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AutoriController");
        dispatcher.forward(request, response);
    }
}
