" 7507/9502 | 2018 1C | TP0 | Enunciado 1 "

| metaCritic pelicula1 pelicula2 pelicula3 pelicula4 votos ganador error |

error := false.
Transcript clear.

pelicula1 := Pelicula new.
pelicula1 establecerNombre: 'Back To The Future'.
pelicula1 establecerCategoria: 'Ciencia ficcion'.

pelicula2 := Pelicula new.
pelicula2 establecerNombre: 'Annie Hall'.
pelicula2 establecerCategoria: 'Comedia'.

pelicula3 := Pelicula new.
pelicula3 establecerNombre: 'Star Wars'.
pelicula3 establecerCategoria: 'Ciencia ficcion'.

pelicula4 := Pelicula new.
pelicula4 establecerNombre: 'The Big Lebowski'.
pelicula4 establecerCategoria: 'Comedia'.

metaCritic := MetaCritic new.
metaCritic agregarPelicula: pelicula1.
metaCritic agregarPelicula: pelicula2.
metaCritic agregarPelicula: pelicula3.
metaCritic agregarPelicula: pelicula4.

metaCritic votar: 'Star Wars'.
metaCritic votar: 'Back To The Future'.
metaCritic votar: 'Star Wars'.
metaCritic votar: 'The Big Lebowski'.
metaCritic votar: 'Star Wars'.
metaCritic votar: 'The Big Lebowski'.

votos := (metaCritic cantidadDeVotosDe: 'Star Wars').
(votos = 3) ifFalse: [
    Transcript show: 'Error: Star Wars debe tener 3 votos.'; cr.
	error := true.
].

votos := (metaCritic cantidadDeVotosDe: 'Back To The Future').
(votos = 1) ifFalse: [
    Transcript show: 'Error: Back To The Future debe tener un voto.'; cr.
	error := true.
].

votos := (metaCritic cantidadDeVotosDe: 'The Big Lebowski').
(votos = 2) ifFalse: [
    Transcript show: 'Error: The Big Lebowski debe tener dos votos.'; cr.
	error := true.
].

votos := (metaCritic cantidadDeVotosDe: 'Annie Hall').
(votos = 0) ifFalse: [
    Transcript show: 'Error: Annie Hall no tiene votos.'; cr.
	error := true.
].

ganador := (metaCritic ganadorEnCategoria: 'Ciencia ficcion').
(ganador = 'Star Wars') ifFalse: [
    Transcript show: 'Error: Star Wars debe ser el ganador de la categoria Ciencia Ficcion.'; cr.
	error := true.
].

ganador := (metaCritic ganadorEnCategoria: 'Comedia').
(ganador = 'The Big Lebowski') ifFalse: [
    Transcript show: 'Error: The Big Lebowski debe ser el ganador de la categoria Comedia.'; cr.
	error := true.
].

error ifTrue: [  
	Transcript show: 'Resultado final: ERROR'; cr.
]
ifFalse: [
	Transcript show: 'Resultado final: OK'; cr.
].