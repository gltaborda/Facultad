#ifndef FUNCIONES_H_INCLUDED
#define FUNCIONES_H_INCLUDED

#include <iostream>
#include <fstream>
#include <iostream>
#include <string>
#include <sstream>
#include <cstdlib>
#include "Lista.h"
using namespace std;

struct llamadaAProcesar{
    string evento,centralEmisora,centralReceptora,internoEmisor,internoReceptor;
    int kilometros,precio,canales,minutos;
};

#include "Llamada.h"
#include "Enlace.h"
#include "Interno.h"
#include "Central.h"
#include "Nucleo principal.h"
#include "Camino.h"
#include "Gastos.h"
#include "Menu.h"

/*
FUNCIONES
 */

void procesarArchivo( Lista<NodoCentral*>* centrales, char eleccionDeEnlace)
{
    char rutaArchivo[90];
    llamadaAProcesar LlamadaAProcesar;
    cout<<"Indique la ruta y nombre del archivo: "<<endl;
    cin>>rutaArchivo;
    string kilometros,minutos,canales,line;
    ifstream archivoLlamadas(rutaArchivo);
    if(!archivoLlamadas.is_open() )
    {
        while(!archivoLlamadas.is_open())
        {
            cout << "No se puede leer el archivo, intente nuevamente." << endl ;
            cin>>rutaArchivo;
            ifstream archivoLlamadas(rutaArchivo);
        }
    }
    else
    {
        while(getline(archivoLlamadas,line))
        {
            stringstream iss(line);
            getline(iss, LlamadaAProcesar.evento, ' ');
            if (LlamadaAProcesar.evento=="Enlace")
            {
                getline(iss, LlamadaAProcesar.centralEmisora, ' ');
                getline(iss, LlamadaAProcesar.centralReceptora, ' ');
                getline(iss, kilometros, ' ');
                getline(iss, minutos, ' ');
                getline(iss, canales, ' ');
                LlamadaAProcesar.kilometros=atoi(kilometros.c_str());
                LlamadaAProcesar.minutos=atoi(minutos.c_str());
                LlamadaAProcesar.canales=atoi(canales.c_str());
                NodoEnlace* enlaceIda = new NodoEnlace(LlamadaAProcesar.centralReceptora, LlamadaAProcesar.kilometros, LlamadaAProcesar.canales, LlamadaAProcesar.minutos);
                NodoEnlace* enlaceVuelta = new NodoEnlace(LlamadaAProcesar.centralEmisora, LlamadaAProcesar.kilometros, LlamadaAProcesar.canales, LlamadaAProcesar.minutos);
                centrales->iniciarCursor();
                bool encontradoEmisor=false;
                bool encontradoReceptor=false;
                while(centrales->avanzarCursor())  //PREGUNTA SI LA CENTRAL ESTA REPETIDA
                {
                    NodoCentral* actual = centrales->obtenerCursor();
                    if ( LlamadaAProcesar.centralEmisora == actual->obtenerNumero())
                    {
                        actual->agregarEnlace(enlaceIda);
                        encontradoEmisor=true;
                    }

                    if (LlamadaAProcesar.centralReceptora == actual->obtenerNumero())
                    {
                        actual->agregarEnlace(enlaceVuelta);
                        encontradoEmisor=true;
                    }
                }
                if (!encontradoEmisor){
                    NodoCentral* centralIda = new NodoCentral(LlamadaAProcesar.centralEmisora);
                    centralIda->agregarEnlace(enlaceIda);
                    centrales->agregar(centralIda);
                }
                if (!encontradoReceptor){
                    NodoCentral* centralVuelta = new NodoCentral(LlamadaAProcesar.centralReceptora);
                    centralVuelta->agregarEnlace(enlaceVuelta);
                    centrales->agregar(centralVuelta);
                }
            }
            else
            {
                    if (LlamadaAProcesar.evento=="Inicio"){
                        getline(iss, LlamadaAProcesar.centralEmisora, ' ');
                        getline(iss, LlamadaAProcesar.internoEmisor, ' ');
                        getline(iss, LlamadaAProcesar.centralReceptora, ' ');
                        getline(iss, LlamadaAProcesar.internoReceptor, ' ');
                        getline(iss, minutos, ' ');
                        LlamadaAProcesar.minutos=atoi(minutos.c_str());
                        NodoLlamada* nuevaLlamada = new NodoLlamada(LlamadaAProcesar);
                        if (LlamadaAProcesar.centralEmisora==LlamadaAProcesar.centralReceptora){ //PREGUNTA SI LA LLAMADA PASA EN LA MISMA CENTRAL
                            NodoCentral* central;
                            centrales->iniciarCursor();
                            bool encontrado = false;
                            while ((centrales->avanzarCursor())&& (!encontrado))
                            {
                                central=centrales->obtenerCursor();
                                if (central->obtenerNumero()==LlamadaAProcesar.centralEmisora){
                                    encontrado=true;    // UBICO LA CENTRAL DEL INTERNO EMISOR (QUE ES LA MISMA DEL RECEPTOR)
                                }
                            }
                            NodoInterno*    internoEmisor = central->obtenerInterno(LlamadaAProcesar.internoEmisor);
                            NodoInterno*    internoReceptor = central->obtenerInterno(LlamadaAProcesar.internoReceptor);
                            if (!internoEmisor){
                                internoEmisor=new NodoInterno(LlamadaAProcesar.internoEmisor);
                            }
                            if(!internoReceptor){
                                internoReceptor=new NodoInterno(LlamadaAProcesar.internoReceptor);
                            }
                            if(internoReceptor->estaOcupado()){
                                internoEmisor->elReceptorEstaOcupado();
                                internoReceptor->DiOcupado();
                                if(!central->obtenerInterno(LlamadaAProcesar.internoEmisor)){
                                    Lista<NodoInterno*>* internos=central->devolverInternos();
                                    internos->agregar(internoEmisor);
                                }
                            }else //SI EL INTERNO NO ESTA OCUPADO
                            {
                                internoEmisor->agregarLlamada(nuevaLlamada);
                                internoReceptor->cambiarOcupado();
                                if (!central->obtenerInterno(internoEmisor->obtenerNombreInterno())){
                                    Lista<NodoInterno*>* internos=central->devolverInternos();
                                    internos->agregar(internoEmisor);
                                }
                                if (!central->obtenerInterno(internoReceptor->obtenerNombreInterno())){
                                        Lista<NodoInterno*>* internos=central->devolverInternos();
                                        internos->agregar(internoReceptor);
                                }
                            }
                        }else{ //DISTINTA CENTRAL
                            NodoCentral*    centralEmisora;
                            NodoCentral*    centralReceptora;
                            centrales->iniciarCursor();
                            bool encontradoEmisor = false;
                            while ((centrales->avanzarCursor())&& (!encontradoEmisor)){
                                centralEmisora=centrales->obtenerCursor();
                                if (centralEmisora->obtenerNumero()==LlamadaAProcesar.centralEmisora){
                                    encontradoEmisor=true; //ENCUENTRA LA CENTRAL EMISORA
                                }
                            }
                            if (!encontradoEmisor){
                               centralEmisora=new NodoCentral(LlamadaAProcesar.centralEmisora);
                            }
                            centrales->iniciarCursor();
                            bool encontradoReceptor = false;
                            while ((centrales->avanzarCursor())&& (!encontradoReceptor)){
                                centralReceptora=centrales->obtenerCursor();
                                if (centralReceptora->obtenerNumero()==LlamadaAProcesar.centralReceptora ){
                                    encontradoReceptor=true; //ENCUENTRA LA CENTRAL RECEPTORA
                                }
                            }
                            if(!encontradoReceptor){
                                centralReceptora=new NodoCentral(LlamadaAProcesar.centralReceptora);
                            }
                            NodoInterno* internoEmisor= centralEmisora->obtenerInterno(LlamadaAProcesar.internoEmisor);
                            NodoInterno* internoReceptor=   centralReceptora->obtenerInterno(LlamadaAProcesar.internoReceptor);
                            if(!internoEmisor){
                                internoEmisor=new NodoInterno(LlamadaAProcesar.internoEmisor);
                            }
                            if(!internoReceptor){
                                internoReceptor=new NodoInterno(LlamadaAProcesar.internoReceptor);
                            }
                            if(internoReceptor->estaOcupado()){
                                internoEmisor->elReceptorEstaOcupado();
                                internoReceptor->DiOcupado();
                                if(!centralEmisora->obtenerInterno(internoEmisor->obtenerNombreInterno())){
                                    Lista<NodoInterno*>* internosEmisor=centralEmisora->devolverInternos();
                                    internosEmisor->agregar(internoEmisor);
                                }
                            }else{
                                NodoEnlace* enlace= new NodoEnlace();
                                Lista<NodoEnlace*> *centralEmisoraArecorrer = centralEmisora->devolverEnlaces();
                                bool encontradoEnlaceEmisor=false;
                                while ((centralEmisoraArecorrer->avanzarCursor())&&(!encontradoEnlaceEmisor))
                                {
                                    enlace = centralEmisoraArecorrer->obtenerCursor();
                                    if (enlace->obtenerNumeroCentral()== centralReceptora->obtenerNumero()){
                                        encontradoEnlaceEmisor=true;
                                    }
                                }
                                if (enlace->obtenerCantidadCanales()>0)
                                {
                                    internoEmisor->agregarLlamada(nuevaLlamada);
                                    internoReceptor->cambiarOcupado();
                                    if(!centralEmisora->obtenerInterno(internoEmisor->obtenerNombreInterno())){
                                        Lista<NodoInterno*>*    internosDelEmisor= centralEmisora->devolverInternos();
                                        internosDelEmisor->agregar(internoEmisor);
                                    }
                                    if(!centralReceptora->obtenerInterno(internoReceptor->obtenerNombreInterno())){
                                        Lista<NodoInterno*>*    internosDelReceptor=centralReceptora->devolverInternos();
                                        internosDelReceptor->agregar(internoReceptor);
                                    }
                                    enlace->restarCanal();
                                }else{
                                    centralEmisora->agregarLlamadaAnulada();
                                }
                            }
                        }
                    }else{ // FIN DE LLAMADA
                        getline(iss, LlamadaAProcesar.centralEmisora, ' ');
                        getline(iss, LlamadaAProcesar.internoEmisor, ' ');
                        getline(iss, LlamadaAProcesar.centralReceptora, ' ');
                        getline(iss, LlamadaAProcesar.internoReceptor, ' ');
                        getline(iss, minutos, ' ');
                        LlamadaAProcesar.minutos=atoi(minutos.c_str());
                        NodoCentral*    centralEmisora;
                        NodoCentral*    centralReceptora;
                        centrales->iniciarCursor();
                        bool encontradoEmisor = false;
                        while ((centrales->avanzarCursor())&& (!encontradoEmisor)){
                            centralEmisora=centrales->obtenerCursor();
                            if (centralEmisora->obtenerNumero()==LlamadaAProcesar.centralEmisora){
                                encontradoEmisor=true; //ENCUENTRA LA CENTRAL EMISORA
                            }
                        }
                        centrales->iniciarCursor();
                        bool encontradoReceptor = false;
                        while ((centrales->avanzarCursor())&& (!encontradoReceptor)){
                            centralReceptora=centrales->obtenerCursor();
                            if (centralReceptora->obtenerNumero()==LlamadaAProcesar.centralReceptora ){
                                encontradoReceptor=true;  //ENCUENTRA LA CENTRAL RECEPTORA
                            }
                        }
                        NodoInterno* internoEmisor= centralEmisora->obtenerInterno(LlamadaAProcesar.internoEmisor);
                        NodoInterno* internoReceptor= centralReceptora->obtenerInterno(LlamadaAProcesar.internoReceptor);
                        internoEmisor->sumarMinutos(LlamadaAProcesar);
                        internoReceptor->cambiarOcupado();
                        NodoLlamada* llamadaEntreAmbos=internoEmisor->buscarLlamada(internoReceptor->obtenerNombreInterno(),centralReceptora->obtenerNumero());
                        internoReceptor->agregarLlamadaRecibida(llamadaEntreAmbos);
                    }
                }
        }
        // ESTABLECIMIENTO DE COSTO DE LLAMADA
        Gastos costeDeLlamadas (centrales, eleccionDeEnlace);
        costeDeLlamadas.establecerCostos();
        archivoLlamadas.close();
    }
}

#endif // FUNCIONES_H_INCLUDED
