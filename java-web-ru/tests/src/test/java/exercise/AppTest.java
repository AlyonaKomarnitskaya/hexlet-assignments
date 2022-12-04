package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    static void beforeAll() {
        app = App.getApp();
        app.start();
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @Test
    void testCreateUser() {
        HttpResponse response = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Kaeya")
                .field("lastName", "Alberich")
                .field("email", "ila@gmail.com")
                .field("password", "19630")
                .asString();
        assertThat(response.getStatus()).isEqualTo(302);
        User user = new QUser()
                .email.equalTo("ila@gmail.com")
                .findOne();
        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Kaeya");
        assertThat(user.getLastName()).isEqualTo("Alberich");
        assertThat(user.getPassword()).isEqualTo("19630");
    }

    @Test
    void testInvalidUser() {
        HttpResponse response = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Kaeya")
                .field("lastName", "Alberich")
                .field("email", "ila@gmail.com")
                .field("password", "196")
                .asString();
        assertThat(response.getStatus()).isEqualTo(422);
        User user = new QUser()
                .email.equalTo("ila@gmail.com")
                .findOne();
        assertThat(user).isNull();
    }

    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("user");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @AfterAll
    static void afterAll() {
        app.stop();
    }
    // END
}
