/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import cn.edu.sdut.softlab.model.PublishedItem;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gaoziqiang
 */
@Named("fuzzyQuery")
public class FuzzyQuery {
    @Inject
    EntityManager em;
    
    List<PublishedItem> fuzzyQueryList = new ArrayList<PublishedItem>();

    public List<PublishedItem> getFuzzyQueryList() {
        return fuzzyQueryList;
    }

    public void setFuzzyQueryList(List<PublishedItem> fuzzyQueryList) {
        this.fuzzyQueryList = fuzzyQueryList;
    }
    
    public String fuzzyQuery() {
        Query query = em.createQuery("select item from PublishedItem item where item.name like '%三%'");
        //query.setMaxResults(5);
        fuzzyQueryList = query.getResultList();
        System.out.println("---断点测试---\r\n" + fuzzyQueryList.size());
        
        return "index.jsf";
    }
}
