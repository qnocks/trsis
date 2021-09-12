package ru.qnocks.lab1.servlets.patients;

import ru.qnocks.shared.dao.PatientsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet {
    private final PatientsDao patientsDao = PatientsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("patients", patientsDao.findALl());
        req.getRequestDispatcher("/jsp/patients/list.jsp").forward(req, resp);
    }
}
