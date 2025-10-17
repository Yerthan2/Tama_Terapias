import React from "react";
import { ListaDatos } from "../components/ListaDatos";

export const Servicios = () => {
  return (
    <ListaDatos
      endpoint="/servicios"
      title="Nuestros Servicios"
      renderItem={(servicio) => (
        <div
          className="card shadow-sm"
          style={{
            width: "18rem",
            margin: "auto",
            borderRadius: "12px",
            overflow: "hidden",
          }}
        >
          {servicio.imagen && (
            <img
              src={`http://localhost:8080${servicio.imagen}`}
              alt={servicio.nombre}
              className="card-img-top"
              style={{ height: "180px", objectFit: "cover" }}
            />
          )}

          <div className="card-body text-center">
            <h5 className="card-title fw-bold">{servicio.nombre}</h5>
            <p className="card-text text-muted mb-2">
              {servicio.descripcion || "Sin descripción disponible"}
            </p>
            <p className="fw-semibold">
              Duración: {servicio.duracion || "—"} minutos
            </p>
            <p className="fw-bold">{servicio.precio} €</p>

            <button className="btn btn-outline-primary w-100 mt-2">
              Reservar cita 🗓️
            </button>
          </div>
        </div>
      )}
    />
  );
}
