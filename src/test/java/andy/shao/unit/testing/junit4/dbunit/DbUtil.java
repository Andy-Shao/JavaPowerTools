package andy.shao.unit.testing.junit4.dbunit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.InputSource;

public class DbUtil {

	public static Connection getCon() throws SQLException{
		Connection con = null;
		
		con = DriverManager.getConnection("");
		
		return con;
	}
	
	@Ignore
	@Test
	public void testLoad() throws DatabaseUnitException, IOException, SQLException{
		IDatabaseConnection con = new DatabaseConnection(DbUtil.getCon());
		System.out.println(con);
		
		try(InputStream fileInpustStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("andy/shao/unit/testing/junit4/dbunit/dbunit.xml")){
			IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(fileInpustStream)));
			System.out.println(ds);
			
			//Clean database then insert information by dbunit.xml
			DatabaseOperation.CLEAN_INSERT.execute(con, ds);
		}
	}
}
