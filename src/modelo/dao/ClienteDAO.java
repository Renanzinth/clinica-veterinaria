package modelo.dao;

import java.util.List;

import modelo.dominio.Cliente;

public class ClienteDAO extends JpaDAO<Cliente> {
	
	@Override
	public List<Cliente> lerTodos() {

		List<Cliente> lista = super.lerTodos();
		
		if (lista.isEmpty()) {
			this.salvar(new Cliente("17673919788", "Renan", "Narciso", "21371325"));
			this.salvar(new Cliente("17673940710", "Ruan", "Diego", "21371325"));
			this.salvar(new Cliente("45678712379", "Carolini", "Campos", "22424590"));
			this.salvar(new Cliente("48957158684", "Leticia", "Barbosa", "35246584"));
			
			lista = super.lerTodos();
		}
		return lista;
	
	}
}
