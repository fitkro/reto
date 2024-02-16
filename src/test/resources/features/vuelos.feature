Feature: Despegar reto

    @vuelos
    Scenario Outline: Realizo el proceso de un vuelo hasta el pago
        Given Ingreso a la pagina "https://www.latamairlines.com/co/es"
        And Ingreso a vuelos
        And El origen del vuelo es "<Origen>" y el destino es "<Destino>"
        And Seleccionar fecha random y buscar
        And escoger el vuelo de ida menor a "<Precio_Ida>" COP
        And escoger el vuelo de vuelta menor a "<Precio_Vuelta>" COP
        And elegir asientos random
        And elegir equipaje
        And informacion pasajero nombre "<Nombre>", apellido "<Apellido>", fecha "<Fecha_Nacimiento>", documento "<Documento>", email "<Email>" y telefono "<Telefono>"
        And pago con tarjeta de credito tarjeta "<Tarjeta>", nombre y apellido "<Nombre_Apellido>", expiracion "<Expiracion>" y CVV "<CVV>"

        Examples:
            | Origen              | Destino            | Precio_Ida | Precio_Vuelta | Nombre | Apellido | Fecha_Nacimiento | Documento    | Email            | Telefono    | Tarjeta          | Nombre_Apellido | Expiracion | CVV   |
            | Pasto, PSO - Colombia | Bogotá, BOG - Colombia | 300000     | 250000        | Test   | Example  | 12-02-1970      | 12727272712 | test@gmail.com | 3214235652 | 3783737637636767 | Home Test       | 0230       | 234   |

#    @cargaDatosCSV
#        @vuelos_po
#    Scenario Outline: Realizo el proceso de un vuelo hasta el pago
#        Given Ingreso a la pagina "https://www.latamairlines.com/co/es"
##        And El origen del vuelo es "<Origen>" y el destino es "<Destino>"
#        And Realizo el proceso de un vuelo hasta el pago
#
#        Examples:
#            | Origen      | Destino|
#            | <Origen_1>  | <Destino_1>|

    @paquetes
    Scenario: Realizo el proceso de un vuelo hasta el pago
        Given Ingreso a la pagina "https://www.despegar.com.co/"
        And Ingreso a paquetes
        And Seleccionar fecha random
        And El origen del vuelo es "Pasto, Nariño, Colombia" y el destino es "Medellín, Antioquia"

#  URL: https://www.despegar.com.co/
#  1. Ingresar a la página.
#  2. Realizar búsqueda según la opción requerida ingresadas en el caso de prueba
#  a ejecutar. La automatización debe permitir seleccionar servicio de alojamiento,
#  vuelos o paquetes (Piense en cada una de estas como una característica de cada
#  feature), luego de seleccionar uno (de forma aleatoria que este en el rango como
#  se especifica en el siguiente paso) y por consiguiente, ingresar los datos
#  solicitados dependiendo del flujo de compra.
#  3. Al momento de hacer la búsqueda, la automatización debe tener la opción de
#  seleccionar cualquiera de los resultados de la búsqueda, bien sea con nombre del
#  hotel o el precio más cercano por debajo al esperado a reservar (Tenga en cuenta
#  que estos son escenarios).
#  Ejemplo: Si requiero un vuelo y el presupuesto ingresado es de $500.000, debo
#  buscar entre los resultados de la búsqueda un valor cercano a ese precio por
#  debajo. NO SE PUEDE APLICAR FILTRO PARA NINGUNO DE LAS OPCIONES.
#  4. Se deben diligenciar todos los campos para el pago, por método tarjeta de
#  crédito. (Las demás son opcionales)
#  5. Todos los campos presentados para la compra deben ser diligenciados
#  (información personal).
#  6. No es necesario finalizar el flujo de compra, con diligenciar la información de
#  compra, se da por finalizada la ejecución.
#
#  Pautas del reto:
#  -Para la asignación de los datos de búsqueda, puede usar un indicador en sus
#  esquemas de escenario, en el cual apunte a ese archivo externo, o lo sobre
#  escriba en el escenario escrito en el feature.
#
#  -Maneje un archivo .conf o .properties para los drivers, este reto debe descargarlo
#  de forma automáticas y no depender de que tenga la misma versión de driver en
#  su proyecto y el equipo que lo ejecutará.
#
#  Considere entregar el reto compartiendo la url del repositorio, el cuál debe tener
#  un guía en el readme de que se construyó, con qué librerías y como es su
#  compilación, así como consideraciones si son necesarias.
#
#  Criterios técnicos bajo los que se evaluara el reto:
#  1. Se requiere implementar el uso de las siguientes Herramientas:
#   Lenguaje: Java
#   Tipo de proyecto: Deseable Maven
#   Framework de ejecución: Junit
#   Framework de pruebas: Serenity/Selenium
#   Driver o navegador: Chrome
#   Arquetipo: Page Object Model
#   Escribir HU en: Cucumber
#
#  2. Realice la ejecución de lo automatizado, con sus respectivas evidencias.
#  3. Colocar el código automatizado en un Repositorio y enviarlo. (Repositorio
#  público).
#  4. Sera un Plus que la automatización tenga en cuenta el presupuesto en los
#  resultados de la búsqueda