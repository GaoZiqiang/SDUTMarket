/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;

/**
 *
 * @author gaoziqiang
 */
@Named("mainTest")
public class MainTest {

    public void FMTest() throws TemplateException {
        System.out.println("---FMTest Start!---\r\n");
        Configuration configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        System.out.println("---打印当前路径---\r\n" + this.getClass().getResource("/"));
        configuration.setClassForTemplateLoading(this.getClass(),"cn.edu.sdut.softlab.controller");
        //configuration.setTemplateLoader(new ClassTemplateLoader(MainTest.class, "cn/edu/sdut/softlab/test"));
        try {
            Template template = configuration.getTemplate("temp.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> context = new HashMap<String, Object>();

            context.put("message", "我的第一个Maven_FreeMarker程序");

            template.process(context, writer);
            System.out.println(writer.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
