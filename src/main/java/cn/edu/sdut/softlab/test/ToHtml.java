/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author gaoziqiang
 */
public class ToHtml extends HttpServlet {

    //String file_name;
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String name = "";
        ServletContext sc = getServletContext();
        //你要访问的jsp文件名，如index,不包括扩展名//则你访问这个servlet是加参数，如http://localhost/test/toHtml?file_name=index
        String file_name = request.getParameter("file_name");
        //你要生成的也没的文件名
        url = "/" + file_name + ".jsp";
        // 这是生成的html文件名,如index.htm.文件名字与源文件名相同。扩展名为htm
        name = "/home/gaoziqiang/SDUTMarket" + "//" + file_name + ".html";
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();

        final ServletOutputStream stream = new ServletOutputStream() {
            public void write(byte[] data, int offset, int length) {
                os.write(data, offset, length);
            }

            @Override
            public void write(int b) throws IOException {
                os.write(b);
            }

            @Override
            public boolean isReady() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        final PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
        HttpServletResponse rep = new HttpServletResponseWrapper(response) {
            public ServletOutputStream getOutputStream() {
                return stream;
            }

            public PrintWriter getWriter() {
                return pw;
            }

        };

        rd.include(request, rep);
        pw.flush();
        FileOutputStream fos = new FileOutputStream(name);//把jsp输出的内容写到xxx.html
        os.writeTo(fos);
        fos.close();
        PrintWriter out = response.getWriter();
        out.print("<p align=center><font size=3 color=red>页面已经成功生成！single<br>http://www.agilejava.org/space/? 233</font></p>");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
    }
}
