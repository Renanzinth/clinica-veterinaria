package modelo.dao;

import java.util.List;

import modelo.dominio.Tipo;

public class TipoDAO extends JpaDAO<Tipo> {

	@Override
	public List<Tipo> lerTodos() {
		
		List<Tipo> lista = super.lerTodos();
		
		if (lista.isEmpty()) {
			this.salvar(new Tipo("Cachorro"));
			this.salvar(new Tipo("Gato"));
			this.salvar(new Tipo("Periquito"));
			this.salvar(new Tipo("Calopsyta"));
			
			lista = super.lerTodos();
		}
		return lista;
	}
}
