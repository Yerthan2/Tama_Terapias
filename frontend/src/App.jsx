import React from "react";
import { Routes, Route } from "react-router-dom";
import { Navbar } from "./components/NavBar";
import {Servicios} from "./pages/Servicios";
import {Tienda} from "./pages/Tienda";
import Cita from "./pages/Cita";
import Home from "./pages/Home";
import {Footer} from "./components/Footer"

export default function App() {
  return (
    <>
      <Navbar />
       <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/servicios" element={<Servicios />} />
        <Route path="/tienda" element={<Tienda />} />
        <Route path="/cita" element={<Cita />} />
      </Routes>

      <Footer/>
    </>
  );
}
