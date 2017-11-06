package br.com.uniftec.trabalhofinal.repositorio;

import java.util.Random;

import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 06/11/2017.
 */

public class ProdutoFactory {

    private static String[] titulos = {"Fone de Ouvido", "Memória RAM", "Processador", "Mouse", "Teclado", "Monitor"};
    private static Double[] precos = {14.50, 200.45, 75.90, 25.00, 69.99, 1589.99, 700.00};
    private static String[] descricoes = {"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n " +
            "Etiam eget ligula eu lectus lobortis condimentum.\n Aliquam nonummy auctor massa.\"",
            "\"Quis custodiet ipsos custodes?\""};

    public static Produto makeProduct() {
        return new Produto(titulos[getRandomValue(0, 5)],
                precos[getRandomValue(0, 5)],
                descricoes[getRandomValue(0, 2)]);

    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }


}
