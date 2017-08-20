/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.PublishedItem;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author gaoziqiang
 */
@Named("electric")
@RequestScoped
public class ElectricController {

    EntityManagerFactory emf;
    EntityManager em;
    List<PublishedItem> itemList;

    public List<PublishedItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<PublishedItem> itemList) {
        this.itemList = itemList;
    }

    //PublishedItem对象
    private PublishedItem currentPublishedItem = new PublishedItem();

    public PublishedItem getNewPublishedItem() {
        return currentPublishedItem;
    }

    public void setNewPublishedItem(PublishedItem newPublishedItem) {
        this.currentPublishedItem = newPublishedItem;
    }

    //闲置数码物品处理
    public String eclectricUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'electric'");
        itemList = query.getResultList();
        System.out.println("---itemList的size: " + itemList.size() + "---");
        Iterator iterator = itemList.iterator();
        if (itemList.size() >= 1) {
            while (iterator.hasNext()) {
                currentPublishedItem = (PublishedItem) iterator.next();
            }
        }

        return "publishedItem";
    }
}
