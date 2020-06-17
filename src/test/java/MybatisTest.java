import com.myitem.dao.UserDao;
import com.myitem.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session = factory.openSession();
        userDao=session.getMapper(UserDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<User> userList= userDao.findAll();
        for(User user:userList){
            System.out.println(user);
        }

    }

    @Test
    public void saveUser(){
        User user=new User();
        user.setUsername("娃哈哈");
        user.setAddress("中国北京");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
//        System.out.println(user);
    }
    @Test
    public void deleteUser(){
        userDao.deleteUser(57);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setUsername("娃哈哈");
        user.setAddress("中国北京");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setId(48);
        userDao.updateUser(user);
    }

    @Test
    public void testFindById(){
        User user= userDao.findUserById(48);
        System.out.println(user);

    }

    @Test
    public void testFindByName(){
//        userDao=session.getMapper(UserDao.class);
        List<User> users= userDao.findUserByName("%王%");
        for(User user:users){
            System.out.println(user);
        }


    }

    @Test
    public void testFindByCondition(){
        User userCon=new User();
//        userCon.setUsername("老王");
        userCon.setSex("女");
        List<User> users= userDao.findUserByCondition(userCon);
        for(User user:users){
            System.out.println(user);
        }
    }

}
