/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.Destination;
import travel.model.ImagedetailDestination;

/**
 *
 * @author vanduc
 */
@MultipartConfig
@Controller
@RequestMapping(value = "/admin")
public class DestinationManageController {

    @RequestMapping(value = "/destinationManage", method = RequestMethod.GET)
    public ModelAndView viewDestinationManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/destinationManage");
        List listDes = Destination.getAllListDes();
        mm.put("listDes", listDes);
        return mv;
    }

    @RequestMapping(value = "/detailDestination", method = RequestMethod.GET)
    public ModelAndView viewDetailDestination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            int idDestination = Integer.parseInt(request.getParameter("idDestination"));
            Destination des = Destination.getDesById(idDestination);
            view.setViewName("admin/detailDestination");

            mm.put("detailDes", des);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @RequestMapping(value = "/deleteDestination", method = RequestMethod.GET)
    public String deleteDestination(@RequestParam("idDestination") int idDestination, final RedirectAttributes redirectAttributes) {
        Destination des = Destination.getDesById(idDestination);
        try {
            des.delete();
            redirectAttributes.addFlashAttribute("message", "Xóa địa điểm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/destinationManage.htm";
    }

    @RequestMapping(value = "/editDestination", method = RequestMethod.GET)
    public String viewEditDestination(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        int idDestination = Integer.parseInt(request.getParameter("idDestination"));
        Destination des = Destination.getDesById(idDestination);
        
        mm.put("des", des);
        return "admin/editDestination";
    }

    @RequestMapping(value = "/editDestination", method = RequestMethod.POST)
    public String editDestination(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        boolean check = true;
        String name = request.getParameter("name_destination");
        String domain = request.getParameter("name_domain");
        String desciption = request.getParameter("desciption");
        int idDestination = Integer.parseInt(request.getParameter("idDestination"));

        List<Destination> listDes = Destination.getAllListDes();
        for (int i = 0; i < listDes.size(); i++) {
            if (listDes.get(i).getTitle().equals(name) && listDes.get(i).getIdDestination() != idDestination) {
                check = false;
            }
        }

        if (check == true) {
            
            Destination des = Destination.getDesById(idDestination);
            des.setTitle(name);
            des.setNameArea(domain);
            des.setDiscription(desciption);
            
            Collection<Part> fileParts = request.getParts();
            Object arrParts[] = fileParts.toArray();
            for (int i = 3; i < arrParts.length; i++) {
                Part filePart = (Part) arrParts[i];
                String fileName = getFileName(filePart);

                OutputStream out = null;
                InputStream filecontent = null;

                try {
                    String absolutePathProfile = context.getRealPath("img/destination/profile");
                    String absolutePathDetail = context.getRealPath("img/destination/detail");

                    if (i == 3) {
                        out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                + des.getIdDestination() + ".png"));
                    } else {
//                        ImagedetailDestination detail = new ImagedetailDestination(des);
//                        int idImage = detail.add();
//                        if (idImage != -2) {
//                            out = new FileOutputStream(new File(absolutePathDetail + File.separator
//                                    + idImage + ".png"));
//                        }

                    }
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = filecontent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }

                } catch (FileNotFoundException fne) {
                    LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                            new Object[]{fne.getMessage()});
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (filecontent != null) {
                        filecontent.close();
                    }
                }
            }
            
//            des.update();
            return "redirect:detailDestination.htm?idDestination="+idDestination+"&success=true";
        }else{
            return "redirect:editDestination.htm?idDestination=" + idDestination + "&success=false";
        }

    }

    @RequestMapping(value = "/addDestination", method = RequestMethod.GET)
    public String view1AddDestination(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        return "admin/addDestination";
    }

    @Autowired
    private ServletContext context;

    @RequestMapping(value = "/addDestination", method = RequestMethod.POST)
    public String viewAddDestination(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        String name = request.getParameter("name_destination");
        String domain = request.getParameter("name_domain");
        String desciption = request.getParameter("desciption");
        String profile = request.getParameter("profile");
        System.out.println(name);
        System.out.println(domain);
        System.out.println(desciption);
        System.out.println(profile);
        Destination des = new Destination(name, domain, desciption, "profile", 1);
        if (des.add() == -1) {

            request.setAttribute("error", "Tên địa điểm đã tồn tại!");
            return "admin/addDestination";
        } else {
            // Create path components to save the file
            Collection<Part> fileParts = request.getParts();
            Object arrParts[] = fileParts.toArray();
            for (int i = 3; i < arrParts.length; i++) {
                Part filePart = (Part) arrParts[i];
                String fileName = getFileName(filePart);

                OutputStream out = null;
                InputStream filecontent = null;

                try {
                    String absolutePathProfile = context.getRealPath("img/destination/profile");
                    String absolutePathDetail = context.getRealPath("img/destination/detail");

                    if (i == 3) {
                        out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                + des.getIdDestination() + ".png"));
                    } else {
                        ImagedetailDestination detail = new ImagedetailDestination(des);
                        int idImage = detail.add();
                        if (idImage != -2) {
                            out = new FileOutputStream(new File(absolutePathDetail + File.separator
                                    + idImage + ".png"));
                        }

                    }
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = filecontent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }

                } catch (FileNotFoundException fne) {
                    LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                            new Object[]{fne.getMessage()});
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (filecontent != null) {
                        filecontent.close();
                    }
                }
            }

            redirectAttributes.addFlashAttribute("success", "Thêm địa điểm thành công!");
            return "redirect:/admin/destinationManage.htm";
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
