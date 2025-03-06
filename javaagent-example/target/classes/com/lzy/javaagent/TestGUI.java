package com.lzy.javaagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestGUI {

    private static final String XPATH_BINARY_RADIO_BUTTON = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JRadioButton[0]";
    private static final String XPATH_DECIMAL_RADIO_BUTTON = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JRadioButton[2]";
    private static final String XPATH_BUTTON_1 = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JButton[18]";
    private static final String XPATH_BUTTON_2 = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JButton[19]";
    private static final String XPATH_BUTTON_PLUS = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JButton[28]";
    private static final String XPATH_BUTTON_EQUALS = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JButton[23]";
    private static final String XPATH_TEXT_FIELD = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JTextField[0]";
    private static final String XPATH_CLEAR_BUTTON = "/JRootPane[0]/JLayeredPane[0]/JPanel[0]/JButton[32]";

    public static void main(String[] args) throws InterruptedException {
        GUIDriver driver = new GUIDriver();

        // Decimal modunu seçme
        driver.findElement(By.xpath(XPATH_DECIMAL_RADIO_BUTTON)).click();
        Thread.sleep(500);

        // 1 + 2 işlemi
        driver.findElement(By.xpath(XPATH_BUTTON_1)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_PLUS)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_2)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_EQUALS)).click();
        Thread.sleep(500);

        // Sonucu doğrulama
        Thread.sleep(1000); // Sonucun güncellenmesi için bekleme
        WebElement resultElement = driver.findElement(By.xpath(XPATH_TEXT_FIELD));
        String result = resultElement.getText();
        String expectedResult = "3"; // Decimal modda 1 + 2 = 3

        if (result.equals(expectedResult)) {
            System.out.println("Test başarılı! Sonuç: " + result);
        } else {
            System.err.println("Test başarısız! Beklenen sonuç: " + expectedResult + ", Alınan sonuç: " + result);
        }

        // Metin alanını temizleme
        driver.findElement(By.xpath(XPATH_CLEAR_BUTTON)).click();
        Thread.sleep(500);

        // Binary modunu seçme
        driver.findElement(By.xpath(XPATH_BINARY_RADIO_BUTTON)).click();
        Thread.sleep(500);

        // 1 + 2 işlemi tekrarlama
        driver.findElement(By.xpath(XPATH_BUTTON_1)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_PLUS)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_1)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(XPATH_BUTTON_EQUALS)).click();
        Thread.sleep(500);

        // Sonucu tekrar doğrulama
        Thread.sleep(1000);
        resultElement = driver.findElement(By.xpath(XPATH_TEXT_FIELD));
        result = resultElement.getText();
        expectedResult = "10"; // Binary modda 1 + 2 = 11

        if (result.equals(expectedResult)) {
            System.out.println("Test başarılı! Sonuç: " + result);
        } else {
            System.err.println("Test başarısız! Beklenen sonuç: " + expectedResult + ", Alınan sonuç: " + result);
        }

        driver.quit();
    }
}
