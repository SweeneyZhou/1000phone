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
@WebServlet("/login")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置字符编码
        resp.setContentType("text/html;charset=utf-8");
        //HTML
        String html="<!DOCTYPE html>\n" +
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
                "    <form action=\"./login\" method=\"post\" class=\"\">\n" +
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
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        //发送响应
        resp.getWriter().print(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        //获取表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = new User(username, password, null, null);
        //执行登录业务
        UserService userService=new UserServiceImpl();
        User user=userService.check(loginUser);

        //返回登录结果、重定向至雇员界面 或者登录界面
        String msg;
        if (user!=null){
            if (password.equals(user.getPassword())){
                System.out.println("登录成功！");
                return;
            }else {
                msg= URLEncoder.encode("密码错误！", StandardCharsets.UTF_8);
            }
        }else {
            msg= URLEncoder.encode("用户名不存在！", StandardCharsets.UTF_8);
        }
        resp.sendRedirect("/web/login?msg="+msg);
    }
}
