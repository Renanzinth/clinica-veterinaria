package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Tipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_TIPO")
	@SequenceGenerator(name="ID_TIPO", sequenceName="SEQ_ID_TIPO", initialValue=1 ,allocationSize=1)
	private Integer codigo;
	
	@Column(unique=true)
	private String nome;
	
	@OneToMany(mappedBy="tipo")
	private List<Animal> animais;
	
	public Tipo() {
		super();
	}
	
	public Tipo(String nome) {
		this.nome = nome;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
