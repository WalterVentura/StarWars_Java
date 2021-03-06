﻿package Ex1_Universo;

class Data{
	private int ano;
	private String yavin; //para aceitar ABY ou DBY
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getYavin() {
		return yavin;
	}
	public void setYavin(String yavin) {
		this.yavin = yavin;
	}
	
}
class Planeta {
	private String nome;
	private String cor;
	private int diametro;
	private String sistema; //nome do sistema planet�rio onde se encontra o planeta

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
}

class Governo{
	private Data início;
	private Data fim;
	private String capital; //planeta central do governo
	private String nome;
	private String tipo; //republica, imp�rio, etc.
	
	public Data getInício() {
		return início;
	}
	public void setInício(Data início) {
		this.início = início;
	}
	
	public Data getFim() {
		return fim;
	}
	public void setFim(Data fim) {
		this.fim = fim;
	}
	
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

class Ser{
	private String nome;
	private String sexo; //macho, f�mea, indeterminado, ambos...
	private String especie;
	private Data dataDeNascenca;
	private Planeta planetaNatal;
	private int concentracaoMidi_chlorians;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public Data getDataDeNascenca() {
		return dataDeNascenca;
	}
	public void setDataDeNascenca(Data dataDeNascenca) {
		this.dataDeNascenca = dataDeNascenca;
	}
	
	public Planeta getPlanetaNatal() {
		return planetaNatal;
	}
	public void setPlanetaNatal(Planeta planetaNatal) {
		this.planetaNatal = planetaNatal;
	}
	
	public int getConcentracaoMidi_chlorians() {
		return concentracaoMidi_chlorians;
	}
	public void setConcentracaoMidi_chlorians(int concentracaoMidi_chlorians) {
		this.concentracaoMidi_chlorians = concentracaoMidi_chlorians;
	}
	
}

class Academia{
	private String nome;
	private String vertente; //jedi ou sith
	private String nomeOrganizacao; //nome da organiza��o que administra a academia
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getVertente() {
		return vertente;
	}
	public void setVertente(String vertente) {
		this.vertente = vertente;
	}
	
	public String getNomeOrganizacao() {
		return nomeOrganizacao;
	}
	public void setNomeOrganizacao(String nomeOrganizacao) {
		this.nomeOrganizacao = nomeOrganizacao;
	}
}

class Clã{
	private String nome;
	private Data dataDeFundacao;
	private Ser fundador;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Data getDataDeFundacao() {
		return dataDeFundacao;
	}
	public void setDataDeFundacao(Data dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}
	
	public Ser getFundador() {
		return fundador;
	}
	public void setFundador(Ser fundador) {
		this.fundador = fundador;
	}

}

class Youngling extends Ser{
	private Data dataDeIngresso;
	private Clã clã;

	public Data getDataDeIngresso() {
		return dataDeIngresso;
	}
	public void setDataDeIngresso(Data dataDeIngresso) {
		this.dataDeIngresso = dataDeIngresso;
	}

	public String getClã() {
		return clã;
	}
	public void setClã(Clã clã) {
		this.clã = clã;
	}

}

class Padawan extends Ser{
	private Data dataDePromocão;
	private Ser mestre;

	public Data getDataDePromocão() {
		return dataDePromocão;
	}
	public void setDataDePromocão(Data dataDePromocão) {
		this.dataDePromocão = dataDePromocão;
	}

	public String getMestre() {
		return mestre;
	}
	public void setMestre(Ser mestre) {
		this.mestre = mestre;
	}

}

class CavaleiroJedi extends Ser{
	private Data dataDePromocão;

	public Data getDataDePromocão() {
		return dataDePromocão;
	}
	public void setDataDePromocão(Data dataDePromocão) {
		this.dataDePromocão = dataDePromocão;
	}
}

class MestreJedi extends Ser{
	private boolean imortal;
	private int campoDeVidencia;

	public boolean getImortal() {
		return imortal;
	}
	public void setImortal(boolean imortal) {
		this.imortal = imortal;
	}

	public int getcampoDeVidencia() {
		return campoDeVidencia;
	}
	public void setcampoDeVidencia(int campoDeVidencia) {
		this.campoDeVidencia = campoDeVidencia;
	}
}

class Sith extends Ser
{
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

class AprendizSith extends Sith{
	private Data dataDeIngresso;
	private Ser mestre;

	public Data getDataDeIngresso() {
		return dataDeIngresso;
	}
	public void setDataDeIngresso(Data dataDeIngresso) {
		this.dataDeIngresso = dataDeIngresso;
	}

	public String getMestre() {
		return mestre;
	}
	public void setMestre(Ser mestre) {
		this.mestre = mestre;
	}
}

class LordeSith extends Sith{
	private int campoDeVidencia;

	public int getcampoDeVidencia() {
		return campoDeVidencia;
	}
	public void setcampoDeVidencia(int campoDeVidencia) {
		this.campoDeVidencia = campoDeVidencia;
	}
}