/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import freemarker.template.Configuration;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import freemarker.template.Template;

/**
 *
 * @author gaoziqiang
 */
public class Test extends HttpServlet {

    private Configuration _config;

    public void init() {
        // 初始化Freemarker配置
        _config = new Configuration();
        // 设置Freemarker模板文件的位置
        _config.setServletContextForTemplateLoading(this.getServletContext(), "templates");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 数据
        Map root = new HashMap();
        root.put("user", "Jack");

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
}
