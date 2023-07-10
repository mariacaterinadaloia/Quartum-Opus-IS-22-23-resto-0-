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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String codice = request.getParameter("codice");
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
                try{
                    dao.doModifyNome(bean, nome);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyGenere":{
                String genere = request.getParameter("genere");
                try{
                    dao.doModifyGenere(bean, genere);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyAnno":{
                int anno = Integer.parseInt(request.getParameter("anno"));
                try{
                    dao.doModifyAnno(bean, anno);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyEdizione":{
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
                try{
                    dao.doModifyCasaEditrice(bean, casa);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyCopertina":{
                String copertina = request.getParameter("copertina");
                try{
                    dao.doModifyCopertina(bean,copertina);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
            case "modifyPrezzo":{
                double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                try{
                    dao.doModifyPrezzo(bean, prezzo);
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CatalogoAdminController");
        dispatcher.forward(request, response);
    }
}
