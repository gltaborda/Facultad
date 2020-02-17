#ifndef CAMINO_H_INCLUDED
#define CAMINO_H_INCLUDED


/*
 * Camino
 */

class Camino
{
    private:
        Lista<NodoCentral*>* centrales;
        string* vectorVisitado;
        int costoMinimo;
        string centralBase;
        string centralDestino;
        unsigned int maximoVector;
    public:
       /**
        ** Post: Inicializa la clase camino con la lista de centrales, la central de origen y la de destino.
                 Se crea el 'vectorVisitado' con las centrales de la lista y despues se ordena.
        **/
        Camino(Lista<NodoCentral*>* centralDato, string centralOrigen, string centralDestino);

        /**
         ** Post: Se recorren las centrales y se acumula los precios de los enlaces mas economicos, desde la central de origen hasta la de destino.
         **/
        int obtenerCosteMinimo();

        /**
         ** Post:Se recorren las centrales y se acumula los precios de los enlaces mas cercanos, desde la central de origen hasta la de destino.
         **/
        int obtenerCosteEnlaceMasCercano();

        /**
         ** Post: Recorre el vector, y si encuentra a la central dada, significa que todavia no fue visitada.
         **/
        bool todaviaNoVisitado(string central);

        /**
         ** Post: Busca a 'centralInicio' en la lista de centrales dada.
         **/
        NodoCentral* buscarCentral(Lista<NodoCentral*>* centrales, string centralInicio);

        /**
         ** Post: Ordena al vector en orden alfabetico.
         **/
        void ordenarVector();

        /**
         ** Post: Borra a la central dada del 'vectorVisitado'.
         **/
        void marcarCentralVisitada(NodoCentral* central);

        /**
         ** Post: Marca la central como visitada en el 'vectorVisitado' y lo ordena.
                  Recorre todos los enlaces, preguntando si la central fue visitada, de ese recorrido obtiene la mas economica.
                  Modifica la 'centralBase' con la central del enlace obtenido.
         **/
        int devolverEnlaceMinimo(NodoCentral* central);

        /**
         ** Post: Marca la central como visitada en el 'vectorVisitado' y lo ordena.
                  Recorre todos los enlaces, preguntando si la central fue visitada, de ese recorrido obtiene la mas cercana a la 'centralOrigen'.
                  Modifica la 'centralBase' con la central del enlace obtenido.
         **/
        int devolverEnlaceMasCorto(NodoCentral* central);

        /**
         ** Post: Destruye el vector de centrales visitadas.
         **/
        ~Camino();

};

Camino::Camino(Lista<NodoCentral*>* centralDato, string centralOrigen, string centralDestino)
{
    this->centrales = centralDato;
    this->centralBase = centralOrigen;
    this->centralDestino = centralDestino;
    this->costoMinimo=0;
    this->maximoVector =centrales->contarElementos();
    this->vectorVisitado = new string[maximoVector];
    centralDato->iniciarCursor();
    unsigned int i = 0;
    while(centralDato->avanzarCursor())
    {
        NodoCentral* centralActual = centralDato->obtenerCursor();
        this->vectorVisitado[i]=centralActual->obtenerNumero();
        i++;
    }
    ordenarVector();
}

int Camino::obtenerCosteMinimo()
{
    while(todaviaNoVisitado(this->centralDestino) && (this->centralBase != this->centralDestino))
    {
        NodoCentral* central = buscarCentral(this->centrales,this->centralBase);
        this->costoMinimo = costoMinimo+ devolverEnlaceMinimo(central);
    }
    return costoMinimo;
}

int Camino::obtenerCosteEnlaceMasCercano()
{
    while(todaviaNoVisitado(this->centralDestino) && (this->centralBase != this->centralDestino))
    {
        NodoCentral* central = buscarCentral(this->centrales,this->centralBase);
        this->costoMinimo = costoMinimo + devolverEnlaceMasCorto(central);
    }
    return costoMinimo;
}

bool Camino::todaviaNoVisitado(string central)
{
    bool fin = false;
    for(unsigned int i=0; i<this->maximoVector &&!fin;i++)
    {
        if (this->vectorVisitado[i]==central)
            fin = true;
    }
    return fin;
}



NodoCentral* Camino::buscarCentral(Lista<NodoCentral*>* centrales, string centralInicio)
{
    centrales->iniciarCursor();
    bool fin = false;
    NodoCentral* centralActual;
    while(centrales->avanzarCursor() && !fin)
    {
        centralActual = centrales->obtenerCursor();
        if(centralActual->obtenerNumero()==centralInicio)
            fin=true;
    }
    return centralActual;
}

void Camino::ordenarVector()
{
    string stringAuxiliar;
    for(unsigned int i=0; i<this->maximoVector-1; i++)
    {
        for(unsigned int j= i+1; j<this->maximoVector; j++)
        {
            if(this->vectorVisitado[i]>this->vectorVisitado[j])
            {
                stringAuxiliar = this->vectorVisitado[j];
                this->vectorVisitado[j] = this->vectorVisitado[i];
                this->vectorVisitado[i] = stringAuxiliar;
            }
        }
    }
}

void Camino::marcarCentralVisitada(NodoCentral* centralASacar) //Remueve la central del vector visitado, es decir, esa central ya fue visitada
{
    for(unsigned int i=0; i<this->maximoVector; i++)
    {
        if(this->vectorVisitado[i]==centralASacar->obtenerNumero())
        {
            vectorVisitado[i]="999999";
        }
    }
}

int Camino::devolverEnlaceMinimo(NodoCentral* central)
{
    marcarCentralVisitada(central);
    ordenarVector();
    this->maximoVector--;
    int minimo = 999999;
    Lista<NodoEnlace*>* enlaces = central->devolverEnlaces();
    enlaces->iniciarCursor();

    while(enlaces->avanzarCursor())  //CONSULTA TODOS LOS ENLACES
    {
        NodoEnlace* enlaceActual = enlaces->obtenerCursor();
        if(todaviaNoVisitado(enlaceActual->obtenerNumeroCentral()) || (enlaceActual->obtenerCostoPorMinutos()< minimo))
        {
            minimo=enlaceActual->obtenerCostoPorMinutos();
            this->centralBase=enlaceActual->obtenerNumeroCentral();
        }
    }
    return minimo;
}

int Camino::devolverEnlaceMasCorto(NodoCentral* central)
{
    marcarCentralVisitada(central);
    ordenarVector();
    this->maximoVector--;
    int minimo = 999999;
    Lista<NodoEnlace*>* enlaces = central->devolverEnlaces();
    enlaces->iniciarCursor();

    while(enlaces->avanzarCursor())  //CONSULTA TODOS LOS ENLACES
    {
        NodoEnlace* enlaceActual = enlaces->obtenerCursor();
        if(todaviaNoVisitado(enlaceActual->obtenerNumeroCentral()) || (enlaceActual->obtenerDistancia()< minimo))
        {
            minimo=enlaceActual->obtenerDistancia();
            this->centralBase=enlaceActual->obtenerNumeroCentral();
        }
    }
    return minimo;
}

Camino :: ~Camino()
{
    delete[] this->vectorVisitado;
}


#endif // CAMINO_H_INCLUDED
