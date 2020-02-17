#ifndef ENLACE_H_INCLUDED
#define ENLACE_H_INCLUDED

/*
 ENLACE
 */
class NodoEnlace
{
    private:
        string numeroDeCentral;
        int distancia;
        int cantidadCanales;
        int costoPorMinuto;
        int precio;

    public:

        NodoEnlace();
       /*
         post: El enlace con una central resulta inicializado con los datos
        */
        NodoEnlace(string numeroDeCentral, int distancia, int cantidadCanales, int costoPorMinuto);
       /*
         post: Devuelve el valor del numero de la central.
        */
        string obtenerNumeroCentral();
       /*
         post: Devuelce el valor de la distancia.
        */
        int obtenerDistancia();
       /*
        post: Devuelve el valor de la cantidad de canales.
        */
        int obtenerCantidadCanales();
        /*
        post= resta en uno la cantidad de canales disponibles para la comunicacion entre centrales
        */
        void restarCanal();

       /*
         post: Devuelve el valor del costo por minuto.
        */
        int obtenerCostoPorMinutos();
        //CAMBIOS
        /*
         post: iguala la variable precio con costoPorMinuto
         */
         void establecerCostoPorMinuto();

         /*
          post: iguala la variable precio con distancia
          */
          void establecerCostoPorDistancia();

};

NodoEnlace::NodoEnlace()
{
    this->numeroDeCentral = " ";
    this->distancia = 0;
    this->cantidadCanales = 0;
    this->costoPorMinuto = 0;
    this->precio = 0;
}

NodoEnlace::NodoEnlace(string numeroDeCentral, int distancia, int cantidadCanales, int costoPorMinuto){
            this->numeroDeCentral = numeroDeCentral;
            this->distancia = distancia;
            this->cantidadCanales = cantidadCanales;
            this->costoPorMinuto = costoPorMinuto;
            this->precio = 0;
}

string NodoEnlace::obtenerNumeroCentral(){
        return numeroDeCentral;
}

int NodoEnlace::obtenerDistancia(){
            return distancia;
}

int NodoEnlace::obtenerCantidadCanales(){
            return cantidadCanales;
}

void NodoEnlace::restarCanal(){
    this->cantidadCanales=this->cantidadCanales-1;
}

int NodoEnlace::obtenerCostoPorMinutos(){
            return costoPorMinuto;
}

void NodoEnlace::establecerCostoPorMinuto()
{
    this->precio= this->costoPorMinuto;
}

void NodoEnlace::establecerCostoPorDistancia()
{
    this->precio=this->distancia;
}


#endif // ENLACE_H_INCLUDED
