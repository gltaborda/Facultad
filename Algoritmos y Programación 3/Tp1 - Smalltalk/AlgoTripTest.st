'From Pharo6.0 of 13 May 2016 [Latest update: #60528] on 14 April 2018 at 2:09:52.350685 pm'!TestCase subclass: #AlgoTripTest	instanceVariableNames: ''	classVariableNames: ''	poolDictionaries: ''	category: 'AlgoViajesTest'!!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 13:36'!test06ViajesConAsistenciaAlViajero	| algoTrip costoEsperado |		algoTrip := AlgoTrip new.	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.	algoTrip agregarCiudad: 'Cordoba' dePais: 'Argentina' conCodigo: 'COR' latitud: -31.42 longitud: -64.18.	algoTrip agregarHotel: 'Hotel Fernet Con Cola' en: 'COR' conPrecioPorNoche: 500.		algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'COR' enFecha: '2018-6-1'.	algoTrip agregarAsistenciaAlViajeroAlViaje: 'vacaciones-2018'.		algoTrip crearViaje: 'vacaciones-2019'.	algoTrip agregarEstadiaEnViaje: 'vacaciones-2019' enHotel: 'Hotel Fernet Con Cola' desde: '2018-6-1' hasta: '2018-6-7'.	algoTrip agregarAsistenciaAlViajeroAlViaje: 'vacaciones-2019'.		algoTrip crearViaje: 'Fiesta del Fernet'.	algoTrip agregarVueloEnViaje: 'Fiesta del Fernet' de: 'BUE' a: 'COR' enFecha: '2018-8-1'.	algoTrip agregarVueloEnViaje: 'Fiesta del Fernet' de: 'COR' a: 'BUE' enFecha: '2018-8-7'.	algoTrip agregarEstadiaEnViaje: 'Fiesta del Fernet' enHotel: 'Hotel Fernet Con Cola' desde: '2018-8-1' hasta: '2018-8-7'.	algoTrip agregarAsistenciaAlViajeroAlViaje: 'Fiesta del Fernet'.		" Asistencia al viajero para vuelos: 10% del valor (ya sean internacionales o domesticos). "	costoEsperado := 645.97 * 1 * 1.1.	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).	" Asistencia al viajero para hoteles: 30 pesos por dia de estadia. "	costoEsperado := (6 * 500) + (6 * 30).	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2019') closeTo: costoEsperado precision: 0.001).	" Viaje de ida y vuelta con hotel y asistencia al viajero. "	costoEsperado := (2 * 645.97 * 1 * 1.1) + (6 * 500) + (6 * 30).	self assert: ((algoTrip obtenerCostoDelViaje: 'Fiesta del Fernet') closeTo: costoEsperado precision: 0.001).! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 14:08'!test08PaqueteConVuelosYHotel
	| algoTrip costoEsperado costoVuelos costoHotel |

	algoTrip := AlgoTrip new.	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip agregarCiudad: 'Moscu' dePais: 'Rusia' conCodigo: 'MOW' latitud: 55.75 longitud: 37.62.
	algoTrip agregarHotel: 'Matreshka Hotel' en: 'MOW' conPrecioPorNoche: 3000.	algoTrip agregarPaquete: 'Rusia 18'.	algoTrip agregarVueloEnPaquete: 'Rusia 18' de: 'BUE' a: 'MOW' enFecha: '2018-6-13'.	algoTrip agregarVueloEnPaquete: 'Rusia 18' de: 'MOW' a: 'BUE' enFecha: '2018-7-16'.	algoTrip agregarEstadiaEnPaquete: 'Rusia 18' enHotel: 'Matreshka Hotel'  desde: '2018-6-14' hasta: '2018-7-16'.
	algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarPaquete: 'Rusia 18' enViaje: 'vacaciones-2018'.	" El paquete descuenta 10% del costo de vuelos y 20% del costo de hotel. "	costoVuelos := 2 * (13475.12 * 1.5 * 1.05).	costoHotel := (32 * 3000).	costoEsperado := (0.9 * costoVuelos) + (0.8 * costoHotel).	
	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).		" El viaje dura 34 dias. "	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 34.		algoTrip agregarAsistenciaAlViajeroAlViaje: 'vacaciones-2018'.		" El paquete bonifica la asistencia al viajero completamente. "	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 13:12'!test05ViajeConHotel
	| algoTrip costoEsperado |

	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.
	algoTrip agregarHotel: 'Copacabana Palace' en: 'RIO' conPrecioPorNoche: 3000.
	algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarEstadiaEnViaje: 'vacaciones-2018' enHotel: 'Copacabana Palace' desde: '2018-6-1' hasta: '2018-6-7'.
		" 6 noches a 3000 pesos por noche "	costoEsperado := 6 * 3000.	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).		" La estadia es de 6 noches pero el viaje es de 7 dias. "
	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 7.! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 13:46'!test07ViajeDeIdaConComidaEspecialAbordo
	| algoTrip costoEsperado |

	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.	algoTrip agregarCiudad: 'Cordoba' dePais: 'Argentina' conCodigo: 'COR' latitud: -31.42 longitud: -64.18.
	algoTrip crearViaje: 'vacaciones-2018'.
	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'COR' enFecha: '2018-6-1'.

	algoTrip solicitarComidaEspecialAbordoPara: 'vacaciones-2018'.
	" comida a bordo suma 100 pesos por vuelo"
	costoEsperado := 645.97 + 100.
	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).
	! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/13/2018 19:21'!test01ViajeVacio
	| algoTrip |
	
	algoTrip := AlgoTrip new.
	algoTrip crearViaje: 'vacaciones-2018'.		self assert: (algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: 0.	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 0.
	! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 11:12'!test03ViajeConVueloInternacional
	| algoTrip costoEsperado |
	
	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.
	algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'RIO' enFecha: '2018-6-1'.
	"costo: 1.5 peso por km para vuelos internacionales, mas 5% de impuestos"
	costoEsperado:= 1966.7 * 1.5 * 1.05.	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).
	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 1.! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 11:11'!test02ViajeConVueloDomestico
	| algoTrip costoEsperado |
	
	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip agregarCiudad: 'Cordoba' dePais: 'Argentina' conCodigo: 'COR' latitud: -31.42 longitud: -64.18.
	algoTrip crearViaje: 'vacaciones-2018'.
	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'COR' enFecha: '2018-6-1'.	
	" Costo: 1 peso por km para vuelos domesticos. La distancia se calcula con la formula del haversine. "	costoEsperado := 645.97 * 1.	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).
	" Duracion del viaje es un dia (el 1 de Junio que estamos volando). "	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 1.
! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 13:13'!test06ViajeConVueloIdaYVueltaYHotel	| algoTrip costoEsperado |		algoTrip := AlgoTrip new.	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.	algoTrip agregarHotel: 'Copacabana Palace' en: 'RIO' conPrecioPorNoche: 3000.	algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'RIO' enFecha: '2018-6-1'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'RIO' a: 'BUE' enFecha: '2018-6-6'.	algoTrip agregarEstadiaEnViaje: 'vacaciones-2018' enHotel: 'Copacabana Palace' desde: '2018-6-1' hasta: '2018-6-6'.	" Eos vuelos internacionales iguales y cinco noches de hotel. "	costoEsperado := (2 * (1966.7 * 1.5 * 1.05)) + (5 * 3000).	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).		" El viaje dura 6 dias: salimos el 1 de Junio y volvemos el 6. "	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 6.! !!AlgoTripTest methodsFor: 'tests' stamp: 'jtb 4/14/2018 13:30'!test04ViajeConVueloIdaYVuelta
	| algoTrip costoEsperado |		algoTrip := AlgoTrip new.	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.	algoTrip crearViaje: 'vacaciones-2018'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'RIO' enFecha: '2018-6-1'.	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'RIO' a: 'BUE' enFecha: '2018-6-5'.
	" Dos vuelos internacionales iguales. "
	costoEsperado := 2 * (1966.7 * 1.5 * 1.05).	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).		" El viaje dura 5 dias, incluyendo tanto el dia del primer vuelo como el del ultimo. "	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 5.
! !