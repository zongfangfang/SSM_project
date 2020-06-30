import com.myitem.dao.AccountDao;
import com.myitem.dao.UserDao;
import com.myitem.domain.Account;
import com.myitem.domain.QueryVo;
import com.myitem.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisAccountTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session = factory.openSession();
        accountDao=session.getMapper(AccountDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAllAccount(){
        List<Account> accounts= accountDao.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }


}
