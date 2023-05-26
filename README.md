
# AccountsViewAppliaction
Aplikacja imitująca konto klienta w banku.
Aplikacja pozwala  tworzyć konto klienta wraz z rachunkiem bankowym oraz kartą debetową.
Aplikacja co 30 sekund odpytuje Api NBP o aktualny kurs dla 5 walut oraz zapisuje wartości to tabeli co pozwala na bieżąco
zewryfikować jaki jest aktualny stan konta w danej walucie.
Istnieje możliwość weryfikacji najlepszego kursu danrj waluty dla określonego okresu 
czasu.
Aplikacja umożliwa wysłanie eventu na topic Kafki, który pozwala na
modyfikację danych adresowych klienta.

------------------------------
Wymagania

Zainstalowany oraz uruchomiony Zookeeper and Kafka
Java Development Kit (JDK), Maven, MySQL

