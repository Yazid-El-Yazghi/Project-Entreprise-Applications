# SamenSterk Anderlecht - Event Management Platform

Een dynamische Spring Boot webapplicatie voor het beheren van evenementen in Anderlecht. SamenSterk Anderlecht is een platform waar bezoekers evenementen kunnen bekijken, nieuwe evenementen kunnen toevoegen, en gedetailleerde informatie kunnen raadplegen over lokale activiteiten.

## Functionaliteiten

### Evenement Beheer
- **Overzicht**: Bekijk de laatste 10 evenementen gesorteerd op datum
- **Details**: Gedetailleerde weergave van elk evenement met volledige informatie
- **Nieuw evenement**: Formulier voor het toevoegen van nieuwe evenementen
- **Validatie**: Uitgebreide formulier validatie voor alle velden

### Locatie Systeem
- **Locatie informatie**: Naam, adres en capaciteit voor elk evenement
- **Database opslag**: Aparte entiteit voor herbruikbare locatie gegevens
- **Capaciteit tracking**: Maximaal aantal personen per locatie

### Contact & Organisatie
- **Organisatie informatie**: Wie organiseert het evenement
- **Contactpersoon**: E-mail voor vragen en communicatie
- **Tijdstip planning**: Datum en tijd voor elk evenement

### Gebruiksvriendelijke Interface
- **Responsive design**: Werkt op alle apparaten met Tailwind CSS
- **Nederlandse interface**: Volledig in het Nederlands
- **Moderne UI**: Clean en professionele uitstraling
- **Navigatie**: Eenvoudige navigatie tussen pagina's

## Technische Implementatie

### Models & Database Relaties
- **Event Model** (`src/main/java/be/ehb/ngo/model/Event.java`) - Evenement beheer
- **Location Model** (`src/main/java/be/ehb/ngo/model/Location.java`) - Locatie informatie

#### Database Relaties:
- **Many-to-One**: Event → Location (meerdere evenementen kunnen dezelfde locatie gebruiken)

### Controllers
- **EventController** (`src/main/java/be/ehb/ngo/controller/EventController.java`) - Hoofdcontroller voor evenementen
  - `GET /` - Overzicht van laatste evenementen
  - `GET /new` - Formulier voor nieuw evenement
  - `POST /new` - Verwerking van nieuw evenement
  - `GET /details/{id}` - Gedetailleerde weergave
- **AboutController** (`src/main/java/be/ehb/ngo/controller/AboutController.java`) - Over ons pagina
- **LocationController** (`src/main/java/be/ehb/ngo/controller/LocationController.java`) - Locatie beheer

### Repositories
- **EventRepository** (`src/main/java/be/ehb/ngo/repository/EventRepository.java`) - Database operaties voor evenementen
- **LocationRepository** (`src/main/java/be/ehb/ngo/repository/LocationRepository.java`) - Database operaties voor locaties

### Views & Templates
- **Thymeleaf Templates**: Server-side rendering met dynamische content
- **Responsive Layout**: Tailwind CSS voor moderne styling
- **Form Handling**: Geïntegreerde foutafhandeling en validatie
- **Dutch Language**: Volledig Nederlandse interface

## Project Structuur

```
Project-Entreprise-Application/
├── src/
│   ├── main/
│   │   ├── java/be/ehb/ngo/
│   │   │   ├── controller/          # Spring MVC Controllers
│   │   │   │   ├── AboutController.java
│   │   │   │   ├── EventController.java
│   │   │   │   └── LocationController.java
│   │   │   ├── model/               # JPA Entiteiten
│   │   │   │   ├── Event.java
│   │   │   │   └── Location.java
│   │   │   ├── repository/          # Data Access Layer
│   │   │   │   ├── EventRepository.java
│   │   │   │   └── LocationRepository.java
│   │   │   └── ProjectEntrepriseApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── style.css        # Tailwind CSS styling
│   │       ├── templates/           # Thymeleaf templates
│   │       │   ├── about.html       # Over ons pagina
│   │       │   ├── details.html     # Evenement details
│   │       │   ├── index.html       # Hoofdpagina
│   │       │   └── new.html         # Nieuw evenement formulier
│   │       └── application.properties # Configuratie
│   └── test/                        # Unit tests
├── target/                          # Build output
├── .mvn/                           # Maven wrapper
├── mvnw                            # Maven wrapper script (Unix)
├── mvnw.cmd                        # Maven wrapper script (Windows)
└── pom.xml                         # Maven configuratie
```

## Installatie

### Vereisten
- Java 17 of hoger
- Maven 3.6+ (of gebruik de meegeleverde Maven wrapper)
- MySQL/MariaDB database
- Web browser

### Installatiestappen

1. **Clone de repository**
```bash
git clone [repository-url]
cd Project-Entreprise-Application
```

2. **Database configuratie**
Maak een MySQL database aan en pas `src/main/resources/application.properties` aan:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Project
spring.datasource.username=root
spring.datasource.password=jouw_wachtwoord
spring.jpa.hibernate.ddl-auto=update
server.port=1070
```

3. **Database setup**
De applicatie zal automatisch de benodigde tabellen aanmaken bij de eerste start.

4. **Applicatie starten**
```bash
# Met Maven wrapper (aanbevolen)
./mvnw spring-boot:run

# Of met geïnstalleerde Maven
mvn spring-boot:run
```

5. **Toegang tot de applicatie**
Bezoek `http://localhost:1070` om de applicatie te bekijken.

## Gebruiksaanwijzing

### Evenementen Bekijken
1. Ga naar de hoofdpagina (`/`)
2. Bekijk de tabel met laatste evenementen
3. Klik op "Details" voor meer informatie over een evenement

### Nieuw Evenement Toevoegen
1. Klik op "Nieuw evenement" in de navigatie
2. Vul alle verplichte velden in:
   - Titel van het evenement
   - Omschrijving
   - Organisatie naam
   - Contactpersoon e-mail
   - Datum en tijd
   - Locatie informatie (naam, adres, capaciteit)
3. Klik op "Toevoegen" om het evenement op te slaan

### Over Ons Pagina
- Bekijk informatie over SamenSterk Anderlecht
- Contact gegevens en adres informatie
- Beschrijving van de organisatie

## Technische Vereisten Implementatie

| Vereiste | Implementatie | Beschrijving |
|----------|---------------|--------------|
| **Spring Boot** | `ProjectEntrepriseApplication.java` | Hoofdapplicatie klasse |
| **Spring MVC** | Controllers package | Web MVC architectuur |
| **Spring Data JPA** | Repository interfaces | Database abstractie |
| **Thymeleaf** | Templates folder | Server-side templating |
| **Bean Validation** | Model annotations | Form validatie |
| **MySQL Integration** | `application.properties` | Database configuratie |
| **Responsive Design** | `style.css` | Tailwind CSS styling |

## Database Schema

### Event Tabel
- `id` (Long, Primary Key, Auto-increment)
- `titel` (String, Required)
- `omschrijving` (String, Required)
- `organisatie` (String, Required)
- `email` (String, Required, Valid Email)
- `tijdstip` (LocalDateTime, Required)
- `locatie_id` (Long, Foreign Key)

### Location Tabel
- `id` (Long, Primary Key, Auto-increment)
- `naam` (String, Required)
- `adres` (String, Required)
- `capaciteit` (Integer, Min: 1)

## Gebruikte Technologieën

- **Backend**: Spring Boot 3.5.0, Java 17
- **Web Framework**: Spring MVC
- **Database**: MySQL met Spring Data JPA
- **Template Engine**: Thymeleaf
- **Styling**: Tailwind CSS
- **Validation**: Bean Validation (Hibernate Validator)
- **Build Tool**: Maven
- **Testing**: JUnit 5, Spring Boot Test

## Security & Validatie

- **Input Validatie**: Bean Validation annotations op alle model fields
- **XSS Protection**: Thymeleaf auto-escaping
- **SQL Injection Protection**: JPA/Hibernate prepared statements
- **Error Handling**: Graceful error handling met gebruiksvriendelijke berichten

## Testing

De applicatie bevat unit tests in de `src/test` directory:

```bash
# Tests uitvoeren
./mvnw test
```

## Deployment

### Productie Build
```bash
./mvnw clean package
java -jar target/Project-Entreprise-Application-0.0.1-SNAPSHOT.jar
```

### Docker (Optioneel)
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/Project-Entreprise-Application-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 1070
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## Mogelijke Uitbreidingen

- **User Authentication**: Login systeem voor beheerders
- **Event Categories**: Categorisering van evenementen
- **Image Upload**: Afbeeldingen bij evenementen
- **Email Notifications**: Automatische e-mail bevestigingen
- **Calendar Integration**: Kalender weergave van evenementen
- **Search Functionality**: Zoeken en filteren van evenementen

## Troubleshooting

### Veelvoorkomende Problemen

**Database Connection Error**
- Controleer of MySQL draait
- Verificeer database credentials in `application.properties`
- Zorg dat de database `Project` bestaat

**Port Already in Use**
- Wijzig de poort in `application.properties`: `server.port=8080`
- Of stop andere applicaties die poort 1070 gebruiken

**Build Errors**
- Controleer Java versie: `java -version` (moet 17+ zijn)
- Clear Maven cache: `./mvnw clean`

## Gebruikte Bronnen

- AI Assistants:
  - GitHub Copilot voor code suggestions, vragen en autocompletion tijdens development

**Development Log**: Voor een gedetailleerd overzicht van de ontwikkeling en opgeloste problemen, zie [chatlog.md](chatlog.md).

## Auteur

**Naam**: Yazid  
**Project**: Enterprise Application Development  
**Academiejaar**: 2024-2025  
**Technologie Stack**: Spring Boot, MySQL, Thymeleaf

---

*SamenSterk Anderlecht - Samen bouwen aan een sterke gemeenschap* 🏘️