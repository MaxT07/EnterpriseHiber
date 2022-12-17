package servlets;

import exception.DepartmentException;
import model.Department;
import services.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import services.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentServlet extends HttpServlet {

    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.departmentService = new DepartmentService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("action");

        if (StringUtils.isNotBlank(id)) {
            Department dep = departmentService.getById(Integer.parseInt(id));
            if ("edit".equals(action)) {
                req.setAttribute("department", dep);
                getServletContext().getRequestDispatcher("/views/dep/depEdit.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                req.setAttribute("department", dep);
                getServletContext().getRequestDispatcher("/views/dep/depDelete.jsp").forward(req, resp);
            }
        }else if (StringUtils.isNotBlank(id)&& "create".equals(action))
        { getServletContext().getRequestDispatcher("/views/dep/depAdd.jsp?id=" + id).forward(req, resp);

        } else {
            ArrayList<Department> departments = departmentService.getAll();
            req.setAttribute("department", departments);
            getServletContext().getRequestDispatcher("/views/dep/department.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("action");
        if (StringUtils.isNotBlank(id)) {
            Department dep = departmentService.getById(Integer.parseInt(id));
            if ("edit".equals(action)) {
                doPut(req, resp);
            } else if ("delete".equals(action)) {
                doDelete(req, resp);
            }
        } else {

            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String description = req.getParameter("description");
            Department department = new Department(name, phone, email, address, description);

            try {
                departmentService.create(department);
                req.setAttribute("department", department);
                resp.sendRedirect(req.getContextPath() + "/departments");
            } catch (DepartmentException error) {
                req.setAttribute("department", department);
                req.setAttribute("error", error.violations);
                req.setAttribute("errorMsg", error.getMessage());
                getServletContext().getRequestDispatcher("/views/dep/depAdd.jsp?id=" + id).forward(req, resp);
            }
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String description = req.getParameter("description");
        Department department = new Department(id, name, phone, email, address, description);
        try {
        departmentService.update(department);
            req.setAttribute("department", department);
            resp.sendRedirect(req.getContextPath() + "/departments");
        } catch (DepartmentException error) {
            req.setAttribute("department", department);
            req.setAttribute("error", error.violations);
            req.setAttribute("errorMsg", error.getMessage());
            getServletContext().getRequestDispatcher("/views/dep/depEdit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        departmentService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/departments");
    }
}