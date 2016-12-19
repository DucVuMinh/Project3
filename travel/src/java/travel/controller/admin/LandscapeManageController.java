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
import java.util.ArrayList;
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
import travel.model.Festival;
import travel.model.ImagedetailLandscape;
import travel.model.Landscape;
import travel.model.Rankinglandscape;

/**
 *
 * @author vanduc
 */
@MultipartConfig
@Controller
@RequestMapping(value = "/admin")
public class LandscapeManageController {
    
    @Autowired
    private ServletContext context;

    @RequestMapping(value = "/landscapeManage", method = RequestMethod.GET)
    public ModelAndView viewLandscapeManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/landscapeManage");
        List listLand = Landscape.getAllInstance();
        mm.put("listLand", listLand);
        return mv;
    }
    
    @RequestMapping(value = "/deleteLandscape", method = RequestMethod.GET)
    public String deleteLandscape(@RequestParam("idLandscape") int idLandscape, final RedirectAttributes redirectAttributes){
        Landscape land = Landscape.getLandscapeById(idLandscape);
        try {
            land.delete();
            redirectAttributes.addFlashAttribute("message","Xóa thắng cảnh thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/landscapeManage.htm";
    }
    
    @RequestMapping(value = "/detailLandscape", method = RequestMethod.GET)
    public ModelAndView viewDetailLandscape(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            int idLandscape = Integer.parseInt(request.getParameter("idLandscape"));
            Landscape detailLand = Landscape.getLandscapeById(idLandscape);
            view.setViewName("admin/detailLandscape");

            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int j = 0; j < 5; j++) {
                r.add(0);
            }
            for (Object rp : detailLand.getRankinglandscapes()) {
                if (((Rankinglandscape) rp).getRank() == 1) {
                    r.set(0, r.get(0) + 1);
                } else if (((Rankinglandscape) rp).getRank() == 2) {
                    r.set(1, r.get(1) + 1);
                } else if (((Rankinglandscape) rp).getRank() == 3) {
                    r.set(2, r.get(2) + 1);
                } else if (((Rankinglandscape) rp).getRank() == 4) {
                    r.set(3, r.get(3) + 1);
                } else {
                    r.set(4, r.get(4) + 1);
                }
            }
            mm.put("rank", r);
            mm.put("detailLand", detailLand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
    
    @RequestMapping(value = "/addLandscape", method = RequestMethod.GET)
    public String viewAddLandscape(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        List listDes = Destination.getAllListDesIstance();
        mm.put("listDes", listDes);
        return "admin/addLandscape";
    }
    
    @RequestMapping(value = "/addLandscape", method = RequestMethod.POST)
    public String addLandscape(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        String name_destination = request.getParameter("name_destination");
        String name_landscape = request.getParameter("name_landscape").trim();
        String desciption = request.getParameter("desciption").trim();
        String profile = request.getParameter("profile");
//        System.out.println(name_destination);
//        System.out.println(domain);
//        System.out.println(desciption);
//        System.out.println(profile);
        Destination des = Destination.getDesByTitle(name_destination);
//        System.out.println(des.getDiscription());
        Landscape land = new Landscape(des, name_landscape, desciption, profile, 1);
        if (land.add() == -1) {

//            request.setAttribute("error", "Tên lễ hội đã tồn tại!");
//            return "admin/addFestival";
//            Destination listDes = Destination.getDesById(1);
//            redirectAttributes.addAttribute("name_festival", name_festival);
//            redirectAttributes.addAttribute("desciption", desciption);
            redirectAttributes.addFlashAttribute("error", "Tên thắng cảnh đã tồn tại!");
            redirectAttributes.addFlashAttribute("name_festival", name_landscape);
            redirectAttributes.addFlashAttribute("name_destination", name_destination);
            redirectAttributes.addFlashAttribute("desciption", desciption);
            return "redirect:/admin/addLandscape.htm";
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
                    String absolutePathProfile = context.getRealPath("img/landscape/profile");
                    String absolutePathDetail = context.getRealPath("img/landscape/detail");

                    if (i == 3) {
                        out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                + land.getIdLandscape() + ".png"));
                    } else {
                        ImagedetailLandscape detail = new ImagedetailLandscape(land);
                        int idImage = detail.add();

                        out = new FileOutputStream(new File(absolutePathDetail + File.separator
                                + idImage + ".png"));

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

            redirectAttributes.addFlashAttribute("success", "Thêm thắng cảnh thành công!");
            return "redirect:/admin/landscapeManage.htm";
        }
    }
    
    @RequestMapping(value = "/editLandscape", method = RequestMethod.GET)
    public String viewEditLandscape(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        int idLandscape = Integer.parseInt(request.getParameter("idLandscape"));
        Landscape land = Landscape.getLandscapeById(idLandscape);
        List listDes = Destination.getAllListDesIstance();
        mm.put("listDes", listDes);
        mm.put("land", land);
        return "admin/editLandscape";
    }
    
    @RequestMapping(value = "/editLandscape", method = RequestMethod.POST)
    public String editLandscape(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        boolean check = true;
        String name_landscape = request.getParameter("name_landscape").trim();
        String name_destination = request.getParameter("name_destination");
        String desciption = request.getParameter("desciption").trim();
        Part profilePart = request.getPart("profile");
        int idLandscape = Integer.parseInt(request.getParameter("idLandscape"));

        List<Landscape> listLand = Landscape.getAll();
        for (int i = 0; i < listLand.size(); i++) {
            if (listLand.get(i).getTitle().equals(name_landscape) && listLand.get(i).getIdLandscape() != idLandscape) {
                check = false;
                break;
            }
        }

        if (check == true) {

            Landscape land = Landscape.getLandscapeById(idLandscape);
            land.setTitle(name_landscape);
            land.setDestination(Destination.getDesByTitle(name_destination));
            System.out.println(land.getDestination().getTitle());
            land.setDiscription(desciption);
//
            if (profilePart.getSize() > 0) {
                Collection<Part> fileParts = request.getParts();
                Object arrParts[] = fileParts.toArray();
                for (int i = 3; i < arrParts.length; i++) {
                    Part filePart = (Part) arrParts[i];
                    String fileName = getFileName(filePart);

                    OutputStream out = null;
                    InputStream filecontent = null;

                    try {
                        String absolutePathProfile = context.getRealPath("img/landscape/profile");
                        String absolutePathDetail = context.getRealPath("img/landscape/detail");

                        if (i == 3) {
                            out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                    + land.getIdLandscape() + ".png"));
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
            }

            land.update();
            return "redirect:detailLandscape.htm?idLandscape=" + idLandscape + "&success=true";
        } else {
            return "redirect:editLandscape.htm?idLandscape=" + idLandscape + "&success=false";
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
