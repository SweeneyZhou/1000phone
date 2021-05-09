package servlet;

import entity.Department;
import entity.Employee;
import entity.Job;
import service.EmployeeService;
import service.Impl.EmployeeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 17:15
 */
@WebServlet({"/emp","/emp/add","/emp/update","/emp/delete"})
public class EmployeeServlet extends HttpServlet {
    //显示列表、修改或添加页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uri=req.getRequestURI();
        String method=uri.substring(uri.lastIndexOf('/'));
        switch (method){
            case "/emp":
                list(req,resp);
                break;
            case "/add":
                addView(resp);
                break;
            case "/update":
                updateView(req,resp);
                break;
            case "/delete":
                deleteEmployee(req,resp);
        }

    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id=req.getParameter("id");
        if (id!=null){
            //删除
            EmployeeService service=new EmployeeServiceImpl();
            String msg=service.deleteEmployee(Integer.parseInt(id))?"删除成功!":"删除失败!";
            resp.sendRedirect("../emp?msg="+URLEncoder.encode(msg, StandardCharsets.UTF_8));
            return;
        }
        resp.sendRedirect("../emp");
    }

    private void updateView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id=req.getParameter("id");
        if (!"".equals(id)){
            EmployeeService service=new EmployeeServiceImpl();
            Employee emp = service.getById(Integer.parseInt(id));
            if (emp!=null){
                //获取所有职位和部门
                List<Job> jobs = service.jobList();
                List<Department> departments = service.departmentList();
                //构建HTML语句
                StringBuilder jobHTML=new StringBuilder();
                for (Job job : jobs) {
                    jobHTML.append("\t\t\t\t\t\t\t\t<option value=\"").append(job.getJobId()).append("\">");
                    jobHTML.append(job.getJobTitle());
                    jobHTML.append("</option>\n");
                }
                StringBuilder depHTML=new StringBuilder();
                for (Department dep : departments) {
                    depHTML.append("\t\t\t\t\t\t\t\t<option value=\"").append(dep.getDepartmentId()).append("\">");
                    depHTML.append(dep.getDepartmentName());
                    depHTML.append("</option>\n");
                }
                String html="<!DOCTYPE html>\n" +
                        "<html lang=\"zh-Hans\">\n" +
                        "<head>\n" +
                        "\t<meta charset=\"UTF-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                        "\t<link rel=\"stylesheet\" href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.min.css\">\n" +
                        "\t<title>修改雇员</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div class=\"m-4 p-4\" >\n" +
                        "<div class=\"mt-10 \">\n" +
                        "\t<div class=\"mt-5 \">\n" +
                        "\t\t<form action=\"../emp\" method=\"POST\">\n" +
                        "\t\t\t<div class=\"shadow overflow-hidden \">\n" +
                        "\t\t\t\t<div class=\"px-4 py-5 bg-white\">\n" +
                        "\t\t\t\t\t<div class=\"grid grid-cols-6 gap-6\">\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"employee_id\" class=\"block text-sm font-medium text-gray-700\">员工编号</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" readonly name=\"employee_id\" id=\"employee_id\" value=\""+emp.getEmployeeId()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"hire_date\" class=\"block text-sm font-medium text-gray-700\">入职日期</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"date\" name=\"hire_date\" id=\"hire_date\" value=\""+emp.getHireDate()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"manager_id\" class=\"block text-sm font-medium text-gray-700\">Manager_Id</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"manager_id\" id=\"manager_id\" value=\""+emp.getManagerId()+"\"  \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"first_name\" class=\"block text-sm font-medium text-gray-700\">First name</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"first_name\" id=\"first_name\" value=\""+emp.getFirstName()+"\"  \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"last_name\" class=\"block text-sm font-medium text-gray-700\">Last name</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"last_name\" id=\"last_name\" value=\""+emp.getLastName()+"\"  \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"email\" class=\"block text-sm font-medium text-gray-700\">Email address</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"email\" id=\"email\" value=\""+emp.getEmail()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"phone_number\" class=\"block text-sm font-medium text-gray-700\">Phone number</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"phone_number\" id=\"phone_number\" value=\""+emp.getPhoneNumber()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"salary\" class=\"block text-sm font-medium text-gray-700\">薪资</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"salary\" id=\"salary\" value=\""+emp.getSalary()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"comm\" class=\"block text-sm font-medium text-gray-700\">提成</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" name=\"comm\" id=\"comm\" value=\""+emp.getComm()+"\" \n" +
                        "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"job_id\" class=\"block text-sm font-medium text-gray-700\">职位</label>\n" +
                        "\t\t\t\t\t\t\t<select id=\"job_id\" name=\"job_id\" value=\""+emp.getJobId()+"\" \n" +
                        "\t\t\t\t\t\t\t\t\tclass=\"mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm\">\n" +
                        jobHTML+
                        "\t\t\t\t\t\t\t</select>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"department_id\" class=\"block text-sm font-medium text-gray-700\">部门</label>\n" +
                        "\t\t\t\t\t\t\t<select id=\"department_id\" name=\"department_id\" value=\""+emp.getDepartmentId()+"\" \n" +
                        "\t\t\t\t\t\t\t\t\tclass=\"mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm\">\n" +
                        depHTML+
                        "\t\t\t\t\t\t\t</select>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"mt-4 text-right\">\n" +
                        "\t\t\t\t\t\t<a  href=\"../emp\" class=\"inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-gray-600 hover:bg-gray-300 \">\n" +
                        "\t\t\t\t\t\t\tBack\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t<button type=\"submit\" class=\"inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500\">\n" +
                        "\t\t\t\t\t\t\tSave\n" +
                        "\t\t\t\t\t\t</button>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t</form>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>";
                resp.getWriter().print(html);
                return;
            }
        }
        resp.sendRedirect("../emp");
    }

    private void addView(HttpServletResponse resp) throws IOException {
        EmployeeService service=new EmployeeServiceImpl();

        //获取所有职位和部门
        List<Job> jobs = service.jobList();
        //构建HTML语句
        StringBuilder jobHTML=new StringBuilder();
        for (Job job : jobs) {
            jobHTML.append("\t\t\t\t\t\t\t\t<option value=\"").append(job.getJobId()).append("\">");
            jobHTML.append(job.getJobTitle());
            jobHTML.append("</option>\n");
        }
        List<Department> departments = service.departmentList();
        StringBuilder depHTML=new StringBuilder();
        for (Department dep : departments) {
            depHTML.append("\t\t\t\t\t\t\t\t<option value=\"").append(dep.getDepartmentId()).append("\">");
            depHTML.append(dep.getDepartmentName());
            depHTML.append("</option>\n");
        }
        String html="<!DOCTYPE html>\n" +
                "<html lang=\"zh-Hans\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "\t<link rel=\"stylesheet\" href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.min.css\">\n" +
                "\t<title>添加雇员</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"m-4 p-4\" >\n" +
                "<div class=\"mt-10 \">\n" +
                "\t<div class=\"mt-5 \">\n" +
                "\t\t<form action=\"../emp\" method=\"POST\">\n" +
                "\t\t\t<div class=\"shadow overflow-hidden \">\n" +
                "\t\t\t\t<div class=\"px-4 py-5 bg-white\">\n" +
                "\t\t\t\t\t<div class=\"grid grid-cols-6 gap-6\">\n" +
                "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                "\t\t\t\t\t\t\t<label for=\"employee_id\" class=\"block text-sm font-medium text-gray-700\">序号</label>\n" +
                "\t\t\t\t\t\t\t<input disabled type=\"text\" name=\"employee_id\" id=\"employee_id\"\n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                "\t\t\t\t\t\t\t<label for=\"hire_date\" class=\"block text-sm font-medium text-gray-700\">入职日期</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"date\" name=\"hire_date\" id=\"hire_date\"\n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-2\">\n" +
                "\t\t\t\t\t\t\t<label for=\"manager_id\" class=\"block text-sm font-medium text-gray-700\">Manager_Id</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"manager_id\" id=\"manager_id\"\n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"first_name\" class=\"block text-sm font-medium text-gray-700\">First name</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"first_name\" id=\"first_name\" autocomplete=\"given-name\"\n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"last_name\" class=\"block text-sm font-medium text-gray-700\">Last name</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"last_name\" id=\"last_name\"\n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"email\" class=\"block text-sm font-medium text-gray-700\">Email address</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"email\" id=\"email\" \n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"phone_number\" class=\"block text-sm font-medium text-gray-700\">Phone number</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"phone_number\" id=\"phone_number\" \n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"salary\" class=\"block text-sm font-medium text-gray-700\">薪资</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"salary\" id=\"salary\" \n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"comm\" class=\"block text-sm font-medium text-gray-700\">提成</label>\n" +
                "\t\t\t\t\t\t\t<input type=\"text\" name=\"comm\" id=\"comm\" \n" +
                "\t\t\t\t\t\t\t\t   class=\"px-3 py-2 mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full border shadow rounded\">\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"job_id\" class=\"block text-sm font-medium text-gray-700\">职位</label>\n" +
                "\t\t\t\t\t\t\t<select id=\"job_id\" name=\"job_id\" \n" +
                "\t\t\t\t\t\t\t\t\tclass=\"mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm\">\n" +
                jobHTML+
                "\t\t\t\t\t\t\t</select>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"col-span-6 sm:col-span-3\">\n" +
                "\t\t\t\t\t\t\t<label for=\"department_id\" class=\"block text-sm font-medium text-gray-700\">部门</label>\n" +
                "\t\t\t\t\t\t\t<select id=\"department_id\" name=\"department_id\" \n" +
                "\t\t\t\t\t\t\t\t\tclass=\"mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm\">\n" +
                depHTML+
                "\t\t\t\t\t\t\t</select>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"mt-4 text-right\">\n" +
                "\t\t\t\t\t\t<button type=\"submit\" class=\"inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500\">\n" +
                "\t\t\t\t\t\t\tSave\n" +
                "\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t<a href=\"../emp\" class=\"inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-gray-600 hover:bg-gray-300 \">\n" +
                "\t\t\t\t\t\t\tBack\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</form>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        resp.getWriter().print(html);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EmployeeService service=new EmployeeServiceImpl();
        List<Map<String,Object>> list = service.list();
        String msg = req.getParameter("msg");

        StringBuilder sb=new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"zh-Hans\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "\t<link rel=\"stylesheet\" href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.css\">\n" +
                "\t<title>雇员列表</title>\n" +
                "</head>\n" +
                "<body>\n" );
        if (msg!=null&&!"".equals(msg)){
            if (msg.contains("成功")){
                sb.append("<div class=\"flex max-w-sm w-full mx-auto bg-white shadow-md rounded-lg overflow-hidden mt-4\">\n" +
                        "\t<div class=\"flex justify-center items-center w-12 bg-green-500\">\n" +
                        "\t\t<svg viewBox=\"0 0 40 40\" xmlns=\"http://www.w3.org/2000/svg\" class=\"h-6 w-6 fill-current text-white\">\n" +
                        "\t\t\t<path d=\"M20 3.33331C10.8 3.33331 3.33337 10.8 3.33337 20C3.33337 29.2 10.8 36.6666 20 36.6666C29.2 36.6666 36.6667 29.2 36.6667 20C36.6667 10.8 29.2 3.33331 20 3.33331ZM16.6667 28.3333L8.33337 20L10.6834 17.65L16.6667 23.6166L29.3167 10.9666L31.6667 13.3333L16.6667 28.3333Z\"></path>\n" +
                        "\t\t</svg>\n" +
                        "\t</div>\n" +
                        "\t<div class=\"-mx-3 py-2 px-4\">\n" +
                        "\t\t<div class=\"mx-3\"><span class=\"text-green-500 font-semibold\">Success</span>\n" +
                        "\t\t\t<p class=\"text-gray-600 text-sm\">" );
                sb.append(msg);
                        sb.append(
                        "</p></div>\n" +
                        "\t</div>\n" +
                        "</div>\n");
            }else if (msg.contains("失败")){
                sb.append("<div class=\"flex max-w-sm w-full mx-auto bg-white shadow-md rounded-lg overflow-hidden mt-4\" style=\"\">\n" +
                        "\t<div class=\"flex justify-center items-center w-12 bg-red-500\">\n" +
                        "\t\t<svg viewBox=\"0 0 40 40\" xmlns=\"http://www.w3.org/2000/svg\" class=\"h-6 w-6 fill-current text-white\">\n" +
                        "\t\t\t<path d=\"M20 3.36667C10.8167 3.36667 3.3667 10.8167 3.3667 20C3.3667 29.1833 10.8167 36.6333 20 36.6333C29.1834 36.6333 36.6334 29.1833 36.6334 20C36.6334 10.8167 29.1834 3.36667 20 3.36667ZM19.1334 33.3333V22.9H13.3334L21.6667 6.66667V17.1H27.25L19.1334 33.3333Z\"></path>\n" +
                        "\t\t</svg>\n" +
                        "\t</div>\n" +
                        "\t<div class=\"-mx-3 py-2 px-4\">\n" +
                        "\t\t<div class=\"mx-3\"><span class=\"text-red-500 font-semibold\">Error</span>\n" +
                        "\t\t\t<p class=\"text-gray-600 text-sm\">" );
                sb.append(msg);
                sb.append("</p></div>\n" +
                        "\t</div>\n" +
                        "</div>\n");
            }
        }
        sb.append("<div class=\"m-2 p-5\">\n" +
                "\t<div class=\"flex flex-col\">\n" +
                "\t\t<div class=\"-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8\">\n" +
                "\t\t\t<div class=\"py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8\">\n" +
                "\t\t\t\t<div class=\"shadow overflow-hidden border-b border-gray-200 sm:rounded-lg\">\n" +
                "\t\t\t\t\t<table class=\"min-w-full divide-y divide-gray-200\">\n" +
                "\t\t\t\t\t\t<thead class=\"bg-gray-50\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\t\t\t\t\t\t\t\t序号\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\t\t\t\t\t\t\t\t雇员信息\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\t\t\t\t\t\t\t\t<div>职位</div>\n" +
                "\t\t\t\t\t\t\t\t<div>薪资+提成</div>\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\t\t\t\t\t\t\t\t部门\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider\">\n" +
                "\t\t\t\t\t\t\t\tManager_ID\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t\t<th scope=\"col\" class=\"relative px-6 py-3\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"./emp/add\" class=\"text-indigo-600 hover:text-indigo-900\">添加雇员</a>\n" +
                "\t\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</thead>\n" +
                "\t\t\t\t\t\t<tbody class=\"bg-white divide-y divide-gray-200\">" );
        for (int i = 1,size=list.size(); i <=size; i++) {
            Map<String,Object> emp=list.get(i-1);
            sb.append("\t\t\t\t\t\t\t<tr>\n" + "\t\t\t\t\t\t\t\t<td class=\"px-6 py-4 whitespace-nowrap\">\n" +
                    "\t\t\t\t\t\t\t\t\t<span class=\"px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-500 text-green-800\">")
                    .append(i)
                    .append("\t\t\t\t\t\t\t\t\t</span>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-3 py-2 whitespace-nowrap\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<div class=\"flex items-center\">\n")
                    .append("\t\t\t\t\t\t\t\t\t\t<div class=\"mx-4 font-medium text-gray-900 text-sm\">\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>员工编号:")
                    .append(emp.get("employee_Id"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>姓:")
                    .append(emp.get("last_name"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>名:")
                    .append(emp.get("first_Name"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-3 py-2 whitespace-nowrap\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<div class=\"flex items-center\">\n")
                    .append("\t\t\t\t\t\t\t\t\t\t<div class=\"mx-4 font-medium text-gray-900 text-sm\">\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>email:")
                    .append(emp.get("email"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>tel:")
                    .append(emp.get("phone_number"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t<div>入职日期:")
                    .append(emp.get("hire_Date"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-6 py-4 whitespace-nowrap text-sm text-gray-500\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<div class=\"text-sm text-gray-900\">")
                    .append(emp.get("job_title")
                    ).append("\n")
                    .append("\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t\t<div class=\"text-sm text-gray-500\">")
                    .append(emp.get("salary")).append("+").append(emp.get("comm"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-6 py-4 whitespace-nowrap\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<div class=\"text-sm text-gray-900\">")
                    .append(emp.get("department_name"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t</div>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-6 py-4 whitespace-nowrap\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<span class=\"px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800\">")
                    .append(emp.get("manager_id"))
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t\t</span>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\n")
                    .append("\t\t\t\t\t\t\t\t<td class=\"px-6 py-4 whitespace-nowrap text-right text-sm font-medium\">\n")
                    .append("\t\t\t\t\t\t\t\t\t<a href=\"./emp/update?id=")
                    .append(emp.get("employee_id"))
                    .append("\" class=\"text-indigo-600 hover:text-indigo-900\">编辑</a>\n")
                    .append("\t\t\t\t\t\t\t\t\t<a href=\"./emp/delete?id=")
                    .append(emp.get("employee_id"))
                    .append("\" class=\"text-indigo-600 hover:text-indigo-900\">删除</a>\n")
                    .append("\t\t\t\t\t\t\t\t</td>\n")
                    .append("\t\t\t\t\t\t\t</tr>");
        }
        sb.append(
                "\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        resp.getWriter().print(sb);
    }

    //添加和修改
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String employee_id = req.getParameter("employee_id");
        System.out.println(employee_id);
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone_number=req.getParameter("phone_number");
        String hire_date=req.getParameter("hire_date");
        String job_id = req.getParameter("job_id");
        String salary = req.getParameter("salary");
        String comm = req.getParameter("comm");
        String manager_id = req.getParameter("manager_id");
        String department_id = req.getParameter("department_id");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date hireDate = dateFormat.parse(hire_date);
            EmployeeService service=new EmployeeServiceImpl();
            String msg;
            if (employee_id!=null&&!employee_id.equals("")){
                //id不为空，修改employee
                Employee employee=new Employee(Integer.parseInt(employee_id),first_name,last_name,email,phone_number,hireDate,job_id,Integer.parseInt(salary),Double.parseDouble(comm),Integer.parseInt(manager_id),Integer.parseInt(department_id),null);
                msg=service.updateEmployee(employee)?"修改成功!":"修改失败!";
            }else {
                //id为空，添加employee
                Employee employee=new Employee(null,first_name,last_name,email,phone_number,hireDate,job_id,Integer.parseInt(salary),Double.parseDouble(comm),Integer.parseInt(manager_id),Integer.parseInt(department_id),null);
                msg=service.addEmployee(employee)?"添加成功!":"添加失败!";
            }
            resp.sendRedirect("./emp?msg="+ URLEncoder.encode(msg, StandardCharsets.UTF_8));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
