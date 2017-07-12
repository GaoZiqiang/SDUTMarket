package cn.edu.sdut.softlab.usercontroller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("facesTest")
@RequestScoped
public class FacesTest {

	/**
	 * 测试facesContext存储的内容的作用域
	 */
	public void test() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName"));
	}
}
