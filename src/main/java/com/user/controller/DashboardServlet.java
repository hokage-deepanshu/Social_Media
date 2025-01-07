package com.user.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the username from the request parameter
        String username = request.getParameter("username");

        // Optionally, fetch other necessary data from the database or other sources
        int followersCount = getFollowersCount(username);  // A method to fetch the follower count
        int followingCount = getFollowingCount(username);  // A method to fetch following count

        // Set attributes to forward data to the JSP
        request.setAttribute("username", username);
        request.setAttribute("followersCount", followersCount);
        request.setAttribute("followingCount", followingCount);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    // Mock methods to retrieve followers/following counts
    private int getFollowersCount(String username) {
        return 100;  // Replace with real database call
    }

    private int getFollowingCount(String username) {
        return 50;  // Replace with real database call
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle form submissions or any other POST request logic here
        String newPost = request.getParameter("newPost");

        if (newPost != null && !newPost.trim().isEmpty()) {
            // Save post to database (Pseudo-code)
            // Database.savePost(username, newPost);

            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("error", "Post content cannot be empty!");
            doGet(request, response);
        }
    }
}




