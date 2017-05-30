package cn.edu.cumt.ec.dao;

public class DataAccess {
	private static String db = "Sqlite";
    public static GuitarDao CreateGuitarDao()
    {
        GuitarDao result = null;
        switch (db)
        {
            case "Sqlite":
                result = new cn.edu.cumt.ec.sqliteDao.GuitarDaoImpl();
                break;
            case "Mysql":
                result = new cn.edu.cumt.ec.mysqlDao.GuitarDaoImpl();
                break;
        }
        return result;
    }

}
