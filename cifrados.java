void  cifradocesar(String eleccion, int cifrado, String frase){
    char[] abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    if (eleccion.equals("cifrar") || eleccion.equals("Cifrar")) {
         int letras = frase.length();
        for (int i = 0; i < letras; i++) {
            char caracter = frase.charAt(i);
            int valorcaracter = caracter - 'a';
            int valorcifrado = (valorcaracter + cifrado) % 26;
            char caractercifrado = (abecedario[valorcifrado]);
            IO.print(caractercifrado);
        }
}
    else if (eleccion.equals("descifrar") || eleccion.equals("Descifrar")){
        int letras = frase.length();
        int vueltas = 0;
        int x = 0;
        do {
            for (int i = 0; i < 26; i++){
                char caracter = frase.charAt(x);
                int  valorcaracter = caracter - 'a';
                int valorcifrado = (valorcaracter + vueltas) % 26;
                char caractercifrado = (abecedario[valorcifrado]);
                IO.print(caractercifrado); x++;
                if (x >= letras){
                    x = 0;
                    vueltas++;
                    IO.println(" El anterior resultado es la frase cifrada " + vueltas);
                }
            }
        } while (vueltas < 26);
    }
}
void cifradoatbash(String frase){
    char[] atbash1 = "abcdefghijklm".toCharArray();
    char[] atbash2 = "zyxwvutsrqpon".toCharArray();
        int letras = frase.length();
        int x = 0;
        for (int i = 0; x<letras;i++){
            char caracter = frase.charAt(i);
            int valorcaracter = caracter - 'a';
            if (valorcaracter >= 13){
                valorcaracter = 'z' - caracter;
            }
            for (char caracteratbash: atbash1){
                if (caracter == caracteratbash){
                    char caractercifrado = (atbash2[valorcaracter]);
                    IO.print(caractercifrado);
                    x++;
                }
            }
            for (char caracteratbash: atbash2){
                if (caracter == caracteratbash){
                    char caractercifrado = (atbash1[valorcaracter]);
                    IO.print(caractercifrado);
                    x++;
                }
            }
        }
    }

void main() {
    while (true){
        for (int i = 0; i <= 20; i++){
            if (i == 0 || i == 20 ){
                IO.println("\n------------------------");
            }
            if (i == 10){
                IO.println("MENU DE CIFRADOS HECHO POR EDSON ORELLANA\n selecciona una opcion \n 1- CIFRADO CESAR \n 2- CIFRADO ATBASH\n 0- SALIR");
            }
        }
        int opcion = Integer.parseInt(IO.readln("Ingrese la opcion a realizar "));
        switch (opcion){
            case 0:
                System.exit(0);
                      IO.println("CIFRADO CESAR \n\n\n QUE OPERACION DESEA REALIZAR \n1-cifrar \n2-descifrar");
                      break;
            case 1:
            String eleccion = IO.readln("Ingrese la opcion ").toLowerCase();
            if (eleccion.equals("cifrar")){
                int  cifrado = Integer.parseInt(IO.readln("cuanto quiere sumar al valor del caracter "));
                String frase = IO.readln("Ingrese la linea a cifrar ");
                cifradocesar(eleccion,cifrado,frase);
            }
            else if (eleccion.equals("descifrar")){
                int  cifrado = 0;
                String frase = IO.readln("Ingrese la linea a descifrar ");
                cifradocesar(eleccion,cifrado,frase);
            }
            break;
            case 2:
                    String frase = IO.readln("Ingrese la linea a cifrar/descifrar ");
                    cifradoatbash(frase);
                    break;
        }
}
}