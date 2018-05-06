package Servlet;

import Lib.Generation2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * test2
 * Created by TestUser on 2018/5/5.
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/upload",asyncSupported = true)
public class UploadServlet extends HttpServlet {
    public UploadServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
        PrintWriter out = response.getWriter();   //服务器向客户端反馈的时候需要用流向客户端输出数据
        String state = request.getParameter("state");  //获取jsp页面发生的事件

        if (state.equals("upload")) {
            try {
               upload(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



    private void  upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
        RequestDispatcher rd = null;
        try{

            //调用你上传文件的方法
            //先将上传的文件解析，将每一行作为一个字符串，输入到方法中，判断结果是否正确。
            rd = request.getRequestDispatcher("main.jsp");//返回页面
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
