package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class mobilePageTest {
    public static void main(String[] args) throws  Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver obj = new ChromeDriver();
        obj.get("https://qamobilespecs.ccbp.tech/");
        ArrayList expectedSpecs = new ArrayList<>();
        expectedSpecs.add("5.80 Super Retina HD OLED Display");
        expectedSpecs.add("Front Camera 7MP");
        expectedSpecs.add("Rear Camera 12MP + 12MP");
        expectedSpecs.add("Apple A11 Bionic Processor");
        expectedSpecs.add("Battery Capacity 2716mAH");
        List <WebElement> spec = obj.findElements(By.xpath("//*[text() = '3 GB RAM']/following-sibling::*"));
        int expectedSpec = spec.size();
        int currentSpec = 0;
        for (int i = 0; i < spec.size(); i++) {
            if (expectedSpecs.get(i).equals(spec.get(i).getText())){
                currentSpec++;
            }
        }
        if (expectedSpec == currentSpec){
            System.out.println("Verified Specifications");
        }else {
            System.out.println("Mismatch found in Specifications");
        }
        WebElement h1 = obj.findElement(By.xpath("//*[text() = '3 GB RAM']/parent::ul/preceding-sibling::h1"));
        if (h1.getText().equals("Specifications:")){
            System.out.println("Verified Heading");
        }else {
            System.out.println("Mismatch Found in Heading");
        }
        WebElement button = obj.findElement(By.xpath("//*[text() = '3 GB RAM']/parent::ul/following::button"));
        button.click();
        System.out.println("Button Clicked");
        Thread.sleep(3000);
        obj.quit();
    }
}
