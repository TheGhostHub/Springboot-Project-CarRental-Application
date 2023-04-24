package carrental.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrental.demo.model.Booking;
import carrental.demo.model.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> findByUser(User user);
	
}
