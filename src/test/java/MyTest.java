import com.project.dao.StudentMapper;
import com.project.dao.TeacherMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Student;
import com.project.pojo.Teacher;
import com.project.pojo.User;
import lombok.Data;
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
    /**
     * @description
     * @author  haojiaxing
     * @date   2020/7/28 20:01
     * @return      void
     * @Exception
     **/
    @Test
    public void testStudent(){

        String resource = "sqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.queryAllStudent2();
            for (Student student:studentList) {
                System.out.println(student);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * @description
     * @author  haojiaxing
     * @date   2020/7/28 20:01
     * @return      void
     * @Exception
     **/
    @Test
    public void testTeacher(){
        String resource = "sqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = teacherMapper.queryAllTeacher2(1);
            for (Teacher teacher:teacherList) {
                System.out.println(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
