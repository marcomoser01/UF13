# FoodMe

Piattaforma online per l'acquisto di prodotti (Cibo) proposti dai vari Negozi.

## Table of Contents

- [Usage](#usage)
- [Features](#features)
- [Step](#step)

## Usage

L'utente si registra, naviga tra i vari negozi disponibile e valuta i prodotti da acquistare. Aggiungi i prodotti nel carrello della spesa ed effettua il check out.

## Features

- Utente

  - Pagina di registrazione ( Nome , Cognome , Mobile , Email, Indirizzo)

- Negozio

  - Pagina con la lista dei Negozi: (Nome, Descrizione, Indirizzo, Giorni ed orari di apertura). Scegliete la visualizzazione che preferite, puo' essere anche una semplice tabella. La lista deve essere paginata e devo poter scorrere fra le varie pagine, ogni pagina contiene 10 Negozi.

  - Pagina di dettaglio del negozio: il dettaglio mostra "Tipologia, Nome, Descrizione, Indirizzo, Giorni ed orari di apertura, Immagine vetrina(opzionale)" del negozio. Mostra inoltre TAG che identificano la tipologia di cucina "Indiana, Italiana, BBQ" e un campo di "Ratings". Mostra inoltre la lista dei prodotti venduti dal Negozio ed un bottone per aggiungerlo al carrello della spesa.

- Prodotto

  - La pagina del prodotto mostra, Nome, Descrizione, Prezzo , Immagine ( non obbligatoria ).
  - Posso aggiungere il prodotto al mio carrello della spesa

- Carrello
  - Mostra la lista dei prodotti, (nome , prezzo). Mostra inoltre il totale da pagare.
  - Posso aggiungere un prodotto, eliminarlo, eventualmente modificare la quantita'

Abbiamo quindi le seguenti entita':

- Utente
- Prodotto
- Negozio
- Ordine
- Carrello
- Tag

Le relazioni tra le entita' possono essere le seguenti:

- Persone hanno 0 o piu' Ordini
- Negozio ha almeno un Prodotto
- Prodotto ha almeno un Tag

## Step

Fase 1 (REST API):

- Creazione progetto spring boot e configurazione dei pacchetti necessari
- Configurazione DB h2

```
spring.datasource.url=jdbc:h2:file:~/foodme
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true

```

- Creazione delle Entity e Relazioni
- Creazione delle Crud per le varie Entity ( Utente, Negozio, Prodotto, Ordine , Carello, Tag)

Per la creazione delle crud useremo : Controller, Service, Repository.

In un primo momento non faremo la login ma faremo un FakeLogin che ci passera' ad ogni richiesta l'informazione di un utente registrato nel database:

```
public class FakeUser {
    private String username;
    // ... altre proprietà e metodi

    // Costruttore, getter e setter
}

@Configuration
public class AppConfig {
    @Bean
    public FakeUser fakeUser() {
        return new FakeUser(....parameters);
    }
}

@RestController
public class MyController {
    private final FakeUser fakeUser;

    public MyController(FakeUserInjector fakeUserInjector) {
        this.fakeUser = fakeUserInjector.getFakeUser();
    }

    @GetMapping("/my-endpoint")
    public String myEndpoint() {
        // Utilizza l'utente fittizio nella logica del controller
        return "Hello, " + fakeUser.getUsername();
    }

}
```

Fase 2 (Front-End):

- Configurazione database MongoDB
- Configurazione Thymeleaf
- Security!? ( se facciamo in tempo )
