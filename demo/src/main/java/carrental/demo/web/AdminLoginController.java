package carrental.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import carrental.demo.model.Admin;
import carrental.demo.model.Car;
import carrental.demo.model.repository.AdminRepository;
import carrental.demo.model.repository.CarRepository;

@Controller
public class AdminLoginController {
	@Autowired
	private AdminRepository adminRepository;
	
	
	@GetMapping("/admin/login")
    public String adminLoginForm() {
        return "adminLogin";
    }
	
	@PostMapping("/admin/login")
    public String adminLoginSubmit(@RequestParam("username") String username,
            @RequestParam("password") String password, Model model, HttpSession session) {

        Admin admin = adminRepository.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin);
            return "redirect:/carAdd/Dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "adminLogin";
        }
    }
	@Autowired
	private CarRepository carsRepo;
	
	@GetMapping({"/carAdd/Dashboard"})
	public ModelAndView ShowCars(){
		ModelAndView mav =new ModelAndView("list-cars");
		List<Car>list=carsRepo.findAll();
		mav.addObject("cars",list);
		return mav;
	}
}
