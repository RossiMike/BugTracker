package com.bug_tracker.BugTrackerApp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug_tracker.BugTrackerApp.dao.BugDAO;
import com.bug_tracker.BugTrackerApp.entities.Bug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/bugs")
public class BugController {

    private BugDAO bugDAO;

    public BugController(BugDAO theBugDAO){
        bugDAO = theBugDAO;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listBugs(Model theModel) {

        // get bugs from db
        List<Bug> theBugs = bugDAO.findAll();
        
        // add to the spring model

        theModel.addAttribute("bugs", theBugs);

        return "bugs/list-bugs";
    }

    // add mapping for bug registration
    @GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Bug theBug = new Bug();

		theModel.addAttribute("bug", theBug);

		return "bugs/bug-registration";
	}
    
    @PostMapping("/save")
    public String saveBug(@ModelAttribute("bug") Bug theBug) {

        // save the bug
        bugDAO.save(theBug);

        // use a redirect to prevent duplicate submissions
        return "redirect:/bugs/list";
	}

    @GetMapping("/delete")
        public String delete(@RequestParam("bugName") String theBug) {

            // delete the bug
            bugDAO.delete(theBug);

            // redirect to /bugs/list
            return "redirect:/bugs/list";

	}

}
