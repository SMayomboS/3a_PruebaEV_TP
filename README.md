# 3ª Prueba de Evaluación - Técnicas de Programación


## 🎮  Máquina Arcade en Java
Aplicación de escritorio en Java que simula una máquina arcade con tres juegos clásicos de lógica y álgebra:

- ♛ Problema de las N Reinas  
- ♞ Recorrido del Caballo (Knight's Tour)  
- 🗼 Torres de Hanói  

Este proyecto fue desarrollado con fines educativos, aplicando principios de programación orientada a objetos y patrones de diseño (creacionales y estructurales) en una arquitectura monolítica organizada.

[https://github.com/SMayomboS/3a_PruebaEV_TP/main](https://github.com/SMayomboS/3a_PruebaEV_TP)

---

## 🚀 Requisitos

- Java 8 o superior  
- Maven 3+

---

## ⚙️ Compilación y ejecución

### 🧱 Compilar con Maven

```bash
mvn clean package
```

Se generará un `.jar` ejecutable en:

```
target/ArcadeLogicGames-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### ▶ Ejecutar la aplicación

```bash
java -jar target/ArcadeLogicGames-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## 💾 Persistencia

La aplicación utiliza:

- 🔄 **Hibernate** como framework ORM  
- 🛢️ **Base de datos H2 embebida** (`arcade_db.mv.db`), sin requerir instalación externa  
- 📄 Archivo de configuración: `src/main/resources/hibernate.cfg.xml`

---

## 🧠 Arquitectura del proyecto

```
src/
├── main/
│   ├── java/
│   │   ├── app/           # Lanzador de la aplicación
│   │   ├── controller/    # Controladores + Facades (Facade pattern)
│   │   ├── model/         # Entidades JPA
│   │   ├── view/          # Interfaz gráfica con Swing
│   │   ├── factory/       # GameFactory (Factory Method)
│   │   └── util/          # HibernateUtil (Singleton)
│   └── resources/
│       └── hibernate.cfg.xml
```

---

## 🧩 Patrones de diseño aplicados

| Tipo           | Patrón aplicado                | Ubicación                        |
|----------------|-------------------------------|----------------------------------|
| **Creacional** | Singleton                     | `util.HibernateUtil`            |
|                | Factory Method                | `factory.GameFactory`           |
| **Estructural**| Facade                        | `controller.*Facade`            |
|                | MVC                           | `view`, `controller`, `model`   |

---

## 📜 Créditos

Proyecto académico desarrollado para prácticas de programación avanzada en Java.  
Incluye resolución automática de puzzles, persistencia de resultados y arquitectura limpia basada en principios SOLID.

---

**Autor:** Sergio Mayombo Serrano  
**Licencia:** Uso académico y educativo
