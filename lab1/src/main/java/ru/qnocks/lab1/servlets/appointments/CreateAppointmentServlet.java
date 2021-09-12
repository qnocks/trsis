package ru.qnocks.lab1.servlets.appointments;

import ru.qnocks.shared.dao.AppointmentsDao;
import ru.qnocks.shared.dao.DoctorsDao;
import ru.qnocks.shared.dao.PatientsDao;
import ru.qnocks.shared.domain.Appointment;
import ru.qnocks.shared.domain.Doctor;
import ru.qnocks.shared.domain.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/appointments/create")
public class CreateAppointmentServlet extends HttpServlet {
    private final DoctorsDao doctorsDao = DoctorsDao.getInstance();
    private final PatientsDao patientsDao = PatientsDao.getInstance();
    private final AppointmentsDao appointmentsDao = AppointmentsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/jsp/appointments/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long doctorId = Long.valueOf(req.getParameter("doctorId"));
        Long patientId = Long.valueOf(req.getParameter("patientId"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        LocalTime time = LocalTime.parse(req.getParameter("time"));

        Doctor doctor = doctorsDao.findById(doctorId);
        Patient patient = patientsDao.findById(patientId);

        if (doctor != null && patient != null) {
            Appointment appointment = new Appointment(doctorId, patientId, date, time);
            appointmentsDao.save(appointment);
            resp.sendRedirect("/appointments");
        } else {
            resp.sendError(400);
        }
    }
}
