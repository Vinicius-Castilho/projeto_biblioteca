package entity;

public class USUARIO_ATV {

    private static String cpf;
    private static String nome;
    private static String sobrenome;
    private static int idade;
    private static String email;
    private static int ano;

    
     public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        USUARIO_ATV.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        USUARIO_ATV.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        USUARIO_ATV.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        USUARIO_ATV.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        USUARIO_ATV.email = email;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        USUARIO_ATV.ano = ano;
    }

    public String getEditora() {
        return null;
    }

}
