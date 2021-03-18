package flipkart.model;

public class Customer {


	private long id;
	private String name;
	private String email;
	private long phone;
	private String address;

	public Customer(long id, String name, long phone,String email, String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		
		this.address = address;
	}

	public Customer() {

	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ",  phone=" + phone + ", email=\" + email + \", address=" + address + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
