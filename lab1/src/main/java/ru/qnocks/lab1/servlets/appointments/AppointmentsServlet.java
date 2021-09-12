package ru.qnocks.lab1.servlets.appointments;

import ru.qnocks.shared.dao.AppointmentsDao;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appointments")
@Stateless
public class AppointmentsServlet extends HttpServlet {
    private final AppointmentsDao appointmentsDao = AppointmentsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("appointments", appointmentsDao.findALl());
        req.getRequestDispatcher("/jsp/appointments/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/appointments/list.jsp").forward(req, resp);
    }
}
