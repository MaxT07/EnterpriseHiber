package servlets;

import exception.EmployeeException;
import model.Employee;
import services.EmployeeService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.employeeService = new EmployeeService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
// TODO: add Edit/Delete. It should execute doPut and doDelete
        String id = req.getParameter("id");
        String depId = req.getParameter("depId");
        String action = req.getParameter("action");

            if (StringUtils.isNotBlank(id)) {
                Employee employee = employeeService.getById(Integer.parseInt(id));
                if ("edit".equals(action)) {
                    req.setAttribute("employee", employee);
                    getServletContext().getRequestDispatcher("/views/emp/empEdit.jsp").forward(req, resp);
                } else if ("delete".equals(action)) {
                    req.setAttribute("employee", employee);
                    getServletContext().getRequestDispatcher("/views/emp/empDelete.jsp").forward(req, resp);
                }
            }else if (StringUtils.isNotBlank(depId)&& "create".equals(action))

        {
         getServletContext().getRequestDispatcher("/views/emp/empAdd.jsp?depId=" + depId).forward(req, resp);

            } else {
              List<Employee> employees = employeeService.getByDepId(Integer.parseInt(depId));
                req.setAttribute("employee", employees);
                req.setAttribute("depId", depId);
                getServletContext().getRequestDispatcher("/views/emp/employees.jsp").forward(req, resp);
            }

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("action");
        if (StringUtils.isNotBlank(id)) {
            Employee employee = employeeService.getById(Integer.parseInt(id));
            if ("edit".equals(action)) {
                doPut(req, resp);
            } else if ("delete".equals(action)) {
                doDelete(req, resp);
            }
        } else {

                String firstname = req.getParameter("firstname");
                String lastname = req.getParameter("lastname");
                String age = req.getParameter("age");
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                String position = req.getParameter("position");
                int depId = Integer.parseInt(req.getParameter("depId"));
                Employee employee = new Employee(firstname, lastname, age, phone, email, position, depId);

            try {   employeeService.create(employee);
            req.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/views/emp/empAdded.jsp").forward(req, resp);

            } catch (EmployeeException error) {
                req.setAttribute("employee", employee);
                req.setAttribute("error", error.violations);
                req.setAttribute("errorMsg", error.getMessage());
                getServletContext().getRequestDispatcher( "/views/emp/empAdd.jsp?depId=" + depId).forward(req, resp);
            }
        }
        }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String position = req.getParameter("position");
        int depId = Integer.parseInt(req.getParameter("depId"));
        Employee employee = new Employee(id, firstname, lastname, age, phone, email, position, depId);

        try {
            employeeService.update(employee);
            req.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/views/emp/empEdited.jsp").forward(req, resp);

        } catch (EmployeeException error) {
            req.setAttribute("employee", employee);
            req.setAttribute("error", error.violations);
            req.setAttribute("errorMsg", error.getMessage());
            getServletContext().getRequestDispatcher( "/views/emp/empEdit.jsp?depId=" + depId).forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.getById(id);
        employeeService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/employees?depId=" + employee.getDepId());
    }
}
