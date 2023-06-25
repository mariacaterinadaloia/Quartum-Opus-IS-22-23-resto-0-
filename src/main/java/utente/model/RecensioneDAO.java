package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecensioneDAO implements DAO<RecensioneBean> {
    private static final String TABLE_NAME = "recensione";
    @Override
    public ArrayList<RecensioneBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecensioneDAO.TABLE_NAME+"";
        ArrayList<RecensioneBean> ab = new ArrayList<RecensioneBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                RecensioneBean b=new RecensioneBean();
                b.setText(rs.getString("text"));
                b.setIdRecensione(rs.getInt("idRecensione"));
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
    public RecensioneBean doRetrieveByKey(Object key) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecensioneDAO.TABLE_NAME+" where idRecensione = ?";
        RecensioneBean b=new RecensioneBean();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();


            while (rs.next()) {
                b.setText(rs.getString("text"));
                b.setIdRecensione(rs.getInt("idRecensione"));
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
        String query= "delete from "+RecensioneDAO.TABLE_NAME+" where idRecensione = ?";
        RecensioneBean b=new RecensioneBean();


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
    public void doModifyByKey(Object key, RecensioneBean recensioneBean) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "update "+RecensioneDAO.TABLE_NAME+" set text = ? where recensione = ?";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, id);
            ps.setString(1, recensioneBean.getText());
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
    public void doInsert(RecensioneBean recensioneBean) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "insert into "+RecensioneDAO.TABLE_NAME+" values (?,?)";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, recensioneBean.getIdRecensione());
            ps.setString(2, recensioneBean.getText());
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
}
