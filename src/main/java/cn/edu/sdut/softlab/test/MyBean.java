/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author gaoziqiang
 */
@Named("myBean")
public class MyBean {

    public void action(ActionEvent event) {
        String attrvalue1 = (String) event.getComponent().getAttributes().get("attrname1");
        String attrvalue2 = (String) event.getComponent().getAttributes().get("attrname2");
        System.out.println("---打印输出attrvalue1---\r\n" + attrvalue1);
    }

    public void getJSFTest() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        FacesContext.getUIComponent(""  );
//        UIComponent inputtextValue;
//        inputtextValue = context.getViewRoot().findComponent("index1:indexForm:commandTest");
//        System.out.println("---打印inputtextValue---\r\n" + inputtextValue);

        FacesContext context = FacesContext.getCurrentInstance();

        UIOutput outText = new UIOutput();//页面状态域，用于显示页面描述 
        outText = (UIOutput) context.getViewRoot().findComponent("form:grid:value");

        UIComponent text = context.getViewRoot().findComponent("form:grid:value");

        System.out.println("---JSF组建测试---\r\n" + text.toString());
        System.out.println("---JSF组建outText测试---\r\n" + outText.getValue());
    }
}
