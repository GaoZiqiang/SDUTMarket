/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.Picture;
import cn.edu.sdut.softlab.model.PublishedItem;
import java.util.ArrayList;
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
@Named("publishedItemController")
@RequestScoped
public class PublishedItemController {

    EntityManagerFactory emf;
    EntityManager em;

    List<Picture> digitalPicList = new ArrayList<Picture>();

    public List<Picture> getDigitalPicList() {
        return digitalPicList;
    }

    public void setDigitalPicList(List<Picture> digitalPicList) {
        this.digitalPicList = digitalPicList;
    }
    //PublishedItem对象
    private PublishedItem currentPublishedItem = new PublishedItem();

    public PublishedItem getNewPublishedItem() {
        return currentPublishedItem;
    }

    public void setNewPublishedItem(PublishedItem newPublishedItem) {
        this.currentPublishedItem = newPublishedItem;
    }

    List<PublishedItem> electricItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> digitalItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> ticketItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> bookItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> sportItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> walkItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> clothesItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> recentlyPublishItemList = new ArrayList<PublishedItem>();

    //2
    List<PublishedItem> ticketItemList2 = new ArrayList<PublishedItem>();

    public List<PublishedItem> getTicketItemList2() {
        return ticketItemList2;
    }

    public void setTicketItemList2(List<PublishedItem> ticketItemList2) {
        this.ticketItemList2 = ticketItemList2;
    }

    public List<PublishedItem> getElectricItemList() {
        return electricItemList;
    }

    public void setElectricItemList(List<PublishedItem> electricItemList) {
        this.electricItemList = electricItemList;
    }

    public List<PublishedItem> getDigitalItemList() {
        return digitalItemList;
    }

    public void setDigitalItemList(List<PublishedItem> digitalItemList) {
        this.digitalItemList = digitalItemList;
    }

    public List<PublishedItem> getTicketItemList() {
        return ticketItemList;
    }

    public void setTicketItemList(List<PublishedItem> ticketItemList) {
        this.ticketItemList = ticketItemList;
    }

    public List<PublishedItem> getBookItemList() {
        return bookItemList;
    }

    public void setBookItemList(List<PublishedItem> bookItemList) {
        this.bookItemList = bookItemList;
    }

    public List<PublishedItem> getSportItemList() {
        return sportItemList;
    }

    public void setSportItemList(List<PublishedItem> sportItemList) {
        this.sportItemList = sportItemList;
    }

    public PublishedItem getCurrentPublishedItem() {
        return currentPublishedItem;
    }

    public void setCurrentPublishedItem(PublishedItem currentPublishedItem) {
        this.currentPublishedItem = currentPublishedItem;
    }

    public List<PublishedItem> getRecentlyPublishItemList() {
        return recentlyPublishItemList;
    }

    public void setRecentlyPublishItemList(List<PublishedItem> recentlyPublishItemList) {
        this.recentlyPublishItemList = recentlyPublishItemList;
    }

    public List<PublishedItem> getWalkItemList() {
        return walkItemList;
    }

    public void setWalkItemList(List<PublishedItem> walkItemList) {
        this.walkItemList = walkItemList;
    }

    public List<PublishedItem> getClothesItemList() {
        return clothesItemList;
    }

    public void setClothesItemList(List<PublishedItem> clothesItemList) {
        this.clothesItemList = clothesItemList;
    }

    //新品发布处理
    public String recentlyPublishUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item order by id desc");
        query.setMaxResults(5);
        recentlyPublishItemList = query.getResultList();

        return "index3.jsf";
    }

    //闲置数码物品处理
    public String digitalUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'digital'");
        digitalItemList = query.getResultList();

        Iterator iterator = digitalItemList.iterator();
        if (digitalItemList.size() >= 1) {
            while (iterator.hasNext()) {
                currentPublishedItem = (PublishedItem) iterator.next();
                System.out.println("---currentPublishedItem.getPicturePath()---\r\n" + currentPublishedItem.getPicturePath());
                currentPublishedItem.getPicturePath();
//                digitalPicList = (List<Picture>) currentPublishedItem.getPictures();
//                Iterator newIterator = digitalPicList.iterator();
//                while (newIterator.hasNext()) {
//                    Picture newPicture = (Picture) newIterator.next();
//                    newPicture.getPath();
//                    System.out.println("---newPicture.getPath()---\r\n" + newPicture.getPath());
//                }
            }
        }
        return "digital.jsf";
    }

    //电器日用物品处理
    public String electricUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'electric'");
        electricItemList = query.getResultList();

        return "electric.jsf";
    }

    //图书教材物品处理
    public String bookUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'Book' order by id desc");
        bookItemList = query.getResultList();

        return "book.jsf";
    }

    //运动棋牌物品处理
    public String sportUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'sport'");
        sportItemList = query.getResultList();

        return "sport.jsf";
    }

    //票券小物物品处理
    public String ticketUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'ticket' order by id desc");
        ticketItemList2 = query.getResultList();
        //query.setMaxResults(5);
        ticketItemList = query.setMaxResults(5).getResultList();

        return "index3.jsf";
    }

    //校园代步物品处理
    public String walkUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'walk'");
        walkItemList = query.getResultList();

        return "index3.jsf";
    }

    //美妆衣物物品处理
    public String clothesUtil() {
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'clothes'");
        clothesItemList = query.getResultList();

        return "index3.jsf";
    }
}
