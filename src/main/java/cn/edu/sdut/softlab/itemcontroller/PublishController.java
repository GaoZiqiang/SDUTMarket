package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.Category;
import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.sdut.softlab.model.PublishedItem;
import cn.edu.sdut.softlab.model.User;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

@Named("publishController")
@RequestScoped
public class PublishController {
    // EntityManager

    EntityManagerFactory emf;
    EntityManager em;

    //Credentials 
    private Credentials tempCategory = new Credentials();
    
    public Credentials getTempCategory() {
        return tempCategory;
    }
    
    public void setTempCategory(Credentials tempCategory) {
        this.tempCategory = tempCategory;
    }
    //Category
    private Category currentCategory = new Category();
    
    public Category getCurrentCategory() {
        return currentCategory;
    }
    
    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }
    // published_item
    private PublishedItem publishedItem = new PublishedItem();
    
    public PublishedItem getPublishedItem() {
        return publishedItem;
    }
    
    public void setPublishedItem(PublishedItem publishedItem) {
        this.publishedItem = publishedItem;
    }

    //user
    private User currentUser = new User();
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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

            //查找上级分类
            Query query = em.createQuery("select newCategory from Category newCategory where newCategory.name = :name");
            query.setParameter("name", tempCategory.getCategory());
            List categoryList = query.getResultList();
            Iterator iterator = categoryList.iterator();
            if (categoryList.size() >= 1) {
                while (iterator.hasNext()) {
                    currentCategory = (Category) iterator.next();
                    publishedItem.setCategory(currentCategory);
                }
            }
            System.out.print("---打印当前用户名---");
            System.out.print(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName").toString());
            //查找当前用户
            Query query2 = em.createQuery("select u from User u where u.name = :name");
            query2.setParameter("name", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName"));
            List userList = query2.getResultList();
            Iterator iterator2 = userList.iterator();
            if (userList.size() >= 1) {
                while (iterator2.hasNext()) {
                    currentUser = (User) iterator2.next();
                    publishedItem.setUser(currentUser);
                }
            }
            
            publishedItem.setPublishTime(new Date(0));
            publishedItem.setBargin(true);

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
