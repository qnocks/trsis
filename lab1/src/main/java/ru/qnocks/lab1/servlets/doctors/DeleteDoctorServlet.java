package ru.qnocks.lab1.servlets.doctors;

import ru.qnocks.shared.dao.AppointmentsDao;
import ru.qnocks.shared.dao.DoctorsDao;
import ru.qnocks.lab1.util.UrlParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors/delete/*")
public class DeleteDoctorServlet extends HttpServlet {
    private final DoctorsDao doctorsDao = DoctorsDao.getInstance();
    private final AppointmentsDao appointmentsDao = AppointmentsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = UrlParser.getId(req);
        doctorsDao.delete(id);
        appointmentsDao.deleteByDoctorId(id);
        resp.setContentType("text/html");
        resp.sendRedirect("/doctors");
    }
}
