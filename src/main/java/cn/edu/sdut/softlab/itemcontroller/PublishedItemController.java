/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.Picture;
import cn.edu.sdut.softlab.model.PublishedItem;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * I
 *
 * @author gaoziqiang
 */
public @Named @RequestScoped class PublishedItemController {

    @Inject
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
    List<PublishedItem> electricItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> digitalItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> digitalItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> ticketItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> ticketItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> bookItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> bookItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> sportItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> sportItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> walkItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> walkItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> clothesItemList = new ArrayList<PublishedItem>();
    List<PublishedItem> clothesItemList2 = new ArrayList<PublishedItem>();

    List<PublishedItem> recentlyPublishItemList = new ArrayList<PublishedItem>();

    //2
    public List<PublishedItem> getElectricItemList2() {
        return electricItemList2;
    }

    public void setElectricItemList2(List<PublishedItem> electricItemList2) {
        this.electricItemList2 = electricItemList2;
    }

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

    public List<PublishedItem> getDigitalItemList2() {
        return digitalItemList2;
    }

    public void setDigitalItemList2(List<PublishedItem> digitalItemList2) {
        this.digitalItemList2 = digitalItemList2;
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

    public List<PublishedItem> getBookItemList2() {
        return bookItemList2;
    }

    public void setBookItemList2(List<PublishedItem> bookItemList2) {
        this.bookItemList2 = bookItemList2;
    }

    public List<PublishedItem> getSportItemList() {
        return sportItemList;
    }

    public void setSportItemList(List<PublishedItem> sportItemList) {
        this.sportItemList = sportItemList;
    }

    public List<PublishedItem> getSportItemList2() {
        return sportItemList2;
    }

    public void setSportItemList2(List<PublishedItem> sportItemList2) {
        this.sportItemList2 = sportItemList2;
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

    public List<PublishedItem> getWalkItemList2() {
        return walkItemList2;
    }

    public void setWalkItemList2(List<PublishedItem> walkItemList2) {
        this.walkItemList2 = walkItemList2;
    }

    public List<PublishedItem> getClothesItemList() {
        return clothesItemList;
    }

    public void setClothesItemList(List<PublishedItem> clothesItemList) {
        this.clothesItemList = clothesItemList;
    }

    public List<PublishedItem> getClothesItemList2() {
        return clothesItemList2;
    }

    public void setClothesItemList2(List<PublishedItem> clothesItemList2) {
        this.clothesItemList2 = clothesItemList2;
    }

    //新品发布处理
    public String recentlyPublishUtil() {
        Query query = em.createQuery("select item from PublishedItem item order by id desc");
        query.setMaxResults(5);
        recentlyPublishItemList = query.getResultList();

        return "index3.jsf";
    }

    //闲置数码物品处理
    public String digitalUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'digital' order by id desc");
        digitalItemList2 = query.getResultList();
        digitalItemList = query.setMaxResults(5).getResultList();

        return "digital.jsf";
    }

    //电器日用物品处理
    public String electricUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'electric' order by id desc");
        electricItemList2 = query.getResultList();
        electricItemList = query.setMaxResults(5).getResultList();

        return "electric.jsf";
    }

    //图书教材物品处理
    public String bookUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'Book' order by id desc");
        bookItemList2 = query.getResultList();
        bookItemList = query.setMaxResults(5).getResultList();

        return "book.jsf";
    }

    //运动棋牌物品处理
    public String sportUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'sport' order by id desc");
        sportItemList2 = query.getResultList();
        sportItemList = query.setMaxResults(5).getResultList();

        return "sport.jsf";
    }

    //票券小物物品处理
    public String ticketUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'ticket' order by id desc");
        ticketItemList2 = query.getResultList();
        //query.setMaxResults(5);
        ticketItemList = query.setMaxResults(5).getResultList();

        return "ticket.jsf";
    }

    //校园代步物品处理
    public String walkUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'walk' order by id desc");
        walkItemList2 = query.getResultList();
        walkItemList = query.setMaxResults(5).getResultList();

        return "walk.jsf";
    }

    //美妆衣物物品处理
    public String clothesUtil() {
        Query query = em.createQuery("select item from PublishedItem item where item.category.name = 'clothes' order by id desc");
        clothesItemList2 = query.getResultList();
        clothesItemList = query.setMaxResults(5).getResultList();

        return "clothes.jsf";
    }

    //集合方法
    public String returnToIndex() {

        Query query = em.createQuery("select item from PublishedItem item order by id desc");
        recentlyPublishItemList = query.setMaxResults(5).getResultList();

        Query query2 = em.createQuery("select item from PublishedItem item where item.category.name = 'digital' order by id desc");
        digitalItemList = query2.setMaxResults(5).getResultList();

        Query query3 = em.createQuery("select item from PublishedItem item where item.category.name = 'electric' order by id desc");
        electricItemList = query3.setMaxResults(5).getResultList();

        Query query4 = em.createQuery("select item from PublishedItem item where item.category.name = 'Book' order by id desc");
        bookItemList = query4.setMaxResults(5).getResultList();

        Query query5 = em.createQuery("select item from PublishedItem item where item.category.name = 'sport' order by id desc");
        sportItemList = query5.setMaxResults(5).getResultList();

        Query query6 = em.createQuery("select item from PublishedItem item where item.category.name = 'ticket' order by id desc");
        ticketItemList = query6.setMaxResults(5).getResultList();

        Query query7 = em.createQuery("select item from PublishedItem item where item.category.name = 'walk' order by id desc");
        walkItemList = query7.setMaxResults(5).getResultList();

        Query query8 = em.createQuery("select item from PublishedItem item where item.category.name = 'clothes' order by id desc");
        clothesItemList = query8.setMaxResults(5).getResultList();

        return "index.jsf";
    }
}
