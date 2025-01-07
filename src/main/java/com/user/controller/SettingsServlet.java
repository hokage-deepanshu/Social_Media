package com.user.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            response.sendRedirect("login");
            return;
        }

        // Sample settings data (Replace with actual database queries)
        request.setAttribute("profileVisibility", "Public"); // Example setting
        request.setAttribute("linkedAccounts", "Facebook, Twitter"); // Example data

        // Forward to the settings JSP page
        request.getRequestDispatcher("/settings.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle form submission for updating settings
        String profileVisibility = request.getParameter("profileVisibility");
        String linkedAccount = request.getParameter("linkedAccount");

        if (profileVisibility != null) {
            // Update profile visibility in database (pseudo-code)
            // Database.updateProfileVisibility(username, profileVisibility);
        }

        if (linkedAccount != null) {
            // Link accounts in database (pseudo-code)
            // Database.linkAccount(username, linkedAccount);
        }

        // Redirect to the settings page after updating settings
        response.sendRedirect("setting");
    }
}
