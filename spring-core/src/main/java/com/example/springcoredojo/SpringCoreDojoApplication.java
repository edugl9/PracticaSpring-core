package com.example.springcoredojo;

import com.example.springcoredojo.nttdata.Config;
import com.example.springcoredojo.nttdata.Usuario;
import com.example.springcoredojo.nttdata.Youtuber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ObjectInputFilter;

@SpringBootApplication
public class SpringCoreDojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDojoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			creacionBean();
			classPathXmlApplicationContext();
		};
	}

	private void creacionBean() {
		ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		Usuario usuarioGeneradoPorBean = context.getBean("usuario", Usuario.class);
		System.out.println("Usuario: "+usuarioGeneradoPorBean);
	}

	public void classPathXmlApplicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
		Youtuber youtuber = context.getBean(Youtuber.class);
		System.out.println("youtuber: "+ youtuber.getNombre());
	}

}