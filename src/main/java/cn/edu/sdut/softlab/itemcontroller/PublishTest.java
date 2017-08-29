/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.PublishedItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gaoziqiang
 */

@Named("publishTest")
//@RequestScoped
public class PublishTest extends HttpServlet {

    EntityManagerFactory emf;
    EntityManager em;

    List<PublishedItem> recentlyPublishItemList = new ArrayList<PublishedItem>();

    public List<PublishedItem> getRecentlyPublishItemList() {
        return recentlyPublishItemList;
    }

    public void setRecentlyPublishItemList(List<PublishedItem> recentlyPublishItemList) {
        this.recentlyPublishItemList = recentlyPublishItemList;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("---断点测试---\r\n");
        emf = Persistence.createEntityManagerFactory("SDUTMarket");
        em = emf.createEntityManager();

        Query query = em.createQuery("select item from PublishedItem item order by id desc");
        query.setMaxResults(5);
        recentlyPublishItemList = query.getResultList();
        System.out.println("---断点测试---\r\n" + recentlyPublishItemList.size());

        //return "index3.jsf";
        response.sendRedirect(request.getContextPath() + "/index3.jsf");
        
        //returnTest();
    }
    
    public static String returnTest() {
        return "index3.jsf";
    }
}
