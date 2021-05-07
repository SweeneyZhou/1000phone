import entity.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class EmployeeListServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        EmployeeService service = new EmployeeServiceImpl();
        List<Employee> all = service.getAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"zh-Hans\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "    <title>员工列表</title>\n" +
                "    <link href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.min.css\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<table class=\"m-auto border-collapse border shadow-2xl leading-7 table-fixed\" >\n" +
                "  <thead>\n" +
                "  <tr class=\"bg-blue-400\">\n" +
                "    <th class=\"w-1/12 border border-blue-300\">序号</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">ID</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">名(First Name)</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">姓(Last Name)</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">邮箱</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">手机</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">入职日期</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">职位</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">薪资</th>\n" +
                "    <th class=\"w-1/24 border border-blue-300\">提成</th>\n" +
                "    <th class=\"w-1/24 border border-blue-300\">ManagerID</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">部门</th>\n" +
                "    <th class=\"w-1/12 border border-blue-300\">头像</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n");
        for (int i = 1, size = all.size(); i <= size; i++) {
            Employee employee = all.get(i - 1);
            sb.append("  <tr class=\"hover:bg-blue-100\">\n");
            sb.append("    <th class=\"border border-blue-300\">").append(i).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getEmployeeId()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getFirstName()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getLastName()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getEmail()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getPhoneNumber()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getHireDate()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getJobTitle()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getSalary()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getComm()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getManagerId()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getDepartmentName()).append("</th>\n");
            sb.append("    <th class=\"border border-blue-300\">").append(employee.getPic()).append("</th>\n");
            sb.append("  </tr>\n");
        }
//                "  <tr class=\"hover:bg-blue-100\">\n" +
//                "    <th class=\"border border-blue-300\">ID</th>\n" +
//                "    <th class=\"border border-blue-300\">名(First Name)</th>\n" +
//                "    <th class=\"border border-blue-300\">姓(Last Name)</th>\n" +
//                "    <th class=\"border border-blue-300\">邮箱</th>\n" +
//                "    <th class=\"border border-blue-300\">手机</th>\n" +
//                "    <th class=\"border border-blue-300\">入职日期</th>\n" +
//                "    <th class=\"border border-blue-300\">职位</th>\n" +
//                "    <th class=\"border border-blue-300\">薪资</th>\n" +
//                "    <th class=\"border border-blue-300\">ManagerID</th>\n" +
//                "    <th class=\"border border-blue-300\">部门</th>\n" +
//                "    <th class=\"border border-blue-300\">头像</th>\n" +
//                "  </tr>\n" +
        sb.append(
                "  </tbody>\n" +
                        "</table>\n" +
                        "</body>\n" +
                        "</html>");
        res.setCharacterEncoding("utf-8");
        res.getWriter().print(sb);
    }
}
