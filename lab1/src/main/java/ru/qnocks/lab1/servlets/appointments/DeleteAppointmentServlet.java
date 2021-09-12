package ru.qnocks.lab1.servlets.appointments;

import ru.qnocks.shared.dao.AppointmentsDao;
import ru.qnocks.lab1.util.UrlParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appointments/delete/*")
public class DeleteAppointmentServlet extends HttpServlet {
    private final AppointmentsDao appointmentsDao = AppointmentsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = UrlParser.getId(req);

        resp.setContentType("text/html");
        appointmentsDao.delete(id);
        resp.sendRedirect("/appointments");
    }
}
