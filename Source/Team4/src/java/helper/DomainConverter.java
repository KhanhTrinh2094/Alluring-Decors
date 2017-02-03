
package helper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import admin.manager.ServiceMB;
import entities.Domains;

@FacesConverter(forClass = Domains.class)
public class DomainConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        ServiceMB controller = (ServiceMB) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "serviceMB");
        Domains brand = controller.getDomainsConverter(getKey(value));
        return brand;
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Domains) {
            Domains o = (Domains) object;
            return getStringKey(o.getDomainID());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Domains.class.getName());
        }
    }

}
