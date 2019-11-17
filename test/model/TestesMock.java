package model;


import controller.CadastroLojaController;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.*;





public class TestesMock extends TestCase {
  
    public void TesteCadastroLoja() throws SQLException, ClassNotFoundException, ServletException {
       
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);

        expect(requestMock.getParameter("operacao")).andReturn("Incluir");
        expect(requestMock.getParameter("txtNomeLoja")).andReturn("NyahFood");
        expect(requestMock.getParameter("txtNomeGerenteLoja")).andReturn("David Rodrigues");
        expect(requestMock.getParameter("txtEmailLoja")).andReturn("nyah@gmail.com");
        expect(requestMock.getParameter("txtSenhaLoja")).andReturn("123123123");
        expect(requestMock.getParameter("txtTelefoneLoja")).andReturn("3291434352");
        expect(requestMock.getParameter("txtCnpjLoja")).andReturn("12312312111111");
        expect(requestMock.getParameter("txtDescricaoLoja")).andReturn("asdasdasdsad");
        expect(requestMock.getParameter("optTipoCozinha")).andReturn("4");
        expect(requestMock.getParameter("model.TipoCozinha")).andReturn("Americana");
        expect(requestMock.getParameter("txtCepLoja")).andReturn("37440000");
        expect(requestMock.getParameter("txtLogradouroLoja")).andReturn("Rua Santa Catarina");
        expect(requestMock.getParameter("txtBairroLoja")).andReturn("Leopoldina");
        expect(requestMock.getParameter("txtNumeroLoja")).andReturn("74");
        expect(requestMock.getParameter("txtComplementoLoja")).andReturn("casa 30");
        expect(requestMock.getParameter("txtCidadeLoja")).andReturn("Juiz de fora");
        expect(requestMock.getParameter("txtEstadoLoja")).andReturn("MG");
        replay(requestMock);

        HttpServletResponse responseMock = createMock(HttpServletResponse.class);
        CadastroLojaController cadastroLojaWeb = new CadastroLojaController();
        assertFalse(cadastroLojaWeb.confirmarOperacao(requestMock,responseMock));
    }
    
    

  
}