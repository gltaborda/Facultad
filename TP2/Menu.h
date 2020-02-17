#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED

/*
MENU
 */

class Menu{
    private:
        Lista<NodoCentral*>* listaCentrales;
        string volverMenu;
    public:

        /*
         * post: Crea el Menu e iguala la lista De centrales con el dato dado.
         */
        Menu(Lista<NodoCentral*>* listaCentrales);

        //~Menu();
        /*
         * post: Muestra en pantalla el menu con sus respectivas opciones.
         */
        void mostrarMenu();
        /*
         *   post: busca la llamada con emisor igual al internoX y detalla dicha llamada.
         */
        void detallarLlamada(string emisor, string receptor,string centralDelEmisor,string centralDelReceptor);

        /*
         * post: Imprime en pantalla  los detalles de las llamadas entre un interno con su respectiva central a otro interno con su respectiva central
         *       mostrando la cantidad de llamadas, tiempo hablado y veces ocupados (sumados sus datos)
         */
        void detalleLlamadasEntreXeY();

        /*
         * post:Imprime en pantalla al interno que mas hablo de todos y de cada central. Si hay empate, imprime el primero.
         */
        void masHablo();

        /*
         * post:Imprime en pantalla al interno que mas llamo de todos y de cada central. Si hay empate, imprime el primero.
         */
        void masLlamo();

        /*
         * post: Imprime en pantalla al interno que mas le dio ocupado sus intentos y de cada central. Si hay empate, imprime el primero.
         */
        void masOcupadosRecibio();

        /*
         * post:Imprime en pantalla al interno que mas llamaron de todos y de cada central. Si hay empate, imprime el primero.
         */
        void masLlamado();

        /*
         * post: Imprime en pantalla al interno que mas gasto de todos y de cada central. Si hay empate, imprime el primero.
         */
        void masGasto();

        /*
         * post: Imprime en pantalla al interno que mas le hablaron de todos y de cada central.
         */
        void masLeHablaron();

        /*
         * post: Imprime en pantalla al interno que mas dio ocupado de todos y de cada central.
         */
        void masOcupadosDio();

        /*
         * post: Imprime en pantalla los detalles de las las llamadas emitidas por un interno con su respectiva central.
         */
        void detalleLlamadasEmitidas();

        /*
         * post: Imprime en pantalla los detalles de las las llamadas recibidas por un interno con su respectiva central.
         */
        void detalleLlamadasRecibidas();

        /*
         * post: Imprime en pantalla los detalles de las llamadas realizadas por un interno con su central a otro interno con su central.
         */
        void detalleLlamadasDeXaY();

        /*
         * post: Imprime en pantalla los detalles de las llamadas recibidas por un interno con su central
         *      y las llamadas realizadas por otro interno con su central.
         */
        void detalleLlamadasDeXaYRecibidas();

        /*
         * post: Imprime en pantalla la cantidad de llamadas anuladas por falta de enlace por central, ordenando por cantidad descendiente.
         */
        void cantidadLlamadasAnuladas();

        /*
         * post: Imprime los detalles de enlace (origen, destino y canales).
         */
        void detalleDeEnlaces();

        /*
         * post: Imprime en pantalla los detalles de internos, nombres y numeros.
         */
        void detalleDeInternos();

        /*
         * post: Imprime en pantalla los detalles de centrales con su numeracion.
         */
        void detalleDeCentrales();

        /*
         * post: Devuelve el interno, despues de haber sido buscado en la central dada.
         */
        NodoInterno* devolverInterno(NodoCentral* central, string idInterno);

        /*
         * post: Devuelve un nodo llamada despues de haber sido buscado en la lista de llamadas del interno dado
         *       y la llamada fuera buscada por el numero del interno receptor
         */
        NodoLlamada*  devolverDetalles(NodoInterno* internoEmisor, string internoReceptor);

        /*
         * post: Devuelve al interno que mas gasto en las llamadas perteneciente a la central dada.
         */
        NodoInterno* obtenerGastadorMaximoEnCentral(NodoCentral* central);

        /*
         * post: Devuelve al interno que tuvo la mayor cantidad de minutos hablados, despues de haber buscado en la central dada.
         */
        NodoInterno* obtenerHabladorMaximoEnCentral(NodoCentral* central);

        /*
         * post: Devuelve al interno que tuvo la mayor cantidad de ocupados que dio, despues de haber buscado en la central dada.
         */
        NodoInterno* obtenerOcupadoMaximoEnCentral(NodoCentral* central);

        /*
         * post:
         */
         void volverAlMenu();
       /* void detalles()
        {
            string origen, fin;
            cout<<"Se le diran los precios de los enlaces"<<endl;
            cout<<"Ingrese la central de origen"<<endl;
            cin>>origen;
            cout<<"Ingrese la central de fin"<<endl;
            cin>>fin;
            Camino consulta(listaCentrales,origen,fin);
            cout<<"El precio entre la central"<<origen<<" y la "<<fin<<" es: "<<consulta.obtenerCosteMinimo()<<endl;
        }*/
};

Menu::Menu(Lista<NodoCentral*>* listaDeCentrales){
    this->listaCentrales=listaDeCentrales;
}

//Menu::~Menu(){
  //  this->listaCentrales->~Lista();
//}

void Menu::mostrarMenu(){
    int consulta;
    while (consulta!=17){
        cout << string(8, '\n');
        cout<<"1. Detalle de llamadas entre el interno X de la central A y el interno Y de la central B."<<endl;
        cout<<"2. Interno que mas hablo de todos y de cada central."<<endl;
        cout<<"3. Interno que mas llamo de todos y de cada central."<<endl;
        cout<<"4. Interno al que mas le dio ocupado sus intentos y de cada central."<<endl;
        cout<<"5. Interno al que mas llamaron de todos y de cada central."<<endl;
        cout<<"6. Interno que mas gasto de todos y de cada central."<<endl;
        cout<<"7. Interno al que mas le hablaron de todos y de cada central."<<endl;
        cout<<"8. Interno que mas dio ocupados de todos y de cada central."<<endl;
        cout<<"9. Detalle de llamadas emitidas del interno X de la central A."<<endl;
        cout<<"10. Detalle de llamadas recibidas por el interno X de la central A."<<endl;
        cout<<"11. Detalle de llamadas realizadas de X de la central A a Y de la central B."<<endl;
        cout<<"12. Detalle de llamadas recibidas por X de la central X y realizadas por Y de la central B."<<endl;
        cout<<"13. Cantidad de llamadas anuladas por falta de enlaces por central, ordenando por cantidad descendiente."<<endl;
        cout<<"14. Detalle de enlaces."<<endl;
        cout<<"15. Detalle de internos."<<endl;
        cout<<"16. Detalle centrales."<<endl;
        cout<<"17. Salir."<<endl;
        cout<<"Ingrese el numero correspondiente a la opcion que desea: ";
        cin>>consulta;
        while ((consulta<1) && (consulta>17)){
            cout<<endl<<"Opcion invalida, ingrese nuevamente: ";
            cin>>consulta;
        }
        switch(consulta){
            case 1: {   cout << string(17, '\n');
                        this->detalleLlamadasEntreXeY();
                        this->volverAlMenu();
            }
            break;
            case 2: {   cout << string(17, '\n');
                        this->masHablo();
                        this->volverAlMenu();
            }
            break;
            case 3: {   cout << string(17, '\n');
                        this->masLlamo();
                        this->volverAlMenu();
            }
            break;
            case 4: {   cout << string(17, '\n');
                        this->masOcupadosRecibio();
                        this->volverAlMenu();
            }
            break;
            case 5: {   cout << string(17, '\n');
                        this->masLlamado();
                        this->volverAlMenu();
            }
            break;
            case 6: {   cout << string(17, '\n');
                        this->masGasto();
                        this->volverAlMenu();
            }
            break;
            case 7: {   cout << string(17, '\n');
                        this->masLeHablaron();
                        this->volverAlMenu();
            }
            break;
            case 8: {   cout << string(17, '\n');
                        this->masOcupadosDio();
                        this->volverAlMenu();
            }
            break;
            case 9: {   cout << string(17, '\n');
                        this->detalleLlamadasEmitidas();
                        this->volverAlMenu();
            }
            break;
            case 10: {  cout << string(17, '\n');
                        this->detalleLlamadasRecibidas();
                        this->volverAlMenu();
            }
            break;
            case 11: {  cout << string(17, '\n');
                        this->detalleLlamadasDeXaY();
                        this->volverAlMenu();
            }
            break;
            case 12: {  cout << string(17, '\n');
                        this->detalleLlamadasDeXaYRecibidas();
                        this->volverAlMenu();
            }
            break;
            case 13: {  cout << string(17, '\n');
                        this->cantidadLlamadasAnuladas();
                        this->volverAlMenu();
            }
            break;
            case 14: {  cout << string(5, '\n');
                        this->detalleDeEnlaces();
                        this->volverAlMenu();
            }
            break;
            case 15: {  cout << string(17, '\n');
                        this->detalleDeInternos();
                        this->volverAlMenu();
            }
            break;
            case 16: {  cout << string(17, '\n');
                        this->detalleDeCentrales();
                        this->volverAlMenu();
            }
            break;
            /*case 18: {  this->detalles();
                        cout<<"Presione una tecla para volver al menu."<<endl;
                        cin>>volverMenu;
            }
            break;*/
        }
    }
}
void Menu::detallarLlamada(string emisor, string receptor,string centralDelEmisor,string centralDelReceptor){
    bool encontrado= false;
    NodoCentral* centralEmisor;
    NodoInterno* internoEmisor;
    NodoLlamada* llamada;
    this->listaCentrales->iniciarCursor();
    while(this->listaCentrales->avanzarCursor() && (!encontrado)){
        centralEmisor=this->listaCentrales->obtenerCursor();
        if (centralEmisor->obtenerNumero()==centralDelEmisor){
            encontrado=true;
        }
    }
    internoEmisor=centralEmisor->obtenerInterno(emisor);
    llamada=internoEmisor->buscarLlamada(receptor,centralDelReceptor);
    if (!llamada){
        cout<< "No hay llamadas de "<<emisor<<" a "<<receptor<<endl;
    }else{
        cout<<"El interno "<<emisor<<" de la central "<<centralDelEmisor<<" llamo al interno " <<llamada->obtenerNombreInterlocutor()<<" de la central "<<llamada->obtenerCentralInterlocutor()<<" "<<llamada->obtenerCantidadLlamadas()<<" veces."<<endl;
        cout<<"El interno "<<emisor<<" de la central "<<centralDelEmisor<<" hablo con el interno "<<llamada->obtenerNombreInterlocutor()<<" de la central "<<llamada->obtenerCentralInterlocutor()<<" "<<llamada->obtenerMinutosHablados()<<" minutos."<<endl;
        cout<<"El interno "<<emisor<<" de la central "<<centralDelEmisor<<" recibio "<<llamada->obtenerCantidadOcupados()<<" veces ocupado al llamar al interno "<<llamada->obtenerNombreInterlocutor()<<" de la central "<<llamada->obtenerCentralInterlocutor()<<"."<<endl;
    }
}
void Menu::detalleLlamadasEntreXeY(){
    string internoX,centralX,internoY,centralY;
    cout<<"Ingrese el interno emisor: ";
    cin>>internoX;
    cout<<"Ingrese el interno receptor: ";
    cin>>internoY;
    cout<<"Ingrese la central del interno emisor: ";
    cin>>centralX;
    cout<<"Ingrese la central del interno receptor: ";
    cin>>centralY;
    detallarLlamada(internoX,internoY,centralX,centralY);
    detallarLlamada(internoY,internoX,centralY,centralX);
}

void Menu::masHablo(){
    Lista<NodoInterno*>* listaInternos;
    NodoCentral* central;
    NodoInterno* interno;
    int minutosMaximosCentral,minutosMaximosTotales;
    string masHabloDeCentral,masHabloDeTodos,centralMasHablo;
    minutosMaximosTotales=0;
    this->listaCentrales->iniciarCursor();
    while(this->listaCentrales->avanzarCursor()){
        central=this->listaCentrales->obtenerCursor();
        listaInternos=central->devolverInternos();
        listaInternos->iniciarCursor();
        minutosMaximosCentral=0;
        masHabloDeCentral="------";
        while(listaInternos->avanzarCursor()){
            interno=listaInternos->obtenerCursor();
            if(interno->obtenerMinutosHablados()>minutosMaximosCentral){
                minutosMaximosCentral=interno->obtenerMinutosHablados();
                masHabloDeCentral=interno->obtenerNombreInterno();
            }
        }
        cout<<"El que mas hablo de la central "<<central->obtenerNumero()<<" fue el interno "<<masHabloDeCentral<<endl;
        if(minutosMaximosCentral>minutosMaximosTotales){
            minutosMaximosTotales=minutosMaximosCentral;
            masHabloDeTodos=masHabloDeCentral;
            centralMasHablo=central->obtenerNumero();
        }
    }
    cout<<"El interno que mas hablo de todos es "<<masHabloDeTodos<<" de la central "<<centralMasHablo<<endl;
}

void Menu::masLlamo(){
    Lista<NodoInterno*>* listaInternos;
    NodoCentral* central;
    NodoInterno* interno;
    int llamadasMaximasCentral,llamadasMaximasTotales;
    string masLlamoDeCentral,masLlamoDeTodos,centralMasLlamo;
    llamadasMaximasCentral=0;
    llamadasMaximasTotales=0;
    this->listaCentrales->iniciarCursor();
    while(this->listaCentrales->avanzarCursor()){
        central=this->listaCentrales->obtenerCursor();
        listaInternos=central->devolverInternos();
        listaInternos->iniciarCursor();
        llamadasMaximasCentral=0;
        masLlamoDeCentral="------";
        while(listaInternos->avanzarCursor()){
            interno=listaInternos->obtenerCursor();
            if(interno->obtenerTotalDeLlamadasEmitidas()>llamadasMaximasCentral){
                llamadasMaximasCentral=interno->obtenerTotalDeLlamadasEmitidas();
                masLlamoDeCentral=interno->obtenerNombreInterno();
            }
        }
        cout<<"El que mas llamo de la central "<<central->obtenerNumero()<<" fue el interno "<<masLlamoDeCentral<<endl;
        if(llamadasMaximasCentral>llamadasMaximasTotales){
            llamadasMaximasTotales=llamadasMaximasCentral;
            masLlamoDeTodos=masLlamoDeCentral;
            centralMasLlamo=central->obtenerNumero();
        }
    }
    cout<<"El interno que mas llamo de todos es "<<masLlamoDeTodos<<" de la central "<<centralMasLlamo<<endl;
}

void Menu::masOcupadosRecibio(){
    Lista<NodoInterno*>* listaInternos;
    NodoCentral* central;
    NodoInterno* interno;
    int ocupadosMaximosCentral,ocupadosMaximosTotales;
    string masLeDioOcupadoDeCentral,masLeDioOcupadoDeTodos,centralDelQueMasLeDioOcupado;
    ocupadosMaximosCentral=0;
    ocupadosMaximosTotales=0;
    this->listaCentrales->iniciarCursor();
    while(this->listaCentrales->avanzarCursor()){
        central=this->listaCentrales->obtenerCursor();
        listaInternos=central->devolverInternos();
        listaInternos->iniciarCursor();
        ocupadosMaximosCentral=0;
        masLeDioOcupadoDeCentral="------";
        while(listaInternos->avanzarCursor()){
            interno=listaInternos->obtenerCursor();
            if(interno->obtenerOcupadosRecibidos()>ocupadosMaximosCentral){
                ocupadosMaximosCentral=interno->obtenerOcupadosRecibidos();
                masLeDioOcupadoDeCentral=interno->obtenerNombreInterno();
            }
        }
        cout<<"El que mas ocupados recibio de la central "<<central->obtenerNumero()<<", fue el interno "<<masLeDioOcupadoDeCentral<<endl;
        if(ocupadosMaximosCentral>ocupadosMaximosTotales){
            ocupadosMaximosTotales=ocupadosMaximosCentral;
            masLeDioOcupadoDeTodos=masLeDioOcupadoDeCentral;
            centralDelQueMasLeDioOcupado=central->obtenerNumero();
        }
    }
    cout<<"El interno que mas ocupados recibio es "<<masLeDioOcupadoDeTodos<<" de la central "<<centralDelQueMasLeDioOcupado<<endl;
}

void Menu::masLlamado(){
    Lista<NodoInterno*>* listaInternos;
    NodoCentral* central;
    NodoInterno* interno;
    int llamadasEntrantesMaximasDeCentral,llamadasEntrantesMaximasTotal;
    string masLoLlamaronDeCentral,masLoLlamaronDeTodos,centralDelQueLlamaron;
    llamadasEntrantesMaximasDeCentral=0;
    llamadasEntrantesMaximasTotal=0;
    this->listaCentrales->iniciarCursor();
    while(this->listaCentrales->avanzarCursor()){
        central=this->listaCentrales->obtenerCursor();
        listaInternos=central->devolverInternos();
        listaInternos->iniciarCursor();
        llamadasEntrantesMaximasDeCentral=0;
        masLoLlamaronDeCentral="-------";
        while(listaInternos->avanzarCursor()){
            interno=listaInternos->obtenerCursor();
            if(interno->obtenerTotalDeLlamadasRecibidas()>llamadasEntrantesMaximasDeCentral){
                llamadasEntrantesMaximasDeCentral=interno->obtenerTotalDeLlamadasRecibidas();
                masLoLlamaronDeCentral=interno->obtenerNombreInterno();
            }
        }
        cout<<"El mas llamado de la central "<<central->obtenerNumero()<<", fue el interno "<<masLoLlamaronDeCentral<<endl;
        if(llamadasEntrantesMaximasDeCentral>llamadasEntrantesMaximasTotal){
            llamadasEntrantesMaximasTotal=llamadasEntrantesMaximasDeCentral;
            masLoLlamaronDeTodos=masLoLlamaronDeCentral;
            centralDelQueLlamaron=central->obtenerNumero();
        }
    }
    cout<<"El mas llamado de todos es "<<masLoLlamaronDeTodos<<" de la central "<<centralDelQueLlamaron<<endl;
}

void Menu::masGasto(){
    string centralDelMaximoEnGastar;
    NodoInterno* internoMaximoEnGastarPorCentral;
    NodoInterno* internoMaximoEnGastar=new NodoInterno("-----");
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor())
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        internoMaximoEnGastarPorCentral = obtenerGastadorMaximoEnCentral(central);
        cout<<"En la central "<<central->obtenerNumero()<<" el interno que mas gasto fue: "<<internoMaximoEnGastarPorCentral->obtenerNombreInterno()<<endl;
        if(internoMaximoEnGastarPorCentral->obtenerGastoTotal()>internoMaximoEnGastar->obtenerGastoTotal())
        {
            internoMaximoEnGastar = internoMaximoEnGastarPorCentral;
            centralDelMaximoEnGastar=central->obtenerNumero();
        }
    }
    cout<<"El interno que mas gasto de todas las centrales fue "<<internoMaximoEnGastar->obtenerNombreInterno()<<" de la central "<<centralDelMaximoEnGastar<<endl;
}

void Menu::masLeHablaron(){
    string centralDelMaximoEnHablar;
    NodoInterno* internoMaximoEnHablarPorCentral;
    NodoInterno* internoMaximoEnHablar=new NodoInterno("-----");
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor())
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        internoMaximoEnHablarPorCentral = obtenerHabladorMaximoEnCentral(central);
        cout<<"En la central "<<central->obtenerNumero()<<" el interno al que mas le hablaron fue: "<<internoMaximoEnHablarPorCentral->obtenerNombreInterno()<<endl;
        if(internoMaximoEnHablarPorCentral->obtenerTotalMinutosQueLeHablaron()>internoMaximoEnHablar->obtenerTotalMinutosQueLeHablaron())
        {
            internoMaximoEnHablar = internoMaximoEnHablarPorCentral;
            centralDelMaximoEnHablar=central->obtenerNumero();
        }
    }
    cout<<"El interno al que mas le hablaron de todas las centrales fue "<<internoMaximoEnHablar->obtenerNombreInterno()<<" de la central "<<centralDelMaximoEnHablar<<endl;
}

void Menu::masOcupadosDio(){
    string centralDelMaximoOcupado;
    NodoInterno* internoMaximoOcupadoPorCentral;
    NodoInterno* internoMaximoOcupado=new NodoInterno("-----");
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor())
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        internoMaximoOcupadoPorCentral = obtenerOcupadoMaximoEnCentral(central);
        cout<<"En la central "<<central->obtenerNumero()<<" el interno que mas dio ocupado fue: "<<internoMaximoOcupadoPorCentral->obtenerNombreInterno()<<endl;
        if(internoMaximoOcupadoPorCentral->obtenerCantidadOcupados()>internoMaximoOcupado->obtenerCantidadOcupados())
        {
            internoMaximoOcupado = internoMaximoOcupadoPorCentral;
            centralDelMaximoOcupado=central->obtenerNumero();
        }
    }
    cout<<"El interno al que mas dio ocupado de todas las centrales fue "<<internoMaximoOcupado->obtenerNombreInterno()<<" de la central "<<centralDelMaximoOcupado<<endl;
}

void Menu::detalleLlamadasEmitidas(){
    string numeroInterno,numeroCentral;
    bool finRecorrido = false;
    cout<<"Por favor ingrese el numero de interno y el numero de su respectiva central para continuar."<<endl;
    cout<<"Numero de interno: ";
    cin>>numeroInterno;
    cout<<"Numero de su Central: ";
    cin>>numeroCentral;
    Lista<NodoLlamada*>* llamadas;
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor()&& !finRecorrido)
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        if (numeroCentral ==central->obtenerNumero())
        {
            NodoInterno* interno = devolverInterno(central, numeroInterno);
            llamadas = interno->devolverLlamadas();
            NodoLlamada* llamadaActual;
            while(llamadas->avanzarCursor())
            {
                llamadaActual = llamadas->obtenerCursor();
                cout<<"El interno "<<numeroInterno<<" tuvo con el interno "<<llamadaActual->obtenerNombreInterlocutor()<<endl;
                cout<<"Un total de "<<llamadaActual->obtenerCantidadLlamadas()<<" llamada/s"<<endl;
                cout<<"Un total de "<<llamadaActual->obtenerMinutosHablados()<<" minutos hablados"<<endl;
                cout<<"Un total de "<<llamadaActual->obtenerCantidadOcupados()<<" ocupado/s"<<endl;
            }
            finRecorrido=true;
        }

    }
}

void Menu::detalleLlamadasRecibidas(){
    string numeroInterno,numeroCentral;
    bool finRecorrido = false;
    cout<<"Por favor ingrese el numero de interno y el numero de su respectiva central para continuar."<<endl;
    cout<<"Numero de interno: ";
    cin>>numeroInterno;
    cout<<"Numero de su Central: ";
    cin>>numeroCentral;
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor()&& !finRecorrido)
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        if (numeroCentral ==central->obtenerNumero())
        {
            NodoInterno* interno = devolverInterno(central, numeroInterno);
            cout<<"El interno "<<numeroInterno<<" tuvo:"<<endl;
            cout<<"Un total de "<<interno->obtenerTotalDeLlamadasRecibidas()<<" llamadas recibidas."<<endl;
            cout<<"Un total de "<<interno->obtenerTotalMinutosQueLeHablaron()<<" minutos que le hablaron."<<endl;
            finRecorrido=true;
        }
    }
 }

void Menu::detalleLlamadasDeXaY(){
    bool fin = false;
    string internoEmisor,internoReceptor,centralEmisora,centralReceptora;
    cout<<"Ingrese el numero del interno que llamo con su respectiva central."<<endl;
    cout<<"Interno: ";
    cin>>internoEmisor;
    cout<<"Central: ";
    cin>>centralEmisora;
    cout<<"Ingres el numero del interno que recibio la llamada con su respectiva central"<<endl;
    cout<<"Interno: ";
    cin>>internoReceptor;
    cout<<"Central: ";
    cin>>centralReceptora;
    listaCentrales->iniciarCursor();
    while(listaCentrales->avanzarCursor()&& !fin)
    {
        NodoCentral* central = listaCentrales->obtenerCursor();
        if(centralEmisora==central->obtenerNumero())
        {
            NodoInterno* internoQueLlamo = devolverInterno(central, internoEmisor);
            NodoLlamada* detallesDeLlamada = devolverDetalles(internoQueLlamo, centralReceptora);
            cout<<"Detalles de llamadas del interno "<<internoEmisor<<" al "<<internoReceptor<<endl;
            cout<<"Total de llamada/s: "<<detallesDeLlamada->obtenerCantidadLlamadas()<<endl;
            cout<<"Total de minutos hablados: "<<detallesDeLlamada->obtenerMinutosHablados()<<endl;
            cout<<"Total de ocupado/s: "<<detallesDeLlamada->obtenerCantidadOcupados()<<endl;
            fin = true;
        }
    }
}

void Menu::detalleLlamadasDeXaYRecibidas(){
      int respuesta;
      cout<<"Para los detalles de llamadas recibidas por un interno presione 1."<<endl<<"Para los detalles de las llamadas realizadas por un interno presione 2."<<endl;
      cin>>respuesta;
      if(respuesta==1)
      {
          detalleLlamadasRecibidas();
      }
      else
      {
          detalleLlamadasEmitidas();
      }
}

void Menu::cantidadLlamadasAnuladas(){
    int anuladasTotales=0;
    this->listaCentrales->iniciarCursor();
    NodoCentral* centralActual;
    while(this->listaCentrales->avanzarCursor()){
        centralActual=this->listaCentrales->obtenerCursor();
        anuladasTotales=anuladasTotales+centralActual->obtenerLlamadasAnuladas();
    }
    cout<<"Las llamadas anuladas por falta de enlace totales son: "<<anuladasTotales<<endl;
}

void Menu::detalleDeEnlaces(){
    this->listaCentrales->iniciarCursor();
    NodoCentral* centralActual;
    while(this->listaCentrales->avanzarCursor()){
        centralActual=this->listaCentrales->obtenerCursor();
        cout<<"Enlaces de la central: "<<centralActual->obtenerNumero()<<endl;
        cout<<"---------------------------"<<endl;
        Lista<NodoEnlace*>* listaDeEnlaces;
        listaDeEnlaces=centralActual->devolverEnlaces();
        NodoEnlace* enlaceActual;
        while (listaDeEnlaces->avanzarCursor()){
            enlaceActual=listaDeEnlaces->obtenerCursor();
            cout<<"Numero de central enlazada: "<<enlaceActual->obtenerNumeroCentral()<<endl;
            cout<<"Cantidad de canales del enlace: "<<enlaceActual->obtenerCantidadCanales()<<endl;
            cout<<"Distancia entre las centrales enlazadas: "<<enlaceActual->obtenerDistancia()<<endl;
            cout<<"Costo por minuto: "<<enlaceActual->obtenerCostoPorMinutos()<<endl;
        }
        cout << string(1, '\n');
    }
}

void Menu::detalleDeInternos(){
    this->listaCentrales->iniciarCursor();
    NodoCentral* centralActual;
    Lista<NodoInterno*>* listaInternos;
    while (this->listaCentrales->avanzarCursor()){
        centralActual=this->listaCentrales->obtenerCursor();
        cout<<"Internos de la central: "<<centralActual->obtenerNumero()<<endl;
        cout<<"---------------------------"<<endl;
        listaInternos=centralActual->devolverInternos();
        listaInternos->iniciarCursor();
        NodoInterno* internoActual;
        while (listaInternos->avanzarCursor()){
            internoActual=listaInternos->obtenerCursor();
            cout<<"Numero de interno: "<<internoActual->obtenerNombreInterno()<<endl;
            cout<<"Gastos en total: "<<internoActual->obtenerGastoTotal()<<endl;
        }
        cout << string(1, '\n');
    }
}

void Menu::detalleDeCentrales(){
    this->listaCentrales->iniciarCursor();
    NodoCentral* centralActual;
    while (this->listaCentrales->avanzarCursor()){
        centralActual=this->listaCentrales->obtenerCursor();
        cout<<"Numero de central: "<<centralActual->obtenerNumero()<<endl;
    }
}

//Procedimientos Menu

NodoInterno* Menu:: devolverInterno(NodoCentral* central, string idInterno){
    bool fin = false;
    Lista<NodoInterno*> *internos = central->devolverInternos();
    internos->iniciarCursor();
    NodoInterno* actual;
    while(internos->avanzarCursor() && !fin)
    {
        actual = internos->obtenerCursor();
        if(idInterno == actual->obtenerNombreInterno())
        {
            fin=true;
        }
    }
    return actual;
}

NodoLlamada* Menu:: devolverDetalles(NodoInterno* internoEmisor, string internoReceptor){
    bool fin = false;
    Lista<NodoLlamada*> *llamadas = internoEmisor->devolverLlamadas();
    llamadas->iniciarCursor();
    NodoLlamada* actual;
    while(llamadas->avanzarCursor() && !fin)
    {
        actual = llamadas->obtenerCursor();
        if(internoReceptor == actual->obtenerNombreInterlocutor())
        {
            fin=true;
        }
    }
    return actual;
}

NodoInterno* Menu::obtenerGastadorMaximoEnCentral(NodoCentral* central){
    int internoMayor = 0;
    NodoInterno* internoADevolver = new NodoInterno("-----");
    Lista<NodoInterno*> *internos = central->devolverInternos();
    internos->iniciarCursor();
    while(internos->avanzarCursor())
    {
        NodoInterno* interno = internos->obtenerCursor();
        if (interno->obtenerGastoTotal() > internoMayor)
        {
            internoMayor = interno->obtenerGastoTotal();
            internoADevolver = interno;
        }
    }
    return internoADevolver;
}

NodoInterno* Menu::obtenerHabladorMaximoEnCentral(NodoCentral* central){
    int internoMayor = 0;
    NodoInterno* internoADevolver = new NodoInterno("-----");
    Lista<NodoInterno*> *internos = central->devolverInternos();
    internos->iniciarCursor();
    while(internos->avanzarCursor())
    {
        NodoInterno* interno = internos->obtenerCursor();
        if (interno->obtenerTotalMinutosQueLeHablaron() > internoMayor)
        {
            internoMayor = interno->obtenerTotalMinutosQueLeHablaron();
            internoADevolver = interno;
        }
    }
    return internoADevolver;
}

NodoInterno* Menu::obtenerOcupadoMaximoEnCentral(NodoCentral* central){
    int internoMayor = 0;
    NodoInterno* internoADevolver = new NodoInterno("-----");
    Lista<NodoInterno*> *internos = central->devolverInternos();
    internos->iniciarCursor();
    while(internos->avanzarCursor())
    {
        NodoInterno* interno = internos->obtenerCursor();
        if (interno->obtenerCantidadOcupados() > internoMayor)
        {
            internoMayor = interno->obtenerCantidadOcupados();
            internoADevolver = interno;
        }
    }
    return internoADevolver;
}

void Menu::volverAlMenu(){
    cout<<"Presione una tecla para volver al menu."<<endl;
    cin>>this->volverMenu;
}

#endif // MENU_H_INCLUDED
