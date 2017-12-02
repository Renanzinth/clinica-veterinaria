package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_ANIMAL")
	@SequenceGenerator(name="ID_ANIMAL", sequenceName="SEQ_ID_ANIMAL", initialValue=1 ,allocationSize=1)
	private Integer id;
	
	@Column(length=25, nullable=false)
	private String nome;
	
	private Integer idade;
	
	@Column(nullable=false, length=1)
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=true)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="tipo", nullable=false)
	private Tipo tipo;
	
	public Animal() {
		super();
	}
	
	public Animal(String nome, Integer idade, String sexo, Tipo tipo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getIdStr() {
		if (this.id == null)
			return "";
		
		return id.toString();
	}

	public String getNome() {
		return nome;
	}
	
	public String getNomeStr() {
		if (this.nome == null)
			return "";
		
		return nome.toString();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}
	
	/*public String getIdadeStr() {
		if (this.idade == null)
			return "Não informado";
		
		return idade.toString();
	}*/

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		if (this.sexo == null)
			return "";
		
		return sexo.toString();
	}
	
	public String getSexoStr() {
		if (this.sexo == null)
			return "";
		
		return sexo.toString();
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
