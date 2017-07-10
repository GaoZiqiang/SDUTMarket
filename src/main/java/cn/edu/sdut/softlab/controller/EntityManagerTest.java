package cn.edu.sdut.softlab.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.sdut.softlab.model.User;

@Named("test")
@RequestScoped
public class EntityManagerTest {
	
	EntityManagerFactory emf;
	EntityManager em;

	// 创建User对象
	private User userTest = new User();

	public User getUserTest() {
		return userTest;
	}

	public void setUserTest(User userTest) {
		this.userTest = userTest;
	}

	// 测试persistence.xml的配置情况
	public void persistenceTest() {
		System.out.println("测试开始！");

		try {
			emf = Persistence.createEntityManagerFactory("SDUTMarket");
			em = emf.createEntityManager();
			
			System.out.println("打印输出emf: " + emf.toString());
			//System.out.println("打印输出em: " + em.toString());
			
			userTest.setName("555");
			userTest.setNickname("gaohan");
			userTest.setPassword("555");
			em.getTransaction().begin();
			em.persist(userTest);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
		
	}
}
