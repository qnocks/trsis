package ru.qnocks.lab1.servlets.patients;

import ru.qnocks.shared.dao.AppointmentsDao;
import ru.qnocks.shared.dao.PatientsDao;
import ru.qnocks.lab1.util.UrlParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients/delete/*")
public class DeletePatientServlet extends HttpServlet {
    private final PatientsDao patientsDao = PatientsDao.getInstance();
    private final AppointmentsDao appointmentsDao = AppointmentsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = UrlParser.getId(req);
        patientsDao.delete(id);
        appointmentsDao.deleteByPatientId(id);
        resp.setContentType("text/html");
        resp.sendRedirect("/patients");
    }
}
