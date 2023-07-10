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

@WebServlet(name = "ModificaAutoreController", value = "/ModificaAutoreController")
public class ModificaAutoreController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String codice = request.getParameter("codice");
        AutoreDAO dao = new AutoreDAO();
        AutoreBean bean = new AutoreBean();

        try{
            bean = dao.doRetrieveByKey(codice);
        } catch (SQLException e){
            e.printStackTrace();
        }

        switch (action){
            case "modificaNome": {
                String nome = request.getParameter("name");
                if(nome == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                try{
                    dao.doModifyNome(bean, nome);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modificaCognome": {
                String cognome = request.getParameter("surname");
                if(cognome == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                try{
                    dao.doModifyCognome(bean, cognome);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modificaData": {
                String d = request.getParameter("birthdate");
                if(d==null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                LocalDate data = LocalDate.parse(d);

                try{
                    dao.doModifyDataNascita(bean, Date.from(data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
        }

        response.sendRedirect("/AutoriController");
    }
}
