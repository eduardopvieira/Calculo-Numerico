import java.lang.Math;

public class PontoFixo {
	//Precisa de um valor inicial e de um intervalo
	private static Double x = 0.0;
	private static Double a = -1.2;
	private static Double b = 1.0;
	private static boolean parada = false;
	private static boolean fugiu = false;
	
	public static void main(String []args) {
		//precisão
		final Double e = 0.001;
		
		Double orientacao = f(a) * f(b);
		
		if(orientacao < 0) {
			analise(e);
		} else {
			if(orientacao > 0) {
				System.out.println("Por favor melhore o intervalo");
			} else {
				if(f(a) == 0) {
					x = a;
				} else {
					x = b;
				}
				System.out.println("Uma das extremidades do intervalo é um zero da função");
			}
		}
		
		if (parada && !fugiu) {
			System.out.println("Uma aproximação para a raiz foi encontrada: " + x);
		}
		else {
			System.out.println("Não foi encontrada uma aproximação para a raiz dessa função no intervalo provido");
			System.out.println("Você pode tentar mudar a g(x) também, existem muitas possibilidades");
		}
	}
	
	public static void analise(Double e) {
		Double x0 = 0.0;
		int i = 0;
		
		System.out.println("x0 = " + x + "\n");
		
		if (Math.abs(f(x)) < e) {
			parada = true;
			
		} else {
			while (!parada && !fugiu) {
				i++;
				
				x0 = x;
				x = g(x);
				
				System.out.println("valor atual: " + x);
				System.out.println("iteração: " + i + "\n");
				
				checagem(e, x0);
			}
		}
	}
	
	public static void checagem(Double e, Double x0) {
			if (Math.abs(f(x)) < e || Math.abs(x - x0) < e) {
				parada = true;
			} else {
				parada = false;
			}
			
			if (x > b || x < a) {
				System.out.println("O programa tentou convergir para um x que não está no intervalo, cheque sua g(x)ou melhore seu intervalo");
				fugiu = true;
			} else {
				fugiu = false;
			}
	}
	
	public static Double f(Double x) {
		//TODO Insira sua função principal
		Double resp = (x*x*x) + 12*(x*x) - 9;
		return resp;
	}
	
	public static Double g(Double x) {
		//TODO Insira uma função tal que quando f(x) = 0 => g(x) = x
		Double resp = Math.sqrt((-(x*x*x)+9)/12);//Math.cbrt(-12*(x*x) + 9);
		return resp;
	}
}