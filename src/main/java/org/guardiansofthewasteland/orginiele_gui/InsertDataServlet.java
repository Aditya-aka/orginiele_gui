package org.guardiansofthewasteland.orginiele_gui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insertData")
public class InsertDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String distanceStr = request.getParameter("distance");
        int distance = Integer.parseInt(distanceStr);

        try (Connection connection = DatabaseConnect.getConnection()) {
            if (connection != null) {
                String sql = "INSERT INTO distance_data (distance) VALUES (?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, distance);
                stmt.executeUpdate();
                stmt.close();
                response.getWriter().write("Data inserted successfully");
            } else {
                response.getWriter().write("Failed to establish connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error inserting data");
        }
    }
}
