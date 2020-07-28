import com.project.dao.UserMapper;
import com.project.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyTest {
    @Test
    public void selectUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.queryAllUser();
        for (User user: userList){
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void test2(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       UserMapper userMapper = (UserMapper) context.getBean("userDao");
       List<User> userList = userMapper.queryAllUser();
        System.out.println(userList);
    }
    @Test
    public void testsqlsession(){
        /**
         * @description 类(或接口)是测试sqlsession sqlsessionFactory 在运行期间一直存在  使用sqlsession xml中
         * @author  haojiaxing
         * @date   2020/7/28 15:33
         **/
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
//            需要在xml里配置DataSource
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList =  userMapper.queryAllUser();
            for (User user:userList
                 ) {
                System.out.println(user);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
