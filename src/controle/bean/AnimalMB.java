package controle.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import modelo.dao.AnimalDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.TipoDAO;
import modelo.dominio.Animal;
import modelo.dominio.Cliente;
import modelo.dominio.Tipo;

@ManagedBean(name = "animalMB")
@RequestScoped
public class AnimalMB {

	// campo para o formulário de pesquisa
	private String filtroNomeAnimal;
	private Tipo filtroTipo;
	
	private Animal animal = new Animal();

	private AnimalDAO dao = new AnimalDAO();
	
	private List<Animal> animais = null;

	private List<Cliente> clientes = null;

	private List<Tipo> tipos = null;

	public String getFiltroNomeAnimal() {
		return filtroNomeAnimal;
	}

	public void setFiltroNomeAnimal(String filtroNomeAnimal) {
		this.filtroNomeAnimal = filtroNomeAnimal;
	}

	public Tipo getFiltroTipo() {
		return filtroTipo;
	}

	public void setFiltroTipo(Tipo filtroTipo) {
		this.filtroTipo = filtroTipo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public List<Animal> getAnimais() {
		
		if (this.animais == null) {
			this.animais = new AnimalDAO().lerTodos();
		}
		
		return animais;
	}

	public List<Cliente> getClientes() {

		if (this.clientes == null)
			this.clientes = new ClienteDAO().lerTodos();

		return clientes;
	}

	public List<Tipo> getTipos() {

		if (this.tipos == null)
			this.tipos = new TipoDAO().lerTodos();

		return tipos;
	}

	public String acaoListar() {
		return "animalListar.jsf?faces-redirect=true";
	}

	public String acaoAbrirInclusao() {

		this.animal = new Animal();

		return "animalEditar.jsf";
	}
	
	public String acaoAbrirAlteracao(Integer id) {
		
		this.animal = this.dao.lerPorId(id);
		
		return "animalEditar.jsf";
	}
	
	public String acaoExcluir(Integer id) {
		
		this.animal = this.dao.lerPorId(id);
		
		this.dao.excluir(this.animal);
		
		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.animal);

		FacesContext contexto = FacesContext.getCurrentInstance();

		String mensagem = contexto.getApplication().evaluateExpressionGet(contexto,
				"#{msgs.msgConfirmacao}", String.class);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		contexto.addMessage(null, msg);

		return acaoListar();
	}
	
	public String acaoPesquisar() {

		// carrega a lista de animais filtrando do parâmetro
		this.animais = this.dao.filtrarAnimais(filtroNomeAnimal, filtroTipo);

		return "animalListar.jsf";
	}

}