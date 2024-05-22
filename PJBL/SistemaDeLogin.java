package PJBL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeLogin {

    //Atributo com o nome do arquivo
    private static final String FILE_PATH = "src/PJBL/";
    private static final String FILE_NAME = FILE_PATH + "usuarios.txt";

    // Carregar usuários do arquivo
    public static List<Usuario> carregarUsuarios() throws LoginException{
        List<Usuario> usuarios = new ArrayList<>();
        File file = new File(FILE_NAME);
        // Verifica se o arquivo existe, se não, cria um arquivo vazio
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new LoginException("Erro ao criar o arquivo de usuários: " + e.getMessage());
            }
        }
        //Abre o arquivo e le linha por linha
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            //Armazena o conteúdo de cada linha
            //Para quando não houver mais linhas
            String linha;
            while ((linha = br.readLine()) != null) {
                //Converte a String lida em um Usuario
                Usuario usuario = Usuario.fromFileString(linha);
                if (usuario != null) {
                    //Se usuario for valido, adiciona na lista
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            throw new LoginException("Erro ao carregar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // Salvar usuário no arquivo
    public static void salvarUsuario(Usuario usuario) throws LoginException{
        //Abre o arquivo em modo de adição e inicia a escrita
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            //Transforma o objeto Usuario em uma string
            bw.write(usuario.toFileString());
            //Adiciona mais uma linha no arquivo
            bw.newLine();
        } catch (IOException e) {
            throw new LoginException("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    // Autenticar usuário
    public static Usuario autenticar(String email, String senha, List<Usuario> usuarios) {
        //Intera por cada usuario
        for (Usuario usuario : usuarios) {
            //Se o dados baterem, ele autentica
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
