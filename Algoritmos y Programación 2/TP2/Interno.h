#ifndef INTERNO_H_INCLUDED
#define INTERNO_H_INCLUDED

/*
 INTERNO
 */

class NodoInterno{
    //atributos
    private:
        Lista<NodoLlamada*>* listaLlamadas;
        string numeroInterno;
        bool ocupado;
        int OcupadosQueDio;
        int OcupadosAlLlamar;
        int minutosTotalesHablados;
        int vecesLlamado;
        int vecesQueLlamo;
        int gastoTotal;
        int totalMinutosQueLeHablaron;

    //métodos
    public:
        /** pre:
            post:   Se inicializa el nodo con la lista nula y demas variables vacias**/
        NodoInterno(string numeroDeInterno);
        /**
            post:   Se libera la memoria de la lista **/
        ~NodoInterno();
        /** pre:    Nodo creado.
            post:   Retorna el valor de ocupado, siendo True si el interno esta ocupado y false en caso contrario.**/
        bool estaOcupado();
        /** pre:    Nodo creado.
            post:   Cambia el estado de ocupado del interno a su estado contrario del actual.**/
        void cambiarOcupado();
        /** pre:    Nodo creado.
            post:   Agrega una unidad a la cantidad de ocupados de la llamada, ademas, suma una unidad al contador de ocupados al emitir llamada. **/
        void elReceptorEstaOcupado();
        /** pre:    Nodo creado.
            post:   Añade la llamada pasada a la lista de llamadas y suma una unidad a las llamadas realizadas por el intenro.**/
        void agregarLlamada(NodoLlamada* llamada);
        /** pre:    Nodo creado.
            post:   Suma los minutos hablados de la llamada pasada por parametro a la llamada correspondiente a la lista de las mismas en el interno y, a su vez, a los minutos totales hablados por el nterno.**/
        void sumarMinutos(llamadaAProcesar llamada);
        /** pre:    Nodo creado.
            post:   retorna NULL si no existe la llamada, en caso contrario, devuelve la llamada.**/
        NodoLlamada* buscarLlamada(string numeroInterno,string numeroCentral);
        /** pre:    Nodo creado.
            post:   Suma una unidad a la cantidad de ocupados que el interno dio cuando era llamado por otro interno.**/
        void DiOcupado();
        /** pre:    Nodo creado.
            post:   Devuelve la lista de llamadas del interno, NULL si esta vacia.**/
        Lista<NodoLlamada*>* devolverLlamadas();
        /** pre:    Nodo creado.
            post:   Devuelve la cantidad de minutos totales hablados por el interno.**/
        int obtenerMinutosHablados();
        /** pre:    Nodo creado.
            post:   Devuelve la cantidad de veces ocupadas que el interno dio cuando lo llamaban.**/
        int obtenerCantidadOcupados();
        /** pre:    Nodo creado.
            post:   Devuelve la cantidad de veces que el interno llamo y le dio ocupado.**/
        int obtenerOcupadosRecibidos();
        /** pre:    Nodo creado.
            post:   Devuelve el nombre del interno.**/
        string obtenerNombreInterno();
        /** pre:    Nodo creado.
            post:   Devuelve el monto total que el interno gastò en llamadas.**/
        int obtenerGastoTotal();
        /** pre:    Nodo creado.
            post:   Devuelve la cantidad  total de llamadas emitidas por el interno.**/
        int obtenerTotalDeLlamadasEmitidas();
        /** pre:    Nodo creado.
            post:   Devuelve los minutos totales de llamadas recibidas por el interno.**/
        int obtenerTotalMinutosQueLeHablaron();
        /** pre:    Nodo creado.
            post:   Devuelve la cantidad total de llamadas recibidas por el interno.**/
        int obtenerTotalDeLlamadasRecibidas();
        /** pre:    Nodo creado.
            post:   Suma el valor pasado por parametro al gasto total en llamadas realizadas por el usuario.**/
        void sumarGasto(int aSumar);
        /** pre:    Nodo creado.
            post:   Si es fin de llamada se le suma a los minutos totales hablados los minutos de la llamada, si es inicio de llamada se le restan, quedando como resultado, los minutos hablados realmente en la llamada sumados.**/
        void agregarLlamadaRecibida(NodoLlamada* llamadaASumar);
        /**
         **post: Acumula los gastos de las llamadas hechas por el interno.
         **/
        void acumularGastos(int gastos);
};

NodoInterno::NodoInterno(string numeroDeInterno){
    this->listaLlamadas=new Lista<NodoLlamada*>();
    this->numeroInterno=numeroDeInterno;
    this->ocupado=false;
    //CAMBIOS
    this->OcupadosQueDio = 0;
    this->OcupadosAlLlamar=0;
    this->minutosTotalesHablados=0;
    this->vecesLlamado=0;
    this->vecesQueLlamo=0;
    this->gastoTotal=0;
    this->totalMinutosQueLeHablaron=0;
}

NodoInterno::~NodoInterno(){
    this->listaLlamadas->~Lista();
}

bool NodoInterno::estaOcupado(){
    return this->ocupado;
}

void NodoInterno::cambiarOcupado(){
    if (this->ocupado){
        this->ocupado=false;
    }else{
        this->ocupado=true;
    }
}

void NodoInterno::elReceptorEstaOcupado(){
    this->OcupadosAlLlamar=this->OcupadosAlLlamar+1;
}

void NodoInterno::agregarLlamada(NodoLlamada* llamada)
{
    llamada->incrementarCantidadDeLlamadas();
    this->listaLlamadas->agregar(llamada);
    this->vecesQueLlamo=this->vecesQueLlamo+1;
}

void NodoInterno::sumarMinutos(llamadaAProcesar llamada){
        NodoLlamada* llamadaASumar=this->buscarLlamada(llamada.internoReceptor,llamada.centralReceptora);
        llamadaASumar->guardarMinutos(llamada);
        this->minutosTotalesHablados=this->minutosTotalesHablados + llamadaASumar->obtenerMinutosHablados();
}

NodoLlamada* NodoInterno::buscarLlamada(string numeroInterno,string numeroCentral){
    this->listaLlamadas->iniciarCursor();
    NodoLlamada* nuevoNodo;
    bool encontrado=false;
    while (this->listaLlamadas->avanzarCursor() && (!encontrado)){
        nuevoNodo=this->listaLlamadas->obtenerCursor();
        if((numeroInterno==nuevoNodo->obtenerNombreInterlocutor()) && (numeroCentral==nuevoNodo->obtenerCentralInterlocutor())){
            encontrado=true;
        }
    }
    if(!encontrado){
        return NULL;
    }else{
    return nuevoNodo;
    }
}

void NodoInterno::agregarLlamadaRecibida(NodoLlamada* llamadaASumar)
{
        this->vecesLlamado++;
        this->minutosTotalesHablados=this->minutosTotalesHablados + llamadaASumar->obtenerMinutosHablados();
        this->totalMinutosQueLeHablaron=this->totalMinutosQueLeHablaron + llamadaASumar->obtenerMinutosHablados();
}

void NodoInterno::DiOcupado(){
    this->OcupadosQueDio++;
}

Lista<NodoLlamada*>* NodoInterno::devolverLlamadas()
{
    return this->listaLlamadas;
}

int NodoInterno::obtenerMinutosHablados()
{
    return this->minutosTotalesHablados;
}

int NodoInterno::obtenerCantidadOcupados()
{
    return this->OcupadosQueDio;
}

int NodoInterno::obtenerOcupadosRecibidos(){
    return this->OcupadosAlLlamar;
}
string NodoInterno::obtenerNombreInterno()
{
    return this->numeroInterno;
}

int NodoInterno::obtenerGastoTotal(){
    return this->gastoTotal;
}

int NodoInterno::obtenerTotalDeLlamadasEmitidas()
{
    return this->vecesQueLlamo;
}

int NodoInterno::obtenerTotalMinutosQueLeHablaron()
{
    return this->totalMinutosQueLeHablaron;
}
int NodoInterno::obtenerTotalDeLlamadasRecibidas()
{
    return this->vecesLlamado;
}

void NodoInterno::sumarGasto(int aSumar){
    this->gastoTotal=this->gastoTotal + aSumar;
}

void NodoInterno::acumularGastos(int gastos)
{
    this->gastoTotal+=gastos * this->minutosTotalesHablados;
}

#endif // INTERNO_H_INCLUDED
