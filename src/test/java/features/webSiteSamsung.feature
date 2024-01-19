Feature: Gestione del sito web Samsung

  Scenario: Accesso al website
    Given L'utente si trova sulla pagina di accesso
    When L'utente fa clic sul pulsante di accesso
    Then L'utente viene reindirizzato alla dashboard

  Scenario: Select product
    Given L'utente si trova sulla dashboard
    When L'utente fa clic sul prodotto desiderato
    Then L'articolo viene creato correttamente

  Scenario: Check product
    Given L'utente si trova sul carrello
    When L'utente fa clic sul proprio carrello
    Then Il prodotto viene controllato correttamente
    Then si chiude il test

