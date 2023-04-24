package carrental.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.demo.model.Car;
import carrental.demo.model.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepo;
	public void save(Car car) {
		carRepo.save(car);
	}
	public List<Car> getAllCar(){
		return carRepo.findAll();
	}
}
