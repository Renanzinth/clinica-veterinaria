package listener;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import controle.bean.LoginMB;

public class LoginCheckPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		// recuperar o usuário autenticado
		FacesContext contexto = FacesContext.getCurrentInstance();
		ELContext elContexto = contexto.getELContext();
		Application app = contexto.getApplication();
		ELResolver elResolver = app.getELResolver();

		// recuperar a instância do Managed Bean
		Object obj = elResolver.getValue(elContexto, null, "loginMB");
		// faz type cast para a classe
		LoginMB loginMB = (LoginMB) obj;

		boolean usuarioAutenticado = false;
		boolean estaNaPaginaDeLogin = contexto.getViewRoot().getViewId().lastIndexOf("login") > -1 ? true : false;

		if (loginMB != null && loginMB.getUsuario() != null) {
			// verifica se o usuário existe
			if (!"".equals(loginMB.getUsuario())) {
				usuarioAutenticado = true;
			}
		}

		// se não estiver autenticado
		if (!usuarioAutenticado && !estaNaPaginaDeLogin) {
			String mensagem = contexto.getApplication().evaluateExpressionGet(contexto, "#{msgs.msgExpirado}",
					String.class);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
			contexto.addMessage(null, msg);

			NavigationHandler handler = app.getNavigationHandler();
			handler.handleNavigation(contexto, null, "login.jsf");
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
