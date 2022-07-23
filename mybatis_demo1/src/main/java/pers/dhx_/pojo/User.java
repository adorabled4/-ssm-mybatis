package pers.dhx_.pojo;

/**
 * @author Dhx_
 * @className User
 * @description TODO
 * @date 2022/7/20 11:44
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender; //性别

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String username, String pwd, Integer age, String gender, String email) {
        this.id = id;
        this.username = username;
        this.password = pwd;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

        public User()
        {}
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
}
