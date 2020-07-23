package spring.web.app01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.web.app01.domain.Participant;
import spring.web.app01.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class FirstController {
    @Autowired
    ParticipantService participantService;

    @GetMapping("/")
    public String indexPage(HttpServletRequest req){
        req.setAttribute("participants",participantService.readAll());
        req.setAttribute("mode", "VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String updateParticipant(HttpServletRequest req,@RequestParam(value = "id") int id, Model model){
        req.setAttribute("mode", "UPDATE");
        req.setAttribute("particip",participantService.readById(id));
        model.addAttribute("part", new Participant());
        return "index";
    }

    @GetMapping("/new")
    public String createParticipant(@ModelAttribute("part") Participant part,
                                    HttpServletRequest req){
        req.setAttribute("participants",participantService.readAll());
        req.setAttribute("mode", "CREATE");
        return "index";
    }

    @PostMapping("/saveUpdated")
    public String saveUpdatedParticipant(HttpServletRequest req,@ModelAttribute("part") Participant part){
        participantService.updateById(part.getId(),part);
        req.setAttribute("participants",participantService.readAll());
        req.setAttribute("mode", "VIEW");
        return "index";
    }

    @PostMapping("/saveNew")
    public String saveNewParticipant(HttpServletRequest req,@ModelAttribute("part") Participant part) throws Exception {
        participantService.save(part);
        req.setAttribute("participants",participantService.readAll());
        req.setAttribute("mode", "VIEW");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteParticipant(@RequestParam(value = "id") String id,HttpServletRequest req){
        participantService.deleteById(Integer.parseInt(id));
        req.setAttribute("participants",participantService.readAll());
        req.setAttribute("mode", "VIEW");
        return "index";
    }
}
