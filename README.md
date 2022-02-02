Instrucciones para ejecutar la API:

1. Abrir un Postman o una herramienta para hacer llamado de API
2. En metodo colocar POST
3. En direccion colocar la siguiente URL
http://mutantapplicationdb-env.eba-thmsfghc.us-east-2.elasticbeanstalk.com/api-analyze-mutant/mutant
4. En body colocar raw -> JSON y colocar el siguiente request
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
5. Puede modificar los valores del DNA y hacer las pruebas correspondientes
6. Verificar los resultados
7. Para verificar la base de datos ingresar a la siguiente url desde el navegador
http://mutantapplicationdb-env.eba-thmsfghc.us-east-2.elasticbeanstalk.com/h2-console/login.jsp?jsessionid=9c3a11e08ee3d2ba4e1f1c6d04d5b48a
8. Ingresar los siguientes valores 
username: sa
password: password
JDBC URL: jdbc:h2:mem:dbadnmutant
9. Verificar la base de datos
10. Para la ejecución del otro servicio, abrir una nueva pestaña en postman
11. Colocar el metodo GET
12. Colocar la siguiente URL en la direccion
http://mutantapplicationdb-env.eba-thmsfghc.us-east-2.elasticbeanstalk.com/api-analyze-mutant/stats
13. Verificar los resultados
