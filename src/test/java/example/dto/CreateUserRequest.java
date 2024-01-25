package example.dto;

public class CreateUserRequest {
    private String name;
    private String job;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
