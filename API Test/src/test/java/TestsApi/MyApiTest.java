package TestsApi;

import Pages.LoginPage;
import Pages.SummaryPage;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MyApiTest {



    @Test
    public void testApilogin() throws IOException {
        ApiWork apiWork = new ApiWork();
        Assertions.assertEquals(200, apiWork.loginApi().getStatusLine().getStatusCode());

    }
/*
    @Test
    public void testAlgo(){
        ApiWork aWq = new ApiWork();
        aWq.getArray();
    }

 */
    }
