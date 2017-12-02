package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;

@FacesConverter(value="cliente-converter", forClass=Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		Cliente cliente = null;
		
		
		ClienteDAO dao = new ClienteDAO();
		
			cliente = dao.lerPorId(value);
		
		return cliente;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		if (value instanceof Cliente) {
			Cliente pessoa = (Cliente) value;
			return pessoa.getCpf().toString();
		}
		
		return null;
	}

}
