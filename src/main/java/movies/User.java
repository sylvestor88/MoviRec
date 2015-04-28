package movies;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotEmpty(message="Please provide email.")
	@Email
	@NotNull
    private String email;

	@NotNull
	@NotEmpty(message="Please provide password.")
    private String password;

    public String getEmail() {
        return this.email;
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

    public String toString() {
        return "Person(Email: " + this.email + ", Password: " + this.password + ")";
    }
}
