/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import travel.model.Destination;
import travel.model.ImagedetailPosts;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author ducvu
 */
@WebServlet(name = "UserEditPosts", urlPatterns = {"/usereditposts"})
@MultipartConfig
public class UserEditPosts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            request.setCharacterEncoding("UTF-8");
            User u = User.getUserByUserName(username);
            String context = request.getParameter("content");
            System.out.println("ducvu: context"+context);
            //context = new String(context.getBytes("iso-8859-1"), "UTF-8");
            String title = request.getParameter("title");
            //title = new String(title.getBytes("iso-8859-1"), "UTF-8");
            Collection<Part> fileParts = request.getParts();
            Object arrParts[] = fileParts.toArray();
            int length = arrParts.length;
            int idpost = Integer.valueOf(request.getParameter("idposts"));
            Posts p = Posts.getPostsById(Integer.valueOf(idpost));
            if (p.getUserPost().getIdUser() == u.getIdUser()) {
                p.setTitle(title);
                p.setContext(context);
                p.update();
                for (int i = 2; i < length; i++) {

                    Part filePart = (Part) arrParts[i];
                    String fileName = getFileName(filePart);

                    OutputStream out = null;
                    InputStream filecontent = null;
                    if (fileName != null && fileName.length() > 3) {
                        try {
                            ImagedetailPosts img = new ImagedetailPosts(p);
                            int idimg = img.add();
                            System.out.println("ducvu: add image");
                            String absoluteDiskPath = getServletContext().getRealPath("img/posts/detail");
                            File fimg = new File(absoluteDiskPath + "/"
                                    + idimg + ".png");
                            out = new FileOutputStream(fimg);
                            filecontent = filePart.getInputStream();

                            int read = 0;
                            final byte[] bytes = new byte[1024];

                            while ((read = filecontent.read(bytes)) != -1) {
                                out.write(bytes, 0, read);
                            }
                            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                                    new Object[]{fileName, ""});

                        } catch (FileNotFoundException fne) {
                            PrintWriter writer = response.getWriter();
                            writer.println("You either did not specify a file to upload or are "
                                    + "trying to upload a file to a protected or nonexistent "
                                    + "location.");
                            writer.println("<br/> ERROR: " + fne.getMessage());

                            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                                    new Object[]{fne.getMessage()});
                            response.sendRedirect("requestlogin.htm");
                        } finally {
                            if (out != null) {
                                out.close();
                            }
                            if (filecontent != null) {
                                filecontent.close();
                            }
                        }
                    }
                }
                response.sendRedirect("customposts.htm?id=" + idpost);
            } else {
                response.sendRedirect("requestlogin.htm");
            }
        } else {
            response.sendRedirect("requestlogin.htm");
        }

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
