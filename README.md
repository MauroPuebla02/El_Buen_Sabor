# 🍽️ El Buen Sabor - API [important]

[info] **El Buen Sabor** es un sistema fullstack desarrollado por un equipo de estudiantes, que busca digitalizar la gestión integral de un restaurante moderno. A través de esta API RESTful construida con **Java 21** y **Spring Boot 3.5.0**, se administra el ciclo completo de operaciones: productos, recetas, stock, usuarios, pedidos, pagos online y sucursales.

---

## 🛠️ Tecnologías y arquitectura [info]

El backend de El Buen Sabor está desarrollado sobre una arquitectura por capas bien definida, que garantiza una separación de responsabilidades, mantenibilidad y escalabilidad.

### 🔧 Tecnologías principales
- **Java 21** - Lenguaje principal
- **Spring Boot 3.5.0** - Framework backend
- **Spring Data JPA + Hibernate** - ORM y acceso a datos
- **MapStruct** - Mapeo entre entidades y DTOs
- **Spring Security** - Seguridad y control de acceso
- **H2 / MySQL** - Bases de datos para desarrollo y producción
- **Swagger / OpenAPI** - Documentación de la API
- **Mercado Pago SDK** - Integración de pagos online

### 🧱 Arquitectura implementada
- Modelo Vista Controllador
- Repositorios con Spring Data (DAO)
- Servicios con lógica de negocio
- Controladores REST (API)
- DTOs para comunicación externa

---

## ✨ Características principales [important]

- 📦 Gestión de productos, recetas e insumos
- 🧾 Pedidos con seguimiento de estado (`PENDIENTE` → `ENTREGADO`)
- 🧍‍♂️ Administración de usuarios y roles (clientes, empleados, repartidores)
- 💳 Pagos integrados con **Mercado Pago**
- 🏪 Manejo de sucursales y stock por local
- 📚 Organización jerárquica de categorías
- 🧮 Sistema de fabricación con recetas y stock de insumos
- 🔒 Autenticación segura con JWT/Auth0 (en desarrollo)

---

## ⚙️ Instrucciones de instalación y ejecución [info]

### 📌 Requisitos previos
- Java 21
- Gradle
- MySQL o utilizar H2 (base de datos embebida por defecto)

### 🧪 Instalación y ejecución

```bash
git clone https://github.com/MauroPuebla02/El_Buen_Sabor.git
cd El_Buen_Sabor
./gradlew bootRun
```

- Acceso a la API: `http://localhost:8080`
- Swagger UI (si está activo): `http://localhost:8080/swagger-ui.html`

> ⚠️ Para producción, configurar el acceso a MySQL en `application.properties`

---

## 🧩 Módulos y paquetes [info]

| Módulo | Descripción |
|--------|-------------|
| `Pedido` | Control de pedidos, estados, totales y tipo de envío |
| `Articulo` | Base para insumos y productos manufacturados |
| `Usuario` | Gestión de clientes, empleados, repartidores |
| `Categoria` | Rubros jerárquicos para productos e insumos |
| `PedidoDetalle` | Detalle de cada artículo dentro de un pedido |
| `ArticuloManufacturadoDetalle` | Recetas (ingredientes necesarios por producto) |
| `StockInsumoSucursal` | Control de stock por insumo y por sucursal |
| `DatosMercadoPago` | Almacenamiento de datos de pago confirmados |

---

## 🧑‍💻 Integrantes del grupo [important]

| Nombre | GitHub |
|--------|--------|
| Mauricio Urquiza | [@mauriciogurquiza](https://github.com/mauriciogurquiza) |
| Federico D'Anna | [@FedeDAnna](https://github.com/FedeDAnna) |
| Ailen Bossio | [@ailenBossio](https://github.com/ailenBossio) |
| Maximiliano Attanasio | [@maximilianoAttanasio](https://github.com/maximilianoAttanasio) |
| Mauro Puebla | [@MauroPuebla02](https://github.com/MauroPuebla02) |

---

## 📎 Repositorio [info]
- 🔗 [El Buen Sabor - Backend (GitHub)](https://github.com/MauroPuebla02/El_Buen_Sabor)
- 🔗 [El Buen Sabor - Frontend (GitHub)](https://github.com/FedeDAnna/El_Buen_Sabor_front)
