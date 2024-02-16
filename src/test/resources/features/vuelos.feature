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

#    @paquetes
#    Scenario Outline: Realizo el proceso de un vuelo hasta el pago
#        Given Ingreso a la pagina "https://www.latamairlines.com/co/es"
#        And Ingreso a paquetes
#        And El origen del paquete es "<Origen>" y el destino es "<Destino>"
#        And Seleccionar fecha random y buscar
##        And escoger el vuelo de ida menor a "<Precio_Ida>" COP
##        And escoger el vuelo de vuelta menor a "<Precio_Vuelta>" COP
##        And elegir asientos random
##        And elegir equipaje
##        And informacion pasajero nombre "<Nombre>", apellido "<Apellido>", fecha "<Fecha_Nacimiento>", documento "<Documento>", email "<Email>" y telefono "<Telefono>"
##        And pago con tarjeta de credito tarjeta "<Tarjeta>", nombre y apellido "<Nombre_Apellido>", expiracion "<Expiracion>" y CVV "<CVV>"
#
#        Examples:
#            | Origen              | Destino            | Precio_Ida | Precio_Vuelta | Nombre | Apellido | Fecha_Nacimiento | Documento    | Email            | Telefono    | Tarjeta          | Nombre_Apellido | Expiracion | CVV   |
#            | Pasto | Bogotá| 300000     | 250000        | Test   | Example  | 12-02-1970      | 12727272712 | test@gmail.com | 3214235652 | 3783737637636767 | Home Test       | 0230       | 234   |

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
