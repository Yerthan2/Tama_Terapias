import React, { useState } from "react";
import {api} from "../api/api"


export const ListaDatos = ({endpoint, title, renderItem}) =>{
    //Esto sirve para hacer el cambio
    const [data, setData] = useState([]);
    //Esto sirve para Saber el estado de carga
    const [cargando, setCargando] = useState(true);
    //Sirve apra el estado del error
    const [error, setError] = useState(false);

    //Con esto podemos hacer la petición al serv. La voy a hacer dinámica, para reutilizar código
    //Utilizamos el setDatos y actualizamos datos, si hay error, nos da el error, muestra por consola y luego lo recoge 
    //Por ultimo, 
    
    useEffect(() => {
        api.get(endpoint)
        .then((res) => {
            setData(res.data)})
        .catch((err) =>{
            console.error(`Error cargando ${endpoint}:`, err)
            setError(true)})
        .finally(() => {
            setCargando(false)
        })
    }, [endpoint]);

    //Si sigue cargando, se va a devolver un cargando
    if (loading)
    return (
      <div className="text-center mt-5">
        <p>Cargando {title.toLowerCase()}...</p>
      </div>
    );

  if (error)
    return (
      <div className="text-center text-danger mt-5">
        <p>Error al cargar {title.toLowerCase()}.</p>
      </div>
    );

  if (data.length === 0)
    return (
      <div className="text-center mt-5">
        <p>No hay {title.toLowerCase()} disponibles.</p>
      </div>
    );

    return (
        <div className="container mt-5">
        <h2 className="text-center mb-4">{title}</h2>
        <div className="row">
            {data.map((item) => (
            <div
                key={item.id || item.idProducto || item.idServicio || item.idCita}
                className="col-12 col-md-4 mb-4 d-flex"
            >
                {renderItem(item)}
            </div>
            ))}
        </div>
        </div>
    );
}