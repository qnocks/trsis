package ru.qnocks.lab1.servlets.patients;

import ru.qnocks.shared.dao.PatientsDao;
import ru.qnocks.shared.domain.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/patients/create")
public class CreatePatientServlet extends HttpServlet {
    private final PatientsDao patientsDao = PatientsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/jsp/patients/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String address = req.getParameter("address");

        Patient patient = new Patient(fullName, birthDate, address);
        patientsDao.save(patient);

        req.setAttribute("patients", patientsDao.findALl());
        resp.sendRedirect("/patients");
//        req.getRequestDispatcher("/jsp/patients/list.jps").forward(req, resp);
    }
}
