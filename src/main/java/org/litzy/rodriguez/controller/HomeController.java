package org.litzy.rodriguez.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.litzy.rodriguez.model.Vacante;
import org.litzy.rodriguez.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@Autowired
	private IntVacantesService serviceVacantes;
	@GetMapping("/")
	public String mostrarHome(Model model) {
		//Devuelve una vista(un archivo html)
		List<Vacante> vacantes=serviceVacantes.obtenerTodas();
		model.addAttribute("vacantes", vacantes);
		return "home";
	}
	@GetMapping("/mensaje")
	public String mensaje(Model model) {
		//formatear una fecha, obtenerla del sistema
		//LocalDate fecha=LocalDate.now();
		//personalizar fecha
		LocalDate fecha=null;
		try {
			fecha=LocalDate.parse("23-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			System.out.println("Fecha: "+fecha);
		}catch(DateTimeException ex){
			System.out.println("Error: "+ ex.getMessage());
		}
		model.addAttribute("msg", "Bienvenidos a mi aplicación: Empleos App");
		//Actualmente thymeleaf no soporta LocalDate, por tanto convertirlo a Date
		model.addAttribute("fecha", java.sql.Date.valueOf(fecha));
		return "mensaje";
	}
	//*********************************************
	//metodo para manipular diversos tipos de datos
	@GetMapping("/vacante")
	public String vacante(Model model) {
		Integer id=1000;
		String nombre="Programador de Aplicaciones Web";
		LocalDate fecha=LocalDate.now();
		Double salario=12500.00;
		Boolean vigente=true;
		model.addAttribute("id", id);
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "vacante";
	}
	//una coleccion de datos
	@GetMapping("/lista")
	public String lista(Model model) {
		List<String>vacantes=new LinkedList<String>();
		vacantes.add("Contador Publico");
		vacantes.add("Programador de Aplicaciones");
		vacantes.add("Tecnico en mantenimiento de computadoras");
		vacantes.add("Arquitecto");
		vacantes.add("Ingeniero en Electronica");
		//imprimir el arreglo
		for(String elemento: vacantes) {
			System.out.println(elemento);
		}
		model.addAttribute("vacantes", vacantes);
		return "vacante";
	}
	//un metodo que devuelva un objeto tipo vacante
	@GetMapping("/detalles")
	public String detalles(Model model) {
		Vacante v=new Vacante();
		System.out.println(v);
		v.setId(100);
		v.setNombre("Ingeniero Electronico");
		v.setDescripcion("Relacion con aplicaciones de IOT");
		v.setFecha(LocalDate.now());
		v.setSalario(12800.00);
		System.out.println(v);
		model.addAttribute("vacante", v);
		return "detalles";
	}
	@GetMapping("/tabla")
	public String mostrarVacantes(Model model) {
		List<Vacante> vacantes=serviceVacantes.obtenerTodas();
		for(Vacante elemento:vacantes){
			System.out.println(elemento.getId());
			System.out.println(elemento.getNombre());
			System.out.println(elemento.getDescripcion());
			System.out.println(elemento.getFecha());
			System.out.println(elemento.getSalario());
			System.out.println(elemento.getDestacado());
		}
		model.addAttribute("vacantes", vacantes);
		return "tabla";
	}
	/*private List<Vacante> obtenerVacantes(){
		List<Vacante> lista=new LinkedList<Vacante>();
		try {
			Vacante v1=new Vacante();
			v1.setId(1);
			v1.setNombre("Contador");
			v1.setDescripcion("Relacionado con contabilidad general");
			v1.setFecha(LocalDate.parse("12-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(10000.0);
			v1.setDestacado(1);
			v1.setImagen("contador.png");
			lista.add(v1);
			//*****************************************************************************+
			Vacante v2=new Vacante();
			v2.setId(2);
			v2.setNombre("Arquitecto");
			v2.setDescripcion("Amplia experiencia en construccion");
			v2.setFecha(LocalDate.parse("25-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(12000.0);
			v2.setDestacado(0);
			v2.setImagen("arquitecto.png");
			lista.add(v2);
			//*****************************************************************************+
			Vacante v3=new Vacante();
			v3.setId(3);
			v3.setNombre("Programador");
			v3.setDescripcion("Desarrollo de aplicaciones web");
			v3.setFecha(LocalDate.parse("02-02-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(12000.0);
			v3.setDestacado(0);
			v3.setImagen("programador.png");
			lista.add(v3);
			//*****************************************************************************+
			Vacante v4=new Vacante();
			v4.setId(4);
			v4.setNombre("Tecnico en  mantenimiento");
			v4.setDescripcion("Relacion con el mantenimewinto de computo");
			v4.setFecha(LocalDate.parse("07-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(5000.0);
			v4.setDestacado(1);
			//v1.setImagen("tecnico.png"); Sale imagen por default por no tener la variable activa.
			lista.add(v4);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		return lista;
	} */
}