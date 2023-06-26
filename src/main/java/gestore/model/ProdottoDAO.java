package gestore.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO implements DAO<ProdottoBean> {
    private static final String TABLE_NAME = "prodotto";
    @Override
    public ArrayList<ProdottoBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ ProdottoDAO.TABLE_NAME+"";
        ArrayList<ProdottoBean> ab = new ArrayList<ProdottoBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                ProdottoBean b = new ProdottoBean();
                b.setISBN(rs.getLong("ISBN"));
                b.setNome(rs.getString("nome"));
                b.setGenere(rs.getString("genere"));
                b.setAnno(rs.getInt("anno"));
                b.setEdizione(rs.getInt("edizione"));
                b.setCopertina(rs.getString("copertina"));
                b.setCasaEditrice(rs.getString("casa_editrice"));
                b.setPrezzo(rs.getDouble("prezzo"));
                ab.add(b);
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return ab;
    }

    @Override
    public ProdottoBean doRetrieveByKey(Object key) throws SQLException {
        Long ISBN = (Long) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ProdottoDAO.TABLE_NAME+" where ISBN=?";
        ProdottoBean b=new ProdottoBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(1, ISBN);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setISBN(rs.getLong("ISBN"));
                b.setNome(rs.getString("nome"));
                b.setGenere(rs.getString("genere"));
                b.setAnno(rs.getInt("anno"));
                b.setEdizione(rs.getInt("edizione"));
                b.setCopertina(rs.getString("copertina"));
                b.setCasaEditrice(rs.getString("casa_editrice"));
                b.setPrezzo(rs.getDouble("prezzo"));
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

    @Override
    public void doDeleteByKey(Object key) throws SQLException {
        Long ISBN = (Long) key;
        String query="delete from"+ProdottoDAO.TABLE_NAME+"where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setLong(1, ISBN);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    public void doModifyByKey(Object key, ProdottoBean prodottoBean) throws SQLException {};

    @Override
    public void doInsert(ProdottoBean prodottoBean) throws SQLException {
        String query="Insert into "+ ProdottoDAO.TABLE_NAME+" values(?,?,?,?,?,?,?)";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(1, prodottoBean.getISBN());
            ps.setString(2, prodottoBean.getNome());
            ps.setString(3, prodottoBean.getGenere().toUpperCase());
            ps.setInt(4, prodottoBean.getAnno());
            ps.setInt(5, prodottoBean.getEdizione());
            ps.setString(6, prodottoBean.getCasaEditrice());
            ps.setString(7, prodottoBean.getCopertina());
            ps.execute();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    // tutte le operazioni di modifica del caso
    public void doModifyISBN(ProdottoBean prodottoBean, Long ISBN) throws SQLException{
        String query="update "+ ProdottoDAO.TABLE_NAME+" set ISBN=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setISBN(ISBN);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setLong(1, ISBN);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

    }

    public void doModifyNome(ProdottoBean prodottoBean, String nome) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set nome=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setNome(nome);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setString(1, nome);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyGenere(ProdottoBean prodottoBean, String genere) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set genere=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setGenere(genere);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setString(1, genere.toUpperCase());
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyAnno(ProdottoBean prodottoBean, int anno) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set anno=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setAnno(anno);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setInt(1, anno);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyEdizione(ProdottoBean prodottoBean, int edizione) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set edizione=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setEdizione(edizione);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setInt(1, edizione);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyCasaEditrice(ProdottoBean prodottoBean, String casaEditrice) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set casa_editrice=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setCasaEditrice(casaEditrice);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setString(1, casaEditrice);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

    }

    public void doModifyCopertina(ProdottoBean prodottoBean, String copertina) throws SQLException {
        String query="update "+ ProdottoDAO.TABLE_NAME+" set copertina=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setCopertina(copertina);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setString(1, copertina);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyPrezzo(ProdottoBean prodottoBean, double prezzo) throws SQLException{
        String query="update "+ ProdottoDAO.TABLE_NAME+" set prezzo=? where ISBN=?";
        Connection con=null;
        PreparedStatement ps=null;
        prodottoBean.setPrezzo(prezzo);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(2, prodottoBean.getISBN());
            ps.setDouble(1, prezzo);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public ArrayList<ProdottoBean> doRetrieveByGenre(String genre) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ ProdottoDAO.TABLE_NAME+" where genere = ";
        ArrayList<ProdottoBean> ab = new ArrayList<ProdottoBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, genre.toUpperCase());
            ps.execute();
            ResultSet rs= ps.executeQuery();


            while (rs.next()) {
                ProdottoBean b = new ProdottoBean();
                b.setISBN(rs.getLong("ISBN"));
                b.setNome(rs.getString("nome"));
                b.setGenere(rs.getString("genere"));
                b.setAnno(rs.getInt("anno"));
                b.setEdizione(rs.getInt("edizione"));
                b.setCopertina(rs.getString("copertina"));
                b.setCasaEditrice(rs.getString("casa_editrice"));
                b.setAcquistabile(rs.getBoolean("acquistabile"));
                b.setPrezzo(rs.getDouble("prezzo"));
                ab.add(b);
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return ab;
    }

    public ProdottoBean doRetrieveByNome(String nome) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ProdottoDAO.TABLE_NAME+" where nome=?";
        ProdottoBean b=new ProdottoBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setISBN(rs.getLong("ISBN"));
                b.setNome(rs.getString("nome"));
                b.setGenere(rs.getString("genere"));
                b.setAnno(rs.getInt("anno"));
                b.setEdizione(rs.getInt("edizione"));
                b.setCopertina(rs.getString("copertina"));
                b.setCasaEditrice(rs.getString("casa_editrice"));
                b.setAcquistabile(rs.getBoolean("acquistabile"));
                b.setPrezzo(rs.getDouble("prezzo"));
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

}
