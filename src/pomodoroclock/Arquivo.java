/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
