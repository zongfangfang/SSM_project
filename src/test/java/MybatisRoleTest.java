import com.myitem.dao.AccountDao;
import com.myitem.dao.RoleDao;
import com.myitem.domain.Account;
import com.myitem.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisRoleTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private RoleDao roleDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session = factory.openSession();
        roleDao=session.getMapper(RoleDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAllAccount(){
        List<Role> roles= roleDao.findAll();
        for(Role role:roles){
            System.out.println(role);
            System.out.println(role.getUserList());
        }

    }


}
