import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiplicationTableServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        servletResponse.setCharacterEncoding("utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"zh-Hans\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                        "    <link href=\"https://cdn.bootcdn.net/ajax/libs/tailwindcss/2.1.1/tailwind.min.css\" rel=\"stylesheet\">\n" +
                        "    <title>九九乘法表</title>\n" +
                        "    <style>\n" +
                        "        table {\n" +
                        "            border-collapse: collapse;\n" +
                        "        }\n" +
                        "\n" +
                        "        table, th, td {\n" +
                        "            border: 1px solid black;\n" +
                        "        }\n" +
                        "\n" +
                        "        td {\n" +
                        "            text-align: center;\n" +
                        "            width: 5em;\n" +
                        "            line-height: 2em;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<table class=\"m-3\">\n" +
                        "    <tbody>\n");
        for (int i = 1; i <= 9; i++) {
            sb.append("        <tr>");
            for (int j = 1; j <= i; j++) {
                sb.append("<td>");
                sb.append(j).append("x").append(i).append("=").append(i * j);
                sb.append("</td>");
            }
            sb.append("</tr>\n");
        }
//        "        <tr><td>1*1</td></tr>\n" +
//        "        <tr><td>1*2</td><td>2*2</td></tr>\n" +
        sb.append("    </tbody>\n" +
                "</table>\n" +
                "<a class=\"m-3 hover:underline\" href=\"#\" onClick=\"javascript :history.go(-1);\">返回上一页</a>" +
                "</body>\n" +
                "</html>");

        PrintWriter writer = servletResponse.getWriter();
        servletResponse.getWriter();
        writer.print(sb);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
