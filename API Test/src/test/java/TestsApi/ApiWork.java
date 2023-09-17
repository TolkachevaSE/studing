package TestsApi;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiWork {
public    ArrayList<String> positive_ar_api=new ArrayList();
    public    ArrayList<String> negative_ar_api=new ArrayList();
    public HttpClient httpClient;

    public HttpResponse loginApi() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://app.qa.axa.epm-rtc.projects.epam.com/oauth/token");
        post.setHeader("Authorization", "Basic d2ViYXBwOg==");
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("password", "Staging@Axa"));
        formParams.add(new BasicNameValuePair("username", "selenium_chrome"));
        formParams.add(new BasicNameValuePair("grant_type", "password"));
        formParams.add(new BasicNameValuePair("scope", "deltix.axa.user"));
        post.setEntity(new UrlEncodedFormEntity(formParams));
        HttpResponse response = httpClient.execute(post);
                return response;
    }


    public String getToken(HttpResponse response) throws IOException {

        String s = EntityUtils.toString(response.getEntity());
        s = s.substring(s.indexOf("access_token") + "access_token".length() + 3);
        s = s.substring(0, s.indexOf("\""));
        return s;
    }

    public HttpResponse algoRequest(String token, String json_post) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://app.qa.axa.epm-rtc.projects.epam.com/api/v1/post-trade/orders/query?benchmarkType=VWAP" );
        token = "bearer " + token;
        post.setHeader("Authorization", token);
        post.setHeader("Referer", "https://app.qa.axa.epm-rtc.projects.epam.com/post-trade/summary-dashboard");
        post.setHeader("Accept", "application/json, text/plain, */*");
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Origin", "https://app.qa.axa.epm-rtc.projects.epam.com");
        StringEntity params =new StringEntity(json_post);
        post.setEntity(params);
        HttpResponse response = httpClient.execute(post);
        return response;


    }

    public void getArray()  {
        String positive_post = "{\"expressions\":[\"orderType\",\"countIf(priceImprovementToBenchmarkAmount > 0) as positive\"],\"groupByExpressions\":[\"orderType\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"orderType\",\"sortType\":\"ASC\"}],\"filter\":{\"$type\":\"AndFilterDefinition\",\"filters\":[{\"$type\":\"SubqueryFilterDefinition\",\"fieldExpression\":\"orderInstrument\",\"filterType\":\"IN\",\"filterValue\":{\"expressions\":[\"orderInstrument\"],\"groupByExpressions\":[\"orderInstrument\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"count()\",\"sortType\":\"DESC\"}],\"take\":10}},{\"$type\":\"FilterDefinition\",\"fieldExpression\":\"dbSequence\",\"filterType\":\"LESS_OR_EQUAL\",\"filterValue\":[\"7615\"]}]}}";
        String negative_post = "{\"expressions\":[\"orderType\",\"countIf(priceImprovementToBenchmarkAmount < 0) as negative\"],\"groupByExpressions\":[\"orderType\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"orderType\",\"sortType\":\"ASC\"}],\"filter\":{\"$type\":\"AndFilterDefinition\",\"filters\":[{\"$type\":\"SubqueryFilterDefinition\",\"fieldExpression\":\"orderInstrument\",\"filterType\":\"IN\",\"filterValue\":{\"expressions\":[\"orderInstrument\"],\"groupByExpressions\":[\"orderInstrument\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"count()\",\"sortType\":\"DESC\"}],\"take\":10}},{\"$type\":\"FilterDefinition\",\"fieldExpression\":\"dbSequence\",\"filterType\":\"LESS_OR_EQUAL\",\"filterValue\":[\"7615\"]}]}}";
        String negative_line = null, positive_line = null;
        String token = null;
        try {
            token = getToken(loginApi());
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            negative_line = EntityUtils.toString(algoRequest(token, negative_post).getEntity());
            positive_line = EntityUtils.toString(algoRequest(token, positive_post).getEntity());
        }catch (Exception e){e.printStackTrace();}



        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher_n = pat.matcher(negative_line);
        try {
            while (matcher_n.find()) {
                negative_ar_api.add(matcher_n.group());
                    }            ;
        } catch (Exception e) {
            e.printStackTrace();

        }


        Matcher matcher = pat.matcher(positive_line);
        try {
            while (matcher.find()) {
                positive_ar_api.add(matcher.group());}          ;
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
