package cn.edu.sdut.softlab.usercontroller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import cn.edu.sdut.softlab.model.User;

@Named("loginController")
@RequestScoped
public class LoginController {
	// EntityManager对象
	EntityManagerFactory emf;
	EntityManager em;

	// user对象
	private User loginUser = new User();
	private User currentUser = new User();

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * 用户登录
	 */
        //登录设置建议：可以使用HttpServlet将user加入session
	public void login() throws IllegalStateException, SecurityException, HeuristicMixedException,
			HeuristicRollbackException, RollbackException, SystemException {
		try {
			emf = Persistence.createEntityManagerFactory("SDUTMarket");
			// System.out.println("emf测试: " + emf.toString());
			em = emf.createEntityManager();
			// System.out.println("em测试: " + em.toString());
			Query query = em.createQuery("select u from User u where u.name = :name and u.password = :password");
			query.setParameter("name", loginUser.getName());
			query.setParameter("password", loginUser.getPassword());
			System.out.println("query测试:  " + query.toString());
			List resultList = query.getResultList();
			System.out.println("resultList测试:  " + resultList.size());

			Iterator iterator = resultList.iterator();
			if (resultList.size() == 1) {
				while (iterator.hasNext()) {
					currentUser = (User) iterator.next();
				}
				System.out.println("登录成功");
				// currentUser = loginUser;
				System.out.println("测试userId:  " + currentUser.getId());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId",
						currentUser.getId());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName",
						currentUser.getName());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userNickname",
						currentUser.getNickname());
				// System.out.println("测试userId: " +
				// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId"));
			} else {
				System.out.println("登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 用户登录状态判断
	/**
	 * 用户退出登录
	 */
	public void logOut() {
		System.out.println("logOut方法测试--当前用户名:  " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userName"));
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = facesContext.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) extContext.getRequest();
		HttpSession session = req.getSession(false);
		HttpServletResponse res = (HttpServletResponse) extContext.getResponse();
		try {
			res.sendRedirect("index.jsf");
		} catch (IOException e) {
			e.printStackTrace();

		}

		// 指示当前response已产生，JSF应该在当前阶段执行完成后立刻结束整个生命周期
		facesContext.responseComplete();
		if (session != null) {
			//ExtCmdManager.resultMap.remove(session);
			// 删除session
			session.invalidate();
			System.out.println("测试session的状态:  " + session.toString());
		}

	}

}
