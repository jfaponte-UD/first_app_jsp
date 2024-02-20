/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/form"})
public class form extends HttpServlet {

    private List<String> users = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");

    if (username != null && !username.isEmpty() && email != null && !email.isEmpty()) {
        users.add("Username: " + username + ", Email: " + email);
        // Enviar mensaje de registro exitoso y agregar un botón para regresar a index.jsp
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Registration Successful</title>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">" +
                "</head><body class=\"container mt-5\">");
        out.println("<h1 class=\"text-success\">Registration Successful</h1>");
        out.println("<p>Usuario registrado: " + username + "</p>");
        out.println("<form action=\"index.jsp\">");
        out.println("<button type=\"submit\" class=\"btn btn-primary\">Return to Main Page</button>");
        out.println("</form>");
        out.println("</body></html>");
    } else {
        // Mostrar mensaje de error si el username o el email están vacíos
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Error</title>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">" +
                "</head><body class=\"container mt-5\">");
        out.println("<h1 class=\"text-danger\">Error</h1>");
        out.println("<p>Username and email cannot be empty</p>");
        out.println("<form action=\"index.jsp\">");
        out.println("<button type=\"submit\" class=\"btn btn-primary\">Return to Main Page</button>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>List of Users</title>" +
            "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">" +
            "</head><body class=\"container mt-5\">");
    out.println("<h1>List of Users</h1>");
    out.println("<ul>");
    for (String user : users) {
        out.println("<li>" + user + "</li>");
    }
    out.println("</ul>");
    out.println("<form action=\"index.jsp\">");
    out.println("<button type=\"submit\" class=\"btn btn-primary\">Return to Main Page</button>");
    out.println("</form>");
    out.println("</body></html>");
}


}
