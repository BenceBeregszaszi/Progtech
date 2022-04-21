# Rendszerterv

## 1. A rendszer célja
Fejlesztő csapatunkhoz fordult egy olasz pizzéria,
hogy segítsen nekik létrehozni egy Java alapú asztali alkalmazást,
aminek segítségével a megrendelő készíteni tud magának saját pizzát, 
illetve leadja a rendelést és ezt az adatot eltárolja egy adatbázisban.
Az alkalmazás használatához nem szükséges a bejelentkezés.

## 2. Projektterv
Projektmunkák és felelősei:

 - Adatbázis tervezése és létrehozása: Beregszászi Bence, Nagy Péter Axel
 - API tervezése és létrehozása: Beregszászi Bence, Nagy Péter Axel
 - Java alapú alkalmazás tervezése: Beregszászi Bence, Nagy Péter Axel
 - Java alapú alkalmazás megvalósítása: Beregszászi Bence, Nagy Péter Axel
 - Tesztelés: Beregszászi Bence, Nagy Péter Axel


## 3. Üzleti folyamatok modellje

![Üzleti folyamatok modellje](https://imgur.com/Bcvd2EI.png)


## 4. Követelmények

-Ablakos alkalmazás (User friendly)

-Adatok tárolása adatbázisban

-Adatbázissal való kommunikáció logolása

-Rendelés módosítása (Automatikusan)

Törvényi előírások, szabályok:
 - Az alkalmazás JAVA alapokon készül	
 - Intuitív, átlátható rendszer
 - GDRP (Általános adatvédelmi rendelet)

## 5. Funkcionális terv

## 6. Fizikai környezet
Az alkalmazás asztali platformra készült.
Java nyelv segítségével valósul meg az elkészítése.

Fejlesztő eszközök:
 - IntelliJ IDEA
 - Visual Studio Code
 - MySQL Workbench
 - DataGrip
 - XAMPP
 - CodeTogether
 - Diagrams.Net


## 7. Architektúrális tervek

##  8. Adatbázis terv

![Adatbázis terv](https://imgur.com/fPGQ3Cb.png)

## 9. Implementációs terv

## 10. Tesztterv 

Az alkalmazáshoz Unit tesztek is fognak készülni, ezen felül bármilyen problémát a log fájlba fogjuk menteni, kiírni. Ennek köszönhetően egyszerűbb lesz a karbantartás.

## 11. Telepítési terv

## 12. Karbantartási terv

a) Az alkalmazás folyamatos üzemeltetése és karbantartása, mely magában foglalja a programhibák elhárítását, a belső igények változása miatti módosításokat, valamint a környezeti feltételek változása miatt megfogalmazott program-, illetve állomány módosítási igényeket. 

b) Corrective Maintenance: A megrendelő jelenti, ha bármi hibát vélt felfedezni.

c) Adaptive Maintenance: A program naprakészen tartása és finomhangolása.

d) Perfective Maintenance: A szoftver hosszútávú használata érdekében végzett módosítások, új funkciók, a szoftver teljesítményének és működési megbízhatóságának javítása.

e) Preventive Maintenance: Olyan problémák elhárítása, amelyek még nem tűnnek fontosnak, de később komoly problémákat okozhatnak.
