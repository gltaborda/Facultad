#ifndef GASTOS_H_INCLUDED
#define GASTOS_H_INCLUDED

/*
 * GASTOS
 */

class Gastos
{
    private:
        Lista<NodoCentral*>* centrales;
        char eleccionDeCamino;
    public:
        /**
         ** Post: inicializa 'centrales' con la lista dada y se le asigna a eleccion de camino el valor dado.
         **/
        Gastos(Lista<NodoCentral*>* listaCentrales, char eleccion);

       /**
        ** Post: Recorre la lista de centrales y la de internos para modificar los gastos totales del interno.
        **/
        void establecerCostos();
       /**
        ** Post: Se contabiliza los gastos de cada interno, dependiendo de la eleccion de enlace.
        **/
        void monetizarInterno(NodoInterno* interno, NodoCentral* centralEmisora);
};

Gastos::Gastos(Lista<NodoCentral*>* listaCentrales, char eleccion)
{
    this->centrales = listaCentrales;
    this->eleccionDeCamino = eleccion;
}

void Gastos::establecerCostos()
{
    this->centrales->iniciarCursor();
    while(centrales->avanzarCursor())
    {
        NodoCentral* centralActual = centrales->obtenerCursor();
        Lista<NodoInterno*>* internos = centralActual->devolverInternos();
        internos->iniciarCursor();
        while(internos->avanzarCursor())
        {
            NodoInterno* interno = internos->obtenerCursor();
            monetizarInterno(interno, centralActual);
        }

    }
}

void Gastos::monetizarInterno(NodoInterno* interno, NodoCentral* centralEmisora)
{
    Lista<NodoLlamada*>* llamadas = interno->devolverLlamadas();
    llamadas->iniciarCursor();
    while(llamadas->avanzarCursor())
    {
        NodoLlamada* llamadaActual = llamadas->obtenerCursor();
        Camino precio(this->centrales, centralEmisora->obtenerNumero(), llamadaActual->obtenerCentralInterlocutor());
        if(this->eleccionDeCamino == '1')
            interno->acumularGastos(precio.obtenerCosteMinimo());
        else
            interno->acumularGastos(precio.obtenerCosteEnlaceMasCercano());
    }

}

#endif // GASTOS_H_INCLUDED
