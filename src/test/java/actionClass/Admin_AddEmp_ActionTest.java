/**
 * @author amith kikkeri
 */
package actionClass;

import org.apache.struts2.StrutsTestCase;
import org.mockito.Mockito;

import com.opensymphony.xwork2.ActionProxy;

import daoImpl.Admin_AddEmp_DaoImpl;

public class Admin_AddEmp_ActionTest extends StrutsTestCase {

	public void testAddEmp() throws Exception {
		request.setParameter("add.bank_id", "9999");
		request.setParameter("add.branch", "My test branch");
		request.setParameter("add.role_name", "Manager");
		request.setParameter("add.firstName", "FN");
		request.setParameter("add.middleName", "Middle Nm");
		request.setParameter("add.lastName", "LN");
		request.setParameter("add.gender", "M");
		request.setParameter("add.dob", "05/15/2018");
		request.setParameter("add.landLine", "88888888");
		request.setParameter("add.mobile", "9999999999");
		request.setParameter("add.email", "mindtree@mindtree.com");
		request.setParameter("add.address", "hudson st");
		request.setParameter("add.city", "jersey city");
		request.setParameter("add.state", "NJ");

		ActionProxy proxy = getActionProxy("/addEmp");
		Admin_AddEmp_Action empAction = (Admin_AddEmp_Action) proxy.getAction();
		Admin_AddEmp_DaoImpl mockDAO = Mockito.mock(Admin_AddEmp_DaoImpl.class);
		Mockito.when(mockDAO.addEmp(empAction.getAdd())).thenReturn(empAction.getAdd());
		empAction.setXyz(mockDAO);
		String res = proxy.execute();
		assertEquals("Message", "success",res);
	}
}
