#include "Funciones.h"
#include <fstream>
#include <sstream>

void menu(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int opcionMenu=15;
    while (opcionMenu!=13){
        cout<<"Ingrese el numero de la opcion deseada: "<<endl;
        cout<<"1.   Detallar llamadas entre interno X y el interno Y."<<endl;
        cout<<"2.   Interno que mas hablo."<<endl;
        cout<<"3.   Interno que mas llamo."<<endl;
        cout<<"4.   Interno que mas le dio ocupado un intento."<<endl;
        cout<<"5.   Interno al que mas llamaron."<<endl;
        cout<<"6.   Interno al que mas le hablaron."<<endl;
        cout<<"7.   Interno que mas dio ocupado."<<endl;
        cout<<"8.   Detallar llamadas emitidas por X."<<endl;
        cout<<"9.   Detallar llamadas recibidas por X."<<endl;
        cout<<"10.  Detallar llamadas realizadas de X a Y."<<endl;
        cout<<"11.  Detallar llamadas recibidas por Y y realizadas por X."<<endl;
        cout<<"12.  Imprimir Detalle de internos."<<endl;
        cout<<"13.  Salir"<<endl;
        cin>>opcionMenu;
        while ((opcionMenu<1) || (opcionMenu>13)){
            cout<<"Opcion invàlida, ingrese nuevamente: "<<endl;
            cin>>opcionMenu;
        }
        switch (opcionMenu){
            case 1:{
                detalleLlamadasEntreXeY(matrizInternos,vectorNombres);
                break;
                }
            case 2:{
                internoMasHablo(matrizInternos,vectorNombres);
                break;
                }
            case 3:{
                internoQueMasLlamo(matrizInternos,vectorNombres);
                break;
                }
            case 4:{
                masDioOcupadoUnIntento(matrizInternos,vectorNombres);
                break;
                }
            case 5:{
                alQueMasLlamaron(matrizInternos,vectorNombres);
                break;
                }
            case 6:{
                masTiempoLeHablaron(matrizInternos,vectorNombres);
                break;
                }
            case 7:{
                masDioOcupado(matrizInternos,vectorNombres);
                break;
                }
            case 8:{
                detalleLlamadasEmitidasPorX(matrizInternos,vectorNombres);
                break;
                }
            case 9:{
                detalleLlamadasRecibidasPorX(matrizInternos,vectorNombres);
                break;
                }
            case 10:{
                detalleLlamadasDeXaY(matrizInternos,vectorNombres);
                break;
                }
            case 11:{
                llamadasRecibidasPorYyRealizadasPorX(matrizInternos,vectorNombres);
                break;
                }
            case 12:{
                detallarInternos(vectorNombres);
                break;
                }
        }
    }
}

void inicializarMatriz(structInterno matrizInternos[10][10]){
    int fila,columna;
    for(fila=0;fila<=9;fila++){
        for(columna=0;columna<=9;columna++){
            matrizInternos[fila][columna].llamadasRealizadas=0;
            matrizInternos[fila][columna].minutosHablados=0;
            matrizInternos[fila][columna].ocupados=0;
            matrizInternos[fila][columna].inicioLlamadaMinutos=0;
            matrizInternos[fila][columna].ocupado=false;
        }
    }

}

void inicializarVector(nombreInterno vectorNombres[10]){
    int contador;
    for(contador=1;contador<=9;contador++){
            vectorNombres[contador].numero=0;
            vectorNombres[contador].nombre="";
    }
}


void procesarLlamadaEnMatriz(structInterno matrizInternos[10][10],llamada structLlamada,nombreInterno vectorNombres[10]){
    int numeroInternoX,numeroInternoY;
    numeroInternoX=convertirNombreANumero(vectorNombres,structLlamada.internoX);
    numeroInternoY=convertirNombreANumero(vectorNombres,structLlamada.internoY);
    if(structLlamada.inicioFin=="Inicio"){
        if (!matrizInternos[numeroInternoX][numeroInternoY].ocupado){
            matrizInternos[numeroInternoX][numeroInternoY].inicioLlamadaMinutos=structLlamada.minutos;
            matrizInternos[numeroInternoX][numeroInternoY].llamadasRealizadas=matrizInternos[numeroInternoX][numeroInternoY].llamadasRealizadas+1;
            matrizInternos[numeroInternoX][numeroInternoY].ocupado=true;
        }
        else{
            matrizInternos[numeroInternoX][numeroInternoY].ocupados=matrizInternos[numeroInternoX][numeroInternoY].ocupados+1;
        }
    }else{
        matrizInternos[numeroInternoX][numeroInternoY].minutosHablados=matrizInternos[numeroInternoX][numeroInternoY].minutosHablados+(structLlamada.minutos-matrizInternos[numeroInternoX][numeroInternoY].inicioLlamadaMinutos);
        matrizInternos[numeroInternoX][numeroInternoY].inicioLlamadaMinutos=0;
    }
}

void ingresarNombreEnVector(llamada structLlamada, nombreInterno vectorNombres[10]){
    bool encontrado=false;
    int contadorVector=0;
    if(structLlamada.inicioFin=="Inicio"){
                contadorVector=0;
                encontrado=false;
                while ((!encontrado) && (vectorNombres[contadorVector].nombre!="")){
                    if (structLlamada.internoX==vectorNombres[contadorVector].nombre){
                        encontrado=true;
                    }
                    contadorVector++;
                }
                if (!encontrado){
                    vectorNombres[contadorVector].nombre=structLlamada.internoX;
                    vectorNombres[contadorVector].numero=contadorVector+100;
                }
                contadorVector=0;
                encontrado=false;
                while ((!encontrado) && (vectorNombres[contadorVector].nombre!="")){
                    if (structLlamada.internoY==vectorNombres[contadorVector].nombre){
                        encontrado=true;
                    }
                    contadorVector++;
                }
                if (!encontrado){
                    vectorNombres[contadorVector].nombre=structLlamada.internoY;
                    vectorNombres[contadorVector].numero=contadorVector+100;
                }
    }
}

void procesarArchivo(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    string rutaArchivo;
    string palabra;
    llamada structLlamada;
    cout<<"Indique la ruta y nombre del archivo: "<<endl;
    cin>>rutaArchivo;
    ifstream archivoLlamadas(rutaArchivo.c_str());
    string minutos, line;
    if(!archivoLlamadas.is_open() ){
        while(!archivoLlamadas.is_open()){
            cout << "No se puede leer el archivo, intente nuevamente." << endl ;
            cin>>rutaArchivo;
        }
    }
    else
    {
        while(getline(archivoLlamadas,line))
        {
            stringstream iss(line);
            getline(iss, structLlamada.inicioFin, ' ');
            getline(iss, structLlamada.internoX, ' ');
            getline(iss, structLlamada.internoY, ' ');
            getline(iss, minutos, '\n');
            structLlamada.minutos= atoi(minutos.c_str());
            ingresarNombreEnVector(structLlamada,vectorNombres);
            procesarLlamadaEnMatriz(matrizInternos,structLlamada,vectorNombres);
        }
    }
    archivoLlamadas.close();
}



int convertirNombreANumero(nombreInterno vectorNombres[10],string nombreAConvertir){
    int contador=0;
    while (nombreAConvertir!=vectorNombres[contador].nombre){
        contador++;
    }
    return contador;
}


void convertirNumeroANombre(int numeroAConvertir, nombreInterno vectorNombres[10],string* nombreInterno){
    switch (numeroAConvertir){
        case 0: case 100:   {
                                *nombreInterno=vectorNombres[0].nombre;
                                break;
                            }
        case 1: case 101:   {
                                *nombreInterno=vectorNombres[1].nombre;
                                break;
                            }
        case 2: case 102:   {
                                *nombreInterno=vectorNombres[2].nombre;
                                break;
                            }
        case 3: case 103:   {
                                *nombreInterno=vectorNombres[3].nombre;
                                break;
                            }
        case 4: case 104:   {
                                *nombreInterno=vectorNombres[4].nombre;
                                break;
                            }
        case 5: case 105:   {
                                *nombreInterno=vectorNombres[5].nombre;
                                break;
                            }
        case 6: case 106:   {
                                *nombreInterno=vectorNombres[6].nombre;
                                break;
                            }
        case 7: case 107:   {
                                *nombreInterno=vectorNombres[7].nombre;
                                break;
                            }
        case 8: case 108:   {
                                *nombreInterno=vectorNombres[8].nombre;
                                break;
                            }
        case 9: case 109:  {
                                *nombreInterno=vectorNombres[9].nombre;
                                break;
                            }
        }
}



void detalleLlamadasEntreXeY(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int cantidadLlamadas,cantidadOcupadas,minutosHablados,posX,posY;
    string internoX,internoY;
    cout<<"Ingrese el interno X: "<<endl;
    cin>>internoX;
    cout<<"Ingrese el interno Y: "<<endl;
    cin>>internoY;
    posX=convertirNombreANumero(vectorNombres,internoX);
    posY=convertirNombreANumero(vectorNombres,internoY);
    cantidadLlamadas=matrizInternos[posX][posY].llamadasRealizadas+matrizInternos[posY][posX].llamadasRealizadas;
    cantidadOcupadas=matrizInternos[posX][posY].ocupados+matrizInternos[posY][posX].ocupados;
    minutosHablados=matrizInternos[posX][posY].minutosHablados+matrizInternos[posY][posX].minutosHablados;
    cout<<endl;
    cout<<"Cantidad de llamadas: "<<cantidadLlamadas<<endl;
    cout<<"Cantidad de veces ocupadas: "<<cantidadOcupadas<<endl;
    cout<<"Minutos hablados: "<<minutosHablados<<endl;
    cout<<endl;
    }

void internoMasHablo(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,internoMinutosMaximos;
    string interno;
    maximo=0;
    comparador=0;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador1][contador2].minutosHablados+matrizInternos[contador2][contador1].minutosHablados;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            internoMinutosMaximos=contador1+100;
        }
    }
    convertirNumeroANombre(internoMinutosMaximos,vectorNombres,&interno);
    cout<<"El interno que mas hablo fue: "<<interno<<endl;
}

void internoQueMasLlamo(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,masLlamo;
    string interno;
    maximo=0;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador1][contador2].llamadasRealizadas;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            masLlamo=contador1+100;
        }
    }
    convertirNumeroANombre(masLlamo,vectorNombres,&interno);
    cout<<"El interno que mas llamo es: "<<interno<<endl;
}

void masDioOcupadoUnIntento(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,internoMasDioOcupado;
    maximo=0;
    string interno;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador1][contador2].ocupados;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            internoMasDioOcupado=contador1+100;
        }
    }
    convertirNumeroANombre(internoMasDioOcupado,vectorNombres,&interno);
    cout<<"El interno que mas dio ocupado un intenro es: "<<interno<<endl;
}

void alQueMasLlamaron(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,internoMasLlamado;
    string interno;
    maximo=0;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador2][contador1].llamadasRealizadas;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            internoMasLlamado=contador1+100;
        }
    }
    convertirNumeroANombre(internoMasLlamado,vectorNombres,&interno);
    cout<<"El interno que mas llamadas recibio es: "<<interno<<endl;
}

void masTiempoLeHablaron(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,internoMasHablado;
    string interno;
    maximo=0;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador2][contador1].minutosHablados;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            internoMasHablado=contador1+100;
        }
    }
    convertirNumeroANombre(internoMasHablado,vectorNombres,&interno);
    cout<<"El interno al que mas le hablaron es: "<<interno<<endl;
}

void masDioOcupado(structInterno matrizInternos[10][10],nombreInterno vectorNombres[10]){
    int maximo,comparador,contador1,contador2,internoMasOcupado;
    string interno;
    maximo=0;
    for (contador1=0;contador1<10;contador1++){
        comparador=0;
        for (contador2=0;contador2<10;contador2++){
            if(contador1!=contador2){
                comparador=comparador+matrizInternos[contador2][contador1].ocupados;
            }
        }
        if (comparador>maximo){
            maximo=comparador;
            internoMasOcupado=contador1+100;
        }
    }
    convertirNumeroANombre(internoMasOcupado,vectorNombres,&interno);
    cout<<"El interno que mas dio ocupado es: "<<interno<<endl;
}

void detalleLlamadasEmitidasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int contador,numInterno;
    string internoX,internoY;
    cout<<"Ingrese el interno : "<<endl;
    cin>>internoX;
    numInterno=convertirNombreANumero(vectorNombres,internoX);
    for(contador=0;contador<10;contador++){
        if(contador!=numInterno){
            convertirNumeroANombre(contador,vectorNombres,&internoY);
            cout<<"Llamadas emitidas a "<<internoY<<" : "<<matrizInternos[numInterno][contador].llamadasRealizadas<<endl;
            cout<<"Llamadas Ocupadas a "<<internoY<<" : "<<matrizInternos[numInterno][contador].ocupados<<endl;
            cout<<"Minutos Hablados con : "<<internoY<<" : "<<matrizInternos[numInterno][contador].minutosHablados<<endl;
            cout<<endl;
        }
    }
}

void detalleLlamadasRecibidasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int contador,numeroInterno;
    string internoX,nombreEmisor;
    cout<<"Ingrese el interno : "<<endl;
    cin>>internoX;
    numeroInterno=convertirNombreANumero(vectorNombres,internoX);
    for(contador=0;contador<10;contador++){
        if(contador!=numeroInterno){
            convertirNumeroANombre(contador,vectorNombres,&nombreEmisor);
            cout<<"Llamadas recibidas por "<<nombreEmisor<<" : "<<matrizInternos[contador][numeroInterno].llamadasRealizadas<<endl;
            cout<<"Llamadas Ocupadas a "<<nombreEmisor<<" : "<<matrizInternos[contador][numeroInterno].ocupados<<endl;
            cout<<"Minutos Hablados a "<<nombreEmisor<<" : "<<matrizInternos[contador][numeroInterno].minutosHablados<<endl;
            cout<<endl;
        }
    }
}

void detalleLlamadasDeXaY(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int numeroInternoX,numeroInternoY;
    string internoX,internoY;
    cout<<"Ingrese el interno X: "<<endl;
    cin>>internoX;
    cout<<"Ingrese el interno Y: "<<endl;
    cin>>internoY;
    numeroInternoX=convertirNombreANumero(vectorNombres,internoX);
    numeroInternoY=convertirNombreANumero(vectorNombres,internoY);
    cout<<"Llamadas realizadas de "<<internoX<<" a "<<internoY<<" : "<<matrizInternos[numeroInternoX][numeroInternoY].llamadasRealizadas<<endl;
    cout<<"Llamadas que dieron ocupadas de "<<internoX<<" a "<<internoY<<" : "<<matrizInternos[numeroInternoX][numeroInternoY].ocupados<<endl;
    cout<<"Minutos hablados entre "<<internoX<<" y "<<internoY<<" : "<<matrizInternos[numeroInternoX][numeroInternoY].minutosHablados<<endl;
    cout<<endl;
}

void llamadasRecibidasPorYyRealizadasPorX(structInterno matrizInternos[10][10], nombreInterno vectorNombres[10]){
    int numeroInternoX,numeroInternoY,contador;
    string internoX,internoY;
    cout<<"Ingrese el interno X: "<<endl;
    cin>>internoX;
    cout<<"Ingrese el interno Y: "<<endl;
    cin>>internoY;
    numeroInternoX=convertirNombreANumero(vectorNombres,internoX);
    numeroInternoY=convertirNombreANumero(vectorNombres,internoY);
    cout<<endl;
    for(contador=0;contador<10;contador++){
        string nombreContador;
        convertirNumeroANombre(contador,vectorNombres,&nombreContador);
        if (contador!=numeroInternoY){
            cout<<"Llamadas recibidas por "<<internoY<<" y realizada por "<<nombreContador<<" : "<<matrizInternos[contador][numeroInternoY].llamadasRealizadas<<endl;
        }
    }
    cout<<endl;
    for(contador=0;contador<10;contador++){
        string nombreContador;
        convertirNumeroANombre(contador,vectorNombres,&nombreContador);
        if (contador!=numeroInternoX){
            cout<<"Llamadas realizadas por "<<internoX<<" y recibidas por "<<nombreContador<<" : "<<matrizInternos[numeroInternoX][contador].llamadasRealizadas<<endl;
        }
    }
    cout<<endl;
}

void detallarInternos(nombreInterno vectorNombres[]){
    int contador;
    for (contador=0;contador<10;contador++){
            cout<<"Interno numero "<<vectorNombres[contador].numero<<" = "<<vectorNombres[contador].nombre<<endl;
            cout<<endl;
    }
}
