package services;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Slf4j
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UserService {

    @Autowired
    ApiService apiService;

    public Response createUser(User user) {
        log.info("Creating user " + user);
        return apiService.setup()
                .body(user)
                .when()
                .post("/users");
    }
}
