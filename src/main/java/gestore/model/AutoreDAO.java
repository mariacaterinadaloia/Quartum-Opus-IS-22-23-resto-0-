package gestore.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AutoreDAO implements DAO<AutoreBean> {
    private static final String TABLE_NAME = "autore";
    @Override
    public ArrayList<AutoreBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ AutoreDAO.TABLE_NAME+"";
        ArrayList<AutoreBean> ab = new ArrayList<AutoreBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                AutoreBean b=new AutoreBean();
                b.setCodice(rs.getString("codice"));
                b.setCognome(rs.getString("cognome"));
                b.setNome(rs.getString("nome"));
                b.setDatanascita(new Date(rs.getDate("datanascita").getTime()));
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
    public AutoreBean doRetrieveByKey(Object key) throws SQLException {
        String codice= (String) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ AutoreDAO.TABLE_NAME+" where codice=?";
        AutoreBean b=new AutoreBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setCodice(rs.getString("codice"));
                b.setNome(rs.getString("nome"));
                b.setDatanascita(new Date(rs.getDate("datanascita").getTime()));
                b.setCognome(rs.getString("cognome"));
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
        String codice= (String) key;
        String query="delete from "+AutoreDAO.TABLE_NAME+" where codice=?";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, codice);
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
    //non serve per ora
    public void doModifyByKey(Object key, AutoreBean autoreBean) throws SQLException {};


    @Override
    public void doInsert(AutoreBean autoreBean) throws SQLException {
        String query="Insert into "+ AutoreDAO.TABLE_NAME+" values(?,?,?,?)";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, autoreBean.getNome());
            ps.setString(2,autoreBean.getCognome());
            ps.setDate(4, new java.sql.Date(autoreBean.getDatanascita().getTime()));
            ps.setString(3, autoreBean.getCodice());

            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyNome(AutoreBean autoreBean, String nome) throws SQLException{
        String query="update "+ AutoreDAO.TABLE_NAME+" set nome=? where codice=?";
        Connection con=null;
        PreparedStatement ps=null;
        autoreBean.setNome(nome);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(2, autoreBean.getCodice());
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

    public void doModifyCognome(AutoreBean autoreBean, String cognome) throws SQLException{
        String query="update "+ AutoreDAO.TABLE_NAME+" set cognome=? where codice=?";
        Connection con=null;
        PreparedStatement ps=null;
        autoreBean.setCognome(cognome);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(2, autoreBean.getCodice());
            ps.setString(1, cognome);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyCodice(AutoreBean autoreBean, String codice) throws SQLException{
        String query="update "+ AutoreDAO.TABLE_NAME+" set codice=? where codice=?";
        Connection con=null;
        PreparedStatement ps=null;
        autoreBean.setCodice(codice);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(2, autoreBean.getCodice());
            ps.setString(1, codice);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doModifyDataNascita(AutoreBean autoreBean, Date date) throws SQLException{
        String query="update "+ AutoreDAO.TABLE_NAME+" set datanascita=? where codice=?";
        Connection con=null;
        PreparedStatement ps=null;
        autoreBean.setDatanascita(date);
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(2, autoreBean.getCodice());
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
}
