/**
 * @author amith kikkeri
 */

package actionClass;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class Client_Login_ActionTest extends StrutsTestCase {

	private Map<String, Object> session;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = new HashMap<String, Object>();
	}

	public void testLogout() throws Exception {
		session.put("user", "admin");
		session.put("user0", "user0");
		session.put("user1", "user1");
		ActionContext.getContext().setSession(session);
		ActionProxy proxy = getActionProxy("/logout");
		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals(ActionContext.getContext().getSession().size(), 0);

	}
}
