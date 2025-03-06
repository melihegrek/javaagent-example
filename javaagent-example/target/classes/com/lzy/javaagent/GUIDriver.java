package com.lzy.javaagent;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class GUIDriver extends RemoteWebDriver {
    private static final String SPARK_SERVER_URL = "http://localhost:8081";

    @Override
    public WebElement findElement(By by) {
        if (by instanceof By.ByXPath) {
            String xpath = by.toString().replace("By.xpath: ", "");
            return new WebElementProxy(xpath, this);
        } else {
            throw new UnsupportedOperationException("Sadece XPath ile arama desteklenir.");
        }
    }

    private static class WebElementProxy implements WebElement {
        private final String xpath;
        private final GUIDriver driver;

        public WebElementProxy(String xpath, GUIDriver driver) {
            this.xpath = xpath;
            this.driver = driver;
        }

        @Override
        public void click() {
            try {
                String requestUrl = SPARK_SERVER_URL + "/trigger?path=" + xpath;
                HttpGet request = new HttpGet(URI.create(requestUrl));
                try (CloseableHttpClient client = HttpClientBuilder.create().build();

                     CloseableHttpResponse response = (CloseableHttpResponse) client
                             .execute(request, new ResponseHandler<Object>() {
                                 @Override
                                 public Object handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                                     if (httpResponse.getStatusLine().getStatusCode() != 200) {
                                         throw new NoSuchElementException("Element bulunamadı: " + xpath);
                                     }

                                     return null;
                                 }
                             })) {


                }


                //HttpClient client = HttpClient.newHttpClient();
                //HttpRequest request = HttpRequest.newBuilder().uri().build();
                //HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            } catch (Exception e) {
                throw new RuntimeException("Spark sunucusuna istek gönderilirken hata oluştu.", e);
            }
        }

        @Override
        public void submit() {
            // Implement the submit action here if needed
        }

        @Override
        public void sendKeys(CharSequence... keysToSend) {
            // Implement sendKeys if necessary
        }

        @Override
        public void clear() {
            // Implement clear if necessary
        }

        @Override
        public String getTagName() {
            return null;
        }

        @Override
        public String getAttribute(String name) {
            return null;
        }

        @Override
        public boolean isSelected() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }

        @Override
        public String getText() {
            try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
                String requestUrl = SPARK_SERVER_URL + "/getText?path=" + xpath;
                HttpGet request = new HttpGet(requestUrl);

                try (CloseableHttpResponse response = client.execute(request)) {
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            return extractTextFromSparkResponse(EntityUtils.toString(entity)); // Extract text using EntityUtils
                        } else {
                            return null; // Return null if there's no entity
                        }
                    } else if (statusCode == 404) {
                        throw new NoSuchElementException("Element bulunamadı: " + xpath);
                    } else {
                        throw new RuntimeException("Spark sunucusu hatası: " + statusCode);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Spark sunucusuna istek gönderilirken hata oluştu.", e);
            }
        }


        @Override
        public List<WebElement> findElements(By by) {
            return Collections.emptyList();
        }
        @Override
        public WebElement findElement(By by) {
            return null;
        }

        @Override
        public boolean isDisplayed() {
            return false;
        }

        @Override
        public Point getLocation() {
            return null;
        }

        @Override
        public Dimension getSize() {
            return null;
        }

        @Override
        public Rectangle getRect() {
            return null;
        }

        @Override
        public String getCssValue(String propertyName) {
            return null;
        }

        @Override
        public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
            return null;
        }
        private String extractTextFromSparkResponse(String sparkResponse) {
            // Assuming sparkResponse is in the format: "Text in component with path '/path': actualText"
            int colonIndex = sparkResponse.lastIndexOf(':');
            if (colonIndex != -1) {
                return sparkResponse.substring(colonIndex + 1).trim();
            } else {
                throw new RuntimeException("Unexpected Spark response format: " + sparkResponse);
            }
        }
    }
}
