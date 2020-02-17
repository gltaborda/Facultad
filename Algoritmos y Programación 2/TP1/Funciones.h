#include <fstream>
#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

typedef struct llamada{
                string inicioFin;
                string internoX;
                string internoY;
                int minutos;
                }llamada;

typedef struct nombreInterno{
                string nombre;
                int numero;
                }nombreInterno;

typedef struct structInterno{
                int inicioLlamadaMinutos;
                int minutosHablados;
                int ocupados;
                int llamadasRealizadas;
                bool ocupado;
                }structInterno;

/** pre:    Archivo de llamadas procesado.
    post:   Muestra menu, dando las opciones a elegir y llamado a las distintas subrutinas. **/
void menu(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    Matriz creada.
    post:   La matriz queda inicializada con 0 y false en los campos correspondientes y lista para usar.**/
void inicializarMatriz(structInterno matrizInternos[10][10]);

/** pre:    Vector creado
    post:   El vector queda inicializado con 0 en ambos campos y listo para usar.**/
void inicializarVector(nombreInterno vectorNombres[10]);

/** pre:    Matriz inicializada.
    post:   Carga los datos del registro de llamada al campo correspondiente en la matriz. Si la llamada dio ocupado, no se toma como llamada realizada.**/
void procesarLlamadaEnMatriz(structInterno matrizInternos[10][10],llamada structLlamada,nombreInterno vectorNombres[10]);

/** pre:    Vector de nombres inicializado.
    post:   Verifica que el nombre pasado en el registro de llamada exista o no en el vector, y lo añade si se da esto último.**/
void ingresarNombreEnVector(llamada structLlamada, nombreInterno vectorNombres[10]);

/** pre:    Matriz y Vector creados e inicializados.
    post:   Lee el archivo dado en la ruta ingresada, ingresa, si es debido, el interno al vector de nombres y procesa dicha llamada en la matriz.**/
void procesarArchivo(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    El nombre debe estar en mayusculas enteramente,
    post:   Retorna la posición en el vector de nombres correspondiente al interno dado**/
int convertirNombreANumero(nombreInterno vectorNombres[10],string nombreAConvertir);

/** pre: El numero debe estar dentro del rango 100-109, en caso de pasar la posicion en vector de nombres, el rango debe ser 0-9.
    post:   Retorna el nombre del interno de acuerdo al numero de interno o numero de posicion dado. **/
void convertirNumeroANombre(int numeroAConvertir, nombreInterno vectorNombres[10],string nombreInterno);

/** pre:    Archivo de llamadas procesado.
    post:   devuelve el numero de posicion del interno**/
int elegirInterno(nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado, nombre del interno enteramente en mayuscula.
    post:   Imprime por pantalla el detalle general de las llamadas emitidas por X y recibidas por Y. **/
void detalleLlamadasEntreXeY(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado,
    post:   Imprime por pantalla el nombre del interno que mas minutos totales habló. **/
void internoMasHablo(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el nombre del interno que mas llamadas emitió (llamadas realizadas). **/
void internoQueMasLlamo(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el nombre del interno al que mas veces le dio ocupado un intento de emision de llamada. **/
void masDioOcupadoUnIntento(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el  nombre del interno que mas llamadas recibidas exitosas tiene. */
void alQueMasLlamaron(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el nombre del interno que mas minutos hablados tiene en todas las llamadas recibidas. **/
void masTiempoLeHablaron(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el nombre del interno que mas ocupados acumuló en llamadas entrantes. **/
void masDioOcupado(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado, nombre del interno enteramente en mayuscula.
    post:   Imprime por pantalla el detalle de las llamadas emitidas por el interno dado hacia cada uno de los demas internos, tanto realizadas como ocupadas.**/
void detalleLlamadasEmitidasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado, nombre del interno enteramente en mayuscula.
    post:   Imprime por pantalla el detalle de las llamadas emitidas por los demas internos hacia el interno dado.**/
void detalleLlamadasRecibidasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado, nombre del interno enteramente en mayuscula.
    post:   Imprime por pantalla el detalle total de las llamadas emitidas por X y recibidas por Y.**/
void detalleLlamadasDeXaY(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado, nombre del interno enteramente en mayuscula.
    post:   Imprime por pantalla la cantidad de llamadas emitidas por el resto de los internos y recibidas por el interno dado Y,
            e imprime por pantalla la cantidad de llamadas emitidas por el interno dado X y recibidas por el resto de los internos.**/
void llamadasRecibidasPorYyRealizadasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]);

/** pre:    Archivo de llamadas procesado.
    post:   Imprime por pantalla el nombre y numero de cada uno de los internos presentes en el archivo de llamadas.**/
void detallarInternos(nombreInterno vectorNombres[10]);
