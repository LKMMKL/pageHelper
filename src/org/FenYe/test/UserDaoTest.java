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
		//��ȡ��1ҳ��10�����ݣ�Ĭ�ϲ�ѯ����count
		 PageHelper.startPage(1, 10);
		 //������м�¼
		 List<User> users =  userDao.queryAll();
		//��PageInfo�Խ�����а�װ,����List����,���ڵ�������ʾ����ҳ
		 PageInfo page = new PageInfo(users,5);
		 
		 System.out.println("ÿҳ�ļ�¼��"+page.getPageSize());
		 System.out.println("��ǰҳ��"+page.getPageNum());
		 System.out.println("�ӵڼ�����¼��ʼ��ʾ"+page.getStartRow());
		 System.out.println("�ӵڼ�����¼������ʾ"+page.getEndRow());
		 System.out.println("��ҳ����"+page.getPages());
		 System.out.println("�ܼ�¼����"+page.getTotal());
		 System.out.println("�Ƿ�����һҳ��"+page.isHasPreviousPage());
		 System.out.println("�Ƿ�����һҳ��"+page.isHasNextPage());
		 //��ȡ��ǰ��ʾ��ҳ������
		 int[] nums = page.getNavigatepageNums();
		 for(int num:nums){
			 System.out.println(num);
		 }
//		 for(User user:users){
//			 System.out.println(user);
//		 }
		 
	}
}
