package cn.edu.sdut.softlab.itemcontroller;

import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.sdut.softlab.model.PublishedItem;

@Named("publishController")
@RequestScoped
public class PublishController {
	// EntityManager
	EntityManagerFactory emf;
	EntityManager em;

	// published_item
	private PublishedItem publishedItem = new PublishedItem();

	public PublishedItem getPublishedItem() {
		return publishedItem;
	}

	public void setPublishedItem(PublishedItem publishedItem) {
		this.publishedItem = publishedItem;
	}

	/**
	 * 物品发布
	 */
	public void publish() {
		System.out.println("测试开始！");

		try {
			emf = Persistence.createEntityManagerFactory("SDUTMarket");
			em = emf.createEntityManager();
			System.out.println("打印输出emf: " + emf.toString());
			// System.out.println("打印输出em: " + em.toString());
			// 开启事务
			em.getTransaction().begin();
			
			publishedItem.setPublishTime(new Date(0));
			// 持久化到数据库
			em.persist(publishedItem);
			// 提交事务
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
