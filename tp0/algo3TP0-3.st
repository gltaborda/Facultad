" 7507/9502 | 2018 1C | TP0 | Enunciado 3 "

| rottenTomatoes peliculas puntaje titulo error |

error := false.
Transcript clear.

peliculas := Peliculas new.
peliculas agregarConNombre: 'Blade Runner' yDirector: 'Ridley Scott'.
peliculas agregarConNombre: 'Pulp Fiction' yDirector: 'Quentin Tarantino'.
peliculas agregarConNombre: 'Kill Bill' yDirector: 'Quentin Tarantino'.
peliculas agregarConNombre: 'The Grand Budapest Hotel' yDirector: 'Wes Anderson'.
peliculas agregarConNombre: 'Trainspotting' yDirector: 'Danny Boyle'.
peliculas agregarConNombre: 'Alien' yDirector: 'Ridley Scott'.
peliculas agregarConNombre: 'Isle of Dogs' yDirector: 'Wes Anderson'.

rottenTomatoes := RottenTomatoes new.
rottenTomatoes agregarPeliculas: peliculas.

rottenTomatoes calificarPelicula: 'Kill Bill' conPuntaje: 6.
rottenTomatoes calificarPelicula: 'Blade Runner' conPuntaje: 8.
rottenTomatoes calificarPelicula: 'Pulp Fiction' conPuntaje: 8.
rottenTomatoes calificarPelicula: 'Blade Runner' conPuntaje: 10.
rottenTomatoes calificarPelicula: 'Blade Runner' conPuntaje: 9.
rottenTomatoes calificarPelicula: 'Trainspotting' conPuntaje: 6.
rottenTomatoes calificarPelicula: 'The Grand Budapest Hotel' conPuntaje: 3.
rottenTomatoes calificarPelicula: 'Isle of Dogs' conPuntaje: 7.
rottenTomatoes calificarPelicula: 'Alien' conPuntaje: 7.
rottenTomatoes calificarPelicula: 'Trainspotting' conPuntaje: 9.
rottenTomatoes calificarPelicula: 'Kill Bill' conPuntaje: 8.

puntaje := (rottenTomatoes puntajeDelDirector: 'Quentin Tarantino'). " (6 + 8 + 8) / 3 = 7.33 "
((puntaje closeTo: 7.33) or: (puntaje closeTo: 22/3)) ifFalse: [
    Transcript show: 'Error: El puntaje promedio de Quentin Tarantino debe ser 7.33.'; cr.
	error := true.
].

puntaje := (rottenTomatoes puntajeDelDirector: 'Ridley Scott'). " (8 + 10 + 9 + 7) / 4 = 8.5 "
(puntaje closeTo: 8.5) ifFalse: [
    Transcript show: 'Error: El puntaje promedio de Ridley Scott debe ser 8.5.'; cr.
	error := true.
].

puntaje := (rottenTomatoes puntajeDelDirector: 'Wes Anderson'). " (3 + 7) / 2 = 5 "
(puntaje closeTo: 5) ifFalse: [
    Transcript show: 'Error: El puntaje promedio de Wes Anderson debe ser 5.'; cr.
	error := true.
].

puntaje := (rottenTomatoes puntajeDelDirector: 'Danny Boyle'). " (6 + 9) / 2 = 7.5 "
(puntaje closeTo: 7.5) ifFalse: [
    Transcript show: 'Error: El puntaje promedio de Danny Boyle debe ser 7.5.'; cr.
	error := true.
].

titulo := rottenTomatoes mejorPelicular.
(titulo = 'Blade Runner') ifFalse: [
    Transcript show: 'Error: La pelicula mejor puntuada debe ser Blade Runner.'; cr.
	error := true.
].

titulo := rottenTomatoes peorPelicular.
(titulo = 'The Grand Budapest Hotel') ifFalse: [
    Transcript show: 'Error: La pelicula peor puntuada debe ser The Grand Budapest Hotel.'; cr.
	error := true.
].

error ifTrue: [  
	Transcript show: 'Resultado final: ERROR'; cr.
]
ifFalse: [
	Transcript show: 'Resultado final: OK'; cr.
].