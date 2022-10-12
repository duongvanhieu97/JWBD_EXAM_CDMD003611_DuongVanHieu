package servlet;

import dao.ClassDAO;
import model.Classroom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassServlet", value = "/ClassServlet")
public class ClassServlet extends HttpServlet {
    private ClassDAO classDAO;
    public void init() {
        classDAO = new ClassDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void listRole(HttpServletRequest request, HttpServletResponse response) {
        List<Classroom> listClassroom = classDAO.selectAllClassroom();
        request.setAttribute("listClassroom", listClassroom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("class/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
