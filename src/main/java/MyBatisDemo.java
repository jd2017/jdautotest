import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis 入门代码

 */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //1，加载mybatis的核心配置文件，获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2，获取Sqlsession对象，用它来执行sql
        SqlSession  sqlSession = sqlSessionFactory.openSession();

        //3，执行sql
        List<Object> users = sqlSession.selectList("com.itheima.mapper.UserMapper.selectAll");
        System.out.println(users);

        // 4，释放资源
        sqlSession.close();

    }
}
