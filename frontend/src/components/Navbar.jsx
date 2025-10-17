import { Link, useNavigate } from "react-router-dom";
import logo from "../assets/logo.jpg";

export const Navbar = () => {

  const navigate = useNavigate();
  //Si el usuario ha iniciado sesión, se habrá guardado en un LocalStorage 
  const usuario = JSON.parse(localStorage.getItem("usuario"));

  //Handle significa manejar
  //Esto nos va a servir para saber si tiene que ir al perfil o si va a hacer login

  const handleUserClick=() =>{
    if(usuario){
      navigate("/perfil")
    }else{
      navigate("/login")
    }
  }

  //Este manejador sirve para cerrar sesión y vuelve a la página de inicio

  const handleLogOut =() =>{
    localStorage.removeItem("usuario");
    navigate("/")
  }


  return (

    <nav className="navbar bg-body-tertiary  px-3">
      <div className="container d-flex justify-content-between align-items-center">

        <Link to="/" className="navbar-brand d-flex align-items-center">
          <img
            src={logo}
            alt="Logo TamaTerapias"
            width="40"
            height="40"
            className="d-inline-block align-text-top me-2 rounded-circle"
          />
          TamaTerapias
        </Link>

        <div>
          <Link to="/servicios" className="text-decoration-none text-dark mx-3 fw-semibold">
            Servicios
          </Link>
          <Link to="/tienda" className="text-decoration-none text-dark mx-3 fw-semibold">
            Tienda
         </Link>
          <Link to="/cita" className="text-decoration-none text-dark mx-3 fw-semibold">
            Cita
          </Link>
        </div>
        
      </div>
    </nav>
  );
};
