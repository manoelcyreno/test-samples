package testeApp.portlet;

import testeApp.constants.TesteAppPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author manoelcyreno
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=testeApp Portlet",
		"javax.portlet.name=" + TesteAppPortletKeys.TesteApp,
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TesteAppPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PrintWriter printWriter = renderResponse.getWriter();

		printWriter.print(getText("text"));
	}

	public String getText(String someText) {
		String text = someText;
		
		if (text != null && text != "") {
			text = "testeApp Portlet - Hello World! By Manoel Cyreno";
		} else {
			text = "testeApp Portlet - Error!";
		}
		return text;
	}
}