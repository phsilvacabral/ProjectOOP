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

    // Método para formatar os dados do usuário como uma linha de texto separada por virgula
    public String toFileString() {
        return String.join(",", String.valueOf(idUsuario), nome, tipo, cpf, email, senha, telefone,
                endereco);
    }

    // Método para criar um usuário a partir de uma linha de texto
    //Recebe dados de um usuário delimitados por virgula
    public static Usuario fromFileString(String fileString) throws LoginException {
        // Verifica se a string de entrada é nula ou vazia
        if (fileString == null || fileString.isEmpty()) {
            throw new LoginException("A string de entrada está nula ou vazia.");
        }
        // Separa cada parte dos dados e coloca num array
        String[] parts = fileString.split(",");
        // Verifica se todas as partes necessárias estão presentes
        if (parts.length != 8) {
            throw new LoginException("A string de entrada não contém todas as partes necessárias.");
        }
        try {
            int id = Integer.parseInt(parts[0]);
            String nome = parts[1].trim();
            String tipo = parts[2].trim();
            String cpf = parts[3].trim();
            String email = parts[4].trim();
            String senha = parts[5].trim();
            String telefone = parts[6].trim();
            String endereco = parts[7].trim();
            // Verifica se todos os campos obrigatórios estão presentes e não vazios
            if (nome.isEmpty() || tipo.isEmpty() || cpf.isEmpty() || email.isEmpty() ||
                    senha.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
                throw new LoginException("Um ou mais campos obrigatórios estão vazios.");
            }
            // Retorna um objeto dependendo do tipo
            if (tipo.equals("Administrador")) {
                return new Administrador(id, nome, cpf, email, senha, telefone, endereco);
            } else if (tipo.equals("Funcionario")) {
                return new Funcionario(id, nome, cpf, email, senha, telefone, endereco);
            } else {
                throw new LoginException("Tipo de usuário inválido.");
            }
        } catch (NumberFormatException e) {
            // Se a conversão do id falhar, lança LoginException
            throw new LoginException("Falha na conversão do ID: " + e.getMessage());
        } catch (Exception e) {
            // Captura qualquer outra exceção que possa ocorrer e lança LoginException
            throw new LoginException("Erro desconhecido: " + e.getMessage());
        }
    }

    public void criarNovoProduto(Scanner scanner, List<Veiculo> carro, List<Veiculo> aviao, List<Veiculo> embarcacao) {
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

            Veiculo veiculo = new Carro(codVeiculo, tipoVeiculo, marca, modelo, ano, quilometragem, cor,
                    capacidadeDePassageiro, preco, quantidade, numRodas, carroceria, numAssentos, portas,
                    capacidadePortaMalas, tipoMotor, potenciaMotor, tipoCombustivel, tipoCambio);
            carro.add(veiculo);

        } else if (numero == 2) {
            int codVeiculo = aviao.size() + 1;
            System.out.print("O id do avião é " + codVeiculo);
            System.out.println("--Avião--");
            System.out.print("Digite o tipo da aeronave: ");
            String tipo = scanner.nextLine();
            System.out.print("Digite a marca da aeronave: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o modelo da aeronave: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite o ano de fabricação da aeronave: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a quilometragem da aeronave: ");
            int quilometragem = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a cor da aeronave: ");
            String cor = scanner.nextLine();
            System.out.print("Digite a capacidade de passageiros da aeronave: ");
            int capacidadeDePassageiro = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o preço da aeronave: ");
            double preco = Float.parseFloat(scanner.nextLine());
            System.out.print("Digite o preço da aeronave: ");
            float precoAero = Float.parseFloat(scanner.nextLine());
            System.out.print("Digite a quantidade de aeronaves: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o tipo de propulsão da aeronave: ");
            String tipoPropulsao = scanner.nextLine();
            System.out.print("Digite a quantidade de motores da aeronaves: ");
            int numeroDeMotore = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o tipo da aeronave: ");
            String tipoDeAviao = scanner.nextLine();
            System.out.print("Digite o alcance de voo da aeronaves: ");
            double alcanceDeVoo = Integer.parseInt(scanner.nextLine());

            Veiculo veiculo = new Aviao(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor,
                    capacidadeDePassageiro, preco, quantidade, tipoPropulsao, numeroDeMotore, tipoDeAviao, alcanceDeVoo);

            aviao.add(veiculo);

        } else if (numero == 3) {
            int codVeiculo = embarcacao.size() + 1;
            System.out.print("O id da embarcação é " + codVeiculo);
            System.out.println("--Embarcação--");
            System.out.print("Digite o tipo da embarcação: ");
            String tipo = scanner.nextLine();
            System.out.print("Digite a marca da embarcação: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o modelo da embarcação: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite o ano da embarcação: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a quilometragem da embarcação: ");
            int quilometragem = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a cor da embarcação: ");
            String cor = scanner.nextLine();
            System.out.print("Digite a capacidade de passageiros da embarcação: ");
            int capacidadeDePassageiro = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o preço da embarcação: ");
            double preco = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a quantidade de embarcações: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o tipo de propulsão da embarcação: ");
            String tipoProplsao = scanner.nextLine();
            System.out.print("Digite o alcance de navegação da embarcação: ");
            double alcanceNavegacao = Integer.parseInt(scanner.nextLine());

            Veiculo veiculo = new Embarcacao(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro, preco, quantidade,
                    tipoProplsao, alcanceNavegacao);

            embarcacao.add(veiculo);
        }
    }

    public class VerificacaoEmbarcacao {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Verificação do tipo da embarcação
            String tipo;
            do {
                System.out.print("Digite o tipo da embarcação: ");
                tipo = scanner.nextLine().trim();
            } while (tipo.isEmpty());

            // Verificação da marca da embarcação
            String marca;
            do {
                System.out.print("Digite a marca da embarcação: ");
                marca = scanner.nextLine().trim();
            } while (marca.isEmpty());

            // Verificação do modelo da embarcação
            String modelo;
            do {
                System.out.print("Digite o modelo da embarcação: ");
                modelo = scanner.nextLine().trim();
            } while (modelo.isEmpty());

            // Verificação do ano da embarcação
            int ano;
            do {
                System.out.print("Digite o ano da embarcação: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Ano inválido. Digite apenas números positivos: ");
                    scanner.next();
                }
                ano = scanner.nextInt();
            } while (ano <= 0);

            // Verificação da quilometragem da embarcação
            int quilometragem;
            do {
                System.out.print("Digite a quilometragem da embarcação: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Quilometragem inválida. Digite apenas números positivos: ");
                    scanner.next();
                }
                quilometragem = scanner.nextInt();
            } while (quilometragem <= 0);

            scanner.nextLine(); // Limpar o buffer do scanner

            // Verificação da cor da embarcação
            String cor;
            do {
                System.out.print("Digite a cor da embarcação: ");
                cor = scanner.nextLine().trim();
            } while (cor.isEmpty() || cor.matches(".*\\d+.*"));

            // Verificação da capacidade de passageiros da embarcação
            int capacidadeDePassageiro;
            do {
                System.out.print("Digite a capacidade de passageiros da embarcação: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Capacidade inválida. Digite apenas números positivos: ");
                    scanner.next();
                }
                capacidadeDePassageiro = scanner.nextInt();
            } while (capacidadeDePassageiro <= 0);

            // Verificação do preço da embarcação
            double preco;
            do {
                System.out.print("Digite o preço da embarcação: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Preço inválido. Digite apenas números positivos: ");
                    scanner.next();
                }
                preco = scanner.nextDouble();
            } while (preco <= 0);

            // Verificação da quantidade de embarcações
            int quantidade;
            do {
                System.out.print("Digite a quantidade de embarcações: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Quantidade inválida. Digite apenas números positivos: ");
                    scanner.next();
                }
                quantidade = scanner.nextInt();
            } while (quantidade <= 0);

            scanner.nextLine(); // Limpar o buffer do scanner

            // Verificação do tipo de propulsão da embarcação
            String tipoPropulsao;
            do {
                System.out.print("Digite o tipo de propulsão da embarcação: ");
                tipoPropulsao = scanner.nextLine().trim();
            } while (tipoPropulsao.isEmpty() || tipoPropulsao.matches(".*\\d+.*"));

            // Verificação do alcance de navegação da embarcação
            double alcanceNavegacao;
            do {
                System.out.print("Digite o alcance de navegação da embarcação: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Alcance inválido. Digite apenas números positivos: ");
                    scanner.next();
                }
                alcanceNavegacao = scanner.nextDouble();
            } while (alcanceNavegacao <= 0);

            // Agora você pode utilizar os dados verificados como desejar
        }
    }


    @Override
    public String toString() {
        return "ID: " + idUsuario + ", Nome: " + nome + ", Tipo: " + tipo + ", CPF: " + cpf + ", Email: " + email +
                ", Telefone: " + telefone + ", Endereço: " + endereco;
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
