package pomodoroclock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Classe para criar um arquivo que salva as definicições do usuário.
 *
 * @author Allan
 */
public class Arquivo {

    OutputStream os = null;
    OutputStreamWriter osw = null;
    BufferedWriter bw = null;
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;

    /**
     * Uma função que recebe os tempos editados para salvá-los no arquivo.
     *
     * Ela salva cada um deles em linhas separadas, com um total de 3 linhas que
     * podem também ser editadas no Arquivo.
     *
     * @param temposEditados Recebe os tempos editados em outras classes.
     */
    public void SalvaTemposEditados(ArrayList<String> temposEditados) {
        try {
            os = new FileOutputStream("Arquivo.txt", false);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            for (int i = 0; i < temposEditados.size(); i++) {
                bw.write(temposEditados.get(i) + "\n");
            }
        } catch (Exception e) {
            System.out.println("Erro na entrada: " + e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * A função que recupera os tempos editados do Arquivo.txt.
     *
     * Caso ela não encontre nenhum tempo cria um Arquivo com os tempos padrão
     * que são 25, 5 e 30 minutos.
     *
     * @return Retorna um ArrayList de Strings com os tempos de Trabalho,
     * Descanso e Descanso Longo.
     *
     */
    public ArrayList<String> pegaTemposEditados() {
        ArrayList<String> temposEditados = new ArrayList();
        try {
            is = new FileInputStream("Arquivo.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String lerLinha = null;
            lerLinha = br.readLine();
            while (lerLinha != null) {
                temposEditados.add(lerLinha);
                lerLinha = br.readLine();
            }
        } catch (IOException e) {
            try {
                os = new FileOutputStream("Arquivo.txt", false);
                osw = new OutputStreamWriter(os);
                bw = new BufferedWriter(osw);
                bw.write("25\n");
                bw.write("5\n");
                bw.write("30\n");
            } catch (Exception f) {
                System.out.println("Erro na entrada: " + e);
            } finally {
                try {
                    bw.close();
                } catch (Exception f) {
                    System.out.println(e);
                }
            }
            System.out.println(e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return temposEditados;
    }
}
