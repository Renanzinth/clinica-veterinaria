package modelo.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	@Column(length=20, nullable=true)
	private int credito;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.PERSIST)
	private List<Animal> animais;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String cpf, String nome, String sobrenome, String telefone) {
		super(cpf, nome, sobrenome, telefone);
	}
	
	public int getcredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
