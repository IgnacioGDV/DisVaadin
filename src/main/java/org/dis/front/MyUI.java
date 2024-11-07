package org.dis.front;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private TextField creaLabel(String texto){
        TextField etiqueta = new TextField();
        etiqueta.setCaption(texto);
        return etiqueta;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout salarioBruto = new HorizontalLayout();
        final HorizontalLayout salarioNeto = new HorizontalLayout();
        final VerticalLayout salarioBrutoContenedor = new VerticalLayout();
        final VerticalLayout salarioNetoContenedor = new VerticalLayout();

        TextField tipo = creaLabel("Tipo de empleado");
        TextField ventasMes = creaLabel("Ventas del mes");
        TextField horasExtra = creaLabel( "Horas extra");

        salarioBruto.addComponents(tipo, ventasMes, horasExtra);

        Button BotonSalarioBruto = new Button( "Calcula Salario Bruto");
        BotonSalarioBruto.addClickListener(e -> {
        });

        Button BotonSalarioNeto = new Button( "Calcula Salario Neto");
        BotonSalarioNeto.addClickListener(e -> {
        });

        salarioBrutoContenedor.addComponents(salarioBruto, BotonSalarioBruto);
        salarioNetoContenedor.addComponents(salarioNeto, BotonSalarioNeto);
        TabSheet tabs = new TabSheet();
        tabs.addTab(salarioBruto).setCaption("Calcula Salario Bruto");
        tabs.addTab(salarioNeto).setCaption("Calcula Salario Neto");



        layout.addComponent(tabs);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
