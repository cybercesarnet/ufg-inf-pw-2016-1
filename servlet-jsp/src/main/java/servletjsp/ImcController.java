package servletjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imc")
public class ImcController extends HttpServlet {
	private String valor(
			HttpServletRequest req,
			String param,
			String padrao) {

		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	private int toInt(
			HttpServletRequest req,
			String param,
			String padrao) {

		return Integer.parseInt(valor(req, param, padrao));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int peso = toInt(req, "peso", "0");
		//String imc = valor(req, "imc", "");
		int altura = toInt(req, "altura", "0");

		int resultadoCalculo = ImcModel.CalculoImc(peso, altura);
		
		//Passando parâmetro para o JSP.
		req.setAttribute(
				"imc",
				resultadoCalculo);

		req.getRequestDispatcher("ImcView.jsp").forward(req, resp);
	}
}
