package gestore.control;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificaProdottoController", value = "/ModificaProdottoController")
public class ModificaProdottoController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Long codice = Long.parseLong(request.getParameter("codice"));
        ProdottoDAO dao = new ProdottoDAO();
        ProdottoBean bean = new ProdottoBean();

        try{
            bean = dao.doRetrieveByKey(codice);
        } catch (SQLException e){
            e.printStackTrace();
        }

        switch(action){
            case "modifyNome":{
                String nome = request.getParameter("nome");
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
            case "modifyGenere":{
                String genere = request.getParameter("genere");
                if(genere==null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                try{
                    dao.doModifyGenere(bean, genere);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyAnno":{
                if(request.getParameter("anno") == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                int anno = Integer.parseInt(request.getParameter("anno"));
                try{
                    dao.doModifyAnno(bean, anno);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyEdizione":{
                if(request.getParameter("edizione") == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                int edizione = Integer.parseInt(request.getParameter("edizione"));
                try{
                    dao.doModifyEdizione(bean, edizione);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyCasa":{
                String casa = request.getParameter("casa");
                if(casa == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                try{
                    dao.doModifyCasaEditrice(bean, casa);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyCopertina":{
                String copertina = request.getParameter("copertina");
                if(copertina == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                try{
                    dao.doModifyCopertina(bean,copertina);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyPrezzo":{
                if(request.getParameter("prezzo") == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
                    return;
                }
                double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                try{
                    dao.doModifyPrezzo(bean, prezzo);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
        }

        response.sendRedirect("/CatalogoAdminController");
    }
}
