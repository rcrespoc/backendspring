# Backend Spring Boot.

La aplicación fue desarrollada en Spring y desplegada en el puerto 5000, con la ayuda de Spring Boot para inicializar el proyecto de una manera sencilla y rápida con algunas dependencias necesarias para el desarrollo óptimo de la misma.

### Lista de dependencias usadas.
- Spring Web
- Spring Boot DevTools
- Lombok

La dependencia Lombok se empleó para tener rápidamente los getters, setters y demás métodos necesarios para el manejo de las clases del modelo de datos, ahorrando bastante tiempo y código.

El servicio contiene un endpoint para poder consultar los productos relacionados partiendo desde uno que debe brindar al consultar dicho endpoint.

- `/product/{productId}/similar`

La respuesta de dicho endpoint será una lista con los productos relacionados.
```
[
  {
    "id": "2",
    "name": "Dress",
    "price": 19.99,
    "availability": true
  },
  {
    "id": "3",
    "name": "Blazer",
    "price": 29.99,
    "availability": false
  },
  {
    "id": "4",
    "name": "Boots",
    "price": 39.99,
    "availability": true
  }
]
```

Mientras que al brindar algún id que no corresponda a algún producto, retornará el código de estado 404 y se mostrará el mensaje "Product not found".

Por otro lado, los tests que se le han aplicado a la aplicación se muestran a continuación.

![test](https://res.cloudinary.com/dmjgwv0zs/image/upload/v1649301644/Screenshot_1_oxwdjq.png "test")
