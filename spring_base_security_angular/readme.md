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

# Probleme

Zitat:

What’s Wrong with That?

On the face of it, it seems like we did a pretty good job, it’s concise, easy to implement, all our data are secured by a secret password, and it would still work if we changed the front end or backend technologies. But there are some issues.

    Basic authentication is restricted to username and password authentication.

    The authentication UI is ubiquitous but ugly (browser dialog).

    There is no protection from Cross Site Request Forgery (CSRF).

CSRF isn’t really an issue with our application as it stands since it only needs to GET the backend resources (i.e. no state is changed in the server). As soon as you have a POST, PUT or DELETE in your application it simply isn’t secure any more by any reasonable modern measure.

In the next section in this series we will extend the application to use form-based authentication, which is a lot more flexible than HTTP Basic. Once we have a form we will need CSRF protection, and both Spring Security and Angular have some nice out-of-the box features to help with this. Spoiler: we are going to need to use the HttpSession.

Thanks: I would like to thank everyone who helped me develop this series, and in particular Rob Winch and Thorsten Spaeth for their careful reviews of the sections and sources codes, and for teaching me a few tricks I didn’t know even about the parts I thought I was most familar with.
