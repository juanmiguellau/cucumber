package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.DriverUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.className;


public class WebSiteManagement extends Runner {

   // static ChromeDriver chromeDriver;
    // DriverUtil  driverUtil;
    // Runner runner;
   //private final DriverUtil driverUtil=getDriverUtil();
   // mettendo il get non partiva il driverutil perche ce lavevo nel runner visto che ho extend il Runner( invece si deve fare quando le classi si trovano una nel test e una in java)
//se si mette private driver..in ruuner si deve mettere il private driveruti ..get invece senza private si chiama direttamnte il metodo driverutil
    By searchBox=id("APjFqb");
    By cookie=className("truste-button1");
    By accetta=cssSelector("#L2AGLb > div");
    By main= id("res");
    By mainClass= className("v7W49e");
    By galaxy = By.cssSelector("#bc-cross-navigation > div > div > ul > li.bc-cross-navigation-item.swiper-slide.swiper-slide-next > a");
    By s23= By.cssSelector("#device > div.hubble-product__options-content > ul > li:nth-child(2) > div.s-option-box.hubble-pd-radio.js-radio-wrap.is-checked > label > span.s-label > span");
    By s512= By.cssSelector("#storage > div.hubble-product__options-content > ul > li:nth-child(3) > div.s-option-box.hubble-pd-radio.js-radio-wrap.is-checked > label > span.s-label > span");
   // By galaxy = cssSelector("#bc-cross-navigation > div > div > ul > li.bc-cross-navigation-item.swiper-slide.swiper-slide-next > a");
    By totalPrice = By.cssSelector("#deviceSummary > div:nth-child(3) > span.hubble-product__summary-product-price.device-price-info");
    By modelCart= By.cssSelector("#deviceSummary > div:nth-child(1)");
    By webChoose=cssSelector("#tads > div:nth-child(3) > div > div > div > div.v5yQqb.VSfPcc > a > div.CCgQ5.vCa9Yd.QfkTvb.k6WZR.OSrXXb.N8QANc.MUxGbd.v0nnCb > span");
    By btnClick=className("gNO89b");

    /**
    @Given("star driver")
    public void star_driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        chromeDriver = new ChromeDriver(options);
        driverUtil = new DriverUtil(chromeDriver);
    }
     */

    @Given("L'utente si trova sulla pagina di accesso")
    public void l_utente_si_trova_sulla_pagina_di_accesso() {
        star_drive();
    }

    @When("L'utente fa clic sul pulsante di accesso")
    public void l_utente_fa_clic_sul_pulsante_di_accesso() {
        getURL();
        clickElement("element found", "element not found", accetta);
        writeText("element found", "element not found", searchBox, "samsung s23\n ");
        clickElement("element found", "element not found", btnClick);
       // driverUtil.findElement(accetta).click();
        //driverUtil.findElement(searchBox).sendKeys("samsung s23 ");
        //driverUtil.findElement(btnClick).click();
    }
    @Then("L'utente viene reindirizzato alla dashboard")
    public void l_utente_viene_reindirizzato_alla_dashboard() {
        WebElement element = driverUtil.findElement(main);
        List<WebElement> listSamsung =element.findElements(mainClass);
        WebElement elementWeb= driverUtil.findElement(webChoose);
        for (WebElement samsungList:listSamsung ) {
            if(samsungList.getText().contains("Acquista il nuovo Galaxy S23 | S23 Plus | Prezzo - Samsung")) {
                elementWeb.click();
            }
        }
        WebElement aCookie=driverUtil.findElement(cookie);
        if (aCookie.getText().contains("Accetta i Cookie")) {
            clickElement("element found", "element not found", cookie);
           // aCookie.click();
            System.out.println("clicked");
        }
    }

    @Given("L'utente si trova sulla dashboard")
    public void lUtenteSiTrovaSullaDashboard() {
        WebElement chooseGalaxy=driverUtil.findElement(galaxy);
        if(chooseGalaxy.getText().contains("Galaxy S23 | S23+")) {
            clickElement("element found", "element not found", galaxy);
            //chooseGalaxy.click();
        }
    }

    @When("L'utente fa clic sul prodotto desiderato")
    public void lUtenteFaClicSulProdottoDesiderato() {
        WebElement memoryItem=driverUtil.findElement(s512);
        isEnable(s512);
       // boolean galaxyMemory = memoryItem.isEnabled();
        //Assertions.assertTrue(galaxyMemory);
        assertionContainText("512GB | 8GB\n" +
                "44,97 € al mese per 30 mesi o\n" +
                "1.349,00 €",s512);
        //boolean memoryGalaxy=memoryItem.getText().contains("512GB | 8GB\n" +
              //  "44,97 € al mese per 30 mesi o\n" +
               // "1.349,00 €");
        //Assertions.assertTrue(memoryGalaxy);
    }

    @Then("L'articolo viene creato correttamente")
    public void lArticoloVieneCreatoCorrettamente() {
        WebElement modelItem=driverUtil.findElement(s23);
        isEnable(s23);
        //boolean galaxyModel = modelItem.isEnabled();
        //Assertions.assertTrue(galaxyModel);
        assertionContainText("Galaxy S23+\n" +
                "A partire da 44,97 € al mese per 30 mesi o\n" +
                "1.349,00 €",s23);
       // boolean modelGalaxy=modelItem.getText().contains("Galaxy S23+\n" +
         //       "A partire da 44,97 € al mese per 30 mesi o\n" +
           //     "1.349,00 €");
       // Assertions.assertTrue(modelGalaxy);
    }

    @Given("L'utente si trova sul carrello")
    public void lUtenteSiTrovaSulCarrello() {
        WebElement chooseGalaxyCart=driverUtil.findElement(galaxy);
        if(chooseGalaxyCart.getText().contains("Galaxy S23 | S23+")) {
            clickElement("element found", "element not found", galaxy);
            //chooseGalaxyCart.click();
        }
    }

    @When("L'utente fa clic sul proprio carrello")
    public void lUtenteFaClicSulProprioCarrello() {
       // WebElement priceTotal =driverUtil.findElement(totalPrice);
        //Assertions.assertEquals("1.349,00 €",priceTotal.getText());
        assertionEqualText("1.349,00 €",totalPrice);
    }

    @Then("Il prodotto viene controllato correttamente")
    public void ilProdottoVieneControllatoCorrettamente() {
        //WebElement modelPhone=driverUtil.findElement(modelCart);
       // Assertions.assertEquals("Galaxy S23+",modelPhone.getText());
        assertionEqualText("Galaxy S23+", modelCart);
    }

    @Then("si chiude il test")
    public void siChiudeIlTest() {
        afterAll();
    }
}
