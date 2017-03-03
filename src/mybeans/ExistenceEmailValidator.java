package mybeans;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.TrackingProject.Metier.UserImpl;

@FacesValidator("existenceEmailValidator")
public class ExistenceEmailValidator implements Validator {
	private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée";

	@EJB
	private UserImpl      utilisateurDao;

	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
		String email = (String) value;
			if ( utilisateurDao.getUserByEmail( email ) != null ) {
		        FacesMessage message = new FacesMessage( "erreur message non ajouter !" );
		        FacesContext.getCurrentInstance().addMessage( "error", message );
				throw new ValidatorException(new FacesMessage( FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE_DEJA, null ) );
			}
	}


}