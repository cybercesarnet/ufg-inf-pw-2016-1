package servletjsp;

public class ImcModel {

public static int CalculoImc(int peso, int altura){

int imc;
imc=(peso)/(altura*altura);
return imc;

}
}