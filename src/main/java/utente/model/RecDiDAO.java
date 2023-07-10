package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecDiDAO implements DAO<RecDiBean> {
    private static final String TABLE_NAME = "recDi";
    @Override
    public ArrayList<RecDiBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecDiDAO.TABLE_NAME+"";
        ArrayList<RecDiBean> ab = new ArrayList<RecDiBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                RecDiBean b=new RecDiBean();
                b.setProdotto(rs.getLong("prodotto"));
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
    public RecDiBean doRetrieveByKey(Object key) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecDiDAO.TABLE_NAME+" where recensione = ?";
        RecDiBean b=new RecDiBean();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();


            while (rs.next()) {
                b.setProdotto(rs.getLong("prodotto"));
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
        String query= "delete from "+RecDiDAO.TABLE_NAME+" where recensione = ?";
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
    public void doModifyByKey(Object key, RecDiBean recDaBean) throws SQLException {
        Integer id = (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "update "+RecDiDAO.TABLE_NAME+" set prodotto = ? where recensione = ?";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, id);
            ps.setLong(1, recDaBean.getProdotto());
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
    public void doInsert(RecDiBean recDaBean) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "insert into "+RecDiDAO.TABLE_NAME+" values (?,?)";


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, recDaBean.getRecensione());
            ps.setLong(1, recDaBean.getProdotto());
            ps.execute();

        }finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public ArrayList<RecDiBean> doRetrieveByProduct(long key) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RecDiDAO.TABLE_NAME+" where prodotto = ?";
        ArrayList<RecDiBean> ab = new ArrayList<RecDiBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setLong(1, key);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                RecDiBean b=new RecDiBean();
                b.setProdotto(rs.getLong("prodotto"));
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
}
