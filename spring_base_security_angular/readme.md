# Ziel

Einfache Konfiguration eines Spring Projekts mit Basic Auth und Verwendung von AngularJS.
AngularJS hat selbst keine direkte Beziehung zur Security. Basic Auth läuft über den Browser.

# Vorgehen


- Mit STS ein Spring Boot erzeugt.
- Security und Web Starter ausgewählt
- index.html hinzugefügt
- Nach Start ist die Webseite bereits nur mit user und im Startlog angezeigtes Passwort aufrufbar
- Über application.yml geändert.

- Konfiguration von wro4j übernommen.
- Kleiner Rest-Resource in der Application Klasse hinzugefügt.
- Rest-Resource wird von Angular per `$http.get('/resource/')` abgerufen.
Dieses Projekt basiert auf: 
[Spring Security Angular Tutorial](https://spring.io/guides/tutorials/spring-security-and-angular-js/)