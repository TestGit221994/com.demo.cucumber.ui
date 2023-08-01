package demoblazet.utils.misc;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateTokenUtils {

    private static final Logger logger = LoggerFactory.getLogger(GenerateTokenUtils.class);
    private static String TOKEN_URL = "https://lori-pronto-user-pool-qa.auth.us-east-1.amazoncognito.com/oauth2/token";
    private static String token;
    private static String clientID = "72peq4o9nra23cuaaqq4gipdj1";
    private static String clientKey = "25fp00kgc5ovrdenlrnn40vf4t7htb2bejs3lvhr4j50kelch59";

    private static String email = "arshdeeplori+QATest" + RandomUtils.numericValues(5) + "@yopmail.com";

    private static int noOfDevices = Integer.parseInt(RandomUtils.numericValues(1));
    public static String generateToken(){
        token = RestAssured.given().auth().preemptive().basic(clientID, clientKey)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "partner/signup")
                .when().post(TOKEN_URL).then().log().all()
                .extract().body().path("access_token");
        return token;
    }
}