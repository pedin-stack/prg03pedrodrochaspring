package br.com;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Prg03spring2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Prg03spring2Application.class)
            .headless(false)
            .web(WebApplicationType.NONE)
            .run(args);
        
        CursoListar telaCursoListar = context.getBean(CursoListar.class);
        telaCursoListar.setVisible(true);
    }
	}


