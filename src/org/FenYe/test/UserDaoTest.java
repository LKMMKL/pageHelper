package org.FenYe.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.FenYe.dao.UserDao;
import org.FenYe.entiy.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class UserDaoTest {

	@Test
	public void testQueryAll() throws IOException{
		 InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
		 SqlSession sqlsession = factory.openSession();
		 UserDao userDao = sqlsession.getMapper(UserDao.class);
		//获取第1页，10条内容，默认查询总数count
		 PageHelper.startPage(1, 10);
		 //查出所有记录
		 List<User> users =  userDao.queryAll();
		//用PageInfo对结果进行包装,传入List对象,和在导航上显示多少页
		 PageInfo page = new PageInfo(users,5);
		 
		 System.out.println("每页的记录数"+page.getPageSize());
		 System.out.println("当前页数"+page.getPageNum());
		 System.out.println("从第几条记录开始显示"+page.getStartRow());
		 System.out.println("从第几条记录结束显示"+page.getEndRow());
		 System.out.println("总页数："+page.getPages());
		 System.out.println("总记录数："+page.getTotal());
		 System.out.println("是否有上一页："+page.isHasPreviousPage());
		 System.out.println("是否有下一页："+page.isHasNextPage());
		 //获取当前显示的页的索引
		 int[] nums = page.getNavigatepageNums();
		 for(int num:nums){
			 System.out.println(num);
		 }
//		 for(User user:users){
//			 System.out.println(user);
//		 }
		 
	}
}
