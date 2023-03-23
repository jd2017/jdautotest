package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public  void testSelectAll() throws IOException {
        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void testSelectById() throws IOException {
        Integer id = 2;
        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  selectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%"+ companyName +"%";
        brandName = "%"+ brandName +"%";

        // 封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);


        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  selectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%"+ companyName +"%";
        brandName = "%"+ brandName +"%";

        // 封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);

        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  addTest() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        brandMapper.add(brand);
        System.out.println(brand.getId());

        //提交事务
//        sqlSession.commit();

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  updateTest() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导update";
        String description = "手机中的战斗机1";
        int ordered = 100;
        int id = 5;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        brandMapper.update(brand);
        System.out.println(brand.getId());

        //提交事务
//        sqlSession.commit();

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  deleteByIdTest() throws IOException {
        int id = 5;

        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        brandMapper.deleteById(id);

        //提交事务
//        sqlSession.commit();

        //5，释放资源
        sqlSession.close();
    }
    @Test
    public  void  deleteByIdsTest() throws IOException {
        int[] ids = {4,5};

        //1,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2,获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3，获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4，执行方法
        brandMapper.deleteByIds(ids);

        //提交事务
//        sqlSession.commit();

        //5，释放资源
        sqlSession.close();
    }
}
