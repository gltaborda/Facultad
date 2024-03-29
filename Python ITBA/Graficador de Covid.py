#Se cargan las librerías
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import datetime

#Se declaran dos constantes que contienen las fechas límite del archivo 'full_data.csv' 
FECHA_LIMITE_INICIO = pd.to_datetime('2019-12-31', format='%Y-%m-%d')
FECHA_LIMITE_FINAL = pd.to_datetime('2020-11-17', format='%Y-%m-%d')

#DEFINICION DE FUNCIONES A UTILIZAR EN EL PROGRAMA

#Se lee el CSV, se llenan los registros nulos con 0 y se le da formato a la columna de fecha
def cargarYLimpiarArchivo(nombre_archivo):
  archivo = pd.read_csv(nombre_archivo)
  archivo.fillna(0, inplace = True)
  archivo['date'] = pd.to_datetime(archivo['date'], format='%Y-%m-%d')
  return archivo

#Se verifica el país ingresado por el usuario, si el mismo no está en la columna 'location' del CSV, vuelve a pedir que lo ingrese  
def encontrarPais(pais):
  while not archivo['location'].isin([pais]).any():
    pais = input('País no encontrado, ingrese el primer país buscado nuevamente:\n')
  return pais

#Función que valida fechas ingresadas. Si se encuentran fuera del rango de las constantes, vuelve a pedir el ingreso de las mismas.
def validarFecha(fecha):
  fecha = pd.to_datetime(fecha, format='%Y-%m-%d')
  while fecha < FECHA_LIMITE_INICIO or fecha > FECHA_LIMITE_FINAL:
    fecha = input('La fecha está fuera del rango. Debe estar en el intervalo de 2019-12-31 a 2020-11-17.\nIngrese una fecha válida para el intervalo de tiempo a graficar (formato YYYY-MM-DD):\n')
    fecha = pd.to_datetime(fecha, format='%Y-%m-%d')
  return fecha

#Función que valida fecha final. Verifica que la fecha final ingresada no sea menor o igual que la fecha inicio ingresada. Si es así, vuelve a pedir su ingreso correctamente.
def validarFechaFinal(fecha_inicio, fecha_final):
  while fecha_final <= fecha_inicio:
    print('La fecha final es menor o igual a la de inicio. Debe ingresar una fecha posterior a',str(fecha_inicio)[:10])
    fecha_final = input('Ingrese el final del intervalo de tiempo a graficar (formato YYYY-MM-DD):\n')
    fecha_final = validarFecha(fecha_final)
  return fecha_final

#Función que solicita el ingreso de las fechas inicio y final. A su vez llama a las funciones de validación de fechas declaradas previamente para que su ingreso sea correcto.
def ingresarFechas():
  fecha_inicio = input('Ingrese el comienzo del intervalo de tiempo a graficar (formato YYYY-MM-DD):\n')
  fecha_inicio = validarFecha(fecha_inicio)
  fecha_final = input('Ingrese el final del intervalo de tiempo a graficar (formato YYYY-MM-DD):\n')
  fecha_final = validarFecha(fecha_final)
  fecha_final = validarFechaFinal(fecha_inicio, fecha_final)
  return fecha_inicio,fecha_final  

#Función que grafica en función de cuatro parámetros ingresados. Se coloca el título y los labels correspondientes.
def graficar(pais_a_graficar, dato_a_graficar, nombre_pais, nombre_dato):
  plt.plot(pais_a_graficar['date'] , pais_a_graficar[dato_a_graficar], label = nombre_pais)
  plt.title('Cantidad de ' + nombre_dato + ' en función del tiempo')
  plt.xlabel('Tiempo')
  plt.ylabel('Cantidad de ' + nombre_dato)
  plt.xticks(rotation=60)

#Función que genera dos listas. 'lista_intersecciones_x' guarda las fechas donde hubo intersecciones y 'lista_intersecciones_y' guarda los valores casos/muertes ocurridos en dichas fechas.
# 1. En el for se obtiene el dato de los casos/muertes para las fechas dentro del rango de cada país.
# 2. Luego, en el primer if se verifica que ninguna de las variables de datos se encuentre vacía.
# 3. Por último, en el segundo if se comparan los datos de ambos paises para verificar si se da que un país pasa a tener mas casos que el otro o si tienen valores iguales. Estos datos se guardan en las variables auxiliares 'datos_primer_pais_anterior' y 'datos_segundo_pais_anterior'
def cargarIntersecciones(rango_de_fechas, primer_pais_a_graficar, segundo_pais_a_graficar, dato_a_comparar):
  datos_primer_pais_anterior = 0
  datos_segundo_pais_anterior = 0
  lista_intersecciones_x = []
  lista_intersecciones_y = []
  for date in rango_de_fechas:
    datos_primer_pais = primer_pais_a_graficar[primer_pais_a_graficar['date'] == date][dato_a_comparar]
    datos_segundo_pais = segundo_pais_a_graficar[segundo_pais_a_graficar['date'] == date][dato_a_comparar]
    if (not datos_primer_pais.empty) and (not datos_segundo_pais.empty): 
      datos_primer_pais = int(datos_primer_pais)
      datos_segundo_pais = int(datos_segundo_pais)
      if ((datos_primer_pais != 0 or datos_segundo_pais != 0) and (datos_primer_pais == datos_segundo_pais) or (datos_primer_pais > datos_segundo_pais and datos_primer_pais_anterior < datos_segundo_pais_anterior) or (datos_primer_pais < datos_segundo_pais and datos_primer_pais_anterior > datos_segundo_pais_anterior)):
        fecha_anterior = date - datetime.timedelta(days=1)
        lista_intersecciones_x.append(fecha_anterior)
        lista_intersecciones_y.append((datos_primer_pais + datos_primer_pais_anterior)/2)
      datos_primer_pais_anterior = datos_primer_pais
      datos_segundo_pais_anterior = datos_segundo_pais
  return lista_intersecciones_x,lista_intersecciones_y

#Función que grafica la intersección entre las listas. Con el comando 'ko' se le coloca un punto de color negro.  
def graficarIntersecciones(lista_x, lista_y):
  for i in range(len(lista_x)):
    plt.plot(lista_x[i], lista_y[i], 'ko')

#Función que consulta al usuario si quiere guarda los gráficos. Si ingresa algún caracter, lo guarda en un archivo .png. 
def guardar():
  fig = plt.gcf()
  plt.show
  plt.pause(0.001)
  nombre = input("Si quiere guardar el gráfico ingrese un nombre. De lo contrario presione enter para continuar la ejecución del programa:\n")
  if nombre != '':
    fig.savefig(nombre + '.png' ,dpi=100)

#CUERPO PRINCIPAL DEL PROGRAMA

#Se "limpia" el archivo csv.
archivo = cargarYLimpiarArchivo("full_data.csv")

#Se le da una introducción al usuario con las instrucciones a llevar a cabo para utilizar correctamente el graficador. 
print('Bienvenido al graficador de COVID-19. Este programa tiene 3 funciones distintas.')
print('La función 1 permite ingresar el nombre de un país deseado. El programa realiza 2 gráficos.')
print('El primero muestra casos detectados y el segundo fallecimientos totales para ese país, ambos en función del tiempo.')
print('La función 2 permite ingresar 2 países y el intervalo de tiempo deseado. A partir de estos datos el programa realiza 2 gráficos.')
print('El primero muestra casos detectados y el segundo fallecimientos totales para ambos países, ambos en función del tiempo. Además, marca las intersecciones entre las curvas.')
print('La función 3 permite ingresar hasta 10 países y el intervalo de tiempo deseado. A partir de estos datos el programa realiza 1 gráfico')
print('El gráfico incluye a todos los países y muestra sus casos totales en función del tiempo en una escala logarítmica.')

#Se hace un while con 3 valores para que el usuario pueda elegir la funcionalidad que quiera.
funcion = 1
while funcion == 1 or funcion == 2 or funcion == 3:
  funcion = int(input('Ingrese el número de la función que quiera realizar, o un número distinto para salir:\n'))

#PUNTO 1: Se grafica unicamente un país que ingrese el usuario.  
  if funcion == 1:
    pais_buscado = input('Ingrese el país del cual quiere realizar el gráfico:\n')
    pais_buscado = encontrarPais(pais_buscado)
    pais_a_graficar = archivo[archivo['location'] == pais_buscado]

    plt.figure(figsize = (25, 10))
    plt.subplot(1, 2, 1)
    graficar(pais_a_graficar, 'total_cases', pais_buscado, 'casos')
    plt.subplot(1, 2, 2)
    graficar(pais_a_graficar, 'total_deaths', pais_buscado, 'muertes')

    guardar()

#PUNTO 2: Se grafican los 2 paises que ingrese el usuario, asi como las intersecciones entre los mismos.
  elif funcion == 2:
    primer_pais_buscado = input('Ingrese el país del cual quiere realizar el gráfico:\n')
    primer_pais_buscado = encontrarPais(primer_pais_buscado)
    segundo_pais_buscado = input('Ingrese el país del cual quiere realizar el gráfico:\n')
    segundo_pais_buscado = encontrarPais(segundo_pais_buscado)

    fecha_inicio,fecha_final = ingresarFechas()

    daterange = pd.date_range(fecha_inicio, fecha_final)
    archivo_con_intervalo = archivo[(archivo['date'] >= fecha_inicio) & (archivo['date'] <= fecha_final)]

    primer_pais_a_graficar = archivo_con_intervalo[archivo_con_intervalo['location'] == primer_pais_buscado]
    segundo_pais_a_graficar = archivo_con_intervalo[archivo_con_intervalo['location'] == segundo_pais_buscado]

#Se llama a 'cargarIntersecciones' para la cantidad de casos.
    lista_intersecciones_x,lista_intersecciones_y = cargarIntersecciones(daterange, primer_pais_a_graficar, segundo_pais_a_graficar, 'total_cases')
    plt.figure(figsize = (25, 10))
    plt.subplot(1, 2, 1)
    graficar(primer_pais_a_graficar, 'total_cases', primer_pais_buscado, 'casos')
    graficar(segundo_pais_a_graficar, 'total_cases', segundo_pais_buscado, 'casos')
    graficarIntersecciones(lista_intersecciones_x, lista_intersecciones_y)
    plt.legend()

#Se llama a 'cargarIntersecciones' para la cantidad de muertes.
    lista_intersecciones_x,lista_intersecciones_y = cargarIntersecciones(daterange, primer_pais_a_graficar, segundo_pais_a_graficar, 'total_deaths')
    plt.subplot(1, 2, 2)
    graficar(primer_pais_a_graficar, 'total_deaths', primer_pais_buscado, 'muertes')
    graficar(segundo_pais_a_graficar, 'total_deaths', segundo_pais_buscado, 'muertes')
    graficarIntersecciones(lista_intersecciones_x, lista_intersecciones_y)
    plt.legend()

    guardar()

#PUNTO 3: Se grafica la cantidad de paises que quiera ver el usuario. Se puso un máximo de 10 para que el grafico sea legible. Si ingresa una cantidad distina, se le vuelve a solicitar que ingrese la cantidad correcta.
        # Se guarda los paises ingresados en una lista, y se la recorre con un for para graficarlos. 
  elif funcion == 3:
    lista_paises = []
    cantidad_paises = int(input('Ingrese la cantidad de países a buscar (máximo 10):\n'))
    while cantidad_paises < 1 or cantidad_paises > 10:
      cantidad_paises = int(input('Cantidad inválida, ingrese la cantidad de países a buscar (máximo 10):\n'))
    for x in range(cantidad_paises):
      pais_buscado = input('Ingrese el país del cual quiere realizar el gráfico:\n')
      pais_buscado = encontrarPais(pais_buscado)
      lista_paises.append(pais_buscado)

    fecha_inicio,fecha_final = ingresarFechas()

    archivo_con_intervalo = archivo[(archivo['date'] >= fecha_inicio) & (archivo['date'] <= fecha_final)]

    plt.figure(figsize = (25, 10))
    for pais in lista_paises:
      pais_a_graficar = archivo_con_intervalo[archivo_con_intervalo['location'] == pais]
      graficar(pais_a_graficar, 'total_cases', pais, 'casos')
      plt.yscale('log')
      plt.legend()

    guardar()

#Si el usuario decide salir del graficador, se le da un mensaje de despedida.
print('Gracias por usar el graficador. Hasta la próxima.')