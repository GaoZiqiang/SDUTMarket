package cn.edu.sdut.softlab.usercontroller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.sdut.softlab.model.User;
@Named("registerController")
@RequestScoped
public class RegisterController {
	// EntityManager对象
	EntityManagerFactory emf;
	EntityManager em;
	// user对象
	private User registerUser = new User();

	public User getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}

	//用户注册
	public void register() {
		System.out.println("测试开始！");

		try {
			emf = Persistence.createEntityManagerFactory("SDUTMarket");
			em = emf.createEntityManager();
			System.out.println("打印输出emf: " + emf.toString());
			//System.out.println("打印输出em: " + em.toString());
			//开启事务
			em.getTransaction().begin();
			//持久化到数据库
			em.persist(registerUser);
			//提交事务
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	//用户名验证器
	//用户密码验证器
	//验证码验证
}
