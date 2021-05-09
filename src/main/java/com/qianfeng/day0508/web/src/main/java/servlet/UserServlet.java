package servlet;

import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author sweeney
 */
@WebServlet({"/","/login"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置字符编码
        resp.setContentType("text/html;charset=utf-8");
        String msg=req.getParameter("msg");
        System.out.println(msg);
        //HTML
        StringBuilder html=new StringBuilder();
        html.append("<!DOCTYPE html>\n" +
                "<html lang=\"zh-Hans\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.min.css\">\n" +
                "\n" +
                "    <title>登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container mx-auto w-48 my-auto h-screen pt-auto\">\n" +
                "    <form action=\"./login\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label><input type=\"text\" placeholder=\"用户名\" name=\"username\" class=\"border m-2 w-full py-1 px-3\"></label>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label><input type=\"text\" placeholder=\"密码\" name=\"password\" class=\"border m-2 w-full  py-1 px-3\"></label>\n" +
                "        </div>\n" +
                "        <div class=\"mt-2 text-center\">\n" +
                "            <button type=\"submit\" class=\"bg-blue-100 hover:bg-blue-300 text-violet-700 text-base py-1 px-3 rounded\">登录</button>\n" +
                "            <button type=\"reset\" class=\"bg-blue-100 hover:bg-blue-300 text-violet-700 text-base py-1 px-3 rounded\">重置</button>\n" +
                "        </div>\n" +
                "    </form>\n"
                 );
            if (msg!=null&&!"".equals(msg)){
                html.append("<div class=\"flex max-w-sm w-full mx-auto bg-white shadow-md rounded-lg overflow-hidden mt-4\" style=\"\">\n" +
                        "\t<div class=\"flex justify-center items-center w-12 bg-red-500\">\n" +
                        "\t\t<svg viewBox=\"0 0 40 40\" xmlns=\"http://www.w3.org/2000/svg\" class=\"h-6 w-6 fill-current text-white\">\n" +
                        "\t\t\t<path d=\"M20 3.36667C10.8167 3.36667 3.3667 10.8167 3.3667 20C3.3667 29.1833 10.8167 36.6333 20 36.6333C29.1834 36.6333 36.6334 29.1833 36.6334 20C36.6334 10.8167 29.1834 3.36667 20 3.36667ZM19.1334 33.3333V22.9H13.3334L21.6667 6.66667V17.1H27.25L19.1334 33.3333Z\"></path>\n" +
                        "\t\t</svg>\n" +
                        "\t</div>\n" +
                        "\t<div class=\"-mx-3 py-2 px-4\">\n" +
                        "\t\t<div class=\"mx-3\"><span class=\"text-red-500 font-semibold\">Error</span>\n" +
                        "\t\t\t<p class=\"text-gray-600 text-sm\">" );
                html.append(msg);
                html.append("</p></div>\n" +
                        "\t</div>\n" +
                        "</div>\n");
            }

        html.append("</div>\n"+
                "</body>\n" +
                "</html>");
        //发送响应
        resp.getWriter().print(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置字符集
        if (!req.getRequestURI().endsWith("login")){
            doGet(req,resp);
        }
        req.setCharacterEncoding("utf-8");
        //获取表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = new User();
        loginUser.setName(username);
        loginUser.setPassword(password);
        //执行登录业务
        UserService userService=new UserServiceImpl();
        User user=userService.check(loginUser);

        //返回登录结果、重定向至雇员界面 或者登录界面
        String msg;
        if (user!=null){
            if (password.equals(user.getPassword())){
                resp.sendRedirect("./emp");
                return;
            }else {
                msg= "密码错误！";
            }
        }else {
            msg="用户名不存在！";
        }
        resp.sendRedirect("./login?msg="+URLEncoder.encode(msg, StandardCharsets.UTF_8));
    }
}
