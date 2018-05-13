package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controlador.InnerHTML;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession objsession = request.getSession();
    String type = (String)objsession.getAttribute("alert");
    InnerHTML cp = new InnerHTML();
    if(type == null){
        type = "";
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>OSPStudio</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.13/css/all.css\" integrity=\"sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"icon\" href=\"https://use.fontawesome.com/releases/v5.0.13/svgs/brands/osi.svg\" type=\"image/x-icon\"/>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"text-center\">\n");
      out.write("        <br><br><br><br>\n");
      out.write("        <h1 class=\"display-4 font-italic\">Open Source Programming Studio</h1><br><br>\n");
      out.write("        <div>\n");
      out.write("            ");
      out.print( cp.alert(type) );
      out.write("\n");
      out.write("            ");
 objsession.setAttribute("alert", ""); 
      out.write("\n");
      out.write("        </div><br><br><br>\n");
      out.write("        <form class=\"form-signin\" action=\"InicioSesion\" method=\"POST\">\n");
      out.write("            <label for=\"user\" class=\"sr-only\">Nombre</label>\n");
      out.write("            <input id=\"user\" class=\"form-label-group\" placeholder=\"admin\" type=\"text\" name=\"userName\" required><br>\n");
      out.write("            <label for=\"passw\" class=\"sr-only\">Contraseña</label>\n");
      out.write("            <input id=\"passw\" class=\"form-label-group\" placeholder=\"1234\" type=\"password\" name=\"userPassword\" required><br><br><br>\n");
      out.write("            <div class=\"boton\">\n");
      out.write("                <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Iniciar Sesión</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"checkbox mb-3\"><br>\n");
      out.write("        <label>\n");
      out.write("            <input type=\"checkbox\" value=\"remember-me\" checked=\"checked\"> Recuérdame.\n");
      out.write("        </label>\n");
      out.write("      </div>\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <div>¿Nó tienes cuenta aún?<a href=\"RegistroUsuario.jsp\">Registrate aquí</a></div>\n");
      out.write("        <div ><p class=\"mt-5 mb-3 text-muted\">Alejandro Caralt Caralt © 2018-2019</p></div>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        window.setTimeout(function () {\n");
      out.write("            $(\".alert\").fadeTo(500,0).slideUp(500, function () {\n");
      out.write("                $(this).remove();\n");
      out.write("            });\n");
      out.write("        }, 4000);\n");
      out.write("    </script>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
