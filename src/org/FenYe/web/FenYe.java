package org.FenYe.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.FenYe.dao.UserDao;
import org.FenYe.entiy.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/fenYe")
public class FenYe {

	@RequestMapping("/show")
	public String show(Model model,@RequestParam("pageNum")int pageNum) throws IOException{
		 InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
		 SqlSession sqlsession = factory.openSession();
		 UserDao userDao = sqlsession.getMapper(UserDao.class);
		//获取第1页，10条内容，默认查询总数count
		 PageHelper.startPage(pageNum, 10);
		 List<User> users =  userDao.queryAll();
		//用PageInfo对结果进行包装
		 PageInfo page = new PageInfo(users,5);
		 model.addAttribute("page", page);
		 return "show";
	}
	@RequestMapping("/ajax")
	public String check(){
		 
         return "Ajax";
	}
	
	@RequestMapping(value="/ajax1",method=RequestMethod.GET,headers="Accept=application/json")
	@ResponseBody
	public List<User> check1(){
		 List<User> userList = new ArrayList<User>();
		 User user0 = new User();
		 user0.setName("java");
         User user1 = new User();
         user1.setName("javase");
         User user2 = new User();
         user2.setName("javaee");
         //对象加入集合
         userList.add(user0);
         userList.add(user2);
         return userList;
	}
	
	@RequestMapping("/ajax2")
	@ResponseBody
	public String check2(){
		 
         return "ERROR";
	}
}
