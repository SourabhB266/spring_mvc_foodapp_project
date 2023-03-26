package spring_mvc_foodapp_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_foodapp_project.dao.BranchDao;
import spring_mvc_foodapp_project.dto.Branch;

@Controller
public class BranchController {

	@Autowired
	private BranchDao dao;

	@RequestMapping("/branch")
	public ModelAndView branch() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("branch", new Branch());
		modelAndView.setViewName("branch.jsp");
		return modelAndView;
	}

	@RequestMapping("/savebranch")
	public ModelAndView saveBranch(@ModelAttribute Branch branch) {
		ModelAndView modelAndView = new ModelAndView();
		dao.saveBranch(branch);
		List<Branch> list = dao.getAllBranchs();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("displaybranch.jsp");
		return modelAndView;
	}

	@RequestMapping("/displaybranch")
	public ModelAndView dispalyBranch(@ModelAttribute Branch branch) {
		ModelAndView modelAndView = new ModelAndView();
		List<Branch> list = dao.getAllBranchs();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("displaybranch.jsp");
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteBranch(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean b = dao.deleteBranch(id);
		if (b) {
			List<Branch> list = dao.getAllBranchs();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displaybranch.jsp");
		} else {
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView editBranch(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		Branch branch = dao.getBranchById(id);
		modelAndView.addObject(branch);
		modelAndView.setViewName("editbranch.jsp");
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView updateBranch(@ModelAttribute Branch branch) {
		ModelAndView modelAndView = new ModelAndView();
		dao.updateBranch(branch);
		List<Branch> list = dao.getAllBranchs();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("displaybranch.jsp");
		return modelAndView;
	}

	

}
