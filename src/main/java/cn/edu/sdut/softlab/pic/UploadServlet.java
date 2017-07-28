/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.pic;

import cn.edu.sdut.softlab.model.User;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author gaoziqiang
 */
@Named("uploadServlet")
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

//    HttpSession session;
//    HttpServletRequest request;
//    HttpServletResponse response;
    /**
     *
     * @param uername
     */
    public void uploadFileTest(String username) {
        System.out.println("uploadFileTest!");
    }

//    public void getHttpServlet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        session = request.getSession();
//    }
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void uploadContorller(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("测试request: " + request.toString());
        User user = (User) session.getAttribute("user");
        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                // 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录  
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(new File("/home/gaoziqiang/uploadFile"));
                // System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹  

                // 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。  
                ServletFileUpload sfu = new ServletFileUpload(factory);
                sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte =  
                // 1kb 1024kb=1M 1024M = 1G  
                sfu.setHeaderEncoding("utf-8");

                // 3.  
                // 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。  
                @SuppressWarnings("unchecked")
                List<FileItem> fileItemList = sfu.parseRequest(request);
                Iterator<FileItem> fileItems = fileItemList.iterator();

                // 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件  
                while (fileItems.hasNext()) {
                    FileItem fileItem = fileItems.next();
                    // 普通表单元素  
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();// name属性值  
                        String value = fileItem.getString("utf-8");// name对应的value值  

                        System.out.println(name + " = " + value);
                    } // <input type="file">的上传文件的元素  
                    else {
                        String fileName = fileItem.getName();// 文件名称  
                        System.out.println("原文件名：" + fileName);// Koala.jpg  

                        String suffix = fileName.substring(fileName.lastIndexOf('.'));//拓展名
                        System.out.println("扩展名：" + suffix);// .jpg  

                        // 新文件名（唯一）  
                        String newFileName = new Date().getTime() + suffix;
                        System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg  

                        // 5. 调用FileItem的write()方法，写入文件  
                        File file = new File("/touxiang/" + newFileName);//路径　＋　文件名
                        System.out.println(file.getAbsolutePath());
                        fileItem.write(file);

                        // 6. 调用FileItem的delete()方法，删除临时文件  
                        fileItem.delete();

                        session.setAttribute("image_name", fileName);
                        session.setAttribute("image_path", "touxiang/" + newFileName);
                        response.sendRedirect(request.getContextPath() + "/upImage.html");

                        /* 
             * 存储到数据库时注意 1.保存源文件名称 Koala.jpg 2.保存相对路径 
             * image/1478509873038.jpg 
             *  
                         */
                        //保存在数据库
//                        if (user != null) {
//                            int myid = user.getId();
//                            String SQL = "INSERT INTO t_touxiang(image_path,user_id,old_name)VALUES(?,?,?)";
//                            int rows = JdbcHelper.insert(SQL, false, "touxiang/" + newFileName, myid, fileName);
//                            if (rows > 0) {
//                                session.setAttribute("image_name", fileName);
//                                session.setAttribute("image_path", "touxiang/" + newFileName);
//                                response.sendRedirect(request.getContextPath() + "/upImage.html");
//                            } else {
//
//                            }
//
//                        } else {
//                            session.setAttribute("loginFail", "请登录");
//                            response.sendRedirect(request.getContextPath() + "/login.html");
//                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
