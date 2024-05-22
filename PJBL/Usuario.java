package PJBL;

public abstract class Usuario {
    private int idUsuario;
    private String nome;
    private String tipo;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    public Usuario(int idUsuario, String nome, String tipo, String cpf, String email, String senha, String telefone,
                   String endereco) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Método para formatar os dados do usuário como uma linha de texto separada por virgula
    public String toFileString() {
        return String.join(",", String.valueOf(idUsuario), nome, tipo, cpf, email, senha, telefone, endereco);
    }

    // Método para criar um usuário a partir de uma linha de texto
    //Recebe dados de um usuário delimitados por virgula
    public static Usuario fromFileString(String fileString) {
        //Separa cada parte dos dados e coloca num array
        String[] parts = fileString.split(",");
        int id = Integer.parseInt(parts[0]);
        String nome = parts[1];
        String tipo = parts[2];
        String cpf = parts[3];
        String email = parts[4];
        String senha = parts[5];
        String telefone = parts[6];
        String endereco = parts[7];
        //Retorna um objeto dependendo do tipo
        if (tipo.equals("Administrador")) {
            return new Administrador(id, nome, cpf, email, senha, telefone, endereco);
        } else if (tipo.equals("Funcionario")) {
            return new Funcionario(id, nome, cpf, email, senha, telefone, endereco);
        }
        return null;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
