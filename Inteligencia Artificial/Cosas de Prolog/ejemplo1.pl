padre_de(juan, pedro).
padre_de(juan, carlos).

sumar(X, Y, Z) :- Z is X +Y.

autos(renault, 2020, azul,2000).
autos(fiat, 2018, rojo, 25000).
autos(fiat, 2019, blanco, 15000).

lista_hijos(X):- padre_de(X,Y), writeln(Y), fail.
lista_hijos(X):- padre_de(X,_), writeln("Tiene hijos").
lista_hijos(X):- not(padre_de(X,_)), writeln("No tiene hijos"), fail.

%recorre una lista
reclista([]).
reclista([Ca|Co]):-writeln(Ca),reclista(Co).

%verifica si un elemento pertenece a una lista
perte([Ca|_],Ca).
perte([_|Co],E):-perte(Co, E).

%cuenta la cantidad de elementos de una lista
cuenta([], 0).
cuenta([_|Co],C):- cuenta(Co,CC), C is CC+1.

%concatena 2 listas
concatenar([],[],[]).
concatenar([], L, L).
concatenar(L, [], L).
concatenar([Ca|Co], L2, [Ca|Co3]):- concatenar(Co, L2, Co3).
