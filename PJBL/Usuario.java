package PJBL;

import java.util.List;
import java.util.Scanner;

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


    public void criarNovoProduto(Scanner scanner, List<Veiculo> carro, List<Aviao> aviao, List<Embarcacao> embarcacao) {
        System.out.println("Escolha o produto:");
        System.out.println("1-> Carro");
        System.out.println("2-> Avião");
        System.out.println("3-> Embarcação");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero == 1) {
            int codVeiculo = carro.size() + 1;
            System.out.print("O id do carro é " + codVeiculo);
            System.out.println("--Carro--");
            System.out.print("Digite o tipo da carroceria: ");
            String carroceria = scanner.nextLine();
            System.out.print("Digite o número de assentos: ");
            int numAssentos = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o número de portas: ");
            int portas = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a capacidade do porta-malas: ");
            int capacidadePortaMalas = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o tipo do motor: ");
            String tipoMotor = scanner.nextLine();
            System.out.print("Digite a potência do motor: ");
            int potenciaMotor = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o tipo do combustível: ");
            String tipoCombustivel = scanner.nextLine();
            System.out.print("Digite o tipo do câmbio: ");
            String tipoCambio = scanner.nextLine();
            System.out.print("Digite o tipo do veículo: ");
            String tipoVeiculo = scanner.nextLine();
            System.out.print("Digite a marca do Veículo: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o modelo Veículo: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite o ano do Veículo: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a quilometragem do Veículo: ");
            int quilometragem = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a cor do Veículo: ");
            String cor = scanner.nextLine();
            System.out.print("Digite a capacidade de passageiros do Veículo: ");
            int capacidadeDePassageiro = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o preço do Veículo: ");
            float preco = Float.parseFloat(scanner.nextLine());
            System.out.print("Digite a quantidade desse Veículo: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o número de rodas do Veículo: ");
            int numRodas = Integer.parseInt(scanner.nextLine());

            Veiculo veiculo = new Carro(codVeiculo, tipoVeiculo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro,
                    preco, quantidade, numRodas, carroceria, numAssentos, portas, capacidadePortaMalas, tipoMotor, potenciaMotor, tipoCombustivel, tipoCambio);
            carro.add(veiculo);


        } else if (numero == 2) {
            System.out.println("--Avião--");

        } else if (numero == 3) {
            System.out.println("--Embarcação--");

        }
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
