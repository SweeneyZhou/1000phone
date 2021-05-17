package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author sweeney 2021/5/14 17:50
 */
@WebServlet({"/api/user/list", "/api/user/add","/api/user/update","/api/user/delete"})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //保存要输出的对象
        Object respObject=null;
        String uri=req.getRequestURI();
        if(uri.endsWith("/list")){
            UserService service=new UserServiceImpl();
            String id=req.getParameter("id");
            if(id!=null&&!"".equals(id.trim())){
                //id不为空则根据id查找(查一个
                respObject = service.list(Integer.valueOf(id));
            }else{
                //id为空则返回全部列表(查多个
                respObject = service.list();
            }
            out.print(JSON.toJSONString(respObject));
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //增删改都需要用POST方法提交
        PrintWriter out = resp.getWriter();
        String uri=req.getRequestURI();
        //封装请求对象数据
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String tel=req.getParameter("tel");
        //处理请求
        Object respObject = "Not Acceptable";
        UserService service=new UserServiceImpl();
        System.out.println(uri);
        System.out.println(id);
        if (id!=null&&id.length()>0){
            // id不为空和空串，则删除或修改
            User user = new User(Integer.parseInt(id),name,password,tel,new Date());
            if(uri.endsWith("/update")){
                // 修改
                if (service.update(user)) respObject="OK";
            }else if(uri.endsWith("/delete")){
                // 删除
                if (service.delete(user)) respObject="OK";
            }
        }else{
            // id为空或空,则添加
            User user = new User(null,name,password,tel,new Date());
            if (service.save(user)) respObject="OK";
        }
        out.print(JSON.toJSONString(respObject));
        out.close();

    }
}
