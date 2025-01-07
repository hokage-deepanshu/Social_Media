package com.user.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the username parameter
        String username = request.getParameter("username");

        // Fetch data for the user (e.g., followers, following, etc.)
        int followersCount = getFollowersCount(username);
        int followingCount = getFollowingCount(username);

        // Set the attributes to forward to the profile JSP
        request.setAttribute("username", username);
        request.setAttribute("followersCount", followersCount);
        request.setAttribute("followingCount", followingCount);

        // Forward to the profile JSP
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    private int getFollowersCount(String username) {
        return 120;  // Example count
    }

    private int getFollowingCount(String username) {
        return 60;  // Example count
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle updates to the profile
        String newBio = request.getParameter("bio");
        String newEmail = request.getParameter("email");

        if (newBio != null && newEmail != null) {
            // Update profile in database (Pseudo-code)
            // Database.updateProfile(username, newBio, newEmail);

            response.sendRedirect("profile");
        } else {
            request.setAttribute("error", "Profile updates failed. Please provide valid data.");
            doGet(request, response);
        }
    }

}
