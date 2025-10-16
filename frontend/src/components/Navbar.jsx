import { Link } from "react-router-dom";
import logo from "../assets/logo.jpg";

export const Navbar = () => {
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
