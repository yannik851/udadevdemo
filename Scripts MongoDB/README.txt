Este directorio contiene dos scripts de carga de datos para las colecciones
usadas en el DEMO exclusivo de MONGODB para importarlos en el servicio
de mongo se debe ejecutar la siguiente linea de comandos haciendo
uso del utilitario "mongoimport"

mongoimport --collection problema --file problema.json --db udadevdemo

mongoimport --collection tipoProblema --file tipoProblema.json --db udadevdemo


