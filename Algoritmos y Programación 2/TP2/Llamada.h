#ifndef LLAMADA_H_INCLUDED
#define LLAMADA_H_INCLUDED

/*
 LLAMADA
 */
class NodoLlamada{
    private:
        string internoInterlocutor;
        string centralInterlocutor;
        //bool emitida;
        int cantidadLlamadas;
        int minutosInicioLlamada;
        int minutosHablados;
        int cantidadOcupados;
        int distancia;
        float costoLlamada;

    //métodos
    public:
        /** Pre:
            Post: el nodo se inicializa con sus datos en 0 ò "" segun corresponda.**/
        NodoLlamada();
        /** Pre:
            Post:   El nodo se inicializa con los datos de la llamada pasada por parametro**/
        NodoLlamada(llamadaAProcesar llamada);
        /** Pre:    Nodo creado.
            Post:   Se asignan los minutos que durò la llamada basandose en los datos de la que se paso por parametro.**/
        void guardarMinutos(llamadaAProcesar llamada);
        /** Pre:    Nodo creado.
            Post:   Se le suma una unidad a la cantidad de veces ocupadas de esa llamada.**/
        void sumarOcupados();
        /**Pre: Nodo creado.
            Post: incrementa en una la cantidad de llamadas establecidas al receptor de la llamada.**/
        void incrementarCantidadDeLlamadas();
        /** Pre:    Nodo creado.
            Post:   Retorna los minutos que durò la llamada.**/
        int obtenerMinutosHablados();
        /** Pre:    Nodo creado.
            Post:   Retorna la cantidad de veces que dio ocupada la llamada.**/
        int obtenerCantidadOcupados();
        /** Pre:    Nodo creado.
            Post:   Retorna el nombre de la del interno que recibio la llamada.**/
        string obtenerNombreInterlocutor();
        /** Pre:    Nodo creado.
            Post:   Retorna la central a la que pertenede el interno que recibio la llamada.**/
        string obtenerCentralInterlocutor();
        /** Pre:    Nodo creado.
            Post:   Retorna la cantidad total de llamadas que se realizaron con el interno.**/
        int obtenerCantidadLlamadas();
};

NodoLlamada::NodoLlamada(){
    this->centralInterlocutor="";
    this->internoInterlocutor="";
    this->cantidadLlamadas=0;
    this->minutosHablados=0;
    this->cantidadOcupados=0;
    this->distancia=0;
    this->costoLlamada=0;
    this->minutosInicioLlamada=0;
}

NodoLlamada::NodoLlamada(llamadaAProcesar llamada){
    this->centralInterlocutor=llamada.centralReceptora;
    this->internoInterlocutor=llamada.internoReceptor;
    this->cantidadOcupados=0;
    this->costoLlamada=0;
    this->distancia=0;
    this->minutosHablados=0;
    this->cantidadLlamadas=0;
    this->minutosInicioLlamada=llamada.minutos;
}

void NodoLlamada::guardarMinutos(llamadaAProcesar llamada){
    this->minutosHablados=llamada.minutos-this->minutosInicioLlamada;
}

void NodoLlamada::sumarOcupados(){
    this->cantidadOcupados++;
}

void NodoLlamada::incrementarCantidadDeLlamadas(){
    this->cantidadLlamadas++;
}

int NodoLlamada::obtenerMinutosHablados()
{
    return this->minutosHablados;
}

int NodoLlamada::obtenerCantidadOcupados()
{
    return this->cantidadOcupados;
}

string NodoLlamada::obtenerNombreInterlocutor()
{
    return this->internoInterlocutor;
}

string NodoLlamada::obtenerCentralInterlocutor(){
    return this->centralInterlocutor;
}

int NodoLlamada::obtenerCantidadLlamadas()
{
    return this->cantidadLlamadas;
}

#endif // LLAMADA_H_INCLUDED
