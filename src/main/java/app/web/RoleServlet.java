package app.web;

import app.service.role.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/roles")
public class RoleServlet extends HttpServlet {

    private final RoleService service = RoleService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", service.getAll());
        getServletContext().getRequestDispatcher("/roles.jsp").forward(req, resp);
    }
}
