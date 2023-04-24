package carrental.demo.web;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import carrental.demo.model.Booking;
import carrental.demo.model.Car;
import carrental.demo.model.User;
import carrental.demo.model.repository.BookingRepository;
import carrental.demo.model.repository.CarRepository;
import carrental.demo.model.repository.UserRepository;
import carrental.demo.service.BookingService;
import carrental.demo.service.CarService;

@Controller
public class MainController {
	@Autowired
	private CarService carServ;
	
	@Autowired
	private BookingService bookingServ;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/aboutUs") 
	public String aboutUs() 
	{ 
		return "aboutUs"; 
	}
	
	@GetMapping("/profile") 
	public String profile() 
	{ 
		return "profile"; 
	}
	
	@GetMapping("/login") 
	public String login() 
	{ 
		return "login"; 
	}
	@GetMapping("/confirmBooking") 
	public String confiemBooking(Principal principal,Model model) 
	{ 
		
	    String username = principal.getName();
	    User user = userRepo.findByEmail(username);
	    List<Booking> bookings = bookingRepo.findByUser(user);
	    model.addAttribute("booking", bookings);
	    return "confirmBooking";
		
	}
	
	@GetMapping("/") 
	public String home() 
	{ 
		return "index"; 
	}
	@GetMapping("/booking") 
	public String booking() 
	{ 
		return "booking"; 
	}
	
	  @PostMapping("/savebooking") 
	  public String bookingSave(@ModelAttribute Booking b,@ModelAttribute Car c) 
	  {  
		  bookingServ.save(b);
		  carServ.save(c); 
		  return "redirect:/confirmBooking?success"; 
	  }
	 
	
	@GetMapping("/cars") 
	public ModelAndView getAllCars() 
	{ 
		List<Car> carList=carServ.getAllCar();
		return new ModelAndView("cars","car",carList);
	}

	@GetMapping("/bookedCar")
	public ModelAndView showUpdateFormcar(@RequestParam Long carId,Model model,Principal principal) {
		String name=principal.getName();
		User user=userRepo.findByEmail(name);
		model.addAttribute("user", user);
		ModelAndView mav =new ModelAndView("bookCar");
		Car car=carRepo.findById(carId).get();
		mav.addObject("cars",car);
		return mav;
	}          
}
