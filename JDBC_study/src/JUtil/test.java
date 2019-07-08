package JUtil;

import java.sql.SQLException;
import java.util.List;

public class test {

	public static void main(String[] args) throws SQLException {
		Dao dao = new Dao();
		int i = dao.update(15, "haha", "123456");
		System.out.println(i);
	}
}
