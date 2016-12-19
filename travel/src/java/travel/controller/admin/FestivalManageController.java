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
import travel.model.ImagedetailFestival;
import travel.model.Rankingfestival;

/**
 *
 * @author vanduc
 */
@MultipartConfig
@Controller
@RequestMapping(value = "/admin")
public class FestivalManageController {

    @Autowired
    private ServletContext context;

    @RequestMapping(value = "/festivalManage", method = RequestMethod.GET)
    public ModelAndView viewFestivalManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/festivalManage");
        List listFes = Festival.getAll();
        mm.put("listFes", listFes);
        return mv;
    }

    @RequestMapping(value = "/deleteFestival", method = RequestMethod.GET)
    public String deleteFestival(@RequestParam("idFestival") int idFestival, final RedirectAttributes redirectAttributes) {
        Festival fes = Festival.getFestivalById(idFestival);
        try {
            fes.delete();
            redirectAttributes.addFlashAttribute("message", "Xóa thắng cảnh thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/festivalManage.htm";
    }

    @RequestMapping(value = "/detailFestival", method = RequestMethod.GET)
    public ModelAndView viewDetailFestival(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            int idFestival = Integer.parseInt(request.getParameter("idFestival"));
            Festival detailFes = Festival.getFestivalById(idFestival);
            view.setViewName("admin/detailFestival");

            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int j = 0; j < 5; j++) {
                r.add(0);
            }
            for (Object rp : detailFes.getRankingfestivals()) {
                if (((Rankingfestival) rp).getRank() == 1) {
                    r.set(0, r.get(0) + 1);
                } else if (((Rankingfestival) rp).getRank() == 2) {
                    r.set(1, r.get(1) + 1);
                } else if (((Rankingfestival) rp).getRank() == 3) {
                    r.set(2, r.get(2) + 1);
                } else if (((Rankingfestival) rp).getRank() == 4) {
                    r.set(3, r.get(3) + 1);
                } else {
                    r.set(4, r.get(4) + 1);
                }
            }
            mm.put("rank", r);
            mm.put("detailFes", detailFes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @RequestMapping(value = "/addFestival", method = RequestMethod.GET)
    public String viewAddFestival(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        List listDes = Destination.getAllListDesIstance();
        mm.put("listDes", listDes);
        return "admin/addFestival";
    }

    @RequestMapping(value = "/addFestival", method = RequestMethod.POST)
    public String addFestival(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        String name_destination = request.getParameter("name_destination");
        String name_festival = request.getParameter("name_festival").trim();
        String desciption = request.getParameter("desciption").trim();
        String profile = request.getParameter("profile");
        System.out.println(name_destination);
//        System.out.println(domain);
//        System.out.println(desciption);
//        System.out.println(profile);
        Destination des = Destination.getDesByTitle(name_destination);
        System.out.println(des.getDiscription());
        Festival fes = new Festival(des, name_festival, desciption, profile, 1);
        if (fes.add() == -1) {

//            request.setAttribute("error", "Tên lễ hội đã tồn tại!");
//            return "admin/addFestival";
//            Destination listDes = Destination.getDesById(1);
//            redirectAttributes.addAttribute("name_festival", name_festival);
//            redirectAttributes.addAttribute("desciption", desciption);
            redirectAttributes.addFlashAttribute("error", "Tên lễ hội đã tồn tại!");
            redirectAttributes.addFlashAttribute("name_festival", name_festival);
            redirectAttributes.addFlashAttribute("name_destination", name_destination);
            redirectAttributes.addFlashAttribute("desciption", desciption);
            return "redirect:/admin/addFestival.htm";
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
                    String absolutePathProfile = context.getRealPath("img/festival/profile");
                    String absolutePathDetail = context.getRealPath("img/festival/detail");

                    if (i == 3) {
                        out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                + fes.getIdFestival() + ".png"));
                    } else {
                        ImagedetailFestival detail = new ImagedetailFestival(fes);
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

            redirectAttributes.addFlashAttribute("success", "Thêm lễ hội thành công!");
            return "redirect:/admin/festivalManage.htm";
        }
    }

    @RequestMapping(value = "/editFestival", method = RequestMethod.GET)
    public String viewEditFestival(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        int idFestival = Integer.parseInt(request.getParameter("idFestival"));
        Festival fes = Festival.getFestivalById(idFestival);
        List listDes = Destination.getAllListDesIstance();
        mm.put("listDes", listDes);
        mm.put("fes", fes);
        return "admin/editFestival";
    }

    @RequestMapping(value = "/editFestival", method = RequestMethod.POST)
    public String editFestival(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        boolean check = true;
        String name_festival = request.getParameter("name_festival").trim();
        String name_destination = request.getParameter("name_destination");
        String desciption = request.getParameter("desciption").trim();
        Part profilePart = request.getPart("profile");
        int idFestival = Integer.parseInt(request.getParameter("idFestival"));

        List<Festival> listFes = Festival.getAll();
        for (int i = 0; i < listFes.size(); i++) {
            if (listFes.get(i).getTitle().equals(name_festival) && listFes.get(i).getIdFestival() != idFestival) {
                check = false;
                break;
            }
        }

        if (check == true) {

            Festival fes = Festival.getFestivalById(idFestival);
            fes.setTitle(name_festival);
            fes.setDestination(Destination.getDesByTitle(name_destination));
            System.out.println(fes.getDestination().getTitle());
            fes.setDiscription(desciption);
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
                        String absolutePathProfile = context.getRealPath("img/festival/profile");
                        String absolutePathDetail = context.getRealPath("img/festival/detail");

                        if (i == 3) {
                            out = new FileOutputStream(new File(absolutePathProfile + File.separator
                                    + fes.getIdFestival() + ".png"));
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

            fes.update();
            return "redirect:detailFestival.htm?idFestival=" + idFestival + "&success=true";
        } else {
            return "redirect:editFestival.htm?idFestival=" + idFestival + "&success=false";
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
