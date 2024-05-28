package PJBL;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaProduto {

    private static final String FILE_PATH = "src/PJBL/";
    private static final String FILE_NAME = FILE_PATH + "produtos.txt";

    public static List<String> carregarProdutos() throws LoginException {
        List<String> produtos = new ArrayList<>();
        File file = new File(FILE_NAME);

        // Verifica se o arquivo existe, se não, cria um arquivo vazio
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Arquivo de produtos criado com sucesso.");
                } else {
                    throw new LoginException("Erro ao criar o arquivo de produtos: motivo desconhecido.");
                }
            } catch (IOException e) {
                throw new LoginException("Erro ao criar o arquivo de produtos: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                produtos.add(linha);
            }
        } catch (IOException e) {
            throw new LoginException("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }

    public static void cadastrar(String produto) throws LoginException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.newLine();
            bw.write(produto);
        } catch (IOException e) {
            throw new LoginException("Erro ao salvar produto: " + e.getMessage());
        }
    }
}
