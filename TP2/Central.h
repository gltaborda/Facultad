#ifndef CENTRAL_H_INCLUDED
#define CENTRAL_H_INCLUDED

/*
 CENTRAL
 */

class NodoCentral{
    private:
        string numeroCentral;
        Lista<NodoEnlace*> *listaDeEnlaces;
        Lista<NodoInterno*> *listaInternos;
        int llamadasAnuladas;
    public:

       /*
        * post: La central resulta inicializado con los datos dados.
        */
        NodoCentral(string nombreCentral);

        /*
         * post: Devuelve el numero de la central.
         */
        string obtenerNumero();

        /*
         * post:Devuelve la cantidad de llamadas anuladas de la central.
         */
        int obtenerLlamadasAnuladas();

        /*
         * post:Devuelve el iterno perteneciente a su lista de internos correspondiente.
         */
        NodoInterno* obtenerInterno(string numeroInterno);

        /*
         * post:Incrementa la cantidad de llamadas anuladas en uno.
         */
        void agregarLlamadaAnulada();

        /*
         * post:Devuelve el precio total de las llamadas realizadas por el interno dado.
         */
        void gastoTotalEnLlamadas(string interno);

        /*
         * post:Agrega un enlace a la lista de Enlaces.
         */
        void agregarEnlace(NodoEnlace* centralAEnlazar);
       /*
        * post: Devuelva la lista de internos.
        */
        Lista<NodoInterno*> *devolverInternos();

        /*
         * post: Devuelve la lista de enlaces.
         */
        Lista<NodoEnlace*> *devolverEnlaces();

        /*
         * post: Destruye la central.
         */
        ~NodoCentral();
};

NodoCentral::NodoCentral(string numeroDeCentral){
    this->numeroCentral=numeroDeCentral;
    this->listaDeEnlaces=new Lista<NodoEnlace*>();
    this->listaInternos=new Lista<NodoInterno*>();
    this->llamadasAnuladas=0;
}

string NodoCentral::obtenerNumero(){
    return this->numeroCentral;
}

int NodoCentral::obtenerLlamadasAnuladas(){
    return this->llamadasAnuladas;
}

NodoInterno* NodoCentral::obtenerInterno(string numeroInterno){
    NodoInterno* nuevoInterno;
    bool encontrado=false;
    this->listaInternos->iniciarCursor();
    while ((this->listaInternos->avanzarCursor())&&(!encontrado)){
        nuevoInterno=this->listaInternos->obtenerCursor();
        if (nuevoInterno->obtenerNombreInterno()==numeroInterno){
            encontrado=true;
        }
    }
    if (!encontrado){
        return NULL;
    }else{
        return nuevoInterno;
    }
 }

void NodoCentral::agregarLlamadaAnulada(){
    this->llamadasAnuladas++;
}

void NodoCentral::gastoTotalEnLlamadas(string interno){
    NodoEnlace* enlace;
    NodoInterno* internoASumar;
    NodoLlamada* llamada;
    Lista<NodoLlamada*>* listaLlamadas;
    internoASumar=this->obtenerInterno(interno);
    bool encontrado=false;
    listaLlamadas=internoASumar->devolverLlamadas();
    while (listaLlamadas->avanzarCursor()){
        llamada=listaLlamadas->obtenerCursor();
        this->listaDeEnlaces->iniciarCursor();
        while(this->listaDeEnlaces->avanzarCursor() && (!encontrado)){
            enlace=this->listaDeEnlaces->obtenerCursor();
            if (enlace->obtenerNumeroCentral()==llamada->obtenerCentralInterlocutor()){
                encontrado=true;
            }
        }
        if (encontrado){
            internoASumar->sumarGasto(enlace->obtenerCostoPorMinutos()*llamada->obtenerMinutosHablados());
        }
    }
}

void NodoCentral::agregarEnlace(NodoEnlace* centralAEnlazar)
{
    if(!this->listaDeEnlaces){
        this->listaDeEnlaces=new Lista<NodoEnlace*>();
    }
    this->listaDeEnlaces->agregar(centralAEnlazar);
}

Lista <NodoInterno*>* NodoCentral::devolverInternos()
{
    return this->listaInternos;
}

Lista<NodoEnlace*>* NodoCentral::devolverEnlaces()
{
    return this->listaDeEnlaces;
}

NodoCentral::~NodoCentral(){
            this->listaDeEnlaces->~Lista();
            this->listaInternos->~Lista();
}

#endif // CENTRAL_H_INCLUDED
