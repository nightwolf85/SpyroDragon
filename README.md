# Spyro the Dragon - Companion App

## Introducción
Esta aplicación es una guía interactiva y enciclopedia visual dedicada al universo de **Spyro the Dragon**. El propósito principal es ofrecer a los usuarios información detallada sobre los personajes, mundos y coleccionables del juego, 
integrando una experiencia de usuario fluida y elementos interactivos ocultos (Easter Eggs).

## Características principales
- **Guía de Inicio Interactiva:** Un recorrido paso a paso para nuevos usuarios que utiliza animaciones y sonidos para explicar las secciones de la app.
- **Sección de Personajes:** Lista detallada de héroes y villanos gestionada mediante un `RecyclerView`.
- **Explorador de Mundos:** Información sobre los niveles del juego cargada dinámicamente desde archivos XML.
- **Coleccionables:** Listado de los objetos icónicos de la saga.
- **Easter Eggs:** 
	- **Vídeo Secreto:** Activado mediante un triple clic en la pestaña de mundos.
	- **Magia de Ripto:** Animación avanzada con **Canvas** que se activa mediante pulsación larga sobre el villano Ripto.

## Tecnologías utilizadas
- **Kotlin:** Lenguaje principal de desarrollo.
- **Navigation Component:** Gestión de fragmentos y flujo de navegación.
- **View Binding:** Acceso seguro a las vistas del layout.
- **Multimedia:** Uso de `VideoView` para vídeo y `MediaPlayer` para efectos de sonido.
- **Gráficos en 2D:** Implementación de dibujos dinámicos y animaciones mediante la clase `Canvas`.
- **SharedPreferences:** Persistencia para asegurar que la guía solo se muestre una vez.

## Instrucciones de uso
1. Clonar el repositorio:  
   `git clone https://github.com/tu-usuario/SpyroTheDragon.git`
2. Abrir el proyecto en **Android Studio (Ladybug o superior)**.
3. Sincronizar el proyecto con los archivos de **Gradle**.
4. Ejecutar en un emulador o dispositivo físico con **API 24** o superior.
5. Pulsar en comenzar en la pantalla de bienvenida, y siguiente en los siguientes apartados, para seguir la guía interactiva hasta finalizarla en el último paso. Se puede usar el botón omitir para no seguirla.
6. Dejar pulsado el personaje de Ripto para visualiza el easter egg correspondiente.
7. En la lista de mundos, hacer click 3 veces para ver el vídeo del easter egg.

## Conclusiones del desarrollador
El desarrollo de esta aplicación me ha permitido profundizar en el ciclo de vida de los fragmentos y la importancia de una arquitectura limpia. El mayor desafío fue la colocación de los diferentes elementos, 
tanto de los apartados de la guía interactiva para que coincida con los botones ya creados de la aplicación como el ubicar bien el easter egg de Ripto. 
Aprendí que la experiencia de usuario al usar una aplicación mejora drásticamente cuando se añaden pequeños detalles como sonidos y transiciones suaves.
