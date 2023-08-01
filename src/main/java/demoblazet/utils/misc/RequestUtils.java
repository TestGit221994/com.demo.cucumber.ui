package demoblazet.utils.misc;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.util.List;

import static demoblazet.utils.misc.GenerateTokenUtils.generateToken;

public class RequestUtils {

    private static final Logger logger = LogManager.getLogger(RequestUtils.class);

    public static RequestSpecification getOauth2Request(DataTable configDetails) {

        RequestSpecification spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("")
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .addFilter(RequestLoggingFilter.logRequestTo(IoBuilder.forLogger(logger).buildPrintStream()))
                .addFilter(ResponseLoggingFilter.logResponseTo(IoBuilder.forLogger(logger).buildPrintStream())).build();

        RestAssured.authentication = getOauth2(configDetails);

        return RestAssured.given(spec).log().all();
    }

    public static AuthenticationScheme getOauth2(DataTable configDetails) {
        List<List<String>> list = configDetails.asLists();
        List<String> dataTableHeading = list.get(0);
        List<String> dataTableValues = list.get(1);
        return RestAssured.oauth2(generateToken());
    }
}
