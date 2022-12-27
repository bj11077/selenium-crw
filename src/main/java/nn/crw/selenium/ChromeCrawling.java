package nn.crw.selenium;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
@RequiredArgsConstructor
public class ChromeCrawling {


    private final ObjectProvider<WebDriver> webDriverObjectProvider;

    @Scheduled(fixedDelay = 3000)
    private void crawling(){
        log.info("crawling work");
        WebDriver driver = webDriverObjectProvider.getObject();
        driver.get("https://www.wanted.co.kr");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        List<WebElement> element = driver.findElements(By.xpath("/html"));
        log.info("search size : {}", element.size());
    }




}
