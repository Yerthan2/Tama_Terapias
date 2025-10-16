import { useEffect, useState } from "react";
import api from "../api/api.js";

export default function Productos() {
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    api.get("/productos")
      .then(res => setProductos(res.data))
      .catch(err => console.error("Error al obtener productos:", err));
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h2>Lista de productos</h2>
      <ul>
        {productos.map(p => (
          <li key={p.idProducto}>
            {p.nombre} — {p.precio} €
          </li>
        ))}
      </ul>
    </div>
  );
}
