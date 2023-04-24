package carrental.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.demo.model.Booking;
import carrental.demo.model.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepo;
	
	public void save(Booking b) {
		bookingRepo.save(b);
	}
	public List<Booking> getAllBooking(){
		return bookingRepo.findAll();
	}

}
