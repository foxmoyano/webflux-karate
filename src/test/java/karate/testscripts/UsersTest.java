package karate.testscripts;

import com.intuit.karate.junit5.Karate;

public class UsersTest {
    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }

}
