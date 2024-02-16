package com.despegar.stepDefinitions;

import com.despegar.pages.VuelosDespegar;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.WebElementState;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebElement;
import com.despegar.model.Vuelo;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class vuelos {


    static VuelosDespegar vuelosDespegar = new VuelosDespegar();

    @Given("Ingreso a la pagina {string}")
    public void ingreso_a_la_pagina(String url) {
        vuelosDespegar.enterToPage(url);
    }

    @Given("El origen del vuelo es {string} y el destino es {string}")
    public void el_origen_del_vuelo_es_y_el_destino_es(String origen, String destino) {
        vuelosDespegar.ingresarVuelo(origen,destino);
    }



    @And("Ingreso a paquetes")
    public void ingresoAPaquetes() {
        vuelosDespegar.ingresoPaquetes();

    }

    @And("Ingreso a vuelos")
    public void ingresoAVuelos() {
        vuelosDespegar.ingresoVuelos();
    }

    @And("Seleccionar fecha random y buscar")
    public void seleccionarFechaRandomYBuscar() {
        vuelosDespegar.seleccionarFechas();


    }

    @And("escoger el vuelo de ida menor a {string} COP")
    public void escogerElVueloDeIdaMenorACOP(String presupuestoIda) {
        String flight = vuelosDespegar.getListFlights(Integer.parseInt(presupuestoIda));
        vuelosDespegar.selectFligth(flight);

    }

    @And("escoger el vuelo de vuelta menor a {string} COP")
    public void escogerElVueloDeVueltaMenorACOP(String presupuestoVuelta) {
        String flight = vuelosDespegar.getListFlights(Integer.parseInt(presupuestoVuelta));
        vuelosDespegar.selectFligth(flight);
    }

    @And("elegir asientos random")
    public void elegirAsientosRandom() {
        System.out.println("lsos");
        vuelosDespegar.selectSeats();
    }

    @And("elegir equipaje")
    public void elegirEquipaje() {
        vuelosDespegar.equipaje();
    }



    @And("informacion pasajero nombre {string}, apellido {string}, fecha {string}, documento {string}, email {string} y telefono {string}")
    public void informacionPasajeroNombreApellidoFechaDocumentoEmailYTelefono(String nombre, String apellido, String fecha, String documento, String email, String telefono) {
        vuelosDespegar.informationPasenger(nombre,apellido,fecha,documento,email,telefono);
    }


    @And("Realizo el proceso de un vuelo hasta el pago")
    public void procesoVuelo(List<Vuelo> vuelos) {
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo);
        }
    }

    @And("pago con tarjeta de credito tarjeta {string}, nombre y apellido {string}, expiracion {string} y CVV {string}")
    public void pagoConTarjetaDeCreditoTarjetaNombreYApellidoExpiracionYCVV(String numberCard, String nameAndLast, String expiration, String cvv) {
        vuelosDespegar.paymentCard(numberCard,nameAndLast,expiration,cvv);


    }

    @And("El origen del paquete es {string} y el destino es {string}")
    public void elOrigenDelPaqueteEsYElDestinoEs(String origen, String destino) {
        vuelosDespegar.ingresarPaquetes(origen,destino);

    }



}
