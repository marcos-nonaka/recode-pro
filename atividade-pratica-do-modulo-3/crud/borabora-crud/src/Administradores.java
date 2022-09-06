
public class Administradores {
	
	private int id_admin;
	private int id_permissao;
	private String nome;
	private String email;
	private String senha;
	
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public int getId_permissao() {
		return id_permissao;
	}
	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
