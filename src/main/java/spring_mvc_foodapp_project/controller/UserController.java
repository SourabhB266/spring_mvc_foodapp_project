package spring_mvc_foodapp_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_foodapp_project.dao.BranchDao;
import spring_mvc_foodapp_project.dao.UserDao;
import spring_mvc_foodapp_project.dto.Branch;
import spring_mvc_foodapp_project.dto.User;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@Autowired
	private BranchDao branchDao;

	@RequestMapping("/signup")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("save.jsp");
		return modelAndView;
	}

	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		dao.saveUser(user);
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("/log")
	public ModelAndView userLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		ModelAndView modelAndView = new ModelAndView();
		User user = dao.loginUser(email);
		modelAndView.addObject("user", new User());
		if (user.getPassword().equals(password)) {
			if (user.getRole().equals("admin")) {
				modelAndView.setViewName("displaybranch");
			} else if (user.getRole().equals("branch manager")) {
				modelAndView.setViewName("menu.jsp");
			} else {
				modelAndView.setViewName("foodorder.jsp");
			}

		}

		return modelAndView;
	}

	@RequestMapping("/addmanager")
	public ModelAndView addManager(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		Branch branch = branchDao.getBranchById(id);
		modelAndView.addObject("branch", branch);
		modelAndView.setViewName("managerbranch.jsp");
		return modelAndView;
	}

	@RequestMapping("/linkmanager")
	public ModelAndView linkManager(@ModelAttribute Branch branch) {
		ModelAndView modelAndView = new ModelAndView();
		int id = branch.getUser().getId();
		User user = dao.getUserById(id);
		if (user.getRole().equals("branch manager")) {
			branch.setUser(user);
			branchDao.updateBranch(branch);
			modelAndView.setViewName("displaybranch");
		} else {
			modelAndView.setViewName("displaybranch");
		}

		return modelAndView;
	}

	@RequestMapping("/showmanagerslist")
	public ModelAndView showManagersList(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = dao.getManagers("branch manager");
		modelAndView.addObject("list", list);
		modelAndView.setViewName("showmanager");
		return modelAndView;
	}

	@RequestMapping("/displaymanager")
	public ModelAndView displayManager(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("showmanager");
		return modelAndView;
	}

	@RequestMapping("/showmanager")
	public ModelAndView showManager(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = dao.getManagers("branch manager");
		modelAndView.addObject("list", list);
		modelAndView.setViewName("showmanager.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/editmanager")
	public ModelAndView editBranch(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		User user = dao.getUserById(id);
		modelAndView.addObject(user);
		modelAndView.setViewName("editmanager.jsp");
		return modelAndView;
	}

	@RequestMapping("/updatemanager")
	public ModelAndView updateBranch(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		dao.updateUser(user);
		List<User> list = dao.getAllUsers();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("showmanager.jsp");
		return modelAndView;
	}
}
