package ru.qnocks.lab1.servlets.doctors;

import ru.qnocks.shared.dao.DoctorsDao;
import ru.qnocks.shared.domain.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors/create")
public class CreateDoctorServlet extends HttpServlet {
    private final DoctorsDao doctorsDao = DoctorsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/jsp/doctors/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String specialty = req.getParameter("specialty");
        String schedule = req.getParameter("schedule");

        Doctor doctor = new Doctor(fullName, specialty, schedule);
        doctorsDao.save(doctor);

        req.setAttribute("doctors", doctorsDao.findALl());
        resp.sendRedirect("/doctors");
//        req.getRequestDispatcher("/jsp/doctors/list.jps").forward(req, resp);
    }
}
