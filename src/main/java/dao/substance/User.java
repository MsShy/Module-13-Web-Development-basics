package dao.substance;

public class User {

	private int id;
	private String lastName;
	private String firtsName;
	private String email;
	private String yearBirth;
	private String password;



/*public User(final int id, final String lastName, final String firtsName, final String email, String yearBirth, final String password) {
		this.id = id;
		this.lastName = lastName;
		this.firtsName = firtsName;
		this.email = email;
		this.yearBirth = yearBirth;
		this.password = password;
	}

	public User(final String lastName, final String firtsName, final String email, final String yearBirth, final String password) {
		this.lastName = lastName;
		this.firtsName = firtsName;
		this.email = email;
		this.yearBirth = yearBirth;
		this.password = password;
	}
	public User( final String password) {

		this.password = password;
	}*/

	public String getYearBirth() {
		return yearBirth;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirtsName() {
		return firtsName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setFirtsName(final String firtsName) {
		this.firtsName = firtsName;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	@Override
	public String toString() {

		String result = this.getClass().getSimpleName();
		result += " id=" + getId()+
				", lastName=" + lastName  +
				", firtsName=" + firtsName  +
				", email=" + email +
				", yearOfBirth=" + yearBirth  +
				", password=" + password + "\n";
		return result;
	}
}
