package ru.qnocks.lab1.servlets.doctors;

import ru.qnocks.shared.dao.DoctorsDao;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors")
@Stateless
public class DoctorsServlet extends HttpServlet {
    private final DoctorsDao doctorsDao = DoctorsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("doctors", doctorsDao.findALl());
        req.getRequestDispatcher("/jsp/doctors/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/doctors/list.jsp").forward(req, resp);
    }
}
