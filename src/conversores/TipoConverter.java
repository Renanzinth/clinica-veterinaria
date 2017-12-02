package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.TipoDAO;
import modelo.dominio.Tipo;

@FacesConverter(value="tipo-converter", forClass=Tipo.class)
public class TipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		Tipo tipo = null;
		Integer codigo;
		
		try {
			codigo = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		TipoDAO dao = new TipoDAO();
		if (codigo != null)
			tipo = dao.lerPorId(codigo);
		
		return tipo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (value instanceof Tipo) {
			Tipo tipo = (Tipo) value;
			return tipo.getCodigo().toString();
		}
		
		return null;
	}

}
