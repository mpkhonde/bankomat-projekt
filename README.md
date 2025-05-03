# Uppgift 5 – SOLID Principer

Detta projekt visar tillämpning av alla SOLID-principer i Java:

- **S**: Single Responsibility – `Item` har endast ansvar för sina egna data.
- **O**: Open/Closed – Nya rabatter kan läggas till utan att ändra befintlig logik.
- **L**: Liskov Substitution – `ShoppingCart` fungerar med alla `IDiscount`-implementationer.
- **I**: Interface Segregation – Ett enda rent interface (`IDiscount`) används.
- **D**: Dependency Inversion – `ShoppingCart` får rabattlogik via konstruktor.

## Körinstruktioner

1. Kompilera:
```bash
javac src/solid/*.java
