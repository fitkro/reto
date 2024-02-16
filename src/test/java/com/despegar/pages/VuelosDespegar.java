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


    By BTN_ALOJAMIENTOS = By.xpath("//a[@product=\"HOTELS\"]");
    By BTN_VUELOS = By.xpath("//button[@data-testid=\"id-tab-flight-tab\"]");
    By BTN_PAQUETES = By.xpath("//a[@product=\"PACKAGES\"]");
    By TXT_ORIGEN = By.xpath("//input[@id=\"txtInputOrigin_field\"]");
    By BTN_AUTOCOMPLETE = By.xpath("//button[@id=\"btnItemAutoComplete_0\"]");
    By TXT_DESTINO = By.xpath("//input[@id=\"txtInputDestination_field\"]");
    By BTN_IDA_FECHA = By.xpath("(//input[@placeholder=\"Ida\"])[1]");
    By BTN_IDA_VUELTA = By.xpath("(//input[@placeholder=\"Vuelta\"])[1]");

    By BTN_SELECCIONAR_POR_MES = By.xpath("(//span[contains(text(),'Selección por mes')])[1]");
    By BTN_BUSCAR = By.xpath("//button[@id=\"btnSearchCTA\"]");

    By BTN_ALL_MONTHS = By.xpath("(//span[contains(text(),'Febrero')]//ancestor::label/input)[1]");
    By BTN_APLICAR = By.xpath("(//em[contains(text(),'Aplicar')]//ancestor::button)[1]");

    By BTN_CLOSE_BANNER = By.xpath("//div[contains(@class,'login-incentive--button-close')]");

    By BTN_TEST = By.xpath("//div[@class=\"sbox5-box-container--1Ro43\"]");

    By BTN_TODAY = By.xpath("(//td[contains(@class,'CalendarDay') and @aria-disabled=\"false\"])[4]");
    By BTN_NEXT = By.xpath("(//td[contains(@class,'CalendarDay') and @aria-disabled=\"false\"])[11]");
    By BTN_CLOSE_COOKIES = By.xpath("//em[contains(text(),'Entendí')]");

    By BTN_SELECT_DATE = By.xpath("//input[@id=\"departureDate\"]");

    By FLIGHTS_IDA = By.xpath("//*[contains(@id,\"WrapperCardFlight\")]");

    By BTN_ELEGIR_ECONOMY = By.xpath("//div[@data-testid=\"flight-1-price-BASIC\"]//following-sibling::div/button");
    By BTN_ACEPTAR_RESTRICCIONES = By.xpath("//span[contains(text(),'Aceptar restricciones')]//ancestor::button");
    public void enterToPage(String url){


        //div[not(contains(@class,'-disabled'))]
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



//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        find(BTN_BUSCAR).waitUntilEnabled().click();

//        try {
//            Thread.sleep(40000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
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
//        find(BTN_CLOSE_BANNER).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        find(BTN_SELECT_DATE).click();

//

        find(BTN_TODAY).click();
        find(BTN_NEXT).click();
//        find(BTN_APLICAR).click();
//

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

// Eliminar los dos últimos caracteres
            precioStr = precioStr.substring(0, precioStr.length() - 2);
            System.out.println(precioStr);
            Double price = Double.parseDouble(precioStr);

            vuelosConPrecios.put(id, price);
        }

        System.out.println(vuelosConPrecios);


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

        // Imprimir los vuelos con precios menores a 500,000
        System.out.println("Vuelos con precios menores a 500,000:");
        for (Map.Entry<String, Double> entry : vuelosMenores500k.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Imprimir el vuelo más barato junto con su ID
        System.out.println("Vuelo más barato:");
        System.out.println("ID: " + idVueloMasBarato + ", Precio: " + precioMinimo);
        System.out.println("lsksks");

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

    public void seats() {
        find(By.xpath("//button[@data-testid=\"button9--button\"]")).click();
        find(By.xpath("//button[@data-testid=\"btn-confirm-cart-section\"]")).click();
        find(By.xpath("//button[@data-testid=\"btn-confirm-cart-section\"]")).click();
        find(By.xpath("//button[@data-testid=\"btn-confirm-cart-section\"]")).click();
        find(By.xpath("//button[@data-testid=\"buttonChooseLater--button\"]")).click();
    }

    public void equipaje() {
        find(By.xpath("//input[@id=\"personal-item\"]")).click();
        find(By.xpath("//button[@id=\"tabSegment-1\"]")).click();
        find(By.xpath("//input[@id=\"personal-item\"]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(By.xpath("//button[@data-testid=\"BAGS-continue-button\"]")).click();
        find(By.xpath("//button[@data-testid=\"button-cart-confirm--button\"]")).click();

    }

    public void informationPasenger(String nombre, String apellido, String fecha, String documento, String email, String telefono) {
        find(By.xpath("//input[@data-testid=\"passengerDetails-firstName-ADT_1-textfield-input\"]")).type(nombre);
        find(By.xpath("//input[@id=\"passengerDetails-lastName-ADT_1\"]")).type(apellido);
        find(By.xpath("//input[@id=\"passengerInfo-dateOfBirth-ADT_1\"]")).type(fecha);
        find(By.xpath("//input[@id=\"documentInfo-documentNumber-ADT_1\"]")).type(documento);
        find(By.xpath("//input[@id=\"passengerInfo-emails-ADT_1\"]")).type(email);
        find(By.xpath("//input[@id=\"passengerInfo-phones0-number-ADT_1\"]")).type(telefono);
        find(By.xpath("//button[@id=\"passengerFormSubmitButtonADT_1\"]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        find(By.xpath("//button[@aria-describedby=\"final-price\"]")).click();

    }

    public void paymetCard(String numberCard,String nameAndLast,String expiration,String cvv){
        find(By.xpath("//span[@data-testid=\"new-credit-card-payment-method-radio-accordion-item--radio-styled\"]")).click();
        find(By.xpath("//input[@data-testid=\"cardNumber--text-field\"]")).type(numberCard);
        find(By.xpath("//input[@data-testid=\"cardHolder--text-field\"]")).type(nameAndLast);
        find(By.xpath("//input[@data-testid=\"expirationDate--text-field\"]")).type(expiration);
        find(By.xpath("//input[@data-testid=\"CVV--password__input--text-field\"]")).type(cvv);

    }
}
