#include <iostream>
#include "Funciones.h"

using namespace std;


int main (){
    nombreInterno vectorNombres[10];
    structInterno matrizInternos[10][10];
    inicializarMatriz(matrizInternos);
    inicializarVector(vectorNombres);
    procesarArchivo(matrizInternos,vectorNombres);
    menu(matrizInternos,vectorNombres);
}




