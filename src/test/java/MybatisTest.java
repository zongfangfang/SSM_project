import com.myitem.dao.UserDao;
import com.myitem.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session = factory.openSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> userList= userDao.findAll();
        for(User user:userList){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
