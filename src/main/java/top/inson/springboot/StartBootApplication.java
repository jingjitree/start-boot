package top.inson.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class StartBootApplication extends SpringBootServletInitializer {
public class StartBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartBootApplication.class, args);
    }

    /*
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartBootApplication.class);
    }
    */
}
