package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecDaDAO implements DAO<RecDaBean> {

    private static final String TABLE_NAME = "recDa";

    @Override
    public ArrayList<RecDaBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecDaDAO.TABLE_NAME+"";
        ArrayList<RecDaBean> ab = new ArrayList<RecDaBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                RecDaBean b=new RecDaBean();
                b.setUtente(rs.getString("utente"));
                b.setRecensione(rs.getInt("recensione"));
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
    public RecDaBean doRetrieveByKey(Object key) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecDaDAO.TABLE_NAME+" where recensione = ?";
        RecDaBean b=new RecDaBean();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();


            while (rs.next()) {
                b.setUtente(rs.getString("utente"));
                b.setRecensione(rs.getInt("recensione"));
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

    @Override
    public void doDeleteByKey(Object key) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "delete from "+RecDaDAO.TABLE_NAME+" where recensione = ?";
        RecDaBean b=new RecDaBean();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();

            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
    }

    @Override
    public void doModifyByKey(Object key, RecDaBean recDaBean) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "update "+RecDaDAO.TABLE_NAME+" set utente = ? where recensione = ?";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, id);
            ps.setString(1, recDaBean.getUtente());
            ResultSet rs= ps.executeQuery();

            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
    }

    @Override
    public void doInsert(RecDaBean recDaBean) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "insert into "+RecDaDAO.TABLE_NAME+" values (?,?)";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, recDaBean.getRecensione());
            ps.setString(1, recDaBean.getUtente());
            ps.execute();

        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
    }

}
