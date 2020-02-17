#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
#include "Funciones.h"


int main()
{
	char eleccionDeEnlace = 'p';
	while (eleccionDeEnlace != '1' && eleccionDeEnlace != '2')
	{
	    cout << "Presione la tecla 1 para cargar los datos con: Camino mas economico" << endl << "Presione la tecla 2 para cargar los datos con: Camino mas corto" << endl;
        cin >> eleccionDeEnlace;
    }
	Lista<NodoCentral*>* listaCentrales =new Lista<NodoCentral*>();
    procesarArchivo(listaCentrales, eleccionDeEnlace);
	Menu Menu(listaCentrales);
	Menu.mostrarMenu();
	return 0;
}
