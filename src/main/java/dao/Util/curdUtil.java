package dao.Util;

import db.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class curdUtil {

    public static <T>T execute(String sql,Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        if (sql.startsWith("SELECT")||sql.startsWith("select")){
          return (T) pstm.executeQuery();
        }
        for (int i = 0; i < args.length; i++) {
           pstm.setObject((i+1),args[i]);
        }
        return (T) (Boolean) (pstm.executeUpdate()>0);
    }
}
