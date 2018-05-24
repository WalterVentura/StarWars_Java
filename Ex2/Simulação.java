import java.util.Random;


class Habilidade{
	
	private int danobase;
	private int dano;
	private String tipo;
	private String nome;
	
	public Habilidade(int danobase, String tipo, String nome) {
		this.danobase = danobase;
		this.tipo = tipo;
		this.nome = nome;
	}
	
	public int getDano() {
		return dano;
	}

	public void setDano(double multiplicador) {
		this.dano = (int) (danobase*multiplicador);
	}

	public int getDanobase() {
		return danobase;
	}
	public void setDanobase(int danobase) {
		this.danobase = danobase;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}


class Combatente{
	
	private String nome;
	private int vida;
	private int dominioSabre;
	private int dominioForca;
	private Habilidade[] ataques = new Habilidade[4];
	private int i = 0;

	public Combatente(String nome, int vida, int dominioSabre, int dominioForca) {
		this.nome = nome;
		this.vida = vida;                   //0 a 1000
		this.dominioSabre = dominioSabre;   //0 a 1000
		this.dominioForca = dominioForca;   //0 a 1000
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getDominioSabre() {
		return dominioSabre;
	}
	public void setDominioSabre(int dominioSabre) {
		this.dominioSabre = dominioSabre;
	}
	
	public int getDominioForca() {
		return dominioForca;
	}
	public void setDominioForca(int dominioForca) {
		this.dominioForca = dominioForca;
	}
	
	public void addHabilidade (Habilidade ataque) {
		if(i < 4) {
			this.ataques[i] = ataque;
			if(ataque.getTipo().equals("Sabre")) {
				ataque.setDano(dominioSabre/500.0);
			}
			else {
				ataque.setDano(dominioForca/500.0);
			}
			i++;
		}	
	}
	public Habilidade[] getAtaques() {
		return ataques;
	}
	
}

class MestreJedi extends Combatente{

	public MestreJedi(String nome, int vida, int dominioSabre, int dominioForca) {
		super(nome, vida, dominioSabre, dominioForca);
	}
}

class LordeSith extends Combatente{

	public LordeSith(String nome, int vida, int dominioSabre, int dominioForca) {
		super(nome, vida, dominioSabre, dominioForca);
	}
}

class Acao{
	private String acao;
	public void executarAcao(int n) {
		if(n == 0) {
			acao = "Esquiva";
		}
		else {
			acao = "Ataque";
		}
	}
	public String getAcao() {
		return acao;
	}
}

class Turno{
	
	public void executar(Combatente a, Combatente b) {
		
		Random destino = new Random(); //gerador de numeros aleatorios
		Acao a1 = new Acao();           //tipo de acao
		Acao b1 = new Acao();
		Habilidade[] ha = a.getAtaques();  //habilidades possiveis se a acao for atacar
		Habilidade[] hb = b.getAtaques();
		Habilidade Golpe_a = null;   //habilidade que será executada pelo A
		Habilidade Golpe_b = null;   
		
		a1.executarAcao(destino.nextInt(3));
		b1.executarAcao(destino.nextInt(3));
		
		if(a1.getAcao() == "Ataque") {
			Golpe_a = ha[destino.nextInt(4)];
		}
		if(b1.getAcao() == "Ataque") {
			Golpe_b = hb[destino.nextInt(4)];
		}
		
		//acoes selecionadas
		
		//Resultados dos embates:
		if(a1.getAcao() == "Esquiva" && b1.getAcao() == "Esquiva") {
			System.out.println("Ambos os combatentes se esquivam!");
		}
		else if(a1.getAcao() == "Esquiva" && b1.getAcao() == "Ataque") {
			System.out.println(b.getNome()+ " utilizou "+ Golpe_b.getNome()+ ", mas "+ a.getNome() + " se esquivou!");
		}
		else if(b1.getAcao() == "Esquiva" && a1.getAcao() == "Ataque") {
			System.out.println(a.getNome()+ " utilizou "+ Golpe_a.getNome()+ ", mas "+ b.getNome() + " se esquivou!");
		}
		else {
			if(Golpe_a.getTipo() == "forca" && Golpe_b.getTipo() == "forca") {
				a.setVida(a.getVida() - Golpe_b.getDano());
				b.setVida(b.getVida() - Golpe_a.getDano());
				System.out.println("Um embate de seus controles sob a força!");
				System.out.println(a.getNome()+ " utiliza "+ Golpe_a.getNome()+ " e causa "+ Golpe_a.getDano()+ " de dano!");
				System.out.println(b.getNome()+ " utiliza "+ Golpe_b.getNome()+ " e causa "+ Golpe_b.getDano()+ " de dano!");
			}
			else if(Golpe_a.getTipo() == "forca" && Golpe_b.getTipo() == "sabre") {
				b.setVida(b.getVida() - Golpe_a.getDano());
				System.out.println(a.getNome()+ " foi mais rápido! Utiliza "+ Golpe_a.getNome()+ " e causa "+ Golpe_a.getDano()+ " de dano!");
			}
			else if(Golpe_b.getTipo() == "forca" && Golpe_a.getTipo() == "sabre") {
				a.setVida(a.getVida() - Golpe_b.getDano());
				System.out.println(b.getNome()+ " foi mais rápido! Utiliza "+ Golpe_b.getNome()+ " e causa "+ Golpe_b.getDano()+ " de dano!");
			}
			else {
				a.setVida(a.getVida() - Golpe_b.getDano());
				b.setVida(b.getVida() - Golpe_a.getDano());
				System.out.println("Que troca de golpes!");
				System.out.println(a.getNome()+ " utiliza "+ Golpe_a.getNome()+ " e causa "+ Golpe_a.getDano()+ " de dano!");
				System.out.println(b.getNome()+ " utiliza "+ Golpe_b.getNome()+ " e causa "+ Golpe_b.getDano()+ " de dano!");
			}
		}
		
	}
}



public class Simulação {
	public static void main(String args[]) {
		
		Turno t = new Turno();
		MestreJedi Yoda = new MestreJedi("Yoda", 500, 900, 1000);
		LordeSith DarthSidious = new LordeSith("Darth Sidious", 600, 800, 950);
		Habilidade ataque1_yoda = new Habilidade(100, "sabre", "pulo com sabre giratório");
		Habilidade ataque0_yoda = new Habilidade(80, "sabre" , "uma sequência rápida");
		Habilidade ataque0_darth = new Habilidade(80, "sabre" , "uma sequência rápida");
		Habilidade ataque1_darth = new Habilidade(90, "sabre" , "um golpe forte");
		Habilidade ataque3_yoda = new Habilidade(40, "forca" , "arremessar objeto");
		Habilidade ataque3_darth = new Habilidade(40, "forca" , "arremessar objeto");
		Habilidade ataque2_yoda = new Habilidade(50, "forca" , "force push");
		Habilidade ataque2_darth = new Habilidade(60, "forca" , "raiosss");
		
		Yoda.addHabilidade(ataque0_yoda);
		Yoda.addHabilidade(ataque1_yoda);
		Yoda.addHabilidade(ataque3_yoda);
		Yoda.addHabilidade(ataque2_yoda);
		DarthSidious.addHabilidade(ataque0_darth);
		DarthSidious.addHabilidade(ataque1_darth);
		DarthSidious.addHabilidade(ataque3_darth);
		DarthSidious.addHabilidade(ataque2_darth);
		
		while(Yoda.getVida() > 0 && DarthSidious.getVida() > 0) {
			t.executar(Yoda, DarthSidious);
		}
		if(Yoda.getVida() <= 0 && DarthSidious.getVida() > 0) {
			System.out.println(DarthSidious.getNome()+ " é o vencedor!");
		}
		else if(Yoda.getVida() > 0 && DarthSidious.getVida() <= 0) {
			System.out.println(Yoda.getNome()+ " é o vencedor!");
		}
		else {
			System.out.println("Empate!");
		}
	}

}

