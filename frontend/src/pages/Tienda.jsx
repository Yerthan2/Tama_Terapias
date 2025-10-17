import React from "react";
import { ListaDatos } from "../components/ListaDatos";

export const Tienda = () => {
  return (
    <ListaDatos
      endpoint="/productos"
      title="Tienda"
      renderItem={(producto) => (
        <div
          className="card shadow-sm"
          style={{ width: "18rem", margin: "auto" }}
        >
          {producto.imagen && (
            <img
              src={producto.imagen}
              alt={producto.nombre}
              className="card-img-top"
              style={{ height: "180px", objectFit: "cover" }}
            />
          )}
          <div className="card-body text-center">
            <h5 className="card-title">{producto.nombre}</h5>
            <p className="card-text text-muted">
              {producto.descripcion || "Sin descripción"}
            </p>
            <p className="fw-bold mb-2">{producto.precio} €</p>
            <button className="btn btn-primary w-100">
              Añadir al carrito 🛒
            </button>
          </div>
        </div>
      )}
    />
  );
};
