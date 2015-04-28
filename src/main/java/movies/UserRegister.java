package movies;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class UserRegister {
	
	@Id
	private Integer userId;
	
	@NotEmpty(message="Please enter your first name.")
	@NotNull
	private String firstName;
	
	@NotEmpty(message="Please enter your last name.")
	@NotNull
	private String lastName;
	
	@NotEmpty(message="Please enter your email.")
	@Email
	@NotNull
	private String email;
	
	@Size(min=6, max=15)
	@NotNull
	@NotEmpty(message="Please enter your password.")
	private String password;
	
	@NotNull
	private String created_at;
	
	String[] genres;
	
	ArrayList<GetMovie> recommendations;
	
	int rating1;
	int rating2;
	int rating3;
	int rating4;
	int rating5;
	
	public ArrayList<GetMovie> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(ArrayList<GetMovie> recommendations) {
		this.recommendations = recommendations;
	}

	public int getRating1() {
		return rating1;
	}

	public void setRating1(int rating1) {
		this.rating1 = rating1;
	}

	public int getRating2() {
		return rating2;
	}

	public void setRating2(int rating2) {
		this.rating2 = rating2;
	}

	public int getRating3() {
		return rating3;
	}

	public void setRating3(int rating3) {
		this.rating3 = rating3;
	}

	public int getRating4() {
		return rating4;
	}

	public void setRating4(int rating4) {
		this.rating4 = rating4;
	}

	public int getRating5() {
		return rating5;
	}

	public void setRating5(int rating5) {
		this.rating5 = rating5;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}
}
