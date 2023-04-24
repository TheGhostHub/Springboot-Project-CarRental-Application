package carrental.demo.model;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	public String picking_up_address;
	private String dropping_up_address;
	private String price;
	private String availability;
	
	private String picking_date;
	private String picking_time;
	
	private String dropping_date;
	private String dropping_time;
	private String Telephone_number;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Booking(String name, String picking_up_address, String dropping_up_address, String price,
			String availability, String picking_date, String picking_time, String dropping_date, String dropping_time,
			String telephone_number, User user) {
		super();
		this.name = name;
		this.picking_up_address = picking_up_address;
		this.dropping_up_address = dropping_up_address;
		this.price = price;
		this.availability = availability;
		this.picking_date = picking_date;
		this.picking_time = picking_time;
		this.dropping_date = dropping_date;
		this.dropping_time = dropping_time;
		Telephone_number = telephone_number;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicking_up_address() {
		return picking_up_address;
	}

	public void setPicking_up_address(String picking_up_address) {
		this.picking_up_address = picking_up_address;
	}

	public String getDropping_up_address() {
		return dropping_up_address;
	}

	public void setDropping_up_address(String dropping_up_address) {
		this.dropping_up_address = dropping_up_address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getPicking_date() {
		return picking_date;
	}

	public void setPicking_date(String picking_date) {
		this.picking_date = picking_date;
	}

	public String getPicking_time() {
		return picking_time;
	}

	public void setPicking_time(String picking_time) {
		this.picking_time = picking_time;
	}

	public String getDropping_date() {
		return dropping_date;
	}

	public void setDropping_date(String dropping_date) {
		this.dropping_date = dropping_date;
	}

	public String getDropping_time() {
		return dropping_time;
	}

	public void setDropping_time(String dropping_time) {
		this.dropping_time = dropping_time;
	}

	public String getTelephone_number() {
		return Telephone_number;
	}

	public void setTelephone_number(String telephone_number) {
		Telephone_number = telephone_number;
	}

	

	

	
	
	
	
	
	
	
}
