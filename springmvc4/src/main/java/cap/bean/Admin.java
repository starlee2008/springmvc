package cap.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Admin {
    @NotEmpty(message = "{name.empty}")
    @Size(min = 6, max = 15, message = "{name.size}")
    private String username;
    @Range(min = 0, max = 150, message = "{age.size}")
    private int age;
    @NotEmpty(message = "{password.empty}")
    private String password;
    @NotEmpty(message = "{email.empty}")
    @Email(message = "{email.format}")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
