package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Animal;
import modelo.dominio.Tipo;

public class AnimalDAO extends JpaDAO<Animal> {

	private EntityManager em;

	public AnimalDAO() {
		super();
		this.em = JPAUtil.getEntityManager();
	}

	public List<Animal> filtrarAnimais(String nomeAnimal, Tipo tipo) {

		String jpql = "FROM Animal a ";

		if (nomeAnimal != null)
			jpql += " WHERE a.nome LIKE :pNome";

		else if (tipo != null)
			jpql += " WHERE a.tipo = :pTipo";

		else
			jpql += " ORDER BY a.nome";

		TypedQuery<Animal> comando = this.getEntityManager().createQuery(jpql, Animal.class);

		if (nomeAnimal != null)
			comando.setParameter("pNome", "%" + nomeAnimal + "%");

		else if (tipo != null)
			comando.setParameter("pTipo", tipo);

		return comando.getResultList();
	}

	/*
	 * public int pegaUltimoId() {
	 * 
	 * String jpql = "SELECT MAX(id)+1 FROM Animal a"; TypedQuery<Animal> query
	 * = em.createQuery(jpql, Animal.class);
	 * 
	 * int idAnimal = query.getFirstResult();
	 * 
	 * return idAnimal;
	 * 
	 * }
	 */

}