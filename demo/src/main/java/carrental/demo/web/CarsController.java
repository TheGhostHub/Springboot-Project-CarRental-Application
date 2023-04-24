package carrental.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import carrental.demo.model.Car;
import carrental.demo.model.repository.CarRepository;

@Controller
public class CarsController {
	@Autowired
	private CarRepository carsRepo;
	
	@GetMapping({"/car"})
	public ModelAndView ShowCars(){
		ModelAndView mav =new ModelAndView("list-cars");
		List<Car>list=carsRepo.findAll();
		mav.addObject("cars",list);
		return mav;
	}
	
	@GetMapping("/addCarForm")
	public ModelAndView addCarForm() {
		ModelAndView mav=new ModelAndView("add-cars-form");
		Car newCar=new Car();
		mav.addObject("cars",newCar);
		return mav;
	}
	
	
	@PostMapping("/saveCar")
	public String saveCar(@ModelAttribute Car car) {
		carsRepo.save(car);
		return "redirect:/car";
		
	}
	
	@GetMapping("/showUpdateFormcar")
	public ModelAndView showUpdateFormcar(@RequestParam Long carId) {
		ModelAndView mav =new ModelAndView("add-cars-form");
		Car cars=carsRepo.findById(carId).get();
		mav.addObject("cars",cars);
		return mav;
		
	}
	
	@GetMapping("/deleteCar")
	public String deleteCar(@RequestParam Long carId) {
		carsRepo.deleteById(carId);
		return "redirect:/car";
		
	}
}
