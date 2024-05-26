package com.haceb.steps.registrarseSteps.menuRegistro;

import com.haceb.PageObject.registrarsePage.menuRegistro.RegistroDetallesAdicionalesPage;

import net.thucydides.core.annotations.Step;

import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.support.ui.Select;

import static com.haceb.utils.CallData.datosPrincipales;
import static com.haceb.utils.CambioVentana.cambiarPantalla;

import static com.haceb.utils.EsperasExplicitas.esperarElemento;
import static com.haceb.utils.HacerScroll.hacerScroll;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistroDetallesAdicionalesSteps {

    @Page
    private RegistroDetallesAdicionalesPage registroDetallesAdicionales;


    @Step("ingreso los datos de la ventana algunos detalles mas")

    public void ingresoDatosAdicionales() {


        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getCjTxtCedula());
        registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getCjTxtCedula()).sendKeys(datosPrincipales().get(0).get("Cedula"));

        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getSelectGenero());
        Select seleccionarGenero = new Select(getDriver().findElement(registroDetallesAdicionales.getSelectGenero()));
        seleccionarGenero.selectByVisibleText(datosPrincipales().get(0).get("Genero"));

        registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getDateFechaNacimiento()).sendKeys(datosPrincipales().get(0).get("Fecha_Nacimiento"));

        hacerScroll(getDriver());

        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getSelectDepartamento());
        registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getSelectDepartamento()).sendKeys(datosPrincipales().get(0).get("Departamento"));


    }

    @Step("presiono el boton enviar")
    public void botonEnviar() {
        hacerScroll(getDriver());
        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getButtonEnviar());
        registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getButtonEnviar()).click();


    }


    @Step("visualizarse la nueva pestaña con respectivo  mensaje")
    public void msjInicioSesion() {
        cambiarPantalla();
        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getAlertclose());
        registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getAlertclose()).click();

        esperarElemento(registroDetallesAdicionales.getDriver(), registroDetallesAdicionales.getMsjInicioSesion());


        assertTrue(
                registroDetallesAdicionales.getDriver().findElement(registroDetallesAdicionales.getMsjInicioSesion()).isDisplayed()

                );



    }
}
