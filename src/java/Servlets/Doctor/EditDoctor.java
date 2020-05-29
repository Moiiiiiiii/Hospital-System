/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Doctor;

import Controller.DoctorController;
import Model.Doctor;
import Model.DoctorProperties;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eng Eslam khder
 */
public class EditDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("fname");
        String phone = request.getParameter("phone");

        if (name.isEmpty()) {
            response.getWriter().print("name");
        } else if (phone.isEmpty() || InvalidNumber(phone) < 0) {
            response.getWriter().print("phone");
        } else {
            SessionFactory session = (SessionFactory) request.getServletContext().getAttribute("factory");
            Doctor d = (Doctor) request.getSession().getAttribute("doctor");
            DoctorController dc = new DoctorController();
            DoctorProperties Doctorproperties = dc.getDoctorProperties(session, d);
            Doctorproperties.setName(name);
            Doctorproperties.setPhone(phone);
            dc.editDoctorProperties(session, Doctorproperties);
            d.setDoctorproperties(Doctorproperties);
            response.getWriter().print("success");
        }
    }

    public int InvalidNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}