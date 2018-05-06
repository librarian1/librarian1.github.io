package Servlet;

import Lib.Generation;
import Lib.Generation2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * test2
 * Created by TestUser on 2018/5/5.
 */
@WebServlet(name = "GenerationServlet",urlPatterns = "/gene",asyncSupported = true)
public class GenerationServlet extends HttpServlet {
    public GenerationServlet(){
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

        if (state.equals("generation")) {
            try {
                generation(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




    private void  generation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
        RequestDispatcher rd = null;

        try {
            String s1 = request.getParameter("n");
            String s2 = request.getParameter("m1");
            String s3 = request.getParameter("m2");
            if (!((s1.matches("^[0.0-9.0]+$"))||(s2.matches("^[0.0-9.0]+$"))||( s3.matches("^[0.0-9.0]+$")))) {
                rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("msg", "输入参数必须为符合要求的正整数,请重新输入！！！");
                 rd.forward(request, response);
            }
            int n= Integer.parseInt(s1);
            int m1= Integer.parseInt(s2);
            int m2= Integer.parseInt(s3);
            int o = Integer.parseInt(request.getParameter("o"));
            int c = Integer.parseInt(request.getParameter("c"));
            int b1 = Integer.parseInt(request.getParameter("b"));
            if (n<1|| m1<0 || m2 <50||n>10000||m1>100||m2<50||o<1||o>10||m1>m2) {
                rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("msg", "输入参数错误,请重新输入！！！");

                rd.forward(request, response);
            }
            Generation2 generation2 = new Generation2();
            generation2.gene(n,m1,m2,b1,o,c);


            String path = request.getContextPath();
            String ctxPath = request.getSession().getServletContext().getRealPath("/");//文件写入的目录
            String fileName =   "result.txt";

            FileWriter fileWriter = new FileWriter(ctxPath+fileName,true);
            PrintWriter out = response.getWriter();

/*             
            String[] str = new String[n];
            str = generation2.gene(n,m1,m2,b1,o,c);
            fileWriter.write(""+str);
*/            
           for (int i = n; i > 0; i--) {
                String str = null;

                //调用产生四则运算的方法，将返回的String写入文档
                str=generation2.gene(n,m1,m2,b1,o,c);



                fileWriter.write("\r\n"+str);
            }

            rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "文件创建成功！！！");
            rd.forward(request, response);


            fileWriter.flush();
            out.flush();
            out.close();

            System.out.println(fileName);

        }catch (Exception e) {
            throw new Exception("sssss");
        }
    }

}
