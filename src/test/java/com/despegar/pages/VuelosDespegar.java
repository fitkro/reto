package com.despegar.pages;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VuelosDespegar extends PageObject {


    private final By BTN_VUELOS = By.xpath("//button[@data-testid=\"id-tab-flight-tab\"]");
    private final By BTN_PAQUETES = By.xpath("//button[@id=\"id-tab-package\"]");
    private final By TXT_ORIGEN = By.xpath("//input[@id=\"txtInputOrigin_field\"]");
    private final By BTN_AUTOCOMPLETE = By.xpath("//button[@id=\"btnItemAutoComplete_0\"]");
    private final By TXT_DESTINO = By.xpath("//input[@id=\"txtInputDestination_field\"]");
    private final By BTN_BUSCAR = By.xpath("//button[@id=\"btnSearchCTA\"]");



    private final By BTN_TODAY = By.xpath("(//td[contains(@class,'CalendarDay') and @aria-disabled=\"false\"])[4]");
    private final By BTN_NEXT = By.xpath("(//td[contains(@class,'CalendarDay') and @aria-disabled=\"false\"])[11]");

    private final By BTN_SELECT_DATE = By.xpath("//input[@id=\"departureDate\"]");

    private final By FLIGHTS_IDA = By.xpath("//*[contains(@id,\"WrapperCardFlight\")]");

    private final By BTN_ELEGIR_ECONOMY = By.xpath("//div[@data-testid=\"flight-1-price-BASIC\"]//following-sibling::div/button");
    private final By BTN_ACEPTAR_RESTRICCIONES = By.xpath("//span[contains(text(),'Aceptar restricciones')]//ancestor::button");


    private final By TXT_ORIGEN_PAQUETE = By.xpath("//input[@id=\"package-searchbox-origin-autocompleteinput\"]");
    private final By TXT_DESTINO_PAQUETES = By.xpath("//input[@id=\"package-searchbox-destination-autocompleteinput\"]");

    private final By BTN_SELECT_SEATS = By.xpath("//button[@data-testid=\"button9--button\"]");
    private final By BTN_CONFIRM_SEATS = By.xpath("//button[@data-testid=\"btn-confirm-cart-section\"]");
    private final By BTN_CHOOSE_LATER = By.xpath("//button[@data-testid=\"buttonChooseLater--button\"]");
    private final By TXT_PERSONAL_ITEM = By.xpath("//input[@id=\"personal-item\"]");
    private final By BTN_CONTINUE = By.xpath("//button[@data-testid=\"BAGS-continue-button\"]");
    private final By BTN_CONFIRM_CART = By.xpath("//button[@data-testid=\"button-cart-confirm--button\"]");
    private final By TXT_FIRST_NAME = By.xpath("//input[@data-testid=\"passengerDetails-firstName-ADT_1-textfield-input\"]");
    private final By TXT_LAST_NAME = By.xpath("//input[@id=\"passengerDetails-lastName-ADT_1\"]");
    private final By TXT_DATE_OF_BIRTH = By.xpath("//input[@id=\"passengerInfo-dateOfBirth-ADT_1\"]");
    private final By TXT_DOCUMENT_NUMBER = By.xpath("//input[@id=\"documentInfo-documentNumber-ADT_1\"]");
    private final By TXT_EMAIL = By.xpath("//input[@id=\"passengerInfo-emails-ADT_1\"]");
    private final By TXT_PHONE_NUMBER = By.xpath("//input[@id=\"passengerInfo-phones0-number-ADT_1\"]");
    private final By BTN_SUBMIT_PASSENGER_FORM = By.xpath("//button[@id=\"passengerFormSubmitButtonADT_1\"]");
    private final By BTN_FINAL_PRICE = By.xpath("//button[@aria-describedby=\"final-price\"]");
    private final By BTN_CREDIT_CARD = By.xpath("//span[@data-testid=\"new-credit-card-payment-method-radio-accordion-item--radio-styled\"]");
    private final By TXT_CARD_NUMBER = By.xpath("//input[@data-testid=\"cardNumber--text-field\"]");
    private final By TXT_CARD_HOLDER = By.xpath("//input[@data-testid=\"cardHolder--text-field\"]");
    private final By TXT_EXPIRATION_DATE = By.xpath("//input[@data-testid=\"expirationDate--text-field\"]");
    private final By TXT_CVV = By.xpath("//input[@data-testid=\"CVV--password__input--text-field\"]");


    public void enterToPage(String url){
        try {
            getDriver().get(url);
            getDriver().manage().window().maximize();
            getDriver().switchTo();


        }catch (Exception e){
            throw new RuntimeException("The page could not be loaded");
        }


    }

    public void ingresoVuelos(){
        find(BTN_VUELOS).click();


    }
    public void ingresoPaquetes(){
        find(BTN_PAQUETES).click();



    }

    public void ingresarVuelo(String origen,String destino) {



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(TXT_ORIGEN).sendKeys(origen);
        find(BTN_AUTOCOMPLETE).click();

        find(TXT_DESTINO).sendKeys(destino);
        find(BTN_AUTOCOMPLETE).click();


    }


    public void ingresarPaquetes(String origen,String destino) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(TXT_ORIGEN_PAQUETE).typeAndTab(origen);
        find(BTN_AUTOCOMPLETE).click();

        find(TXT_DESTINO_PAQUETES).typeAndTab(destino);
        find(BTN_AUTOCOMPLETE).click();


    }


    public void cambiarAPestanaNueva() {
        WebDriver driver = getDriver();
        String ventanaPrincipal = driver.getWindowHandle();
        Set<String> ventanas = driver.getWindowHandles();

        for (String ventana : ventanas) {
            if (!ventana.equals(ventanaPrincipal)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }
    public void seleccionarFechas() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        find(BTN_SELECT_DATE).click();


        find(BTN_TODAY).click();
        find(BTN_NEXT).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
        find(BTN_BUSCAR).click();


        cambiarAPestanaNueva();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public String getListFlights(int presupuesto) {
        List<WebElement> listFlights = getDriver().findElements(FLIGHTS_IDA);
        System.out.println("vuelos "+listFlights.size());
        System.out.println(listFlights);
        Map<String, Double> vuelosConPrecios = new HashMap<>();

        for (WebElement listFlight : listFlights) {
            System.out.println(listFlight.getAttribute("id"));
            String id = listFlight.getAttribute("id");
            String precioStr = find(By.xpath("(//div[@id='"+id+"']//span[contains(@class,'displayCurrencystyle__CurrencyAmount-sc__sc-hel5vp-2 hrlJTh')])[2]")).getText();
            precioStr = precioStr.replace(",", ".");
            precioStr = precioStr.replace(".", "");

            precioStr = precioStr.substring(0, precioStr.length() - 2);
            System.out.println(precioStr);
            Double price = Double.parseDouble(precioStr);

            vuelosConPrecios.put(id, price);
        }



        Map<String, Double> vuelosMenores500k = new HashMap<>();
        double precioMinimo = Double.MAX_VALUE;
        String idVueloMasBarato = "";

        for (Map.Entry<String, Double> entry : vuelosConPrecios.entrySet()) {
            if (entry.getValue() < presupuesto) {
                vuelosMenores500k.put(entry.getKey(), entry.getValue());
                if (entry.getValue() < precioMinimo) {
                    precioMinimo = entry.getValue();
                    idVueloMasBarato = entry.getKey();
                }
            }
        }


        for (Map.Entry<String, Double> entry : vuelosMenores500k.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return idVueloMasBarato;
    }

    public void selectFligth(String id) {
        find(By.xpath("//div[@id='"+id+"']")).click();
        find(BTN_ELEGIR_ECONOMY).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(BTN_ACEPTAR_RESTRICCIONES).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectSeats() {
        find(BTN_SELECT_SEATS).click();
        find(BTN_CONFIRM_SEATS).click();
        find(BTN_CONFIRM_SEATS).click();
        find(BTN_CONFIRM_SEATS).click();
        find(BTN_CHOOSE_LATER).click();
    }

    public void equipaje() {
        find(TXT_PERSONAL_ITEM).click();
        find(BTN_CONTINUE).click();
        find(TXT_PERSONAL_ITEM).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(BTN_CONTINUE).click();
        find(BTN_CONFIRM_CART).click();
    }

    public void informationPasenger(String nombre, String apellido, String fecha, String documento, String email, String telefono) {
        find(TXT_FIRST_NAME).type(nombre);
        find(TXT_LAST_NAME).type(apellido);
        find(TXT_DATE_OF_BIRTH).type(fecha);
        find(TXT_DOCUMENT_NUMBER).type(documento);
        find(TXT_EMAIL).type(email);
        find(TXT_PHONE_NUMBER).type(telefono);
        find(BTN_SUBMIT_PASSENGER_FORM).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(BTN_FINAL_PRICE).click();
    }

    public void paymentCard(String numberCard, String nameAndLast, String expiration, String cvv){
        find(BTN_CREDIT_CARD).click();
        find(TXT_CARD_NUMBER).type(numberCard);
        find(TXT_CARD_HOLDER).type(nameAndLast);
        find(TXT_EXPIRATION_DATE).type(expiration);
        find(TXT_CVV).type(cvv);
    }
}
