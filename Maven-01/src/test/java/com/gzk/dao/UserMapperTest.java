package com.gzk.dao;

import com.gzk.pojo.User;
import com.gzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);


    @Test
    public void test()  {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(3);
            System.out.println(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    //增删改需要提交事务
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(7,"老李","4659"));
        if (res > 0) {
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userid",6);
        map.put("userpassword","2131");
        map.put("username","老张");

        int res = mapper.addUser2(map);
        if (res > 0) {
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(7,"老张","4659"));
        if (res > 0) {
            System.out.println("修改成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleUser(7);
        if (res > 0) {
            System.out.println("删除成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLog4j() {

//        logger.info("info:进入testLog4j");
//        logger.error("error: testLog4j");

        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            logger.debug("debug:进入了testLog4j");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(3);
            System.out.println(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }


        sqlSession.close();



    }
}
