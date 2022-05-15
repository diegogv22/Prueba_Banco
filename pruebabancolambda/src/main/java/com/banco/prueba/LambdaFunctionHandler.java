package com.banco.prueba;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<int[], String> {

    @Override
    public String handleRequest(int[] prueba, Context context) {
    	
        String[] prueba2 = new String[9];
        int cont = 0;
        int cont2 = 0;
        int aux = 0;
        int aux2 = 1;
        int cont3 = 1;
        int vali = 0;
        int vali2 = 0;
        int x = 0;
        String valiStr = "";

        A:
        for (x = 0; x <= prueba.length; x++) {

            B:
            for (int i = 0; i <= prueba.length; i++) {
                while (i <= prueba.length - 1) {
                    if (aux == 0 && aux2 != 0) {
                        aux = prueba[x];
                        cont = prueba[x];
                        continue B;
                    } else if (cont == (aux + prueba[i])) {
                        continue B;
                    } else {
                        if (prueba[i] < cont) {
                            cont2 = cont2 + 1;
                            valiStr = pruebaDos(cont, i, prueba, cont2, cont3);
                            String[] valiSpli = valiStr.split("-");
                            vali = Integer.valueOf(valiSpli[0]);
                            i = vali;
                            vali2 = Integer.valueOf(valiSpli[1]);
                            aux = 0;
                            aux2 = 0;
                            cont3 = 1;
                            continue B;
                        }
                        cont = cont + 1;
                    }
                }

            }
            if (vali2 != 0) {
                prueba2[x] = String.valueOf(cont);
                cont = cont + 1;
                cont2 = 0;
                cont3 = 0;
                System.out.println(prueba2[x]);
            } else {
                cont = cont + 1;
                cont2 = 0;
                cont3 = 0;
                if (x == prueba.length) {
                    int sum = 0;
                    for (int a = 0; a < prueba.length; a++) {
                        sum += prueba[a];
                        if (cont == sum) {
                            prueba2[x] = String.valueOf(cont);
                            System.out.println(prueba2[x]);
                        }
                    }
                }
            }

        }
		return prueba2.toString();
    }

    public static String pruebaDos(int cont, int i, int[] prueba, int cont2, int cont3) {
        int prueba2 = 0;
        int x = prueba[i];
        int vali = 0;
        while (i != prueba.length - 1) {
            if ((i < cont && cont2 == 1)) {
                i = i + 1;
                x = x + prueba[i];
                if (cont == x) {
                    cont2 = 0;
                    vali = 1;
                }
            } else if ((i == cont && cont2 == 1) || (cont < i & cont2 == 1)) {
                i = i + 1;
                x = x + prueba[i];
                if (cont == x) {
                    cont2 = 0;
                    vali = 1;
                }
            } else if (i < cont && cont2 != 1 && cont3 != 0) {
                i = i + 1;
                x = x + prueba[i];
                if (cont == x) {
                    cont2 = 1;
                    vali = 1;
                }
            } else if (cont <= i && cont2 != 0) {
                i = i + 1;
                x = x + prueba[i];
                if (cont == x) {
                    cont2 = 0;
                    vali = 1;
                } else {
                    break;
                }
            } else if (cont == x) {
                vali = 1;
                break;
            }
        }
        String conca = i + "-" + vali;
        return conca;
    }


}
