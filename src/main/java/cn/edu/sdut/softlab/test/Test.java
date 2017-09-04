/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import cn.edu.sdut.softlab.model.PublishedItem;
import cn.edu.sdut.softlab.model.User;
import freemarker.template.Configuration;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import freemarker.template.Template;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author gaoziqiang
 */
public class Test extends HttpServlet {

    @Inject
    EntityManager em;

    private PublishedItem ftlItem = new PublishedItem();

    public PublishedItem getFtlItem() {
        return ftlItem;
    }

    public void setFtlItem(PublishedItem ftlItem) {
        this.ftlItem = ftlItem;
    }

    private Configuration _config;

    public void init() {
        // 初始化Freemarker配置
        _config = new Configuration();
        // 设置Freemarker模板文件的位置
        _config.setServletContextForTemplateLoading(this.getServletContext(), "templates");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 数据

        System.out.println("---doGet---\r\n");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //接收请求的参数
        String userName = request.getParameter("name"); //这里的name指的是标签中的name属性

        //String userPassword = request.getParameter("password"); //这里的password指的也是标签中的name属性

        System.out.println("姓名为：" + userName);
        
        
        FacesContext context = FacesContext.getCurrentInstance();

        UIOutput outText = new UIOutput();//页面状态域，用于显示页面描述 
        outText = (UIOutput) context.getViewRoot().findComponent("form:grid:value");

        UIComponent text = context.getViewRoot().findComponent("form:grid:value");

        System.out.println("---JSF组建测试---\r\n" + text.toString());
        System.out.println("---JSF组建outText测试---\r\n" + outText.getValue());
        try {
            Query query = em.createQuery("select item from PublishedItem item where item.id = 12");
            List resultList = query.getResultList();
            System.out.println("resultList测试:  " + resultList.size());

            Iterator iterator = resultList.iterator();
            if (resultList.size() == 1) {
                while (iterator.hasNext()) {
                    ftlItem = (PublishedItem) iterator.next();
                    System.out.println("---打印ftlItem的名字---\r\n" + ftlItem.getName());
                }
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map root = new HashMap();
        root.put("id", ftlItem.getId());
        root.put("name", ftlItem.getName());
        root.put("price", ftlItem.getSellPrice());
        root.put("information", ftlItem.getDescription());

        // 获取模板
        Template t = _config.getTemplate("Test.ftl");

        // 准备输出， 使用模板的编码作为本页的charset
        response.setContentType("text/html; charset=" + t.getEncoding());
        PrintWriter out = response.getWriter();

        try {
            // 在模板中加入动态数据
            t.process(root, out);
        } catch (freemarker.template.TemplateException e) {
            throw new ServletException("处理Template模版中出现错误", e);
        }
    }

    public void login() throws IllegalStateException, SecurityException, HeuristicMixedException,
            HeuristicRollbackException, RollbackException, SystemException {
        try {
            Query query = em.createQuery("select item from PublishedItem item where item.id = 12");
            List resultList = query.getResultList();
            System.out.println("resultList测试:  " + resultList.size());

            Iterator iterator = resultList.iterator();
            if (resultList.size() == 1) {
                while (iterator.hasNext()) {
                    ftlItem = (PublishedItem) iterator.next();
                }
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
