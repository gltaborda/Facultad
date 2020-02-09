" 7507/9502 | 2018 1C | TP0 | Enunciado 2 "

| almacen producto1 producto2 producto3 pedido1 pedido2 precio stock error |

error := false.
Transcript clear.

producto1 := Producto new.
producto1 establecerNombre: 'Galletitas Oreo'.
producto1 establecerPrecio: 20.5.

producto2 := Producto new.
producto2 establecerNombre: 'Harina 0000'.
producto2 establecerPrecio: 8.5.

producto3 := Producto new.
producto3 establecerNombre: 'Tubo de papas Pringles'.
producto3 establecerPrecio: 45.8.

almacen := Almacen new.
almacen establecerNombre: 'Almacen Don Carlos'.
almacen agregarProducto: producto1 conStock: 10.
almacen agregarProducto: producto2 conStock: 5.
almacen agregarProducto: producto3 conStock: 2.

pedido1 := Pedido new.
pedido1 agregarProducto: 'Galletitas Oreo' conCantidad: 2.
pedido1 agregarProducto: 'Harina 0000' conCantidad: 1.

pedido2 := Pedido new.
pedido2 agregarProducto: 'Galletitas Oreo' conCantidad: 1.
pedido2 agregarProducto: 'Tubo de papas Pringles' conCantidad: 2.
pedido2 agregarProducto: 'Harina 0000' conCantidad: 1.

precio := almacen cobrar: pedido1. " 20.5 * 2 + 8.5 * 1 = 49.5 "
(precio closeTo: 49.5) ifFalse: [
    Transcript show: 'Error: El precio del primer pedido debe ser 49.5.'; cr.
	error := true.
].

precio := almacen cobrar: pedido2. " 20.5 * 1 + 45.8 * 2 + 8.5 * 1 = 120.6 "
(precio closeTo: 120.6) ifFalse: [
    Transcript show: 'Error: El precio del segundo pedido debe ser 120.6.'; cr.
	error := true.
].

stock := almacen obtenerStockDelProducto: 'Galletitas Oreo'.
(stock = 7) ifFalse: [
    Transcript show: 'Error: El stock final del producto Galletitas Oreo debe ser 7.'; cr.
	error := true.
].

stock := almacen obtenerStockDelProducto: 'Harina 0000'.
(stock = 3) ifFalse: [
    Transcript show: 'Error: El stock final del producto Harina 0000 debe ser 3.'; cr.
	error := true.
].

stock := almacen obtenerStockDelProducto: 'Tubo de papas Pringles'.
(stock = 0) ifFalse: [
    Transcript show: 'Error: El stock final del producto Tubo de papas Pringles debe ser 0.'; cr.
	error := true.
].

error ifTrue: [  
	Transcript show: 'Resultado final: ERROR'; cr.
]
ifFalse: [
	Transcript show: 'Resultado final: OK'; cr.
].