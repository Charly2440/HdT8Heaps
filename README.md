# Sistema de Gestión de Pacientes

Este es un sistema de gestión de pacientes que permite agregar nuevos pacientes, atender pacientes en función de su prioridad y cargar pacientes desde un archivo de texto.

## Ejemplo de archivo de texto

Puedes crear un archivo de texto con los nombres de los pacientes y sus respectivos padecimientos en el siguiente formato:

Juan Perez, fractura de pierna, C
Maria Ramirez, apendicitis, A
Lorenzo Toledo, chikungunya, E
Carmen Sarmientos, dolores de parto, B


Cada línea del archivo representa un paciente con el siguiente formato: `nombre, condición, prioridad`.

## Cómo ejecutar el programa

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido.
3. Compila y ejecuta el archivo `App.java`.
4. Sigue las instrucciones en pantalla para utilizar el sistema de gestión de pacientes.

## Funcionalidades principales

- **Agregar paciente:** Permite agregar un nuevo paciente al sistema ingresando su nombre, condición y prioridad.
- **Atender paciente (VectorHeap):** Atiende al paciente con mayor prioridad utilizando una implementación de cola de prioridad basada en VectorHeap.
- **Atender paciente (Java Collections):** Atiende al paciente con mayor prioridad utilizando una implementación de cola de prioridad basada en PriorityQueue de Java Collections.

## Contribuciones

Si deseas contribuir al proyecto, puedes enviar pull requests o abrir issues en el repositorio de GitHub.

¡Gracias por usar nuestro sistema de gestión de pacientes!
