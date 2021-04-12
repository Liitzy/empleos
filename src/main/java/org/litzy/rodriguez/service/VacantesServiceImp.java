package org.litzy.rodriguez.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.litzy.rodriguez.model.Categoria;
import org.litzy.rodriguez.model.Vacante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantesService{
	//variable de clase
	private List<Vacante> lista=null;
	
	public VacantesServiceImp(){
		lista=new LinkedList<Vacante>();
		try {
			Vacante v1=new Vacante();
			v1.setId(1);
			v1.setNombre("Contador");
			v1.setDescripcion("Relacionado con contabilidad general");
			v1.setFecha(LocalDate.parse("12-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(10000.0);
			v1.setDestacado(1);
			v1.setEstatus("Aprobada");
			v1.setImagen("contador.jpg");
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Contabilidad");
			c1.setDescripcion("Relacionado con contabilidad");
			v1.setCategoria(c1);
			lista.add(v1);
			//*****************************************************************************+
			Vacante v2=new Vacante();
			v2.setId(2);
			v2.setNombre("Arquitecto");
			v2.setDescripcion("Amplia experiencia en construccion");
			v2.setFecha(LocalDate.parse("25-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(12000.0);
			v2.setDestacado(0);
			v2.setEstatus("Creada");
			v2.setImagen("arquitecto.jpg");
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Arquitectura");
			c2.setDescripcion("Relacionado con arquitectura");
			v2.setCategoria(c2);
			lista.add(v2);
			//*****************************************************************************+
			Vacante v3=new Vacante();
			v3.setId(3);
			v3.setNombre("Programador");
			v3.setDescripcion("Desarrollo de aplicaciones web");
			v3.setFecha(LocalDate.parse("02-02-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(12000.0);
			v3.setDestacado(0);
			v3.setEstatus("Aprobada");
			v3.setImagen("programaor.png");
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Computacion");
			c3.setDescripcion("Relacionado con computacion ");
			v3.setCategoria(c3);
			lista.add(v3);
			//*****************************************************************************+
			Vacante v4=new Vacante();
			v4.setId(4);
			v4.setNombre("Tecnico en  mantenimiento");
			v4.setDescripcion("Relacion con el mantenimewinto de computo");
			v4.setFecha(LocalDate.parse("07-01-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(5000.0);
			v4.setDestacado(1);
			v4.setEstatus("Eliminada");
			v4.setImagen("tecnicomante.jpg"); //Sale imagen por default por no tener la variable activa.
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Matenimiento");
			c4.setDescripcion("Relacionado con contabilidad");
			v4.setCategoria(c4);
			lista.add(v4);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public Vacante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		for(Vacante vacante: obtenerTodas()) {
			if(vacante.getId()== id) {
				return vacante;
			}
		}
		return null;
	}
	
	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
		
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
