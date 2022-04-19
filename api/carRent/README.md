Indítás 
Indításhoz először fútassa a composer install parancsot majd végezze el az adatbázis létrehozásának első módszerét.  
Az API beüzemelése után az env.example fájl másolása és env-re való átnevezése után a  DB_DATABASE mezőnek megkell adni egy tetszőleges nevet. Majd az XAMPP indítása után a böngészőbe a http://localhost/phpmyadmin/ felületen a megadott névvel létrehozni egy táblát majd az API-ban futtatni a php artisan migrate parancsot. Ezzel létrejönnek a megtervezett táblák és a laravel saját táblái, és a projekt működésének tesztelése érdekében kreált tesztadatok.
